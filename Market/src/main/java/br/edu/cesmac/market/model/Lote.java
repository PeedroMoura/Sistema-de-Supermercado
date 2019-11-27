package br.edu.cesmac.market.model;

import java.sql.Date;

public class Lote {
	
	private Long id;
	private Produtos produtos;
	private Fornecedores fornecedores;
	private Date dataFab;
	private Date dataVen;
	private Integer numLote;
	
	public Lote() {
		this.produtos = new Produtos();
		this.fornecedores = new Fornecedores();
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Produtos getProdutos() {
		return produtos;
	}
	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}
	public Fornecedores getFornecedores() {
		return fornecedores;
	}
	public void setFornecedores(Fornecedores fornecedores) {
		this.fornecedores = fornecedores;
	}
	public Date getDataFab() {
		return dataFab;
	}
	public void setDataFab(Date dataFab) {
		this.dataFab = dataFab;
	}
	public Date getDataVen() {
		return dataVen;
	}
	public void setDataVen(Date dataVen) {
		this.dataVen = dataVen;
	}
	public Integer getNumLote() {
		return numLote;
	}
	public void setNumLote(Integer numLote) {
		this.numLote = numLote;
	}
	
}
