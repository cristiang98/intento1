package com.clase9proyecto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("equipo_encuentro")
public class Equipo_Encuentro {

    @Id
    private Long id;

    private AggregateReference<Equipo, Long> idEquipo;
    private AggregateReference<EncuentroParanormal, Long> idEncuentro;

}
