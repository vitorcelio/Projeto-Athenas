package br.com.athenas.form;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import br.com.athenas.model.Pessoa;
import br.com.athenas.util.StringModify;

public class PessoaForm {

	@NotBlank
	private String nome;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataNascimento;

	@CPF
	private String cpf;

	@NotNull
	private Character sexo;

	@NotNull
	private String altura;

	@NotNull
	private String peso;


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNacimento) {
		this.dataNascimento = dataNacimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Character getSexo() {
		return sexo;
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public Pessoa toPessoa() {

		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nome);
		pessoa.setDataNasc(dataNascimento);
		pessoa.setCpf(cpf);
		pessoa.setSexo(sexo);
		pessoa.setAltura(StringModify.converteDouble(altura));
		pessoa.setPeso(StringModify.converteDouble(peso));
		return pessoa;

	}

}
