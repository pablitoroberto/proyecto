/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entidades.Carrera;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

 
@ManagedBean
@ViewScoped
public class DropdownView implements Serializable {
    
    @ManagedProperty(value = "#{mbmateria}")
    private mbmateria mbmateria= new  mbmateria();
    @ManagedProperty(value = "#{mbdocente}")
    private mbdocente mbdocente= new  mbdocente();
    public mbdocente getMbdocente() {
        return mbdocente;
    }

    public void setMbdocente(mbdocente mbdocente) {
        this.mbdocente = mbdocente;
    }

    
    private ArrayList<SelectItem> cmb1 =null;
    
    private int idcarrera= 0;
    private int idmateria= 0;
    private int iddocente= 0;
    private String nombrecarre;
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
   
    public String getNombrecarre() {
        return nombrecarre;
    }

    public void setNombrecarre(String nombrecarre) {
        this.nombrecarre = nombrecarre;
    }

    public String getNombremateria() {
        return nombremateria;
    }

    public void setNombremateria(String nombremateria) {
        this.nombremateria = nombremateria;
    }
    private static final ArrayList<Order> orderList = 
		new ArrayList<Order>(Arrays.asList(
		
		
	));
    
    public ArrayList<Order> getOrderList() {
 
		return orderList;
 
	}
    
    
    
    
    public String addAction() throws SQLException, Exception {
                
               nombrecarre= LoginDAO.obtenerCarrera(idcarrera);
                nombremateria=LoginDAO.obtenerMateria(idmateria);
                
	    
		Order order = new Order(this.nombrecarre, this.nombremateria);
		
		orderList.add(order);
		
		return null;
	}
    
    
    public static class Order{
		
		String nombrecarrera;
		String nombremateria;
		
		

		public Order(String nombre_carrera, String nombre_materia) {
			this.nombrecarrera = nombre_carrera;
			this.nombremateria = nombre_materia;
			
			
		}

        public String getNombrecarrera() {
            return nombrecarrera;
        }

        public void setNombrecarrera(String nombrecarrera) {
            this.nombrecarrera = nombrecarrera;
        }

        public String getNombremateria() {
            return nombremateria;
        }

        public void setNombremateria(String nombremateria) {
            this.nombremateria = nombremateria;
        }
		
		
		
	}
    
    
    
    
    
    
    

    public int getIdcarrera() {
        return idcarrera;
    }

    public void setIdcarrera(int idcarrera) {
        this.idcarrera = idcarrera;
    }
    
        public ArrayList<SelectItem> getCmb1() {
            if (cmb1==null) {
                cmb1 = new ArrayList<>();
                LoginDAO carr = new LoginDAO();
                try {
                    for (Carrera c : carr.damecarrera()) {
                        SelectItem s= new SelectItem(c.getIdCarrera(),c.getNombre());
                        cmb1.add(s);
                                
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    Logger.getLogger(DropdownView.class.getName()).log(Level.SEVERE,null,ex);
                    
                }
                        
            }
            return cmb1;
        }

        public void setCmb1(ArrayList<SelectItem> cmb1) {
            this.cmb1 = cmb1;
        }
        
        public void obtenerinfomracion() throws Exception{
            
           // System.out.println(idcarrera);
            mbmateria.cargarMAterias(idcarrera);
            
            
        }
         public void addAction1() throws Exception {
                
                mbdocente.cargarDocente(idmateria);
		
	}
         public void verdisponibilidaddocente() throws Exception {
                System.out.println("wasdasdasdasd"+iddocente);
                
             mbdocente.cargarDocente(idmateria);
		
	}
       
        

    public mbmateria getMbmateria() {
        return mbmateria;
    }

    public void setMbmateria(mbmateria mbmateria) {
        this.mbmateria = mbmateria;
    }

  
   
       public String deleteAction(Order order) {
	    
		orderList.remove(order);
		return null;
	}
    
}