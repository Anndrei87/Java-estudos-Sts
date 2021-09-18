package com.example.demo.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.DependenteService;


@RestController
@RequestMapping("/v1/dependente")
@CrossOrigin
public class DepedentesController {
	
	@Autowired
	DependenteService dependenteService;
	
	@PostMapping
	public ResponseEntity<String> salvar(@RequestParam String nome, @RequestParam MultipartFile foto){
		
		dependenteService.save(nome, foto);
		return new ResponseEntity<String>("ok",HttpStatus.OK);
	}

}
