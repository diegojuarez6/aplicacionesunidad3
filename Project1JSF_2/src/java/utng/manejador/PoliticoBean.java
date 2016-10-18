/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.manejador;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import utng.datos.PartidoDAO;
import utng.datos.PoliticoDAO;
import utng.modelo.Partido;
import utng.modelo.Politico;


/**
 *
 * @author RRSR
 */
@ManagedBean(name= "politicoBean")
@SessionScoped
public class PoliticoBean implements Serializable{
    private List<Politico> politicos;
    private Politico politico;
    private List<Partido> partidos;
    
    public PoliticoBean(){
        politico = new Politico();
        politico.setPartido(new Partido());
    }

    public List<Politico> getPoliticos() {
        return politicos;
    }

    public void setPoliticos(List<Politico> politicos) {
        this.politicos = politicos;
    }

    public Politico getPolitico() {
        return politico;
    }

    public void setPolitico(Politico politico) {
        this.politico = politico;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }
    
    public String listar(){
      PoliticoDAO dao = new PoliticoDAO();
        try {
            politicos = dao.getAll();
        } catch (Exception e) { 
            e.printStackTrace();
        }
        return "Politicos";
    }
     public String eliminar(){
        PoliticoDAO dao = new PoliticoDAO();
        try {
            dao.delete(politico);
            politicos = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Eliminar";
    }
     public String iniciar(){
        politico = new Politico();
        politico.setPartido(new Partido());
        try {
            partidos = new PartidoDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Iniciar";
    }
     public String guardar(){
        PoliticoDAO dao = new PoliticoDAO();
        try {
            if(politico.getIdPolitico()!= 0){
                dao.update(politico);
            }else{
                dao.insert(politico);
            } 
            politicos = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Guardar";
    }
      public  String cancelar(){
        return "Cancelar";
    }
      public String editar(Politico politico){
        this.politico = politico;
        try {
            partidos = new PartidoDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Editar";
    }
}
