package Escola.Contrato;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IRepositorioContrato {
	public void cadastrar(Contrato contrato) throws SQLException;
	public Contrato contratoProcurar(int cod_contrato) throws SQLException, ContratoNaoEncontradoException;
	//public boolean existe(String cpf) throws SQLException;
	public ArrayList<Contrato> listar() throws SQLException, ContratoNaoEncontradoException;
	public ArrayList<Contrato> listar(String complemento) throws SQLException, ContratoNaoEncontradoException;
	public void atualizar(Contrato contrato) throws SQLException, ContratoNaoEncontradoException;
	public void remover(int cod_contrato) throws SQLException;
}
