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
@Table(name = "tipo_aula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoAula.findAll", query = "SELECT t FROM TipoAula t"),
    @NamedQuery(name = "TipoAula.findByIdTipoAula", query = "SELECT t FROM TipoAula t WHERE t.idTipoAula = :idTipoAula"),
    @NamedQuery(name = "TipoAula.findByNombre", query = "SELECT t FROM TipoAula t WHERE t.nombre = :nombre")})
public class TipoAula implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO_AULA")
    private Integer idTipoAula;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(mappedBy = "idTipoAula")
    private Collection<Aula> aulaCollection;

    public TipoAula() {
    }

    public TipoAula(Integer idTipoAula) {
        this.idTipoAula = idTipoAula;
    }

    public Integer getIdTipoAula() {
        return idTipoAula;
    }

    public void setIdTipoAula(Integer idTipoAula) {
        this.idTipoAula = idTipoAula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Aula> getAulaCollection() {
        return aulaCollection;
    }

    public void setAulaCollection(Collection<Aula> aulaCollection) {
        this.aulaCollection = aulaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoAula != null ? idTipoAula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAula)) {
            return false;
        }
        TipoAula other = (TipoAula) object;
        if ((this.idTipoAula == null && other.idTipoAula != null) || (this.idTipoAula != null && !this.idTipoAula.equals(other.idTipoAula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + nombre + "";
    }
    
}
