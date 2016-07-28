package estoquestiFX.dao;



import java.util.List;

import org.hibernate.Query;
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

	@SuppressWarnings("unchecked")
	public List<Fornecedor> buscar(String razaoSocial) {
		Session sessao = HibernateUtil.getSessionfactory().openSession();
		List<Fornecedor> listaDeFornecedores = null;
		try{
			Query consulta = sessao.getNamedQuery("Fornecedor.buscarRazaoSocial");
			consulta.setString("razaoSocial", razaoSocial+"%");
			listaDeFornecedores = consulta.list();
		}catch (RuntimeException e) {
			throw e;
		}
		return listaDeFornecedores;
	}

}
