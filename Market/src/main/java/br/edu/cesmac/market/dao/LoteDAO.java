package br.edu.cesmac.market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.cesmac.market.jdbc.ConnectionFactory;
import br.edu.cesmac.market.model.Lote;
import br.edu.cesmac.market.model.Produtos;
import br.edu.cesmac.market.model.Fornecedores;

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
			preparedStatement.setDate(2, lote.getDataFab());
			preparedStatement.setDate(3, lote.getDataVen());
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
		Fornecedores fornecedores = new Fornecedores();
		this.sql = "SELECT razao_social, id FROM fornecedor";
		try(Connection con = ConnectionFactory.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(this.sql);
			ResultSet resultSet = preparedStatement.executeQuery()){
			
			while(resultSet.next()) {
				fornecedores.setId(resultSet.getLong("id"));
				fornecedores.setRazaoSocial(resultSet.getString("razao_social"));
				lista.add(fornecedores);
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return lista;
	}
	
	public List<Produtos> listarProdutos() {
		List<Produtos> lista = new ArrayList<>();
		Produtos produtos = new Produtos();
		this.sql = "SELECT descricao, id FROM produtos";
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement preparedStatement = con.prepareStatement(this.sql);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
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

