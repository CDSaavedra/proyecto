package Proyecto.java.Repository;

import Proyecto.java.modelos.Persona;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface ClienteRepository extends JpaRepository<Persona, Long> {

	 
	@Query("SELECT p FROM Persona p WHERE p.edad = ?1")
	List<Persona> findByedad(String edad);
	
	@Query("SELECT p FROM Persona p WHERE p.fecharegisto = ?1")
	List<Persona> findByfecharegisto (String fecharegisto);
	
	
	@Query ("SELECT p FROM Persona p WHERE p.nombre = ?1 AND p.apellido = ?2")
	Optional<Persona> findByNombreAndApellido (String nombre, String apellido);
	

	
}

