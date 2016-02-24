/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entidades.Docente;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



/**
 *
 * @author User
 */
@Stateless
@LocalBean
public class servicioDocente {
    @PersistenceContext(unitName = "sistemaHorario2016PU")
    private EntityManager em;
    

    public void persist(Object object) {
        em.persist(object);
    }
    
    public Docente obtenerDocente(final String Ci){
        Query query= this.em.createQuery("select c from Docente c where c.ci = ?3");
        query.setParameter(3,Ci);
        
        return (Docente) query.getSingleResult();
    }
    
    
    
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
