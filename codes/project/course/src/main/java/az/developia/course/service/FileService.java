package az.developia.course.service;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import az.developia.course.entity.FileModel;

@Service
public class FileService {

	public ResponseEntity<Object> uploadFiles(MultipartFile file) {
		
		FileModel model = new FileModel();
		if (file==null) {
			model.setFileName("fakeImage.png");
			return ResponseEntity.ok(model);
		}
		String fileName = file.getOriginalFilename();

		try {
			InputStream stream = file.getInputStream();
			File java1 = new File("D:/java1");
			if (java1.exists()) {

			} else {
				java1.mkdir();
			}

			UUID uuid = UUID.randomUUID();
			String randomName = uuid.toString();

			String format = fileName.substring(fileName.lastIndexOf("."));

			randomName += format;
			fileName = randomName;

			Files.copy(stream, Paths.get("D:/java1/" + randomName), StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		model.setFileName(fileName);
		return ResponseEntity.ok(model);
	}

	public ResponseEntity<Resource> getDownload(String filename) {
		try {
			Resource file = new UrlResource(Paths.get("C:/java1").resolve(filename).toUri());
			return ResponseEntity.ok().header(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+file.getFilename()+"\"").body(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
}
