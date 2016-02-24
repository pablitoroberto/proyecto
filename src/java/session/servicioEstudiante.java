/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entidades.Docente;
import entidades.Estudiante;
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
public class servicioEstudiante {
    @PersistenceContext(unitName = "sistemaHorario2016PU")
    private EntityManager em;
    

    public void persist(Object object) {
        em.persist(object);
    }
    
    public Estudiante obtenerDocente(final String Ci){
        Query query= this.em.createQuery("select c from Estudiante c where c.cedula = ?5");
        query.setParameter(5,Ci);
        
        return (Estudiante) query.getSingleResult();
    }
    
    
    
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
