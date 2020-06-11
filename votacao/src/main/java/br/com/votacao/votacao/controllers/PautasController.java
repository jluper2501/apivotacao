package br.com.votacao.votacao.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.votacao.votacao.documents.Pautas;
import br.com.votacao.votacao.responses.Responses;
import br.com.votacao.votacao.services.PautasService;

@RequestMapping(path = "/api/v1/pautas")
public class PautasController {
	
	@Autowired
	private PautasService pautasService;
	
	@GetMapping
	public Responses<Responses<List<Pautas>>> listarTodas() {
		return Responses.ok(new Responses<List<Pautas>>(this.pautasService.listarTodas()));
	}
	
	@GetMapping(path = "/{id}")
	public Responses<Responses<Pautas>> listarPorId(@PathVariable(name = "id") String id) {
		return Responses.ok(new Responses<Pautas>(this.pautasService.listarPorId(id)));
	}
	
	@PostMapping
	public Responses<Responses<Pautas>> cadastrar(@Valid @RequestBody Pautas pautas, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return Responses.badRequest().body(new Responses<Pautas>(erros));
		}
		
		return Responses.ok(new Responses<Pautas>(this.pautasService.cadastrar(pautas)));
	}
	
	@PutMapping(path = "/{id}")
	public Responses<Responses<Pautas>> atualizar(@PathVariable(name = "id") String id, @Valid @RequestBody Pautas pautas, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return Responses.badRequest().body(new Responses<Pautas>(erros));
		}
		
		pautas.setId(id);
		return Responses.ok(new Responses<Pautas>(this.pautasService.atualizar(pautas)));
	}
	
	@DeleteMapping(path = "/{id}")
	public Responses<Responses<Integer>> remover(@PathVariable(name = "id") String id) {
		this.pautasService.remover(id);
		return Responses.ok(new Responses<Integer>(1));
	}

}