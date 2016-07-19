package estoquestiFX.bean;

import java.util.List;
import estoquestiFX.dao.CategoriaDAO;
import estoquestiFX.domain.Categoria;

public class CategoriaBean {
	public void salvar(String nomeCategoria){
		Categoria categoria = new Categoria();
		CategoriaDAO dao = new CategoriaDAO();
		
		categoria.setCategoria(nomeCategoria);
		dao.salvar(categoria);
	}
	
	public List<Categoria> listarCategorias(){
		CategoriaDAO dao = new CategoriaDAO();
		return dao.listarCategorias();
	}
}
