package estoquestiFX.dao;




import org.hibernate.Session;
import org.hibernate.Transaction;

import estoquestiFX.domain.DptoUsuario;
import estoquestiFX.util.HibernateUtil;

import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Jovino
 */
public class DptoUsuarioDAO {

    public void salvar(DptoUsuario dptUsuarioDomain) {
        Session sessao = HibernateUtil.getSessionfactory().openSession();
        Transaction transacao = null;
        try {
            transacao = sessao.beginTransaction();
            sessao.save(dptUsuarioDomain);
            transacao.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sessao.close();
        }
    }
    
    @SuppressWarnings("unchecked")
	public List<DptoUsuario> buscar(){
        Session sessao = HibernateUtil.getSessionfactory().openSession();
        List<DptoUsuario> departamentos = null;
        try {
            Query consulta = sessao.getNamedQuery("DptoUsuario.listar");
            departamentos = consulta.list();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sessao.close();
        }
        return departamentos;
    }
    
}
