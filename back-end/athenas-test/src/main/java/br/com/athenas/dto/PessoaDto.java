package br.com.athenas.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.athenas.model.Pessoa;

public class PessoaDto {
	private Long id;
	private String nome;
	private LocalDate dataNasc;
	private String cpf;
	private Character sexo;
	private Double altura;
	private Double peso;
	private Double pesoIdeal;

	public PessoaDto(Pessoa p) {
		this.id = p.getId();
		this.nome = p.getNome();
		this.dataNasc = p.getDataNasc();
		this.cpf = p.getCpf();
		this.sexo = p.getSexo();
		this.altura = p.getAltura();
		this.peso = p.getPeso();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public String getCpf() {
		return cpf;
	}

	public Character getSexo() {
		return sexo;
	}

	public Double getAltura() {
		return altura;
	}

	public Double getPeso() {
		return peso;
	}

	public Double getPesoIdeal() {
		if (sexo.equals('M')) {
			pesoIdeal = (72.7 * altura) - 58;
		} else {
			pesoIdeal = (62.1 * altura) - 44.7;
		}

		return pesoIdeal;
	}

	public static List<PessoaDto> converter(List<Pessoa> list) {
		return list.stream().map(PessoaDto::new).collect(Collectors.toList());
	}

}
