package Proyecto.java.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import Proyecto.java.Services.RegVehiculoService;
import Proyecto.java.modelos.RegVehiculo;



@RestController
@RequestMapping("registro")
public class RegVehiculoController {

	@Autowired
	private RegVehiculoService regVehiculoService;	
	
	@Secured({"ROLE_ADMIN", "ROLE_CUSTOMER"})
	@GetMapping("/regVehiculo/{id}")
	public Optional<RegVehiculo> findById (@PathVariable Long id){
		return regVehiculoService.findById(id);	
	}
	@Secured({"ROLE_ADMIN", "ROLE_CUSTOMER"})
	@GetMapping("/regVehiculo/{soat}")
	public void existSoatactivo(@PathVariable  Boolean soat) {
	
		regVehiculoService.existSoatactivo(soat);
	}
}
