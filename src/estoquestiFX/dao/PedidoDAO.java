package estoquestiFX.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import estoquestiFX.domain.Pedido;
import estoquestiFX.util.HibernateUtil;

public class PedidoDAO {
	public void salvar(Pedido p){
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction transacao = null;
		try{
			transacao = session.beginTransaction();
			session.save(p);
			transacao.commit();			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
}
