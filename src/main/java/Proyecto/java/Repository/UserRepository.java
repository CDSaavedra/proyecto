package Proyecto.java.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import Proyecto.java.modelos.Auth.Usuario;





@Repository
public interface UserRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findByUsuario(String usuario);


}
