/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pa_bl
 */
@Entity
@Table(name = "prenscripcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prenscripcion.findAll", query = "SELECT p FROM Prenscripcion p"),
    @NamedQuery(name = "Prenscripcion.findByIdPreinscripcion", query = "SELECT p FROM Prenscripcion p WHERE p.idPreinscripcion = :idPreinscripcion"),
    @NamedQuery(name = "Prenscripcion.findByEstado", query = "SELECT p FROM Prenscripcion p WHERE p.estado = :estado"),
    @NamedQuery(name = "Prenscripcion.findByObservacion", query = "SELECT p FROM Prenscripcion p WHERE p.observacion = :observacion")})
public class Prenscripcion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PREINSCRIPCION")
    private Integer idPreinscripcion;
    @Size(max = 10)
    @Column(name = "ESTADO")
    private String estado;
    @Size(max = 250)
    @Column(name = "OBSERVACION")
    private String observacion;
    @JoinColumn(name = "ID_MATERIA", referencedColumnName = "ID_MATERIA")
    @ManyToOne(optional = false)
    private Materia idMateria;
    @JoinColumn(name = "ID_ESTUDIANTE", referencedColumnName = "ID_ESTUDIANTE")
    @ManyToOne
    private Estudiante idEstudiante;

    public Prenscripcion() {
    }

    public Prenscripcion(Integer idPreinscripcion) {
        this.idPreinscripcion = idPreinscripcion;
    }

    public Integer getIdPreinscripcion() {
        return idPreinscripcion;
    }

    public void setIdPreinscripcion(Integer idPreinscripcion) {
        this.idPreinscripcion = idPreinscripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Materia getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Materia idMateria) {
        this.idMateria = idMateria;
    }

    public Estudiante getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Estudiante idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPreinscripcion != null ? idPreinscripcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prenscripcion)) {
            return false;
        }
        Prenscripcion other = (Prenscripcion) object;
        if ((this.idPreinscripcion == null && other.idPreinscripcion != null) || (this.idPreinscripcion != null && !this.idPreinscripcion.equals(other.idPreinscripcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Prenscripcion[ idPreinscripcion=" + idPreinscripcion + " ]";
    }
    
}
