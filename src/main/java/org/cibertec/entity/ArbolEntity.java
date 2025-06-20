package org.cibertec.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "arbol")
public class ArbolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_arbol")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_responsable")
    private ResponsableEntity responsable;

    @ManyToOne
    @JoinColumn(name = "id_especie")
    private EspecieEntity especie;

    @Column(name = "fecha_plantacion")
    private java.sql.Date fechaPlantacion;

    @Column(name = "coordenadas")
    private String coordenadas;

    @Column(name = "hash_registro")
    private String hashRegistro;
}
