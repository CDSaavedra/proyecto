package Proyecto.java.Controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import Proyecto.java.interfaceService.IpersonaService;
import Proyecto.java.modelos.Persona;




@RestController
@RequestMapping("clientes")
public class ProyectoController {

	@Autowired
	private IpersonaService personaService;

	@Secured({"ROLE_ADMIN", "ROLE_CUSTOMER"})
	@GetMapping("/pconsultas/{id}")
	public Optional<Persona> findById(@PathVariable Long id) {
		return personaService.findById(id);
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_CUSTOMER"})
	@GetMapping("/pbuscar/")
	public List<Persona> findAll() {
		return personaService.findAll();
	}
	
	
	
	@GetMapping("/pnombre")
	public Optional<Persona> findByNombreAndApellido(@RequestParam String nombre, @RequestParam String apellido) {
		return personaService.findByNombreAndApellido(nombre,apellido);
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_CUSTOMER"})
	@PostMapping("/pcrear/")
	public void save(@RequestBody Persona persona) {
	 personaService.save(persona);
	 
	 
}
	
	@Secured({"ROLE_ADMIN"})
	@DeleteMapping("/peliminar/{id}")
	public  ResponseEntity<?>  deletePersona(@PathVariable Long id) {

		 

	        Map<String, Object> response = new HashMap<>();

	        try {
	    
	    		personaService.deleteById(id);
	        } catch (DataAccessException e) {
	            response.put("mensaje", "Error al eliminar cliente!");
	            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	        }

	        response.put("mensaje", "Cliente eliminado con exito!");
	        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

		
	}

	
}





