package estoquestiFX.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import estoquestiFX.domain.Estado;
import estoquestiFX.util.HibernateUtil;

public class EstadoDAO {
	public void salvar(Estado estado){
		Session sessao = HibernateUtil.getSessionfactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.save(estado);
			transacao.commit();
		} catch (RuntimeException e) {
			throw e;
		}finally {
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Estado> listar() {
		Session sessao = HibernateUtil.getSessionfactory().openSession();
		List<Estado> listaEstado = null;
		try{
			Query consulta = sessao.getNamedQuery("Estado.listar");
			listaEstado = consulta.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
		}finally {
			sessao.close();
		}
		return listaEstado;
	}
	
}
