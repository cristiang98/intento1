package com.clase9proyecto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipoEncuentroId implements Serializable {

    private Long idEquipo;
    private Long idEncuentro;

}
