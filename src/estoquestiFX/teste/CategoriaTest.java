package estoquestiFX.teste;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import estoquestiFX.bean.CategoriaBean;
import estoquestiFX.domain.Categoria;

public class CategoriaTest {

	@Test
	public void salvarCategoria() {
		CategoriaBean categoriaBean = new CategoriaBean();
		categoriaBean.salvar("Categoria1");
	}
	
	@Ignore
	public void listar(){
		CategoriaBean categoriaBean = new CategoriaBean();
		List<Categoria> categorias = categoriaBean.listarCategorias();
		for(int i = 0; i < categorias.size(); i++){
			System.out.println(categorias.get(i).getCategoria());
		}
	}

}
