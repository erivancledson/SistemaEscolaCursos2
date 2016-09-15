package Escola.Curso;

import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorCurso {

	private IRepositorioCurso repositorioCurso;
	
	
	public ControladorCurso() throws Exception {
		this.repositorioCurso = new RepositorioCursoBDR();
		
	}
	
	public void cadastrar(Curso curso) throws  CampoObrigatorioException, SQLException, CursoJaCadastradoException, CursoNaoEncontradoException{
		
		if(curso.getNome().equals("") == true) throw new CampoObrigatorioException();
		
		if(this.repositorioCurso.existe(curso.getCod_curso())) throw new CursoJaCadastradoException();
		
		this.repositorioCurso.Cadastrar(curso);
		
	
	}
	
	public void remover(String cod_curso) throws CursoNaoEncontradoException, SQLException, CampoObrigatorioException{
		
		Curso cursos = null;
		
		
		cursos = this.repositorioCurso.procurar(cod_curso);
		
		
		this.repositorioCurso.remover(cod_curso);
		
	}

	public Curso procurar(String cod_curso) throws  CursoNaoEncontradoException, SQLException, CampoObrigatorioException{
		
		
		
		return this.repositorioCurso.procurar(cod_curso);
	}

	

	public void atualizar(Curso cursos) throws CursoNaoEncontradoException, SQLException, CampoObrigatorioException{
		
		if(cursos.getNome().equals("") == true) throw new CampoObrigatorioException();
		
		this.repositorioCurso.atualizar(cursos);
	}

	public ArrayList<Curso> listar() throws SQLException{
		return this.repositorioCurso.listar();
	}

	public ArrayList<Curso> listarLog() throws SQLException{
		return this.repositorioCurso.listarLog();
	}
	

}
