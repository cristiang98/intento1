package com.clase9proyecto.repository;

import com.clase9proyecto.model.Caso;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ICasoRepository extends CrudRepository<Caso, Long> {

    @Query("SELECT * FROM caso WHERE id_miembro = :idMiembro")
    Set<Caso> findCasosByMiembroId(Long idMiembro);

}
