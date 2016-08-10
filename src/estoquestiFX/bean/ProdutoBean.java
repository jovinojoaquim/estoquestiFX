package estoquestiFX.bean;

import java.util.List;
import estoquestiFX.dao.ProdutoDAO;
import estoquestiFX.domain.Categoria;
import estoquestiFX.domain.Produto;
import javafx.beans.property.StringProperty;

public class ProdutoBean {
	public void salvar(String nome, String descricao, double quantidade, String medida, String marca, double valorVenda, Categoria categoriaSelecionada, Double valorCompra){
		ProdutoDAO dao = new ProdutoDAO();
		Produto p = new Produto();
		
		p.setNome(nome);
		p.setDescricao(descricao);
		p.setQuantidade(quantidade);
		p.setMedida(medida);
		p.setMarca(marca);
		p.setValorVenda(valorVenda);
		p.setCategoria(categoriaSelecionada);
		p.setValorCompra(valorCompra);
		
		dao.salvar(p);
	}
	
	public List<Produto> listarProdutos(){
		ProdutoDAO dao = new ProdutoDAO();
		return dao.listarProdutos();
	}

	public void editar(Long id, String nome, String descricao, double quantidade, String medida, String marca, double valorVenda, Categoria categoriaSelecionada) {
		ProdutoDAO dao = new ProdutoDAO();
		Produto p = new Produto();
		
		p.setIdProduto(id);
		p.setNome(nome);
		p.setDescricao(descricao);
		p.setQuantidade(quantidade);
		p.setMedida(medida);
		p.setMarca(marca);
		p.setValorVenda(valorVenda);
		p.setCategoria(categoriaSelecionada);
		
		dao.editar(p);
	}

	public List<Produto> pesquisarProduto(String nomeProduto) {
		ProdutoDAO dao = new ProdutoDAO();
		return dao.pesquisarProduto(nomeProduto);
	}
	
	public Produto pesquisarProduto(Long idProduto){
		ProdutoDAO dao = new ProdutoDAO();
		return dao.pesquisarProduto(idProduto);
	}
}
