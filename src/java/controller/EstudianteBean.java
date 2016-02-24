/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import entidades.Estudiante;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import session.servicioEstudiante;



@ManagedBean
@SessionScoped
public class EstudianteBean implements Serializable {
    private static final long serialVersionUID = 5821134609896083061L;
    @EJB
    private servicioEstudiante servicioEstudiante;
    private Estudiante estudiante;
    
    private String nombre;
    private String ci;
    
    
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

   
    
    public EstudianteBean(){
    }
    
    
    public void returnClienteById() {
        try {
             estudiante = servicioEstudiante.obtenerDocente(getCi());
        } catch (Exception e) {
        }
        
        if(estudiante == null) { 
            setNombre("");
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Cliente NO encontrado "));
        }
        if (estudiante != null) {
            setNombre(estudiante.getNombres());
            
        } 
    }
    
        public String encontrar() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            estudiante = this.servicioEstudiante.obtenerDocente(ci);
        } catch (Exception e) {
        }

        boolean valid = LoginDAO.validateestudainte(ci);

        if (valid) {
            
            boolean valid1 = LoginDAO.validateeperincripcion(ci);
            
            if (valid1) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Estudiante Registrado",
                            "Ingrese otro numero de cedula "));
            return "TemplateEstudiante";
            
            }else{
                context.addMessage(null, new FacesMessage("BIENVENIDO \n "+estudiante.getApellidoPaterno()+"  "+estudiante.getApellidoMaterno()+"  " +estudiante.getNombres().toUpperCase()));
            return "/estudiante/Preinscripcion";
            
            }

        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Cedula incorrecta",
                            "Ingrese una cedula valida"));
            return "TemplateEstudiante";
        }
        
    }
}
