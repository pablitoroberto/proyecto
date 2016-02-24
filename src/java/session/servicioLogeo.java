/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import entidades.Usuario;


/**
 *
 * @author User
 */
@Stateless
@LocalBean
public class servicioLogeo {
    @PersistenceContext(unitName = "sistemaHorario2016PU")
    private EntityManager em;
    

    public void persist(Object object) {
        em.persist(object);
    }
    
    public Usuario obtenerUsuario(final String login, final String clave){
        Query query= this.em.createQuery("select c from Usuario c where c.usuario = ?1 and c.contrasenia = ?2");
        query.setParameter(1,login);
        query.setParameter(2,clave);
        return (Usuario) query.getSingleResult();
    }
    
    
    
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
