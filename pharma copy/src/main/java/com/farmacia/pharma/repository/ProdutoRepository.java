package com.farmacia.pharma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmacia.pharma.model.FarmaModel;
import com.farmacia.pharma.model.ProdutoModel;

public interface ProdutoRepository extends JpaRepository <ProdutoModel, Long>{
	public List<ProdutoModel> findAllByNomeContainingIgnoreCase(String nome);
}
