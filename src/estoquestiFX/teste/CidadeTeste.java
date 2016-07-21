package estoquestiFX.teste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import estoquestiFX.bean.CidadeBean;
import estoquestiFX.domain.Cidade;
import estoquestiFX.domain.Estado;

public class CidadeTeste {

	@Ignore
	public void novaCidade(){
		Estado e = new Estado();
		CidadeBean cbean = new CidadeBean();
		
		e.setId(1L);
		cbean.salvar("Belo Horizonte", e);
	}
	
	@Test
	public void listar(){
		CidadeBean cbean = new CidadeBean();
		List<Cidade> lista = cbean.listar();
		
		for (Cidade cidade : lista) {
			System.out.println(cidade.getId());
			System.out.println(cidade.getCidade());
			System.out.println(cidade.getEstado().getNomeEstado());
		}
	}
}
