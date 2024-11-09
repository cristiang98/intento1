package com.clase9proyecto.repository;

import com.clase9proyecto.model.Equipo;
import com.clase9proyecto.model.Equipo_Encuentro;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEquipoEncuentroRepository extends CrudRepository<Equipo_Encuentro, Long> {

    @Query("SELECT COUNT(*) FROM equipo_encuentro WHERE id_equipo = :idEquipo AND id_encuentro = :idEncuentro")
    int countByEquipoAndEncuentro(@Param("idEquipo") Long idEquipo, @Param("idEncuentro") Long idEncuentro);

    @Query("SELECT e.* FROM equipo_encuentro ee JOIN equipo e ON ee.id_equipo = e.id WHERE ee.id_encuentro = :idEncuentro")
    List<Equipo> findEquiposByEncuentro(@Param("idEncuentro") Long idEncuentro);


}
