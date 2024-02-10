package az.developia.springjava13.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springjava13.dto.BookDTO;
import az.developia.springjava13.entity.BookEntity;
import az.developia.springjava13.entity.OwnerEntity;
import az.developia.springjava13.exception.OurRuntimeException;
import az.developia.springjava13.repository.BookRepository;
import az.developia.springjava13.repository.OwnerRepository;
import az.developia.springjava13.response.BookResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/books")
@RequiredArgsConstructor
public class BookController {

	
	private final BookRepository repository;

	private final OwnerRepository ownerRepository;
	
	
	@GetMapping
	@PreAuthorize(value = " hasAuthority('ROLE_GET_ALL_BOOK')")
	public BookResponse findAllById() {
		BookResponse response = new BookResponse();
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		OwnerEntity ownerOperator = ownerRepository.findByUsername(username);
		if (ownerOperator == null) {
			throw new OurRuntimeException(null, "");
		}
		Integer ownerId = ownerOperator.getId();
		List<BookEntity> list = repository.findAllByOwnerId(ownerId);
		
		response.setBooks(list);
		
		return response;
	}

	@PostMapping
    @PreAuthorize(value = " hasAuthority('ROLE_ADD_BOOK')")
	// 0 olmasi,var olmuyan id olmasi,null olmasi,dogru id-ni verib redakte etmek
	// crud emeliyati
	public void addBook(@Valid @RequestBody BookDTO b, BindingResult binding) {
		if (binding.hasErrors()) {
			throw new OurRuntimeException(null, "Melumati duzgun qeyd edin");
		}
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		OwnerEntity operatorOwner = ownerRepository.findByUsername(username);
		if (operatorOwner == null) {
			throw new OurRuntimeException(null, "bele bir istifadeci yoxdur");
		}
		Integer ownerId = operatorOwner.getId();
		
		if (b.getOwnerId() != ownerId) {
			throw new OurRuntimeException(null, "kimsenin adinnan kitab qeyd etmek olmaz");
		}
		
		BookEntity entity = new BookEntity();
		entity.setName(b.getName());
		entity.setAuthor(b.getAuthor());
		entity.setPrice(b.getPrice());
		entity.setPageCount(b.getPageCount());
		entity.setOwnerId(ownerId);
		
		repository.save(entity);
	}

	@PutMapping
	@PreAuthorize(value = " hasAuthority('ROLE_UPDATE_BOOK')")
	public void update(@RequestBody BookEntity b, BindingResult binding) {
		if (b.getId() == null || b.getId() <= 0) {
			throw new OurRuntimeException(null, "id dogru qeyd edin");
		}
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		OwnerEntity operatorOwner = ownerRepository.findByUsername(username);
		if (operatorOwner == null) {
			throw new OurRuntimeException(null, "bele bir istifadeci yoxdur");
		}
		Integer ownerId = operatorOwner.getId();
		
		Optional<BookEntity> optional = repository.findById(b.getId());
		if (optional.isPresent()) {
			BookEntity entity = optional.get();
			if (entity.getOwnerId() == ownerId) {
				repository.save(b);
			}
			else {
				throw new OurRuntimeException(null, "bu kitabi redakte ede bilmezsen");
			}
			
		} else {
			throw new OurRuntimeException(null, "id tapilmadi");
		}
	}

	@DeleteMapping("/{id}")
	@PreAuthorize(value = " hasAuthority('ROLE_DELETE_BOOK')")
	public void delete(@PathVariable Integer id) {
		if (id == null || id <= 0) {
			throw new OurRuntimeException(null, "id duzgun qeyd edin");
		}
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		OwnerEntity operatorOwner = ownerRepository.findByUsername(username);
		if (operatorOwner == null) {
			throw new OurRuntimeException(null, "bele bir istifadeci yoxdur");
		}
		Integer ownerId = operatorOwner.getId();
		
		BookEntity entity = repository.findById(id).orElseThrow(()->new OurRuntimeException(null, "id tapilmadi"));
		
		if (entity.getOwnerId() == ownerId) {
			repository.deleteById(id);
		} 
		else {
			throw new OurRuntimeException(null, "bu kitabi sile bilmezsen");
		}
	}

	@GetMapping("/{id}")
	@PreAuthorize(value = " hasAuthority('ROLE_GET_ID_BOOK')")
	public BookEntity findById(@PathVariable Integer id) {
		if (id == 0 || id <= 0) {
			throw new OurRuntimeException(null, "id-ni duzgun qeyd edin");
		}
		
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        OwnerEntity operator = ownerRepository.findByUsername(username);
        if (operator == null) {
        	throw new OurRuntimeException(null, "bele bir owner yoxdur");
		}
        Integer ownerId = operator.getId();
        
		Optional<BookEntity> optional = repository.findById(id);
		if (optional.isPresent()) {
			BookEntity entity = optional.get();
			if (entity.getOwnerId() == ownerId) {
				return optional.get();
			}else {
				throw new OurRuntimeException(null, "bu id-ni cagira bilmezsen");
			}
			
		} else {
			throw new OurRuntimeException(null, "id tapilmadi");
		}
	}
}
