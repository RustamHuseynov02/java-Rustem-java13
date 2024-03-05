package az.developia.course.service;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import az.developia.course.entity.FileModel;

@Service
public class FileService {

	public ResponseEntity<Object> uploadFiles(MultipartFile file) {
		System.out.println(file.getOriginalFilename());

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

		FileModel model = new FileModel();
		model.setFileName(fileName);
		return ResponseEntity.ok(model);
	}

	
}
