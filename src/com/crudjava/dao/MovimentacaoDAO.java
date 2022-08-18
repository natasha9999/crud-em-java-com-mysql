package com.crudjava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.crudjava.conexao.Conexao;
import com.crudjava.model.Movimentacao;

public class MovimentacaoDAO {
	
Connection con = Conexao.getConnection();
	
	//criar
	public void saveMovimentacao(Movimentacao movimentacao) {
		
		String sql = "INSERT INTO movimentacoes(id,tipo,dataInicio,dataFinal,horaInicio,horaFinal)" + "VALUES(?,?,?,?,?,?)";
		
		Connection con = null;
		
		PreparedStatement pre = null;
		
		try {
			con = Conexao.createConnectionBD();
			
			pre = con.prepareStatement(sql);
			
			pre.setInt(1, movimentacao.getId());
			
			pre.setString(2, movimentacao.getTipo());
			
			pre.setString(3, movimentacao.getDataInicio());
			
			pre.setString(4, movimentacao.getDataFinal());
			
			pre.setString(5, movimentacao.getHoraInicio());
			
			pre.setString(6, movimentacao.getHoraFinal());
			
			pre.execute();
			
			System.out.print("Cadastro realizao");
			
		} catch (Exception e) {
			System.err.print("Cadastro não realizado. Erro: " + e);
		}
		
		try {
			if(pre != null) {
				pre.close();
			}
			
			if(con != null) {
				con.close();
			}
		} catch (Exception e) {
			System.err.print("Não existe.Erro: " + e);
		}
	}
	
	
	public void removeByIdMovimentacao(int id) throws Exception {
		
		String sql = "DELETE FROM movimentacoes WHERE id";
		
		Connection con = null;
		PreparedStatement pre = null;
		
		try {
		con = Conexao.createConnectionBD();
		pre = con.prepareStatement(sql);
		
		pre.setInt(1, id);
		pre.execute();
		
		System.out.println("Exclesao realizada");
		
		} catch (Exception e) {
			System.err.println("Exclusao nao realizada. Erro: " + e);
		}
		
		
		try {
			if(pre != null) {
				pre.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			System.err.println("Nao existe. Erro: " + e);
		}
	}
	
	
	public void updateMovimentacao(Movimentacao movimentacao) {
		
		String sql = "UPDATE movimentacoes SET id = ?, tipo = ?, dataInicio = ?, dataFinal = ?, , horaInicio = ?, , horaFinal = ?" + "WHERE id = ?";
		
		Connection con = null;
		PreparedStatement pre = null;
		
		try {
			con = Conexao.createConnectionBD();
			pre = con.prepareStatement(sql);
			
			pre.setInt(1, movimentacao.getId());
			pre.setString(2, movimentacao.getDataInicio());
			pre.setString(3, movimentacao.getDataFinal());
			pre.setString(4, movimentacao.getHoraInicio());
			pre.setString(5, movimentacao.getHoraFinal());
			
			pre.execute();
			
			System.out.println("Atualizaçao realizada.");
			
		} catch (Exception e) {
			System.err.print("Atualuzação nao realizada. Erro: " + e);
		}
		
		try {
			if(pre != null) {
				pre.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			System.err.println("Nao existe. Erro: " + e);
		}
	}
	
	
	public List<Movimentacao> getMovimentacoes() {
		String sql = "SELECT * FROM movimentacoes";
		
		List<Movimentacao> movimentacoes = new ArrayList<Movimentacao>();
		
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet resultlist = null;
		
		try {
			con = Conexao.createConnectionBD();
			pre = con.prepareStatement(sql);
			resultlist = pre.executeQuery();
			
			System.out.println("Busca realizada" + movimentacoes);
			
			while(resultlist.next()) {
				Movimentacao movimentacao = new Movimentacao();
				
				movimentacao.setId(resultlist.getInt("id"));
				movimentacao.setTipo(resultlist.getString("tipo"));
				movimentacao.setDataInicio(resultlist.getString("dataInicio"));
				movimentacao.setDataFinal(resultlist.getString("dataFinal"));
				movimentacao.setHoraInicio(resultlist.getString("horaInicio"));
				movimentacao.setHoraFinal(resultlist.getString("horaFinal"));
				
				movimentacoes.add(movimentacao);
			}
	} catch (Exception e) {
		System.out.println("Nenhum cadastro. Erro: " +e);
	}
		
		try {
			if(pre != null) {
				pre.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			System.err.println("Nao existe. Erro: " + e);
		}
		
		return movimentacoes;
	}

}
