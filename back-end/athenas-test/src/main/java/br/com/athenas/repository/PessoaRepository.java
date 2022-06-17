package br.com.athenas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.athenas.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	List<Pessoa> findByNomeContaining(String nome);
	List<Pessoa> findByCpfContaining(String cpf);
	List<Pessoa> findByNomeContainingAndCpfContaining(String nome, String cpf);
}
