package com.farmacia.pharma.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Table(name="ProdutoModel")
public class ProdutoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
	@NotNull
	@Size(min=10 , max = 500)
private String nome ;
	@NotNull
	@Size(min=10 , max = 500)
private double preco;
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public double getPreco() {
	return preco;
}
public void setPreco(double preco) {
	this.preco = preco;
}
}
