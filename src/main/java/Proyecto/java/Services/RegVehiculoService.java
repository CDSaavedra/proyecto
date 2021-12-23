package Proyecto.java.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import Proyecto.java.Repository.RegVehiculoRepository;
import Proyecto.java.interfaceService.IregVehiculoService;
import Proyecto.java.modelos.RegVehiculo;

@Service
public class RegVehiculoService implements IregVehiculoService {
	@Autowired
	private RegVehiculoRepository regVehiculoRepository;
	
	public Optional<RegVehiculo> findById(Long id) {
		return regVehiculoRepository.findById(id);
		
		
	}

	public  void save(RegVehiculo regVehiculo) {
		 regVehiculoRepository.save(regVehiculo);
		
	}

	@Override
	public List<RegVehiculo> existSoatactivo(Boolean soatactivo) {
		// TODO Auto-generated method stub
		return regVehiculoRepository.existSoatactivo(soatactivo);
	}

}

