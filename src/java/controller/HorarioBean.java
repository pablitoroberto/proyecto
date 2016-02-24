/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.xml.internal.ws.util.Constants;
import entidades.Aula;
import entidades.Carrera;
import entidades.Periodo;
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
public class HorarioBean implements Serializable {

    private ArrayList<SelectItem> cmb1 = null;
    private ArrayList<SelectItem> cmbaula = null;

    public ArrayList<SelectItem> getCmbaula() throws Exception {
        if (cmbaula == null) {
            cmbaula = new ArrayList<>();
            LoginDAO dao = new LoginDAO();
            try {
                for (Aula c : dao.dameaula()) {
                    SelectItem s = new SelectItem(c.getIdAula(), c.getNombre());
                    cmbaula.add(s);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                Logger.getLogger(HorarioBean.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return cmbaula;
    }

    public void setCmbaula(ArrayList<SelectItem> cmbaula) {
        this.cmbaula = cmbaula;
    }

    public HorarioBean() {
    }

    public ArrayList<SelectItem> getCmb1() throws Exception {
        if (cmb1 == null) {
            cmb1 = new ArrayList<>();
            LoginDAO dao = new LoginDAO();
            try {
                for (Periodo c : dao.dameperiodo()) {
                    SelectItem s = new SelectItem(c.getIdPeriodo(), c.getNombre());
                    cmb1.add(s);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                Logger.getLogger(HorarioBean.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return cmb1;
    }

    public void setCmb1(ArrayList<SelectItem> cmb1) {
        this.cmb1 = cmb1;
    }

    private static final long serialVersionUID = 1L;

    String dia;
    String Hora_inicio;
    String Hora_fin;

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora_inicio() {
        return Hora_inicio;
    }

    public void setHora_inicio(String Hora_inicio) {
        this.Hora_inicio = Hora_inicio;
    }

    public String getHora_fin() {
        return Hora_fin;
    }

    public void setHora_fin(String Hora_fin) {
        this.Hora_fin = Hora_fin;
    }

    private static final ArrayList<Order> orderList
            = new ArrayList<Order>(Arrays.asList());

    public ArrayList<Order> getOrderList() {

        return orderList;

    }
    private int idaula;
    private String nombreaula;

    public int getIdaula() {
        return idaula;
    }

    public void setIdaula(int idaula) {
        this.idaula = idaula;
    }

    public String getNombreaula() {
        return nombreaula;
    }

    public void setNombreaula(String nombreaula) {
        this.nombreaula = nombreaula;
    }

    public String addAction() throws SQLException {

        nombreaula = LoginDAO.obtenerAula(idaula);

        Order order = new Order(this.dia, this.Hora_inicio,
                this.Hora_fin, this.nombreaula);

        orderList.add(order);

        return null;
    }

    public String deleteAction(Order order) {

        orderList.remove(order);
        return null;
    }

    public static class Order {

        String dia;
        String Hora_inicio;
        String Hora_fin;
        String nombreaula;

        public Order(String dia, String hi,String hf, String nombreaula ) {
            this.dia = dia;
            this.Hora_inicio = hi;
            this.Hora_fin = hf;
            this.nombreaula = nombreaula;

        }

        

        public String getDia() {
            return dia;
        }

        public void setDia(String dia) {
            this.dia = dia;
        }

        public String getHora_inicio() {
            return Hora_inicio;
        }

        public void setHora_inicio(String Hora_inicio) {
            this.Hora_inicio = Hora_inicio;
        }

        public String getHora_fin() {
            return Hora_fin;
        }

        public void setHora_fin(String Hora_fin) {
            this.Hora_fin = Hora_fin;
        }

        public String getNombreaula() {
            return nombreaula;
        }

        public void setNombreaula(String nombreaula) {
            this.nombreaula = nombreaula;
        }

    }

}
