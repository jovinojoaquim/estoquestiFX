package estoquestiFX.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import estoquestiFX.domain.Produto;
import estoquestiFX.util.HibernateUtil;

public class ProdutoDAO {
	public void salvar(Produto p){
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(p);
			transaction.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Produto> listarProdutos() {
		Session session = HibernateUtil.getSessionfactory().openSession();
		List<Produto> listaDeProdutos = null;
		try {
			Query consulta = session.getNamedQuery("Produto.listar");
			listaDeProdutos = consulta.list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return listaDeProdutos;
	}

	public void editar(Produto p) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction transacao = null;
		try {
			transacao = session.beginTransaction();
			session.update(p);
			transacao.commit();
		} catch (Exception e) {
			e.getMessage();
		}finally {
			session.close();
		}
		
	}

	@SuppressWarnings("unchecked")
	public List<Produto> pesquisarProduto(String nomeProduto) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		List<Produto> listaDeProdutos = null;
		try {
			Query consulta = session.getNamedQuery("Produto.buscarPorNome");
			consulta.setString("produto", nomeProduto+"%");
			listaDeProdutos = consulta.list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return listaDeProdutos;
	}
}
