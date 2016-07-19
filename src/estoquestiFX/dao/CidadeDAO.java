package estoquestiFX.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import estoquestiFX.domain.Cidade;
import estoquestiFX.util.HibernateUtil;

public class CidadeDAO {
	
	public void salvar(Cidade cidade){
		Session sessao = HibernateUtil.getSessionfactory().openSession();
		Transaction transacao = null;
		try {
			System.out.println(cidade.getCidade().length());
			transacao = sessao.beginTransaction();
			sessao.save(cidade);
			transacao.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally {
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Cidade> listar() {
		Session session = HibernateUtil.getSessionfactory().openSession();
		List<Cidade> listaDeCidades = null;
		try {
			Query consulta = session.getNamedQuery("Cidade.listarCidadeEstado");
			listaDeCidades = consulta.list();
		} catch (RuntimeException e) {
			// TODO: handle exception
		}finally {
			session.close();
		}
		return listaDeCidades;
	}

	@SuppressWarnings("unchecked")
	public List<Cidade> buscarCidade(String cidade) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		List<Cidade> listaDeCidades = null;
		try{
			Query consulta = session.getNamedQuery("Cidade.buscarCidade");
			consulta.setString("cidade", cidade+"%");
			listaDeCidades = consulta.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return listaDeCidades;
	}

	@SuppressWarnings("unchecked")
	public List<Cidade> buscarCidade(String cidade, Long id) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		List<Cidade> listaDeCidades = null;
		try {
			Query consulta = session.getNamedQuery("Cidade.buscarCidadeEEstado");
			consulta.setString("cidade", cidade+"%");
			consulta.setLong("id_estado", id);
			listaDeCidades = consulta.list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return listaDeCidades;
	}

	@SuppressWarnings("unchecked")
	public List<Cidade> buscarCidade(Long id) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		List<Cidade> listaDeCidades = null;
		try {
			Query consulta = session.getNamedQuery("Cidade.buscarPorEstado");
			consulta.setLong("id_estado", id);
			listaDeCidades = consulta.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return listaDeCidades;
	}
}
