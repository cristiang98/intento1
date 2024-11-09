package com.clase9proyecto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Column;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Equipo {
    @Id
    private Long id;
    private String nombre;
    private Tipo tipo;
    @Column("estado_funcional")
    private boolean estadoFuncional;
    private AggregateReference<Miembro, Long> idMiembro;

    @Transient
    private Set<Equipo_Encuentro> equipoEncuentros = new HashSet<>();

    public  Equipo(Long id, String nombre, Tipo tipo, boolean estadoFuncional, AggregateReference<Miembro, Long> idMiembro){
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.estadoFuncional = estadoFuncional;
        this.idMiembro = idMiembro;
    }

}
