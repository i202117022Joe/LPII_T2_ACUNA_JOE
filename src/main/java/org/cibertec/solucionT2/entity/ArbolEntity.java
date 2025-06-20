package org.cibertec.solucionT2.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "arbol")
public class ArbolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_arbol")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_responsable", nullable = false)
    private ResponsableEntity responsable;

    @ManyToOne
    @JoinColumn(name = "id_especie", nullable = false)
    private EspecieEntity especie;

    @Column(name = "fecha_plantacion", nullable = false)
    private Date fechaPlantacion;

    @Column(name = "coordenadas", nullable = false, length = 50)
    private String coordenadas;

    @Column(name = "hash_registro", nullable = false, length = 64)
    private String hashRegistro;

    // Getters y Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ResponsableEntity getResponsable() {
        return responsable;
    }

    public void setResponsable(ResponsableEntity responsable) {
        this.responsable = responsable;
    }

    public EspecieEntity getEspecie() {
        return especie;
    }

    public void setEspecie(EspecieEntity especie) {
        this.especie = especie;
    }

    public Date getFechaPlantacion() {
        return fechaPlantacion;
    }

    public void setFechaPlantacion(Date fechaPlantacion) {
        this.fechaPlantacion = fechaPlantacion;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getHashRegistro() {
        return hashRegistro;
    }

    public void setHashRegistro(String hashRegistro) {
        this.hashRegistro = hashRegistro;
    }
}
