package com.example.gameManagerapi.resources;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.gameManagerapi.models.Conta;
import com.example.gameManagerapi.repository.ContaRepository;

@RestController
@RequestMapping("/conta")
public class ContasResource {
	
	@Autowired
	private ContaRepository contaRepository;
	
	@GetMapping
	public List<Conta> listar() {
		return contaRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Conta> cadastrar(@RequestBody Conta conta, HttpServletResponse response) {
		Conta contaSalva = contaRepository.save(conta);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{idConta}")
			.buildAndExpand(contaSalva.getIdConta()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(contaSalva);
	}
}
