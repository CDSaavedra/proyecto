package Proyecto.java.interfaceService;

import java.util.List;
import java.util.Optional;

import Proyecto.java.modelos.RegVehiculo;

public  interface IregVehiculoService {
	
Optional <RegVehiculo>	findById (Long id);
List<RegVehiculo> existSoatactivo (Boolean soatactivo);
}
