package br.edu.cesmac.market.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.cesmac.market.dao.LoteDAO;
import br.edu.cesmac.market.jdbc.ConnectionFactory;
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
	private List<Lote> listaLote = new ArrayList<>();
	
	public void cadastrarLote() {
		
		 if (loteDao.cadastrarLote(lote)) {
		 FacesContext.getCurrentInstance().addMessage(null, new
		 FacesMessage(FacesMessage.SEVERITY_INFO, "Lote Cadastrado Com Sucesso!",
		 "sucesso")); } else { FacesContext.getCurrentInstance().addMessage(null, new
		 FacesMessage(FacesMessage.SEVERITY_WARN,
		 "Ocorreu um erro no Cadastro do Lote!", "sucesso")); }
		 
	}
	
	public Boolean deletar(Lote lote) {
		Boolean delete = false;
		String sql = "DELETE FROM lote WHERE id = ?";
		try {
			
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setLong(1, lote.getId());
			
			preparedStatement.execute();
			delete = true;
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally {
			Connection con = ConnectionFactory.getConnection();
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return delete;
	}
	
	
	public List<Lote> listarLote(){
		return loteDao.listarLote();
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

	public List<Lote> getListaLote() {
		return listaLote;
	}

	public void setListaLote(List<Lote> listaLote) {
		this.listaLote = listaLote;
	}
	
	
}