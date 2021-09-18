package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.models.Dependente;
import com.example.demo.models.Empregado;

public interface DependenteRepository extends JpaRepository<Dependente, String>{

}