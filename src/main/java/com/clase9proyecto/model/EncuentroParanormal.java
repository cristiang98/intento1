package com.clase9proyecto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EncuentroParanormal {
    @Id
    private Long id;
    private String nombre;
    private String descripcion;
    private String fecha;
    private TipoFenomeno tipoFenomeno;

    @Transient
    private Set<Equipo_Encuentro> encuentrosEquipo = new HashSet<>();
}
