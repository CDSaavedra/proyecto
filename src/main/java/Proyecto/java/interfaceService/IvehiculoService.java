package Proyecto.java.interfaceService;

import java.util.List;

import Proyecto.java.modelos.Vehiculo;

public interface IvehiculoService {

	List<Vehiculo> findByPlaca (String placa);
	
	List<Vehiculo> findByColor(String color);
	
	void  save(Vehiculo vehiculo);

	void deleteById(Long id);
	
	Vehiculo actualizarVehiculo(Vehiculo Vehiculo, Long id);

}
