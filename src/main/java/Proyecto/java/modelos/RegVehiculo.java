package Proyecto.java.modelos;



import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class RegVehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
   @Basic
    private Boolean soatactivo;
    @Basic
    private Boolean tecnactiva;
    @Basic
    private Long multaspendientes;
    @Basic
    private Boolean seguroact;


    public RegVehiculo() {
		super();
	}


	public RegVehiculo(Long id, Boolean soatactivo, Boolean tecnactiva, Long multaspendientes, Boolean seguroact,
			Vehiculo vehiculo) {
		super();
		this.id = id;
		this.soatactivo = soatactivo;
		this.tecnactiva = tecnactiva;
		this.multaspendientes = multaspendientes;
		this.seguroact = seguroact;
		this.vehiculo = vehiculo;
	}


	@OneToOne
    private Vehiculo vehiculo;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Boolean getSoatactivo() {
		return soatactivo;
	}


	public void setSoatactivo(Boolean soatactivo) {
		this.soatactivo = soatactivo;
	}


	public Boolean getTecnactiva() {
		return tecnactiva;
	}


	public void setTecnactiva(Boolean tecnactiva) {
		this.tecnactiva = tecnactiva;
	}


	public Long getMultaspendientes() {
		return multaspendientes;
	}


	public void setMultaspendientes(Long multaspendientes) {
		this.multaspendientes = multaspendientes;
	}


	public Boolean getSeguroact() {
		return seguroact;
	}


	public void setSeguroact(Boolean seguroact) {
		this.seguroact = seguroact;
	}


	public Vehiculo getVehiculo() {
		return vehiculo;
	}


	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

   
}