package com.example.demo.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.models.Dependente;
import com.example.demo.repository.DependenteRepository;

@Service
public class DependenteService {

	
	@Autowired
	DependenteRepository dependenteRepository;
	
	
	public void save(String nome, MultipartFile file){
		
		Dependente dependente = new Dependente();
		
		dependente.setNome(nome);
		
		Byte[] byteObjects;
		try {
			byteObjects = new Byte[file.getBytes().length];
			int i = 0;
			for (byte b : file.getBytes()) {
				byteObjects[i++] = b;
				
			}
			dependente.setFoto(byteObjects);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		dependenteRepository.save(dependente);
		
	}
}
