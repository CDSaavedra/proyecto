package Proyecto.java.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Proyecto.java.Repository.HistoricoRepRepository;
import Proyecto.java.interfaceService.IhistoricoRepService;
import Proyecto.java.modelos.HistoricoRep;

@Service
public class HistoricoRepService implements IhistoricoRepService {

	@Autowired
	private HistoricoRepRepository historicoRepRepository;  
	
	
	@Override
	public Optional<HistoricoRep> findById(Long Id) { 
		return historicoRepRepository.findById(Id);
	}
	
	public void save(HistoricoRep historicoRep) {
		historicoRepRepository.save(historicoRep);
	}


}
