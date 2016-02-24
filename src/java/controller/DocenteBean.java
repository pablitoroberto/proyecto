/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entidades.Docente;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import session.servicioDocente;



@ManagedBean
@SessionScoped
public class DocenteBean implements Serializable {
    private static final long serialVersionUID = 5821134609896083061L;
    @EJB
    private servicioDocente servicioDocente;
    private Docente docente;
    
    private String nombre;
    private String ci;
    private String email_inst;
    private String email_per;
    private String categoria;
    private String dedicacion;
    private String estado;
    private int tiempo;
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getEmail_inst() {
        return email_inst;
    }

    public void setEmail_inst(String email_inst) {
        this.email_inst = email_inst;
    }

    public String getEmail_per() {
        return email_per;
    }

    public void setEmail_per(String email_per) {
        this.email_per = email_per;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDedicacion() {
        return dedicacion;
    }

    public void setDedicacion(String dedicacion) {
        this.dedicacion = dedicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    
    public DocenteBean(){
    }
    
    
    public void returnClienteById() {
        try {
             docente = servicioDocente.obtenerDocente(getCi());
        } catch (Exception e) {
        }
        
        if(docente == null) { 
            setNombre("");
            setEmail_inst("");
            setEmail_per("");
            setEstado("");
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Cliente NO encontrado "));
        }
        if (docente != null) {
            setNombre(docente.getNombre());
            setEmail_inst(docente.getEmailInstitucional());
            setEmail_per(docente.getEmailPersonal());
            setEstado(docente.getEstado());
        } 
    }
    
    public String encontrar() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            docente = this.servicioDocente.obtenerDocente(ci);
        } catch (Exception e) {
        }

        boolean valid = LoginDAO.validatedocente(ci);

        if (valid) {
            
            context.addMessage(null, new FacesMessage("BIENVENIDO \n "+ docente.getNombre().toUpperCase()));
            return "/docente/docente";

        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Cedula incorrecta",
                            "Ingrese una cedula valida"));
            return "TemplateDocente";
        }
        
    }
}
