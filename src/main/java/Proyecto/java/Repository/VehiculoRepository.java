
package Proyecto.java.Repository;

import Proyecto.java.modelos.Vehiculo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

	List<Vehiculo> findByPlaca(String placa);

	@Query("SELECT p FROM Vehiculo p WHERE p.tipovehiculo = ?1")
	List<Vehiculo> findByTipovehiculo(String tipovehiculo);

	@Query("SELECT p FROM Vehiculo p WHERE p.color = ?1")
	List<Vehiculo> findByColor(String color);

}
