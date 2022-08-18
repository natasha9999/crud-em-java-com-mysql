package com.crudjava.teste;

import com.crudjava.dao.ContainerDAO;
import com.crudjava.dao.MovimentacaoDAO;
import com.crudjava.model.Container;
import com.crudjava.model.Movimentacao;

public class TestCrud {
	
	ContainerDAO containerDAO = new ContainerDAO();
	
	public void testSaveContainer() {
		Container container = new Container();
		container.setId(1);
		container.setNome("Natasha");
		container.setNumero("CONT1234567");
		container.setTipo(20);
		container.setStatus("Cheio");
		container.setCategoria("Importação");
		
		containerDAO.saveContainer(container);
		
	}
	
	public void testUpdateContainer() {
		Container container1 = new Container();
		container1.setId(1);
		container1.setNome("Sonia");
		container1.setNumero("AINE4567123");
		container1.setTipo(40);
		container1.setStatus("Vazio");
		container1.setCategoria("EXportação");
		
		containerDAO.updateContainer(container1);
	}
	
	public void testRemoveByIdContainer() throws Exception {
		containerDAO.removeByIdContainer(1);
	}

	
	public void testListContainer() {
		for(Container cont : containerDAO.getContainers()) {
			System.out.println("Id: " +cont.getId());
			System.out.println("Nome: " +cont.getNome());
			System.out.println("Numero: " +cont.getNumero());
			System.out.println("Tipo: " +cont.getTipo());
			System.out.println("Status: " +cont.getStatus());
			System.out.println("Categoria: " +cont.getCategoria());
		}
	}
	
	//------------------------------------------------------------------------------------------------
	
	MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO();
	
	public void testSaveMovimentacao() {
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setId(1);
		movimentacao.setTipo("Embarque");
		movimentacao.setDataInicio("21/05/2022");
		movimentacao.setDataFinal("24/05/2022");
		movimentacao.setHoraInicio("12:30");
		movimentacao.setHoraFinal("14:00");
		
		movimentacaoDAO.saveMovimentacao(movimentacao);
		
	}
	
	public void testUpdateMovimentacao() {
		Movimentacao movimentacao1 = new Movimentacao();
		movimentacao1.setId(1);
		movimentacao1.setTipo("Pesagem");
		movimentacao1.setDataInicio("10/07/2022");
		movimentacao1.setDataFinal("18/07/2022");
		movimentacao1.setHoraInicio("13:00");
		movimentacao1.setHoraFinal("18:00");
		
		movimentacaoDAO.updateMovimentacao(movimentacao1);
	}
	
	public void testRemoveByIdMovimentacao() throws Exception {
		movimentacaoDAO.removeByIdMovimentacao(1);
	}

	
	public void testListMovimentacao() {
		for(Movimentacao cont : movimentacaoDAO.getMovimentacoes()) {
			System.out.println("Id: " +cont.getId());
			System.out.println("Tipo: " +cont.getTipo());
			System.out.println("Data de inicio: " +cont.getDataInicio());
			System.out.println("Data final: " +cont.getDataFinal());
			System.out.println("Hora de inicio: " +cont.getHoraInicio());
			System.out.println("Hora inicio: " +cont.getHoraFinal());
		}
	}
	

}
