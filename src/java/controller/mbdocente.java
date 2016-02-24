/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entidades.Carrera;
import entidades.Disponibilidad;
import entidades.Docente;
import entidades.Materia;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;


@ManagedBean
@ViewScoped
public class mbdocente implements Serializable {

    private Disponibilidad disponibilidad;
    private Docente docente;

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }
    

    public Disponibilidad getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Disponibilidad disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

   
    
    
    public mbdocente(){
    }
    
    private ArrayList<SelectItem> lst = null;

    public ArrayList<SelectItem> getLst() {
        return lst;
    }

    public void setLst(ArrayList<SelectItem> lst) {
        this.lst = lst;
    }

    public void cargarDocente(int idmateria) throws Exception {
        lst=new ArrayList<>();
        LoginDAO dao = new LoginDAO();
        try {
            for (Docente m : dao.damedocente(idmateria)) {
                SelectItem s = new SelectItem(m.getIdDocente(),m.getNombre());
                lst.add(s);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(mbdocente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
