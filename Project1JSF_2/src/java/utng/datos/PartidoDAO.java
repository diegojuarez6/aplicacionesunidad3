/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.datos;

import org.hibernate.HibernateException;
import utng.modelo.Partido;

/**
 *
 * @author RRSR
 */
public class PartidoDAO extends DAO<Partido>{
    public PartidoDAO(){
        super(new Partido());
    }
    
    public Partido getOneById(Partido partido)
            throws HibernateException{
        return super.getOneById(partido.getIdPartido());
    }
    
}
