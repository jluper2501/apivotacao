package br.com.votacao.votacao.controllers;

import br.com.votacao.votacao.documents.Associados;
import br.com.votacao.votacao.responses.Responses;
import br.com.votacao.votacao.services.AssociadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping(path = "/api/v1/associados")
public class AssociadosController {
	
	@Autowired
	private AssociadosService associadosService;
	
	@GetMapping
	public Responses<Responses<List<Associados>>> listarTodos() {
		return Responses.ok(new Responses<List<Associados>>(this.associadosService.listarTodos()));
	}
	
	@GetMapping(path = "/{id}")
	public Responses<Responses<Associados>> listarPorId(@PathVariable(name = "id") String id) {
		return Responses.ok(new Responses<Associados>(this.associadosService.listarPorId(id)));
	}
	
	@PostMapping
	public Responses<Responses<Associados>> cadastrar(@Valid @RequestBody Associados associados, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return Responses.badRequest().body(new Responses<Associados>(erros));
		}
		
		return Responses.ok(new Responses<Associados>(this.associadosService.cadastrar(associados)));
	}
	
	@PutMapping(path = "/{id}")
	public Responses<Responses<Associados>> atualizar(@PathVariable(name = "id") String id, @Valid @RequestBody Associados associados, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return Responses.badRequest().body(new Responses<Associados>(erros));
		}
		
		associados.setId(id);
		return Responses.ok(new Responses<Associados>(this.associadosService.atualizar(associados)));
	}
	
	@DeleteMapping(path = "/{id}")
	public Responses<Responses<Integer>> remover(@PathVariable(name = "id") String id) {
		this.associadosService.remover(id);
		return Responses.ok(new Responses<Integer>(1));
	}

}