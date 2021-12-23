package Proyecto.java.interfaceService;

import java.util.Optional;

import Proyecto.java.modelos.HistoricoRep;

public interface IhistoricoRepService  {
	
Optional<HistoricoRep> findById	(Long Id);

void save(HistoricoRep historicoRep);

}
