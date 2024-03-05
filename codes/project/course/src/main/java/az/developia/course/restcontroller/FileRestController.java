package az.developia.course.restcontroller;


import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import az.developia.course.service.FileService;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/files")
@RequiredArgsConstructor
public class FileRestController {

	private final FileService service;
	
	@PostMapping(path = "/upload")
	public ResponseEntity<Object> uploadFile(@RequestParam(name = "file", required = false) MultipartFile file) {
		ResponseEntity<Object> resp = service.uploadFiles(file);
		return resp;
	}
	
	@GetMapping(path = "/files/download/{filename:.+}")
	public ResponseEntity<Resource> download(@PathVariable String filename){
		ResponseEntity<Resource> resp = service.getDownload(filename);
		return resp;
	}
}
