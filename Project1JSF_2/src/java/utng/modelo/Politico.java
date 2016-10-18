
package utng.modelo;

import java.io.Serializable;                                                            
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author RRSR
 */
@Entity @Table(name= "politico")
public class Politico implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_politico")
    private Long idPolitico;
    @Column(name = "nombre_politico", length = 20)
    private String nombrePolitico;
    @Column(name= "apellido", length = 20)
    private String apellido;
    @Column(name= "correo", length = 40)
    private String correo;
     
    @ManyToOne  ////este esta en duda por lo de el cascade 
    @JoinColumn(name = "id_partido")
    private Partido partido;

    public Politico(Long idPolitico, String nombrePolitico, String apellido, String correo, Partido partido) {
        super();
        this.idPolitico = idPolitico;
        this.nombrePolitico = nombrePolitico;
        this.apellido = apellido;
        this.correo = correo;
        this.partido = partido;
    }

    public Politico() {
            this.idPolitico = 0L;
    }

    public Long getIdPolitico() {
        return idPolitico;
    }

    public void setIdPolitico(Long idPolitico) {
        this.idPolitico = idPolitico;
    }

    public String getNombrePolitico() {
        return nombrePolitico;
    }

    public void setNombrePolitico(String nombrePolitico) {
        this.nombrePolitico = nombrePolitico;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

   

   
}
