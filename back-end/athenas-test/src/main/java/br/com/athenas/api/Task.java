package br.com.athenas.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.athenas.dto.PessoaDto;
import br.com.athenas.form.PessoaAtualizarForm;
import br.com.athenas.form.PessoaForm;
import br.com.athenas.service.PessoaService;

@RestController
@RequestMapping("task")
public class Task {

	@Autowired
	private PessoaService service;
	
	@GetMapping
	public ResponseEntity<List<PessoaDto>> listar() {
		return service.listar();
	}

	@GetMapping("all")
	public ResponseEntity<List<PessoaDto>> pesquisar(@RequestParam(name = "nome", required = false) String nome) {
		return service.pesquisar(nome);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<PessoaDto> detalhar(@PathVariable("id") Long id) {
		return service.detalhar(id);
	}
	
	@PostMapping
	public ResponseEntity<PessoaDto> incluir(@Valid @RequestBody PessoaForm form, UriComponentsBuilder builder) {
		return service.incluir(form, builder);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<PessoaDto> alterar(@PathVariable("id") Long id, @Valid @RequestBody PessoaAtualizarForm form) {
		return service.alterar(id, form);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
		return service.excluir(id);
	}

}
