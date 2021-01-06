package com.farmacia.pharma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmacia.pharma.model.FarmaModel;


public interface FarmaRepository extends JpaRepository <FarmaModel, Long> {

	public List<FarmaModel> findAllByDescricaoContainingIgnoreCase(String descricao);

}
