package Escola.Professor;

import Escola.Contato.Contato;
import Escola.Endereco.Endereco;

public class Professor {
	private String cod_professor;
	private String nome_professor;
	private String cpf;
	private String sexo;
	
	private Contato contato;
	private Endereco endereco;
	private int cod_curso;
	

	
	public Professor(String cod_professor, String nome_professor, String cpf,
			String sexo, Contato contato, Endereco endereco, int cod_curso) {
		super();
		this.cod_professor = cod_professor;
		this.nome_professor = nome_professor;
		this.cpf = cpf;
		this.sexo = sexo;
		
		this.contato = contato;
		this.endereco = endereco;
		this.cod_curso = cod_curso;
	}
	
	public Professor(String nome_professor, String cpf) {
	
		this.nome_professor = nome_professor;
		this.cpf = cpf;
		
	}
	
	public Professor(String nome_professor, String cpf,
			String sexo,  Contato contato, Endereco endereco, int cod_curso) {
	
		this.nome_professor = nome_professor;
		this.cpf = cpf;
		this.sexo = sexo;
		
		this.contato = contato;
		this.endereco = endereco;
		this.cod_curso = cod_curso;
	}

	public Professor(String cod_professor, String nome_professor, String cpf,
			String sexo,  int cod_curso) {
		
		this.cod_professor = cod_professor;
		this.nome_professor = nome_professor;
		this.cpf = cpf;
		this.sexo = sexo;
		
		this.cod_curso = cod_curso;
	}
	
	public Professor(String cod_professor, String nome_professor, String cpf,
			String sexo, String email, String telefone, String celular, String logradouro, String numero,
			String bairro, String cidade, String estado, String cep, int cod_curso) {
		super();
		this.cod_professor = cod_professor;
		this.nome_professor = nome_professor;
		this.cpf = cpf;
		this.sexo = sexo;
		
		email = email;
		telefone = telefone;
		celular = celular;
		logradouro = logradouro;
		numero = numero;
		bairro = bairro;
		cidade = cidade;
		estado = estado;
		cep = cep;
		this.cod_curso = cod_curso;
	}

	public String getCod_professor() {
		return cod_professor;
	}

	public void setCod_professor(String cod_professor) {
		this.cod_professor = cod_professor;
	}

	public String getNome_professor() {
		return nome_professor;
	}

	public void setNome_professor(String nome_professor) {
		this.nome_professor = nome_professor;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public int getCod_curso() {
		return cod_curso;
	}

	public void setCod_curso(int cod_curso) {
		this.cod_curso = cod_curso;
	}

	@Override
	public String toString() {
		return "Professor [cod_professor=" + cod_professor
				+ ", nome_professor=" + nome_professor + ", cpf=" + cpf
				+ ", sexo=" + sexo + ", contato="
				+ contato + ", endereco=" + endereco + ", cod_curso="
				+ cod_curso + "]";
	}

	
	
}
