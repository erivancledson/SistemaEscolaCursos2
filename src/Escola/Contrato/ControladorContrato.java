package Escola.Contrato;

import java.sql.SQLException;
import java.util.ArrayList;

import Escola.Aluno.IRepositorioAlunoBDR;
import Escola.Curso.IRepositorioCurso;
import Escola.Aluno.RepositorioAlunoBDR;
import Escola.Curso.RepositorioCursoBDR;

public class ControladorContrato {
	
	IRepositorioCurso repositorioCurso;
	IRepositorioAlunoBDR repositorioAluno;
	IRepositorioContrato repositorioContrato;
	
	
	public ControladorContrato() throws Exception{
		this.repositorioContrato = new RepositorioContratoBDR();
		this.repositorioCurso = new RepositorioCursoBDR();
		this.repositorioAluno = new RepositorioAlunoBDR();
		
		
		
	}
public void cadastrar (Contrato contrato) throws SQLException{
		
		this.repositorioContrato.cadastrar(contrato);
	}
	
	public void remover(int cod_contrato) throws SQLException{
		this.repositorioContrato.remover(cod_contrato);
	}
	
	public void atualizar(Contrato contrato) throws SQLException, ContratoNaoEncontradoException{
		this.repositorioContrato.atualizar(contrato);
	}
	
	public Contrato procurar(int cod_contrato) throws SQLException, ContratoNaoEncontradoException{
		return this.repositorioContrato.contratoProcurar(cod_contrato);
	}

	public ArrayList<Contrato> listar() throws SQLException, ContratoNaoEncontradoException{
		return this.repositorioContrato.listar();
	}
}
