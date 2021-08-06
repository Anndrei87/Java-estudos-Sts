package com.example.demo.controller.v1;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmpregadoDTO;
import com.example.demo.models.Empregado;
import com.example.demo.service.EmpregadoService;

@RestController
@RequestMapping("/v1/empregados")
public class EmpregadoControllerV1 {

	@Autowired
	EmpregadoService empregadoService;
	
	@GetMapping
	public ResponseEntity<ArrayList<EmpregadoDTO>> buscarTodos(){
		
		return new ResponseEntity<ArrayList<EmpregadoDTO>>(
				empregadoService.findAll(),HttpStatus.OK);
	}
	
	
	@GetMapping("/{cpf}")
	public ResponseEntity<EmpregadoDTO> buscarPorCpf(@PathVariable Integer cpf){
	
		return new ResponseEntity<EmpregadoDTO>(
				empregadoService.findById(cpf), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> salvar(@RequestBody Empregado e){
		
		empregadoService.save(e);
		return new ResponseEntity<String>("ok",HttpStatus.OK);
	}
}
