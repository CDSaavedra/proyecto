package Proyecto.java.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Proyecto.java.Repository.VehiculoRepository;
import Proyecto.java.interfaceService.IvehiculoService;
import Proyecto.java.modelos.Vehiculo;
import Proyecto.java.modelos.VehiculoNotFoundException;

@Service

public class VehiculoService implements IvehiculoService {

	
	@Autowired
	private VehiculoRepository vehiculoRepository;
	
	public  List<Vehiculo> findByPlaca(String placa) {
		
		return vehiculoRepository.findByPlaca(placa);
	}

	@Override
	public List<Vehiculo> findByColor(String color) {
		// TODO Auto-generated method stub
		return vehiculoRepository.findByColor(color);
	}


	@Override
	public void save(Vehiculo vehiculo) {
		vehiculoRepository.save(vehiculo);
		
	}

	@Override
	public  void deleteById(Long id) {
		vehiculoRepository.deleteById(id);
	}

	@Override
	public Vehiculo actualizarVehiculo(Vehiculo newVehiculo, Long id) {

		return vehiculoRepository.findById(id).map(provider -> {
			provider.setMarca(newVehiculo.getMarca());
			provider.setModelo(newVehiculo.getModelo());
			provider.setPlaca(newVehiculo.getPlaca());
			provider.setColor(newVehiculo.getColor());

			return vehiculoRepository.save(provider);
		}).orElseGet(() -> {
			throw new VehiculoNotFoundException(id);
		});
	}





	
	
	}


	

