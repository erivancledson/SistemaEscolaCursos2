package Escola.Fachada;

import java.util.ArrayList;

import Escola.Aluno.Aluno;
import Escola.Aluno.ControladorAluno;
import Escola.Contrato.Contrato;
import Escola.Contrato.ControladorContrato;
import Escola.Curso.ControladorCurso;
import Escola.Curso.Curso;
import Escola.Professor.ControladorProfessor;
import Escola.Professor.Professor;

public class Fachada {
	private static Fachada instance = null;
	
	public static Fachada getInstance(){
		if(Fachada.instance == null){
			Fachada.instance = new Fachada();
		}
		
		return Fachada.instance;
	}
	
	private ControladorCurso controladorCurso;
	private ControladorAluno controladorAluno;
	private ControladorProfessor controladorProfessor;
	private ControladorContrato controladorContrato;
	
	public void cursoCadastrar(Curso cursos) throws Exception{
		this.controladorCurso = new ControladorCurso();
		this.controladorCurso.cadastrar(cursos);
	}
	
	public Curso cursoProcurar(String cod_curso) throws Exception{
		this.controladorCurso = new ControladorCurso();
		return this.controladorCurso.procurar(cod_curso);
	}
	
	public void cursoAtualizar(Curso cursos) throws Exception{
		this.controladorCurso = new ControladorCurso();
		this.controladorCurso.atualizar(cursos);
	}
	
	public void cursoRemover(String cod_curso) throws Exception{
		this.controladorCurso = new ControladorCurso();
		this.controladorCurso.remover(cod_curso);
	}

	public ArrayList<Curso> cursoListar() throws Exception{
		this.controladorCurso = new ControladorCurso();
		return this.controladorCurso.listar();
	}
	
	public ArrayList<Curso> cursoListarLog() throws Exception{
		this.controladorCurso = new ControladorCurso();
		return this.controladorCurso.listarLog();
	}
	

	
	public void alunoCadastrar(Aluno aluno) throws Exception{
		this.controladorAluno = new ControladorAluno();
		this.controladorAluno.cadastrar(aluno);
	}
	
	public Aluno alunoProcurar(String cpf) throws Exception{
		this.controladorAluno = new ControladorAluno();
		return this.controladorAluno.procurar(cpf);
	}
	
	public void AlunoAtualizar(Aluno aluno) throws Exception{
		this.controladorAluno = new ControladorAluno();
		this.controladorAluno.atualizar(aluno);
	}
	
	public void alunoRemover(String cpf) throws Exception{
		this.controladorAluno = new ControladorAluno();
		this.controladorAluno.remover(cpf);
	}

	public ArrayList<Aluno> alunoListar() throws Exception{
		this.controladorAluno = new ControladorAluno();
		return this.controladorAluno.listar();
	}
	
	public ArrayList<Aluno> alunoVisao() throws Exception{
		this.controladorAluno = new ControladorAluno();
		return this.controladorAluno.listarVisao();
	}
	
	
	public void professorCadastrar(Professor professor) throws Exception{
		this.controladorProfessor = new ControladorProfessor();
		this.controladorProfessor.cadastrar(professor);
	}
	public Professor professorProcurar(String cpf) throws Exception{
		this.controladorProfessor = new ControladorProfessor();
		return this.controladorProfessor.procurar(cpf);
	}
	
	public void professorAtualizar(Professor professor) throws Exception{
		this.controladorProfessor = new ControladorProfessor();
		this.controladorProfessor.atualizar(professor);
	}
	
	public void professorRemover(String cpf) throws Exception{
		this.controladorProfessor = new ControladorProfessor();
		this.controladorProfessor.remover(cpf);
	}

	public ArrayList<Professor> professorListar() throws Exception{
		this.controladorProfessor = new ControladorProfessor();
		return this.controladorProfessor.listar();
	}
	
	public ArrayList<Professor> professorListarSub() throws Exception{
		this.controladorProfessor = new ControladorProfessor();
		return this.controladorProfessor.listarSub();
	}
	
	
	public void contratoCadastrar(Contrato contrato) throws Exception{
		this.controladorContrato = new ControladorContrato();
		this.controladorContrato.cadastrar(contrato);
	}
	
	public Contrato contratoProcurar(int cod_contrato) throws Exception{
		this.controladorContrato = new ControladorContrato();
		return this.controladorContrato.procurar(cod_contrato);
	}
	
	public void contratoAtualizar(Contrato contrato) throws Exception{
		this.controladorContrato = new ControladorContrato();
		this.controladorContrato.atualizar(contrato);
	}

	public void contratoRemover(int cod_contrato) throws Exception{
		this.controladorContrato = new ControladorContrato();
		this.controladorContrato.remover(cod_contrato);
	}

	public ArrayList<Contrato> contratoListar() throws Exception{
		this.controladorContrato = new ControladorContrato();
		return this.controladorContrato.listar();
	}
}
