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
import com.farmacia.pharma.model.ProdutoModel;
import com.farmacia.pharma.repository.FarmaRepository;
import com.farmacia.pharma.repository.ProdutoRepository;

@RestController
@RequestMapping("/ProdutoController")
@CrossOrigin("*")
public class ProdutoController {
	@Autowired
	private ProdutoRepository repository;

	@GetMapping
	public ResponseEntity<List<ProdutoModel>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoModel> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<ProdutoModel>> GetByNome(@PathVariable String nome) {
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));

	}

	@PostMapping
	public ResponseEntity<ProdutoModel> post(@RequestBody ProdutoModel nome) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(nome));
	}

	@PutMapping
	public ResponseEntity<ProdutoModel> put(@RequestBody ProdutoModel nome) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(nome));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
