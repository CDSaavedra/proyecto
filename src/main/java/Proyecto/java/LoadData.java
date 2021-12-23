package Proyecto.java;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import Proyecto.java.modelos.Persona;
import Proyecto.java.modelos.RegVehiculo;
import Proyecto.java.modelos.Vehiculo;
import Proyecto.java.modelos.Auth.Rol;
import Proyecto.java.modelos.Auth.Usuario;
import Proyecto.java.Services.PersonaService;
import Proyecto.java.Repository.RoleRepository;
import Proyecto.java.Repository.UserRepository;
import Proyecto.java.Services.HistoricoRepService;
import Proyecto.java.Services.RegVehiculoService;
import Proyecto.java.Services.VehiculoService;
import Proyecto.java.modelos.HistoricoRep;



@Configuration
class LoadData {
	
	@Bean
	CommandLineRunner initDatabase(UserRepository userRepository, RoleRepository rolRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		return args -> {
			
			Rol adminRol = new Rol();
			adminRol.setName("ADMIN");
			rolRepository.save(adminRol);
			
			
			Rol customerRol = new Rol();
			customerRol.setName("CUSTOMER");
			rolRepository.save(customerRol);

			Usuario admin = new Usuario();
			admin.setUsuario("admin");
			admin.setPassword(bCryptPasswordEncoder.encode("12345"));
			admin.setRol(adminRol);
			userRepository.save(admin);
			
			
			
			Usuario customer = new Usuario();
			customer.setUsuario("customer");
			customer.setPassword(bCryptPasswordEncoder.encode("12345"));
			customer.setRol(customerRol);
			userRepository.save(customer);
		};
	}
	

		
		@Bean
		CommandLineRunner vehiculos(VehiculoService vehiculoService) {
	        return arg -> {
	         
	            Vehiculo vehiculo = new Vehiculo();
	            vehiculo.setTipovehiculo("Moto");
	            vehiculo.setPlaca("MXD34D");
	            vehiculo.setMarca("Honda");
	            vehiculo.setModelo("Cbr160");
	            vehiculo.setColor("Rojo");
	            
	            
	            
	            
	           vehiculoService.save(vehiculo);
	            
	            
	            Vehiculo vehiculo1 = new Vehiculo();
	            vehiculo1.setTipovehiculo("Automovil");
	            vehiculo1.setPlaca("DSD23D");
	            vehiculo1.setMarca("Susuki");
	            vehiculo1.setModelo("GSX150");
	            vehiculo1.setColor("Negro");
	            
	         vehiculoService.save(vehiculo1);
	       
		};
	
}
 
	
	@Bean
	CommandLineRunner clientes(PersonaService personaService) {
        return arg -> {
         
            Persona persona = new Persona();
            persona.setNombre("pepe");
            persona.setApellido("Garzon");
            persona.setCedula((long) 1010201);
            persona.setEdad((long) 10);
            persona.setFecharegisto("10/12/2001");
            persona.setTelefono((int) 3132110);
            
            
            
           personaService.save(persona);
            
            Persona persona1 = new Persona();
            persona1.setNombre("paco");
            persona1.setApellido("malgesto");
            persona1.setCedula((long) 23124325);
            persona1.setEdad((long) 24);
            persona1.setFecharegisto("11/1/2002");
            persona1.setTelefono((int) 12312432);
           
            
         personaService.save(persona1);
       
	};

}	
		@Bean
		CommandLineRunner RegVehiculos(RegVehiculoService regVehiculoService) {
	        return arg -> {
	         
	        	RegVehiculo regVehiculo = new RegVehiculo();
	        	regVehiculo.setSoatactivo(false);
	        	regVehiculo.setTecnactiva(true);
	        	regVehiculo.setSeguroact(true);
	        	regVehiculo.setMultaspendientes((long) 1);
	        	
	            
	            
	           
	        	regVehiculoService.save(regVehiculo);
	            
	            
	        	RegVehiculo regVehiculo1 = new RegVehiculo();
	        	regVehiculo1.setSoatactivo(false);
	        	regVehiculo1.setTecnactiva(true);
	        	regVehiculo1.setMultaspendientes((long) 4);
	        	regVehiculo1.setSeguroact(false);
	        	regVehiculoService.save(regVehiculo1);
	       
		};
}




		@Bean
		CommandLineRunner HistoricoRep(HistoricoRepService historicoRepService) {
	        return arg -> {
	         
	        	HistoricoRep historicoRep = new HistoricoRep();
	        	historicoRep.setNombremecanico("Camilo");
	        	historicoRep.setCantreparaciones("2");
	        	historicoRep.setCantrepuestos("1");
	        	historicoRep.setUltimareparacion("23/12/2018");
	        	
                historicoRepService.save(historicoRep);
	            
	            
	        
		};		
}

}

