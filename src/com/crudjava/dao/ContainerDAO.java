package com.crudjava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.crudjava.conexao.Conexao;
import com.crudjava.model.Container;

public class ContainerDAO {
	
	Connection con = Conexao.getConnection();
	
	//criar
	public void saveContainer(Container container) {
		
		String sql = "INSERT INTO containers(id,nome,numero,tipo,status,categoria)" + "VALUES(?,?,?,?,?,?)";
		
		Connection con = null;
		
		PreparedStatement pre = null;
		
		try {
			con = Conexao.createConnectionBD();
			
			pre = con.prepareStatement(sql);
			
			pre.setInt(1, container.getId());
			
			pre.setString(2, container.getNome());
			
			pre.setString(3, container.getNumero());
			
			pre.setInt(4, container.getTipo());
			
			pre.setString(5, container.getStatus());
			
			pre.setString(6, container.getCategoria());
			
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
	
	
	public void removeByIdContainer(int id) throws Exception {
		
		String sql = "DELETE FROM containers WHERE id";
		
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
	
	
	public void updateContainer(Container container) {
		
		String sql = "UPDATE containers SET nome = ?, tipo = ?, status = ?, categoria = ?" + "WHERE id = ?";
		
		Connection con = null;
		PreparedStatement pre = null;
		
		try {
			con = Conexao.createConnectionBD();
			pre = con.prepareStatement(sql);
			
			pre.setInt(1, container.getId());
			pre.setString(2, container.getNome());
			pre.setInt(3, container.getTipo());
			pre.setString(4, container.getStatus());
			pre.setString(5, container.getCategoria());
			
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
	
	
	public List<Container> getContainers() {
		String sql = "SELECT * FROM containers";
		
		List<Container> containers = new ArrayList<Container>();
		
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet resultlist = null;
		
		try {
			con = Conexao.createConnectionBD();
			pre = con.prepareStatement(sql);
			resultlist = pre.executeQuery();
			
			System.out.println("Busca realizada" + containers);
			
			while(resultlist.next()) {
				Container container = new Container();
				
				container.setId(resultlist.getInt("id"));
				container.setNome(resultlist.getString("nome"));
				container.setNumero(resultlist.getString("numero"));
				container.setTipo(resultlist.getInt("tipo"));
				container.setStatus(resultlist.getString("status"));
				container.setCategoria(resultlist.getString("categoria"));
				
				containers.add(container);
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
		
		return containers;
	}
}
