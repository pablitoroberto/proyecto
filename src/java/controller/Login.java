package controller;

import entidades.Usuario;
import java.io.Serializable;
import javax.ejb.EJB;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

import session.servicioLogeo;

@ManagedBean
@SessionScoped
public class Login implements Serializable {

    private static final long serialVersionUID = 1094801825228386363L;
    @EJB
    private servicioLogeo servicioLogeo;
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    private String pwd;
    private String msg;
    private String user;
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    //validate login
    public String validateUsernamePassword() {
        FacesContext context = FacesContext.getCurrentInstance();
        

        boolean valid = LoginDAO.validate(user, pwd);

        if (valid) {
            
            try {
            usuario = this.servicioLogeo.obtenerUsuario(user, pwd);
        } catch (Exception e) {
        }
            
            
            
            if (tipo.equals("1") && usuario.getTipoUsuario().equals("administrador")) {
                context.addMessage(null, new FacesMessage("BIENVENIDO \n "+ usuario.getNombre().toUpperCase()));
                return "/Administrador/TemplateAdministrador";
            }
            else if (tipo.equals("2") && usuario.getTipoUsuario().equals("comision")) {
                return "/horario/TemplateHorario";
            }
            else if (tipo.equals("3") && usuario.getTipoUsuario().equals("docente")) {
                return "template";
            }
            else{
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Usuario y Contraseña Inconrrecta",
                            "Please enter correct username and Password"));
            }

        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return "login";
        }
        return "login";
    }

    //logout event, invalidate session
    
}
