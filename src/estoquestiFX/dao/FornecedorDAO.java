package estoquestiFX.dao;



import org.hibernate.Session;
import org.hibernate.Transaction;

import estoquestiFX.domain.Fornecedor;
import estoquestiFX.util.HibernateUtil;

public class FornecedorDAO {

	public void salvar(Fornecedor f) {
		Session sessao = HibernateUtil.getSessionfactory().openSession();
		Transaction transacao = null;
		try{
			transacao = sessao.beginTransaction();
			sessao.save(f);
			transacao.commit();
		}catch (RuntimeException e) {
			throw e;
		}
		
	}

}
