package com.farmacia.pharma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmacia.pharma.model.FarmaModel;
import com.farmacia.pharma.repository.FarmaRepository;

@RestController
@RequestMapping("/FarmaController")
@CrossOrigin("*")
public class FarmaController {
	@Autowired
	private FarmaRepository repository;

	@GetMapping
	public ResponseEntity<List<FarmaModel>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<FarmaModel> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<FarmaModel>> GetByTitulo(@PathVariable String descricao) {
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));

	}

	@PostMapping
	public ResponseEntity<FarmaModel> post(@RequestBody FarmaModel descricao) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(descricao));
	}

	@PutMapping
	public ResponseEntity<FarmaModel> put(@RequestBody FarmaModel descricao) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(descricao));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}

}
