package estoquestiFX.bean;


import java.util.List;

import estoquestiFX.dao.DptoUsuarioDAO;
import estoquestiFX.domain.DptoUsuario;

/**
 *
 * @author Jovino
 */
public class DptoUsuarioBean {

    public void salvar(String nomeDepartamento) {
        DptoUsuario dptUsuarioDomain = new DptoUsuario();
        DptoUsuarioDAO dptUsuarioDAO = new DptoUsuarioDAO();
        
        dptUsuarioDomain.setNomeDpto(nomeDepartamento);
        
        dptUsuarioDAO.salvar(dptUsuarioDomain);
    }
    
    public List<DptoUsuario> buscar(){
        DptoUsuarioDAO dptUsuarioDAO = new DptoUsuarioDAO();
        return dptUsuarioDAO.buscar();
    }
    
}
