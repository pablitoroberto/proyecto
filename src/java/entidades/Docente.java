/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pa_bl
 */
@Entity
@Table(name = "docente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docente.findAll", query = "SELECT d FROM Docente d"),
    @NamedQuery(name = "Docente.findByIdDocente", query = "SELECT d FROM Docente d WHERE d.idDocente = :idDocente"),
    @NamedQuery(name = "Docente.findByNombre", query = "SELECT d FROM Docente d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Docente.findByCi", query = "SELECT d FROM Docente d WHERE d.ci = :ci"),
    @NamedQuery(name = "Docente.findByEmailInstitucional", query = "SELECT d FROM Docente d WHERE d.emailInstitucional = :emailInstitucional"),
    @NamedQuery(name = "Docente.findByEmailPersonal", query = "SELECT d FROM Docente d WHERE d.emailPersonal = :emailPersonal"),
    @NamedQuery(name = "Docente.findByCategoria", query = "SELECT d FROM Docente d WHERE d.categoria = :categoria"),
    @NamedQuery(name = "Docente.findByDedicacion", query = "SELECT d FROM Docente d WHERE d.dedicacion = :dedicacion"),
    @NamedQuery(name = "Docente.findByEstado", query = "SELECT d FROM Docente d WHERE d.estado = :estado"),
    @NamedQuery(name = "Docente.findByTiempohora", query = "SELECT d FROM Docente d WHERE d.tiempohora = :tiempohora")})
public class Docente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DOCENTE")
    private Integer idDocente;
    @Size(max = 200)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 20)
    @Column(name = "CI")
    private String ci;
    @Size(max = 100)
    @Column(name = "EMAIL_INSTITUCIONAL")
    private String emailInstitucional;
    @Size(max = 250)
    @Column(name = "EMAIL_PERSONAL")
    private String emailPersonal;
    @Size(max = 20)
    @Column(name = "CATEGORIA")
    private String categoria;
    @Size(max = 20)
    @Column(name = "DEDICACION")
    private String dedicacion;
    @Size(max = 20)
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "TIEMPOHORA")
    private Integer tiempohora;
    @OneToMany(mappedBy = "idDocente")
    private Collection<Disponibilidad> disponibilidadCollection;
    @OneToMany(mappedBy = "idDocente")
    private Collection<Horario> horarioCollection;

    public Docente() {
    }

    public Docente(Integer idDocente) {
        this.idDocente = idDocente;
    }

    public Integer getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Integer idDocente) {
        this.idDocente = idDocente;
    }

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

    public String getEmailInstitucional() {
        return emailInstitucional;
    }

    public void setEmailInstitucional(String emailInstitucional) {
        this.emailInstitucional = emailInstitucional;
    }

    public String getEmailPersonal() {
        return emailPersonal;
    }

    public void setEmailPersonal(String emailPersonal) {
        this.emailPersonal = emailPersonal;
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

    public Integer getTiempohora() {
        return tiempohora;
    }

    public void setTiempohora(Integer tiempohora) {
        this.tiempohora = tiempohora;
    }

    @XmlTransient
    public Collection<Disponibilidad> getDisponibilidadCollection() {
        return disponibilidadCollection;
    }

    public void setDisponibilidadCollection(Collection<Disponibilidad> disponibilidadCollection) {
        this.disponibilidadCollection = disponibilidadCollection;
    }

    @XmlTransient
    public Collection<Horario> getHorarioCollection() {
        return horarioCollection;
    }

    public void setHorarioCollection(Collection<Horario> horarioCollection) {
        this.horarioCollection = horarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocente != null ? idDocente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docente)) {
            return false;
        }
        Docente other = (Docente) object;
        if ((this.idDocente == null && other.idDocente != null) || (this.idDocente != null && !this.idDocente.equals(other.idDocente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + nombre + "";
    }
    
}
