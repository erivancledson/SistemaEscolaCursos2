package Escola.Curso;

public class Curso {
 private String cod_curso;
 private String nome;
 private String dia_semana;
 private String horario;
 private String imagem;
 
 
public Curso(String nome, String dia_semana, String horario, String imagem) {
	

	this.nome = nome;
	this.dia_semana = dia_semana;
	this.horario = horario;
	this.imagem = imagem;
}

public Curso( String cod_curso, String nome, String dia_semana, String horario, String imagem) {
	
    this.cod_curso = cod_curso;
	this.nome = nome;
	this.dia_semana = dia_semana;
	this.horario = horario;
	this.imagem = imagem;
}

public Curso(String nome, String dia_semana, String horario) {
	
   
	this.nome = nome;
	this.dia_semana = dia_semana;
	this.horario = horario;
	
}





public Curso() {
	// TODO Auto-generated constructor stub
}

public String getCod_curso() {
	return cod_curso;
}


public void setCod_curso(String cod_curso) {
	this.cod_curso = cod_curso;
}


public String getNome() {
	return nome;
}


public void setNome(String nome) {
	this.nome = nome;
}


public String getDia_semana() {
	return dia_semana;
}


public void setDia_semana(String dia_semana) {
	this.dia_semana = dia_semana;
}


public String getHorario() {
	return horario;
}


public void setHorario(String horario) {
	this.horario = horario;
}

public String getImagem() {
	return imagem;
}

public void setImagem(String imagem) {
	this.imagem = imagem;
}

@Override
public String toString() {
	return "Curso [cod_curso=" + cod_curso + ", nome=" + nome + ", dia_semana="
			+ dia_semana + ", horario=" + horario + ", imagem=" + imagem + "]";
}



 
	
}

