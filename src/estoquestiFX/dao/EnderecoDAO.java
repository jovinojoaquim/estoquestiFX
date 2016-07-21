package estoquestiFX.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import estoquestiFX.domain.Endereco;
import estoquestiFX.util.HibernateUtil;

public class EnderecoDAO {
	public void salvar(Endereco endereco){
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction transacao = null;
		try{
			transacao = session.beginTransaction();
			session.save(endereco);
			transacao.commit();
		}catch (RuntimeException e) {
			throw e;
		}finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Endereco> listar() {
		Session session = HibernateUtil.getSessionfactory().openSession();
		List<Endereco> listaDeEnderecos = null;
		try{
			Query consulta = session.getNamedQuery("Endereco.listar");
			listaDeEnderecos = consulta.list();
		}catch (RuntimeException e) {
			throw e;
		}finally {
			session.close();
		}
		return listaDeEnderecos;
	}

	@SuppressWarnings("unchecked")
	public List<Endereco> buscar(String logradouro) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		List<Endereco> listaDeEnderecos = null;
		try{
			Query consulta = session.getNamedQuery("Endereco.buscar");
			consulta.setString("logradouro", logradouro+"%");
			listaDeEnderecos = consulta.list();
		}catch (RuntimeException e) {
			throw e;
		}finally {
			session.close();
		}
		return listaDeEnderecos;
	}
}
