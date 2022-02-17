package com.myproject.second.file.controller;

import java.io.FileOutputStream;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/api/file/*")
public class FileController {

	@PostMapping("/upload/img")
	public void imageUpload(@RequestParam("fileList") List<MultipartFile> fileList) {
		try {
			for (MultipartFile multipartFile : fileList) {
//				./second/src
				FileOutputStream writer = new FileOutputStream("./src/main/resources/images/" + multipartFile.getOriginalFilename());
				System.out.println(multipartFile.getOriginalFilename());
				writer.write(multipartFile.getBytes());
				writer.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
