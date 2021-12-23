package Proyecto.java.modelos;



import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;   
    @Basic
    private String nombre;
    @Basic
    private String apellido;
    @Basic
    private Long cedula;
    @Basic
    private Long edad;
    @Basic
    private Integer telefono;  
    @Basic
    private String  fecharegisto;
 
  @OneToMany(fetch = FetchType.LAZY)
  private List<Vehiculo> vehiculos;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getApellido() {
	return apellido;
}

public void setApellido(String apellido) {
	this.apellido = apellido;
}

public Long getCedula() {
	return cedula;
}

public void setCedula(Long cedula) {
	this.cedula = cedula;
}

public Long getEdad() {
	return edad;
}

public void setEdad(Long edad) {
	this.edad = edad;
}

public Integer getTelefono() {
	return telefono;
}

public void setTelefono(Integer telefono) {
	this.telefono = telefono;
}

public String getFecharegisto() {
	return fecharegisto;
}

public void setFecharegisto(String fecharegisto) {
	this.fecharegisto = fecharegisto;
}

public List<Vehiculo> getVehiculos() {
	return vehiculos;
}

public void setVehiculos(List<Vehiculo> vehiculos) {
	this.vehiculos = vehiculos;
}

}