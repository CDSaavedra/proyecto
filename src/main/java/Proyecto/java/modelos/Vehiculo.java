package Proyecto.java.modelos;



import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Vehiculo {
    
	@Id
    @GeneratedValue
    private Long id;
    @Basic
    private String tipovehiculo;
    @Basic
    private String placa;
    @Basic
    private String marca;
    @Basic
    private String modelo;
    @Basic
    private String color;
	
    @ManyToOne
    private Persona persona;
    
    @OneToOne
    private RegVehiculo regVehiculo;
    @OneToOne
    private HistoricoRep historicoRep;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipovehiculo() {
		return tipovehiculo;
	}
	public void setTipovehiculo(String tipovehiculo) {
		this.tipovehiculo = tipovehiculo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public RegVehiculo getRegVehiculo() {
		return regVehiculo;
	}
	public void setRegVehiculo(RegVehiculo regVehiculo) {
		this.regVehiculo = regVehiculo;
	}
	public HistoricoRep getHistoricoRep() {
		return historicoRep;
	}
	public void setHistoricoRep(HistoricoRep historicoRep) {
		this.historicoRep = historicoRep;
	}
  
	}


	

	
	
	
	

