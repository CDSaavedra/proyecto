package Proyecto.java.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Proyecto.java.modelos.Auth.Rol;





@Repository
public interface RoleRepository extends JpaRepository<Rol, Long>{


Rol  findByName(String Name);
	
}
