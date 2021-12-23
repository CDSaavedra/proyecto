package Proyecto.java.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Proyecto.java.Services.HistoricoRepService;
import Proyecto.java.modelos.HistoricoRep;

@RestController
@RequestMapping ("historico")
public class HistoricoRepController {

@Autowired
private HistoricoRepService historicoRepService;

@GetMapping("/consHistorico/{id}")
public Optional<HistoricoRep> findById (@PathVariable Long id) {
	return historicoRepService.findById(id);
}
 
@PostMapping("/crearH")
public void save (@RequestBody HistoricoRep historicoRep) {
	
	 historicoRepService.save(historicoRep);
}

}
