package Proyecto.java.modelos;

@SuppressWarnings("serial")
public class VehiculoNotFoundException  extends RuntimeException {

public VehiculoNotFoundException(Long id) {
	super("Could not find team by id:" + id);
}

public VehiculoNotFoundException(String identificacion) {
	super("Could not find team by identificacion:" + identificacion);
}
}