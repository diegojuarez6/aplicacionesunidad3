/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.datos;

import org.hibernate.HibernateException;
import utng.modelo.Politico;

/**
 *
 * @author RRSR
 */
public class PoliticoDAO extends DAO<Politico>{
    public PoliticoDAO(){
        super (new Politico());
    }
    public Politico getOneById(Politico politico)
            throws HibernateException{
        return super.getOneById(politico.getIdPolitico());
    }
    
}
