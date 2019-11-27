package br.edu.cesmac.market.model;

public class Produtos {
	
	private Long id;
	private String descricao;
	private Boolean perecivel;
	private Double precoCompra;
	private Double precoVenda;
	private String medidas;
	private String unidade;
	private String codigoDeBarras;
	private Integer estoqueMaximo;
	private Integer estoqueMinimo;
	private Integer estoqueDisponivel;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Boolean getPerecivel() {
		return perecivel;
	}
	public void setPerecivel(Boolean perecivel) {
		this.perecivel = perecivel;
	}
	public Double getPrecoCompra() {
		return precoCompra;
	}
	public void setPrecoCompra(Double precoCompra) {
		this.precoCompra = precoCompra;
	}
	public Double getPrecoVenda() {
		return precoVenda;
	}
	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}
	public String getMedidas() {
		return medidas;
	}
	public void setMedidas(String medidas) {
		this.medidas = medidas;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	public String getCodigoDeBarras() {
		return codigoDeBarras;
	}
	public void setCodigoDeBarras(String codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}
	public Integer getEstoqueMaximo() {
		return estoqueMaximo;
	}
	public void setEstoqueMaximo(Integer estoqueMaximo) {
		this.estoqueMaximo = estoqueMaximo;
	}
	public Integer getEstoqueMinimo() {
		return estoqueMinimo;
	}
	public void setEstoqueMinimo(Integer estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}
	public Integer getEstoqueDisponivel() {
		return estoqueDisponivel;
	}
	public void setEstoqueDisponivel(Integer estoqueDisponivel) {
		this.estoqueDisponivel = estoqueDisponivel;
	}
	
	

}
