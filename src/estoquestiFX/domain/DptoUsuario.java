package estoquestiFX.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Jovino
 */
@Entity
@Table(name = "departamento")
@NamedQueries({
    @NamedQuery(name = "DptoUsuario.listar", query = "SELECT dptoUsuario FROM DptoUsuario dptoUsuario")
})
public class DptoUsuario {
    
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepartamento;
    
    @Column(length = 30, nullable = false)
    private String nomeDpto;

    public Long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNomeDpto() {
        return nomeDpto;
    }

    public void setNomeDpto(String nomeDpto) {
        this.nomeDpto = nomeDpto;
    }
    
    
}
