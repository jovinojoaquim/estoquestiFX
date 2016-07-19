package estoquestiFX.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import estoquestiFX.domain.Categoria;
import estoquestiFX.util.HibernateUtil;

public class CategoriaDAO {
	
	public void salvar(Categoria categoria){
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction transacao = null;
		try {
			transacao = session.beginTransaction();
			session.save(categoria);
			transacao.commit();	
		} catch (RuntimeException e) {
			// TODO: handle exception
		}finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Categoria> listarCategorias() {
		Session session = HibernateUtil.getSessionfactory().openSession();
		List<Categoria> listaDeCategorias = null;
		try {
			Query consulta = session.getNamedQuery("Categoria.listarCategorias");
			listaDeCategorias = consulta.list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return listaDeCategorias;
	}
}
