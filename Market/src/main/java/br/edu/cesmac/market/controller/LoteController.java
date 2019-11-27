package br.edu.cesmac.market.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.cesmac.market.dao.LoteDAO;
import br.edu.cesmac.market.model.Lote;
import br.edu.cesmac.market.model.Produtos;
import br.edu.cesmac.market.model.Fornecedores;

@ManagedBean
@ViewScoped

public class LoteController {
	
	private LoteDAO loteDao = new LoteDAO();
	private Lote lote  = new Lote();
	private List<Fornecedores> listaFornecedores = new ArrayList<>();
	private List<Produtos> listaProdutos = new ArrayList<>();
	
	public void cadastrarLote() {
		
		 if (loteDao.cadastrarLote(lote)) {
		 FacesContext.getCurrentInstance().addMessage(null, new
		 FacesMessage(FacesMessage.SEVERITY_INFO, "Lote Cadastrado Com Sucesso!",
		 "sucesso")); } else { FacesContext.getCurrentInstance().addMessage(null, new
		 FacesMessage(FacesMessage.SEVERITY_WARN,
		 "Ocorreu um erro no Cadastro do Lote!", "sucesso")); }
		 
	}
	
	public List<Fornecedores> carregarComboFornecedores() {
		return loteDao.listarFornecedores();
	}
	
	public List<Produtos> carregarComboProdutos() {
		return loteDao.listarProdutos();
	}

	public void redirecionarPagina(String page) throws IOException {
		String url = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
		FacesContext.getCurrentInstance().getExternalContext().redirect(url + "/" + page +".faces");
	}
	
	public Lote getLote() {
		return lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
	}

	public List<Fornecedores> getListaFornecedores() {
		return listaFornecedores;
	}
	
	public void setListaFornecedores(List<Fornecedores> listaFornecedores) {
		this.listaFornecedores = listaFornecedores;
	}
	
	public List<Produtos> getListaProdutos(){
		return listaProdutos;
	}

	public void setListaProdutos(List<Produtos> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	
	
	
}
