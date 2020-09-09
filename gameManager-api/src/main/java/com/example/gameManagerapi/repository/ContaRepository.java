package com.example.gameManagerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gameManagerapi.models.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

}
