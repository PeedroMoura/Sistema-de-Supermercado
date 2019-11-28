package br.edu.cesmac.market.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.cesmac.market.jdbc.ConnectionFactory;
import br.edu.cesmac.market.model.Fornecedores;
import br.edu.cesmac.market.model.Lote;
import br.edu.cesmac.market.model.Produtos;

public class LoteDAO {
	Connection con;
	String sql;
	
	public Boolean cadastrarLote(Lote lote) {
		Boolean cadastrou = false;
		this.sql = "INSERT INTO lote(numero_lote, data_fabricacao, data_vencimento, id_produtos, id_fornecedor) VALUES (?,?,?,?,?)";
		try {
			
			this.con = ConnectionFactory.getConnection();
			PreparedStatement preparedStatement = this.con.prepareStatement(this.sql);
			preparedStatement.setInt(1, lote.getNumLote());
			preparedStatement.setDate(2, new java.sql.Date(lote.getDataFabFormatada().getTime()));
			preparedStatement.setDate(3, new java.sql.Date(lote.getDataVenFormatada().getTime()));
			preparedStatement.setLong(4, lote.getProdutos().getId());
			preparedStatement.setLong(5, lote.getFornecedores().getId());
			
			preparedStatement.execute();
			cadastrou = true;
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally {
			try {
				this.con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cadastrou;
	}
	
	public List<Fornecedores> listarFornecedores(){
		List<Fornecedores> lista = new ArrayList<>();

		this.sql = "SELECT razao_social, id FROM fornecedor";
		try(Connection con = ConnectionFactory.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(this.sql);
			ResultSet resultSet = preparedStatement.executeQuery()){
			
			while(resultSet.next()) {
				Fornecedores fornecedores = new Fornecedores();
				fornecedores.setId(resultSet.getLong("id"));
				fornecedores.setRazaoSocial(resultSet.getString("razao_social"));
				lista.add(fornecedores);
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return lista;
	}
	
	public List<Lote> listarLote(){
		List<Lote> lista = new ArrayList<>();

		this.sql = "select l.id, p.descricao, f.razao_social, data_fabricacao, data_vencimento, numero_lote " + 
				"from lote l " + 
				"join fornecedor f ON (l.id_fornecedor = f.id) " + 
				"join produtos p ON (l.id_produtos = p.id); ";
		try(Connection con = ConnectionFactory.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(this.sql);
			ResultSet resultSet = preparedStatement.executeQuery()){
			
			while(resultSet.next()) {
				Lote lote = new Lote();
				lote.setId(resultSet.getLong("id"));
				lote.getProdutos().setDescricao(resultSet.getString("descricao"));
				lote.getFornecedores().setRazaoSocial(resultSet.getString("razao_social"));
				lote.setDataFab(resultSet.getDate("data_fabricacao"));
				lote.setDataVen(resultSet.getDate("data_vencimento"));
				lista.add(lote);
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return lista;
	}
	
	public List<Produtos> listarProdutos() {
		List<Produtos> lista = new ArrayList<>();

		this.sql = "SELECT descricao, id FROM produtos";
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement preparedStatement = con.prepareStatement(this.sql);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				Produtos produtos = new Produtos();
				produtos.setId(resultSet.getLong("id"));
				produtos.setDescricao(resultSet.getString("descricao"));
				lista.add(produtos);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return lista;
	}
}
