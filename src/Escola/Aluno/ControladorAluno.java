package Escola.Aluno;

import java.sql.SQLException;
import java.util.ArrayList;

import Escola.Util.Validacao;

public class ControladorAluno {
	
	private IRepositorioAlunoBDR repositorioAluno;
	
	
	public ControladorAluno() throws Exception {
		this.repositorioAluno = new RepositorioAlunoBDR();
		
	}
	
	public void cadastrar(Aluno aluno) throws CPFInvalidoException, CampoObrigatorioException, SQLException, AlunoJaCadastradoException, AlunoNaoEncontradoException{
		if(!Validacao.validaCPF(aluno.getCpf())) throw new CPFInvalidoException(aluno.getCpf());
		if(aluno.getNome_aluno().equals("") == true) throw new CampoObrigatorioException();
		if(aluno.getContato().getTelefone().equals("") == true) throw new CampoObrigatorioException();
		if(aluno.getContato().getCelular().equals("") == true) throw new CampoObrigatorioException();
		
		if(aluno.getEndereco().getLogradouro().equals("") == true) throw new CampoObrigatorioException();
		if(aluno.getEndereco().getNumero().equals("") == true) throw new CampoObrigatorioException();
		if(aluno.getEndereco().getBairro().equals("") == true) throw new CampoObrigatorioException();
		if(aluno.getEndereco().getCidade().equals("") == true) throw new CampoObrigatorioException();
		if(aluno.getEndereco().getEstado().equals("") == true) throw new CampoObrigatorioException();
		if(aluno.getEndereco().getCep().equals("") == true) throw new CampoObrigatorioException();
		
		if(this.repositorioAluno.existe(aluno.getCpf())) throw new AlunoJaCadastradoException();
		
		this.repositorioAluno.Cadastrar(aluno);
		
	
	}
	
	public void remover(String cpf) throws CPFInvalidoException, AlunoNaoEncontradoException, SQLException, CampoObrigatorioException{
		cpf = cpf.replaceAll("\\.|\\-|\\ ", "");
		Aluno aluno = null;
		
		if(!Validacao.validaCPF(cpf)) throw new CPFInvalidoException(cpf);
		aluno = this.repositorioAluno.procurar(cpf);
		
		
		this.repositorioAluno.remover(cpf);
		
	}

	public Aluno procurar(String cpf) throws CPFInvalidoException, AlunoNaoEncontradoException, SQLException, CampoObrigatorioException{
		cpf = cpf.replaceAll("\\.|\\-|\\ ", "");
		
		if(!Validacao.validaCPF(cpf)) throw new CPFInvalidoException(cpf);
		return this.repositorioAluno.procurar(cpf);
	}

	

	public void atualizar(Aluno aluno) throws AlunoNaoEncontradoException, SQLException, CPFInvalidoException, CampoObrigatorioException{
		if(!Validacao.validaCPF(aluno.getCpf())) throw new CPFInvalidoException(aluno.getCpf());
		if(aluno.getNome_aluno().equals("") == true) throw new CampoObrigatorioException();
		
		this.repositorioAluno.atualizar(aluno);
	}

	public ArrayList<Aluno> listar() throws SQLException{
		return this.repositorioAluno.listar();
	}

	public ArrayList<Aluno> listarVisao() throws SQLException{
		return this.repositorioAluno.listarVisao();
	}
}
