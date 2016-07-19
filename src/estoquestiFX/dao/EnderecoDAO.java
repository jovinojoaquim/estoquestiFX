package estoquestiFX.dao;

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
}
