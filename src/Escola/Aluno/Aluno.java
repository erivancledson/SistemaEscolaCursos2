package Escola.Aluno;

import Escola.Contato.Contato;
import Escola.Endereco.Endereco;

public class Aluno {

private String cod_aluno;
private String nome_aluno;
private String cpf;
private String sexo;
private Contato contato;
private Endereco endereco;
private int cod_curso;

public Aluno(String nome_aluno, String cpf, String sexo, 
		int cod_curso) {
	
	this.nome_aluno = nome_aluno;
	this.cpf = cpf;
	this.sexo = sexo;
	
	this.cod_curso = cod_curso;
}

public Aluno(int cod_curso, String cod_aluno, String nome_aluno){
	this.cod_curso = cod_curso;
	this.cod_aluno = cod_aluno;
	this.nome_aluno = nome_aluno;
}


public Aluno(String cod_aluno, String nome_aluno, String cpf, String sexo,
		Contato contato, Endereco endereco, int cod_curso) {
	super();
	this.cod_aluno = cod_aluno;
	this.nome_aluno = nome_aluno;
	this.cpf = cpf;
	this.sexo = sexo;
	this.contato = contato;
	this.endereco = endereco;
	this.cod_curso = cod_curso;
}

public Aluno(String nome_aluno, String cpf, String sexo,
		Contato contato, Endereco endereco, int cod_curso) {

	this.nome_aluno = nome_aluno;
	this.cpf = cpf;
	this.sexo = sexo;
	this.contato = contato;
	this.endereco = endereco;
	this.cod_curso = cod_curso;
}


public Aluno(String cod_aluno, String nome_aluno, String cpf, String sexo,
		 int cod_curso) {
	super();
	this.cod_aluno = cod_aluno;
	this.nome_aluno = nome_aluno;
	this.cpf = cpf;
	this.sexo = sexo;
	
	this.cod_curso = cod_curso;
}



public Aluno(String cod_aluno,String nome_aluno, String cpf, String sexo,
		  String email, String telefone, String celular, String logradouro, String numero, String bairro,
		 String cidade, String estado, String cep, int cod_curso) {
	
	this.cod_aluno = cod_aluno;
	this.nome_aluno = nome_aluno;
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


public Aluno() {
	// TODO Auto-generated constructor stub
}









public String getCod_aluno() {
	return cod_aluno;
}




public void setCod_aluno(String cod_aluno) {
	this.cod_aluno = cod_aluno;
}




public String getNome_aluno() {
	return nome_aluno;
}




public void setNome_aluno(String nome_aluno) {
	this.nome_aluno = nome_aluno;
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
	return "Aluno [cod_aluno=" + cod_aluno + ", nome_aluno=" + nome_aluno
			+ ", cpf=" + cpf + ", sexo=" + sexo + ", contato=" + contato
			+ ", endereco=" + endereco + ", cod_curso=" + cod_curso + "]";
}






}










	
	
	
	

