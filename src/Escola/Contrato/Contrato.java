package Escola.Contrato;

import Escola.Aluno.Aluno;
import Escola.Curso.Curso;

public class Contrato {
	
	private int cod_contrato;
	private int cod_curso;
	private int cod_aluno;
	private String descricao;
	
	private Curso curso;
	private Aluno aluno;
	
	public Contrato(int cod_contrato, String curso, String aluno, String descricao) {
		
		this.cod_contrato = cod_contrato;
		curso = curso;
		aluno = aluno;
		this.descricao = descricao;
	}
	
	public Contrato(int cod_contrato, int cod_curso, int cod_aluno,
			String descricao) {
		
		this.cod_contrato = cod_contrato;
		this.cod_curso = cod_curso;
		this.cod_aluno = cod_aluno;
		this.descricao = descricao;
	}
	
	public Contrato(int cod_curso, int cod_aluno,
			String descricao) {
		
		
		this.cod_curso = cod_curso;
		this.cod_aluno = cod_aluno;
		this.descricao = descricao;
	}

	public int getCod_contrato() {
		return cod_contrato;
	}

	public void setCod_contrato(int cod_contrato) {
		this.cod_contrato = cod_contrato;
	}

	public int getCod_curso() {
		return cod_curso;
	}

	public void setCod_curso(int cod_curso) {
		this.cod_curso = cod_curso;
	}

	public int getCod_aluno() {
		return cod_aluno;
	}

	public void setCod_aluno(int cod_aluno) {
		this.cod_aluno = cod_aluno;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@Override
	public String toString() {
		return "Contrato [cod_contrato=" + cod_contrato +  ", descricao="
				+ descricao + ", curso=" + curso.getNome() + ", aluno=" + aluno.getNome_aluno() + "]";
	}

	
	
	
	

	
	
}
