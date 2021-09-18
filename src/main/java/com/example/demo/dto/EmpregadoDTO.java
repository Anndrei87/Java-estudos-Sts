package com.example.demo.dto;

import java.io.Serializable;

import com.example.demo.models.Dependente;
import com.example.demo.models.Empregado;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpregadoDTO implements Serializable {

	private static final long serialVersionUID = -541208071814146459L;

	private Integer cpf;
	
	private String nome;
	
	private String nomeAgencia;
	
	private String nomeInstituicao;
	
	private String nomesDependentes;
	
	private Double salario;
	
	public static EmpregadoDTO createEmpregadoDto(Empregado empregado) {
		EmpregadoDTO empregadoDTO = new EmpregadoDTO();
		
		empregadoDTO.setCpf(empregado.getCpf());
		empregadoDTO.setNome(empregado.getNome());
		empregadoDTO.setNomeAgencia(empregado.getAgencia() != null ? empregado.getAgencia().getNome() : "");
		
		empregadoDTO.setNomeInstituicao(empregado.getAgencia() != null && empregado.getAgencia().getInstituicao() != null? 
				empregado.getAgencia().getInstituicao().getName() : "");
		
		empregadoDTO.setSalario(empregado.getSalario());
		
		String nomeDependentesTemp = "";
		
		for(Dependente dependente : empregado.getDependentes()) {
			
			nomeDependentesTemp = nomeDependentesTemp.concat(dependente.getNome());
			nomeDependentesTemp = nomeDependentesTemp.concat(", ");
		}
		
		empregadoDTO.setNomesDependentes(nomeDependentesTemp);
		return empregadoDTO;
	}
}
