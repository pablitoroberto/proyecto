/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entidades.Carrera;
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
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;


@ManagedBean
@ViewScoped
public class mbmateria implements Serializable {

    @ManagedProperty(value = "#{mbdocente}")
    private mbdocente mbdocente= new  mbdocente();
    public mbdocente getMbdocente() {
        return mbdocente;
    }

    public void setMbdocente(mbdocente mbdocente) {
        this.mbdocente = mbdocente;
    }
    
    private int iddocente= 0;
    private int idmateria= 0;
    private String nombredocente;
    private String nombremateria;

    public int getIddocente() {
        return iddocente;
    }

    public void setIddocente(int iddocente) {
        this.iddocente = iddocente;
    }

    public int getIdmateria() {
        return idmateria;
    }

    public void setIdmateria(int idmateria) {
        this.idmateria = idmateria;
    }

    public String getNombredocente() {
        return nombredocente;
    }

    public void setNombredocente(String nombredocente) {
        this.nombredocente = nombredocente;
    }

    public String getNombremateria() {
        return nombremateria;
    }

    public void setNombremateria(String nombremateria) {
        this.nombremateria = nombremateria;
    }
    
    
    
    
    
    
    
    
    
    private Carrera carrera;

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
    
    
    public mbmateria(){
    }
    
    private ArrayList<SelectItem> lst = null;

    public ArrayList<SelectItem> getLst() {
        return lst;
    }

    public void setLst(ArrayList<SelectItem> lst) {
        this.lst = lst;
    }

    public void cargarMAterias(int id_carre) throws Exception {
        
        lst=new ArrayList<>();
        LoginDAO dao = new LoginDAO();
        try {
            for (Materia m : dao.damemateria(id_carre)) {
                SelectItem s = new SelectItem(m.getIdMateria(), m.getNombre());
                lst.add(s);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(mbmateria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
}
