package com.lab.controlmat.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.lab.controlmat.entity.Persona;

public interface UsuarioRepository extends CrudRepository<Persona, Integer>{
	
	
	@Query(nativeQuery = true, value = "SELECT count(*) "
			+ "FROM persona p "
			+ "INNER JOIN usuario_rol u ON P.id_persona = u.fk_id_persona "
			+ "WHERE p.numero_documento = :usuario "
			+ "and u.clave = :clave ")
	public int validateUser(@Param("usuario") String usuario, @Param("clave") String clave);
}
