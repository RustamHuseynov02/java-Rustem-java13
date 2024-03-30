package az.developia.springjava13.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.security.access.prepost.PreAuthorize;
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

import az.developia.springjava13.dto.StudentUpdateDTO;
import az.developia.springjava13.request.StudentAddRequest;
import az.developia.springjava13.service.StudentService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/students")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class StudentController {

	private final StudentService service;

	@GetMapping(path = "/html", produces = { "application/json", "application/xml" }) // content negotiation
	public ResponseEntity<Object> list() {
		ResponseEntity<Object> findAll = service.findAll();
		return findAll;
	}

	@GetMapping(produces = { "application/json", "application/xml" })
	// @PreAuthorize(value = "hasAuthority('ROLE_GET_STUDENT')")
	public ResponseEntity<Object> getList() {
		ResponseEntity<Object> findAllById = service.findAllById();

		return findAllById;
	}

	@GetMapping(path = "/id-username", produces = { "application/json", "application/xml" }) // Spring REST dynamic
																								// filtering
	// @PreAuthorize(value = "hasAuthority('ROLE_GET_STUDENT')")
	public MappingJacksonValue getUsernameId() {
		MappingJacksonValue findAllByIdUsername = service.findAllByIdUsername();

		return findAllByIdUsername;
	}

	@GetMapping(path = "/id-name", produces = { "application/json", "application/xml" }) // Spring REST dynamic
																							// filtering
	// @PreAuthorize(value = "hasAuthority('ROLE_GET_STUDENT')")
	public MappingJacksonValue getNameId() {
		MappingJacksonValue findAllByIdName = service.findAllByIdName();

		return findAllByIdName;
	}

	@PostMapping
	@PreAuthorize(value = " hasAuthority('ROLE_ADD_STUDENT')")
	public ResponseEntity<Object> add(@Valid @RequestBody StudentAddRequest dto, BindingResult br) {
		ResponseEntity<Object> resp = service.add(dto, br);

		return resp;
	}

	@PutMapping
	// @PreAuthorize("hasAuthority('ROLE_UPDATE_STUDENT')")
	public ResponseEntity<Object> update(@Valid @RequestBody StudentUpdateDTO dto, BindingResult br) {
		ResponseEntity<Object> resp = service.findByIdtoUpdate(dto, br);
		return resp;

	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_DELETE_STUDENT')")
	public ResponseEntity<Object> delete(@PathVariable Integer id) {
		ResponseEntity<Object> resp = service.findByIdToDelete(id);
		return resp;
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_GET_ID_STUDENT')")
	public ResponseEntity<Object> findAllById(@PathVariable Integer id) {
		ResponseEntity<Object> resp = service.findById(id);
		return resp;
	}

	// /students/pagination/begin/0/length/100
	@GetMapping(path = "/pagination/begin/{begin}/length/{length}")
	@PreAuthorize(value = "hasAuthority('ROLE_GET_STUDENT')")
	public ResponseEntity<Object> pagination(@PathVariable Integer begin, @PathVariable Integer length) {
		ResponseEntity<Object> resp = service.findPagination(begin, length);
		return resp;
	}

}
