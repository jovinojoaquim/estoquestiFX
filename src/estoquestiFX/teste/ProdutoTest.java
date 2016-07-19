package estoquestiFX.teste;

import java.util.List;
import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import estoquestiFX.bean.ProdutoBean;
import estoquestiFX.dao.ProdutoDAO;
import estoquestiFX.domain.Categoria;
import estoquestiFX.domain.Produto;

public class ProdutoTest {

//	@Ignore
	@Test
	public void salvar() {
		Produto p = new Produto();
		Categoria c = new Categoria();
		ProdutoDAO dao = new ProdutoDAO();
		
		c.setIdCategoria(1L);
		c.setCategoria("Categoria1");
		
		p.setNome("Produto 1");
		p.setDescricao("Descrição Produto");
		p.setMarca("Marca 1");
		p.setMedida("22c3");
		p.setQuantidade(4D);
		p.setValorVenda(50D);
		p.setCategoria(c);		
		dao.salvar(p);
	}
	
//	@Test
	@Ignore
	public void salvarDecimal() {
		Produto p = new Produto();
		Categoria c = new Categoria();
		ProdutoDAO dao = new ProdutoDAO();
		
		c.setIdCategoria(1L);
		c.setCategoria("Categoria1");
		
		p.setNome("Produto 1");
		p.setDescricao("Descrição Produto");
		p.setMarca("Marca 1");
		p.setMedida("22c3");
		p.setQuantidade(4D);
		p.setValorVenda(50.55D);
		p.setCategoria(c);		
		dao.salvar(p);
	}
	
//	@Test
	@Ignore
	public void salvarComMaisCasasDecimais() {
		Produto p = new Produto();
		Categoria c = new Categoria();
		ProdutoDAO dao = new ProdutoDAO();
		
		c.setIdCategoria(1L);
		c.setCategoria("Categoria1");
		
		p.setNome("Produto 1");
		p.setDescricao("Descrição Produto");
		p.setMarca("Marca 1");
		p.setMedida("22c3");
		p.setQuantidade(4D);
		p.setValorVenda(50.555D);
		p.setCategoria(c);		
		dao.salvar(p);
	}
	
//	@Test
	@Ignore
	public void salvarComVirgula() {
		Produto p = new Produto();
		Categoria c = new Categoria();
		ProdutoDAO dao = new ProdutoDAO();
		
		c.setIdCategoria(1L);
		c.setCategoria("Categoria1");
		
		p.setNome("Produto 1");
		p.setDescricao("Descrição Produto");
		p.setMarca("Marca 1");
		p.setMedida("22c3");
		p.setQuantidade(4D);
		p.setValorVenda(500.4D);
		p.setCategoria(c);		
		dao.salvar(p);
	}
	
	@Ignore
//	@Test
	public void listar(){
		ProdutoDAO pdao = new ProdutoDAO();
		List<Produto> lista = pdao.listarProdutos();
		
		for(int i = 0; i< lista.size(); i++){
			System.out.println(lista.get(i).getDescricao());
		}
	}

}
