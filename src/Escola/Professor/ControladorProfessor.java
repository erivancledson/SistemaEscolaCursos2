package Escola.Professor;

import java.sql.SQLException;
import java.util.ArrayList;



import Escola.Util.Validacao;

public class ControladorProfessor{
	
	private IRepositorioProfessorBDR repositorioProfessor;


public ControladorProfessor() throws Exception {
	this.repositorioProfessor = new RepositorioProfessorBDR();
	
}

public void cadastrar(Professor professor) throws CPFInvalidoException, CampoObrigatorioException, SQLException, ProfessorJaCadastradoException, ProfessorNaoEncontradoException{
	if(!Validacao.validaCPF(professor.getCpf())) throw new CPFInvalidoException(professor.getCpf());
	if(professor.getNome_professor().equals("") == true) throw new CampoObrigatorioException();
	if(professor.getContato().getTelefone().equals("") == true) throw new CampoObrigatorioException();
	if(professor.getContato().getCelular().equals("") == true) throw new CampoObrigatorioException();
	
	if(professor.getEndereco().getLogradouro().equals("") == true) throw new CampoObrigatorioException();
	if(professor.getEndereco().getNumero().equals("") == true) throw new CampoObrigatorioException();
	if(professor.getEndereco().getBairro().equals("") == true) throw new CampoObrigatorioException();
	if(professor.getEndereco().getCidade().equals("") == true) throw new CampoObrigatorioException();
	if(professor.getEndereco().getEstado().equals("") == true) throw new CampoObrigatorioException();
	if(professor.getEndereco().getCep().equals("") == true) throw new CampoObrigatorioException();
	
	if(this.repositorioProfessor.existe(professor.getCpf())) throw new ProfessorJaCadastradoException();
	
	this.repositorioProfessor.Cadastrar(professor);
	

}

public void remover(String cpf) throws CPFInvalidoException, ProfessorNaoEncontradoException, SQLException, CampoObrigatorioException{
	cpf = cpf.replaceAll("\\.|\\-|\\ ", "");
	Professor professor = null;
	
	if(!Validacao.validaCPF(cpf)) throw new CPFInvalidoException(cpf);
	professor = this.repositorioProfessor.procurar(cpf);
	
	
	this.repositorioProfessor.remover(cpf);
	
}

public Professor procurar(String cpf) throws CPFInvalidoException, ProfessorNaoEncontradoException, SQLException, CampoObrigatorioException{
	cpf = cpf.replaceAll("\\.|\\-|\\ ", "");
	
	if(!Validacao.validaCPF(cpf)) throw new CPFInvalidoException(cpf);
	return this.repositorioProfessor.procurar(cpf);
}



public void atualizar(Professor professor) throws ProfessorNaoEncontradoException, SQLException, CPFInvalidoException, CampoObrigatorioException{
	if(!Validacao.validaCPF(professor.getCpf())) throw new CPFInvalidoException(professor.getCpf());
	if(professor.getNome_professor().equals("") == true) throw new CampoObrigatorioException();
	
	this.repositorioProfessor.atualizar(professor);
}

public ArrayList<Professor> listar() throws SQLException{
	return this.repositorioProfessor.listar();
}

public ArrayList<Professor> listarSub() throws SQLException{
	return this.repositorioProfessor.listarSub();
}

}
