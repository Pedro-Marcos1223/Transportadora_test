package APITranspotadora.Transportadora.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import APITranspotadora.Transportadora.model.ProdutoRastreio;
import APITranspotadora.Transportadora.repository.ProdutoRastreioRepository;

@RestController
@RequestMapping("/rastreio")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoRastreioController {

	@Autowired
	private ProdutoRastreioRepository repository;
	
	@PostMapping("/criarencomenda")
	public ResponseEntity<ProdutoRastreio> post(@Valid @RequestBody ProdutoRastreio produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}
	
	@GetMapping("/rastrear/{codigoDeRastreio}")
	public ResponseEntity<ProdutoRastreio> getByCode(@PathVariable String codigoDeRastreio){
		if(repository.findByCodigoDeRastreio(codigoDeRastreio).getCodigoDeRastreio().isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi possivel encontrar a encomenda.");
		}
		return ResponseEntity.ok(repository.findByCodigoDeRastreio(codigoDeRastreio));
	}
}
