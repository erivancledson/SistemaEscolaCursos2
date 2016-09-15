package Escola.Curso;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IRepositorioCurso {
	
	public void Cadastrar(Curso curso) throws CursoJaCadastradoException, SQLException, CampoObrigatorioException;
	public Curso procurar(String cod_curso) throws CursoNaoEncontradoException, SQLException, CampoObrigatorioException;
	public void atualizar(Curso curso)throws CursoNaoEncontradoException, SQLException, CampoObrigatorioException;
	public void remover(String cpf)throws CursoNaoEncontradoException, SQLException, CampoObrigatorioException;
	public boolean existe(String cpf)throws SQLException, CampoObrigatorioException, CursoNaoEncontradoException;
	public ArrayList<Curso> listar()throws SQLException;
	public ArrayList<Curso> listarLog()throws SQLException;
	
	public ArrayList<Curso> listar(String complemento)throws SQLException;

}
