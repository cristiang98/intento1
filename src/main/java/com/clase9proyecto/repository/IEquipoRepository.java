package com.clase9proyecto.repository;

import com.clase9proyecto.model.Caso;
import com.clase9proyecto.model.EncuentroParanormal;
import com.clase9proyecto.model.Equipo;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEquipoRepository extends CrudRepository<Equipo, Long> {

    @Query("SELECT * FROM Equipo WHERE id_miembro = :idMiembro")
    Equipo findEquipoByidMiembro(Long idMiembro);

    @Query("SELECT * FROM encuentro_paranormal e WHERE e.id IN " +
            "(SELECT ee.id_encuentro FROM equipo_encuentro ee WHERE ee.id_equipo = :idEquipo)")
    List<EncuentroParanormal> findEncuentrosByEquipoId(@Param("idEquipo") Long idEquipo);

}
