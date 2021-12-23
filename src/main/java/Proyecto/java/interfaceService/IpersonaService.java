package Proyecto.java.interfaceService;

import java.util.List;
import java.util.Optional;

import Proyecto.java.modelos.Persona;



public interface IpersonaService {
	
	
List<Persona>listar();
List<Persona> findAll();
Optional<Persona> findById(Long id);
void save (Persona persona);
void deleteById(Long id);
Optional<Persona> findByNombreAndApellido (String nombre, String apellido);

}
