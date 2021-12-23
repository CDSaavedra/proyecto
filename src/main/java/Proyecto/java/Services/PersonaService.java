package Proyecto.java.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Proyecto.java.Repository.ClienteRepository;
import Proyecto.java.interfaceService.IpersonaService;
import Proyecto.java.modelos.Persona;

@Service
public class PersonaService implements IpersonaService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<Persona> listar() {
		// TODO Auto-generated method stub
		return clienteRepository.findAll();
	}
	@Override
	public Optional<Persona> findById(Long id) {
		
		return clienteRepository.findById(id);
	}

	@Override
	public List<Persona> findAll() {
		
		return clienteRepository.findAll();
	}

	@Override 
	public void save(Persona persona) {
	clienteRepository.save(persona);
		
	}
	
	public PersonaService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	@Override
	public void deleteById(Long id) {
		  clienteRepository.deleteById(id);
		
	}
	@Override
	public Optional<Persona> findByNombreAndApellido(String nombre, String apellido) {
		// TODO Auto-generated method stub
		return clienteRepository.findByNombreAndApellido(nombre,apellido);
	}

	
	
	
	
	
	}


