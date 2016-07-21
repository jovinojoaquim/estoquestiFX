package estoquestiFX.teste;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import estoquestiFX.bean.EnderecoBean;
import estoquestiFX.domain.Cidade;
import estoquestiFX.domain.Endereco;

public class EnderecoTeste {
	
	@Test
	public void inserir(){
		Cidade c = new Cidade();
		Endereco e = new Endereco();		
		EnderecoBean ebean = new EnderecoBean();
		
		c.setId(1L);
		c.setCidade("Belo Horizonte");
		e.setBairro("Bairro");
		e.setCep("31555-210");
		e.setCidade(c);
		e.setComplemento("Complemento");
		e.setLogradouro("Logradouro");
		e.setNumero(1327);	
		
		ebean.salvar("logradouro", "1327", "Complemento", "Bairro", "31555210", c);
	}
	
	@Test
	public void buscarTodos() {
		EnderecoBean bean = new EnderecoBean();
		List<Endereco> lista = bean.listar();
		if(lista == null){
			System.out.println("lista nula");
		}
		for (Endereco endereco : lista) {
			System.out.println(endereco.getLogradouro());
			System.out.println(endereco.getCidade().getCidade());
		}
	}

}
