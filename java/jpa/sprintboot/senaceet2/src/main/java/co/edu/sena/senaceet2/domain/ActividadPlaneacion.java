/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.senaceet2.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "actividad_planeacion", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_actividad", "id_planeacion_trimestre"})})
@NamedQueries({
    @NamedQuery(name = "ActividadPlaneacion.findAll", query = "SELECT a FROM ActividadPlaneacion a")})
public class ActividadPlaneacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JoinColumn(name = "id_actividad", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Actividad idActividad;
    @JoinColumn(name = "id_planeacion_trimestre", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PlaneacionTrimestre idPlaneacionTrimestre;

    public ActividadPlaneacion() {
    }

    public ActividadPlaneacion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Actividad getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Actividad idActividad) {
        this.idActividad = idActividad;
    }

    public PlaneacionTrimestre getIdPlaneacionTrimestre() {
        return idPlaneacionTrimestre;
    }

    public void setIdPlaneacionTrimestre(PlaneacionTrimestre idPlaneacionTrimestre) {
        this.idPlaneacionTrimestre = idPlaneacionTrimestre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActividadPlaneacion)) {
            return false;
        }
        ActividadPlaneacion other = (ActividadPlaneacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.senaceet.model.entities.ActividadPlaneacion[ id=" + id + " ]";
    }
    
}
