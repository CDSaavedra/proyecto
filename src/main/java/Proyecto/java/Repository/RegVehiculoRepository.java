package Proyecto.java.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import Proyecto.java.modelos.RegVehiculo;

@Repository
public interface RegVehiculoRepository extends JpaRepository<RegVehiculo, Long>{

	@Query ("SELECT v FROM RegVehiculo v WHERE v.soatactivo = true")
	List<RegVehiculo> existSoatactivo (Boolean soatactivo);
	}



