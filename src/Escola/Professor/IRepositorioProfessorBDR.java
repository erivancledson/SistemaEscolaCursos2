package Escola.Professor;

import java.sql.SQLException;
import java.util.ArrayList;



public interface IRepositorioProfessorBDR {
	public void Cadastrar(Professor professor) throws ProfessorJaCadastradoException, SQLException, CampoObrigatorioException;
	public Professor procurar(String cpf) throws ProfessorNaoEncontradoException, SQLException, CampoObrigatorioException;
	public void atualizar(Professor professor)throws ProfessorNaoEncontradoException, SQLException, CampoObrigatorioException;
	public void remover(String cpf)throws ProfessorNaoEncontradoException, SQLException, CampoObrigatorioException;
	public boolean existe(String cpf)throws SQLException, CampoObrigatorioException, ProfessorNaoEncontradoException;
	public ArrayList<Professor> listar()throws SQLException;
	public ArrayList<Professor> listarSub()throws SQLException;
	public ArrayList<Professor> listar(String complemento)throws SQLException;
}
