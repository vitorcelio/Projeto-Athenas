package br.com.athenas.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.athenas.dto.PessoaDto;
import br.com.athenas.form.PessoaAtualizarForm;
import br.com.athenas.form.PessoaForm;
import br.com.athenas.model.Pessoa;
import br.com.athenas.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repository;
	
	public ResponseEntity<List<PessoaDto>> listar() {
		List<Pessoa> pessoas = repository.findAll();
		return ResponseEntity.ok(PessoaDto.converter(pessoas));
	}
	
	public ResponseEntity<List<PessoaDto>> pesquisar(String nome) {
		List<Pessoa> pessoas = repository.findByNomeContaining(nome);
		return ResponseEntity.ok(PessoaDto.converter(pessoas));
	}
	
	public ResponseEntity<PessoaDto> detalhar(Long id) {
		Optional<Pessoa> pessoaOptional = repository.findById(id);
		if(pessoaOptional.isPresent()) {
			return ResponseEntity.ok(new PessoaDto(pessoaOptional.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@Transactional
	public ResponseEntity<PessoaDto> incluir(PessoaForm form, UriComponentsBuilder builder) {
		Pessoa pessoa = form.toPessoa();
		repository.save(pessoa);
		
		URI uri = builder.path("/pessoa/{id}").buildAndExpand(pessoa.getId()).toUri();
		return ResponseEntity.created(uri).body(new PessoaDto(pessoa));
	}
	
	@Transactional
	public ResponseEntity<PessoaDto> alterar(Long id, PessoaAtualizarForm form){
		Optional<Pessoa> pessoaOptional = repository.findById(id);
		if(pessoaOptional.isPresent()) {
			Pessoa pessoa = form.toPessoa(id);
			repository.save(pessoa);
			return ResponseEntity.ok(new PessoaDto(pessoa));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@Transactional
	public ResponseEntity<Void> excluir(Long id) {
		Optional<Pessoa> pessoaOptional = repository.findById(id);
		if(pessoaOptional.isPresent()) {
			repository.delete(pessoaOptional.get());
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
