package com.clase9proyecto.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Column;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Caso {
    @Id
    private Long id;
    private String nombre;
    private String ubicacion;
    private NivelActividad nivelActividad;
    private String fechaApertura;
    @Column("id_miembro")
    private AggregateReference<Miembro,Long> idMiembro;


}
