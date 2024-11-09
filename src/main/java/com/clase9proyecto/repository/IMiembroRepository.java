package com.clase9proyecto.repository;
import com.clase9proyecto.model.Miembro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;


@Repository
public interface IMiembroRepository extends CrudRepository<Miembro, Long> {


}
