package Proyecto.java.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Proyecto.java.interfaceService.IvehiculoService;
import Proyecto.java.modelos.Vehiculo;




@RestController
@RequestMapping("vehiculos")
public class VehiculoController {

	@Autowired 
	private IvehiculoService vehiculoService; 

	@Secured({"ROLE_ADMIN", "ROLE_CUSTOMER"})
	@GetMapping("/vconsultar/{placa}")
	public  List<Vehiculo> findByPlaca(@PathVariable String placa) {
		return vehiculoService.findByPlaca(placa);
	}
	
	
	@Secured({"ROLE_ADMIN", "ROLE_CUSTOMER"})
	@GetMapping("/vcolor/{color}")
	public List<Vehiculo> findByColor(@PathVariable String color) {
		return  vehiculoService.findByColor(color);
	
	}
	
		@Secured({"ROLE_ADMIN"})
		@PostMapping("/vcrear")
		public void save(@RequestBody Vehiculo vehiculo) {
			 vehiculoService.save(vehiculo);		
}
	
		
		@Secured({"ROLE_ADMIN"})
		@DeleteMapping("/borrar/{id}")
		public  void deleteVehiculo(@PathVariable Long id) {
    	vehiculoService.deleteById(id);

		     
    	
		}	
		@Secured({"ROLE_ADMIN"})

@PutMapping("/update/{id}")
	public Vehiculo actualizarVehiculo(@RequestBody Vehiculo newVehiculo, @PathVariable Long id) {
		try {
			return vehiculoService.actualizarVehiculo(newVehiculo, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newVehiculo;
	}
}