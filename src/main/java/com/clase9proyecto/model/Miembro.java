package com.clase9proyecto.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import java.util.HashSet;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("miembro")
public class Miembro {

    @Id
    private Long id;
    private String nombre;
    private Rol rol; // Asumiendo que tienes un Enum llamado Rol
    private Integer edad;
    private String especialidad;
    @Transient
    private Set<Caso> casos = new HashSet<>();


    public Miembro(String nombre, Rol rol, Integer edad, String especialidad) {
        this.nombre = nombre;
        this.rol = rol;
        this.edad = edad;
        this.especialidad = especialidad;
    }

}

