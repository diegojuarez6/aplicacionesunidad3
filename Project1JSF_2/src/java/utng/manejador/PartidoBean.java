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
import utng.datos.PartidoDAO;
import utng.modelo.Partido;


/**
 *
 * @author RRSR
 */
@ManagedBean
@SessionScoped
public class PartidoBean implements Serializable{
    private List<Partido> partidos;
    private Partido partido;

    public PartidoBean() {
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }
    
     public String listar(){
       PartidoDAO dao = new PartidoDAO();
       try{
           partidos = dao.getAll();
       }catch (Exception e){
           e.printStackTrace();
       }
       return "Partidos";
   }
     public String eliminar(){
       PartidoDAO dao = new PartidoDAO();
       try{
           dao.delete(partido);
           partidos = dao.getAll();
       }catch (Exception e){
           e.printStackTrace();
       }
       return "Eliminar";
   }
     public String iniciar(){
       partido = new Partido();
       return "Iniciar";
   }
      public String guardar(){
       PartidoDAO dao = new PartidoDAO();
       try{
           if (partido.getIdPartido()!= 0){
               dao.update(partido);
           }else{
               dao.insert(partido);
           }
           partidos = dao.getAll();
       }catch (Exception e){
           e.printStackTrace();
       }
       return "Guardar";
   }
    
     public String cancelar(){
       return "Cancelar";
   }
     public String editar(Partido partido){
       this.partido = partido;
       return "Editar";
   }
}
