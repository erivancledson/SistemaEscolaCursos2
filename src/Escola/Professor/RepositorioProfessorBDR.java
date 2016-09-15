package Escola.Professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import Escola.Contato.Contato;
import Escola.Endereco.Endereco;
import Escola.Util.Conexao;
import Escola.Util.Database;

public class RepositorioProfessorBDR implements IRepositorioProfessorBDR{

	
private Connection conectar = null;
	
	
	
	public RepositorioProfessorBDR() throws Exception {

		this.conectar = Conexao.getConnection(Database.ORACLE);
	}
	
	
	@Override
	public void Cadastrar(Professor professor)
			throws ProfessorJaCadastradoException, SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql;
		if(professor != null){
			try{
				sql = "insert into professor(cod_professor, nome_professor, cpf, sexo, email, telefone, celular, logradouro, numero, bairro, cidade, estado, cep, cod_curso) " +
						"values (cod_professor.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				stmt = this.conectar.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, professor.getNome_professor());
				stmt.setString(2, professor.getCpf());
				stmt.setString(3, professor.getSexo());
				stmt.setString(4, professor.getContato().getEmail());
				stmt.setString(5, professor.getContato().getTelefone());
				stmt.setString(6, professor.getContato().getCelular());
				stmt.setString(7, professor.getEndereco().getLogradouro());
				stmt.setString(8, professor.getEndereco().getNumero());;
				stmt.setString(9, professor.getEndereco().getBairro());
				stmt.setString(10, professor.getEndereco().getCidade());
				stmt.setString(11, professor.getEndereco().getEstado());
				stmt.setString(12, professor.getEndereco().getCep());
				stmt.setInt(13, professor.getCod_curso());	
				
				rs = stmt.getGeneratedKeys();
				stmt.execute();
				
				while(rs.next()){
					professor.getCod_professor();
				}
				
			}finally{
				stmt.close();
				rs.close();
			}
		}
	     }
		
	
	@Override
	public Professor procurar(String cpf)
			throws ProfessorNaoEncontradoException, SQLException {
		Professor professores = null;
		String complemento = " and professor.cpf = " + cpf;
		ArrayList<Professor> Professor = this.listar(complemento);
		if(Professor.isEmpty()){
			throw new ProfessorNaoEncontradoException();
		}
		return Professor.get(0);
	}
	
	
	@Override
	public void atualizar(Professor professor)
			throws ProfessorNaoEncontradoException, SQLException {
		PreparedStatement stmt = null;
		try{
			if(professor != null){
				String sql = "update professor set nome_professor = ?, sexo = ?, email = ?, "
						+ "telefone = ?, celular = ?,  logradouro = ?, numero = ?, bairro = ?, "
						+ "cidade = ?, estado = ?, cep = ?, cod_curso = ?" ;
				sql += " where cpf = ?";
				stmt = this.conectar.prepareStatement(sql);
				stmt.setString(1, professor.getNome_professor());
				stmt.setString(2, professor.getSexo());
				stmt.setString(3, professor.getContato().getEmail());
				stmt.setString(4, professor.getContato().getTelefone());
				stmt.setString(5, professor.getContato().getCelular());
				stmt.setString(6, professor.getEndereco().getLogradouro());
				stmt.setString(7, professor.getEndereco().getNumero());
				stmt.setString(8, professor.getEndereco().getBairro());
				stmt.setString(9, professor.getEndereco().getCidade());
				stmt.setString(10, professor.getEndereco().getEstado());
				stmt.setString(11, professor.getEndereco().getCep());
				stmt.setInt(12, professor.getCod_curso());	
				stmt.setString(13, professor.getCpf());
				Integer resultado = stmt.executeUpdate();
				
				if(resultado == 0){
					throw new ProfessorNaoEncontradoException();
				}
			}
			
		}finally{
			stmt.close();
		}
		
	}
	
	@Override
	public void remover(String cpf) throws ProfessorNaoEncontradoException,
			SQLException {
			PreparedStatement stmt = null;
			try{
				String sql ="delete from professor where cpf = ?" ;
				stmt = this.conectar.prepareStatement(sql);
				stmt.setString(1, cpf);
				stmt.execute();
			}finally{
				stmt.close();
			}
		
	}

	@Override
	public boolean existe(String cpf) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			String sql ="select count(*) as quantidade from professor where cpf = ?";
			stmt = this.conectar.prepareStatement(sql);
			stmt.setString(1, cpf);
			rs = stmt.executeQuery();
			rs.next();
			if(rs.getInt("quantidade") == 0){
				return false;
			}else{
				return true;
			}
		}finally{
			stmt.close();
			rs.close();
		}
	
	}
 
	@Override
	public ArrayList<Professor> listar() throws SQLException {
		PreparedStatement stmt = null;
		ArrayList<Professor> professor = new ArrayList<Professor>();
		String sql = "";
		ResultSet rs = null;
		try{
			sql += "select * from professor";
			sql += " where cod_professor is not null";
			stmt = this.conectar.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				Professor professores = new Professor(rs.getString("cod_professor"), rs.getString("nome_professor"), rs.getString("cpf"), rs.getString("sexo"), rs.getString("email"), rs.getString("telefone"), rs.getString("celular"), rs.getString("logradouro"), rs.getString("numero"), rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("cep"), rs.getInt("cod_curso"));
				
				
				Contato contato = new Contato();
				Endereco endereco = new Endereco();
				
				contato.setEmail(rs.getString("email"));
				contato.setTelefone(rs.getString("telefone"));
				contato.setCelular(rs.getString("celular"));
				endereco.setLogradouro(rs.getString("logradouro"));
				endereco.setNumero(rs.getString("numero"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setEstado(rs.getString("estado"));
				endereco.setCep(rs.getString("cep"));
				
				
				professores.setContato(contato);
				professores.setEndereco(endereco);
				professor.add(professores);
				
            
			}
		}finally{
			stmt.close();
			rs.close();
		}
		
		return professor;
	}
	
	
	@Override
	public ArrayList<Professor> listar(String complemento) throws SQLException {
		PreparedStatement stmt = null;
		ArrayList<Professor> professor = new ArrayList<Professor>();
		String sql = "";
		ResultSet rs = null;
		try{
			sql += "select * from professor";
			sql += " where cod_professor is not null";
			sql += complemento;
			stmt = this.conectar.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				Professor professores = new Professor(rs.getString("cod_professor"), rs.getString("nome_professor"), rs.getString("cpf"), rs.getString("sexo"), rs.getString("email"), rs.getString("telefone"), rs.getString("celular"), rs.getString("logradouro"), rs.getString("numero"), rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("cep"), rs.getInt("cod_curso"));
				
				
				Contato contato = new Contato();
				Endereco endereco = new Endereco();
				
				contato.setEmail(rs.getString("email"));
				contato.setTelefone(rs.getString("telefone"));
				contato.setCelular(rs.getString("celular"));
				endereco.setLogradouro(rs.getString("logradouro"));
				endereco.setNumero(rs.getString("numero"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setEstado(rs.getString("estado"));
				endereco.setCep(rs.getString("cep"));
				
				
				professores.setContato(contato);
				professores.setEndereco(endereco);
				professor.add(professores);
				
            
			}
		}finally{
			stmt.close();
			rs.close();
		}
		
		return professor;

}
	
	
	public ArrayList<Professor> listarSub() throws SQLException {
		PreparedStatement stmt = null;
		ArrayList<Professor> professor = new ArrayList<Professor>();
		String sql = "";
		ResultSet rs = null;
		try{
			sql += "select nome_professor, cpf "
                  + "from professor "
                  + "where sexo IN (select sexo " 
                   + "from professor "
                  + "where nome_professor IN ('ERIVAN'))";
			
			stmt = this.conectar.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				Professor professores = new Professor(rs.getString("nome_professor"), rs.getString("cpf"));
				
				
				
				professor.add(professores);
				
            
			}
		}finally{
			stmt.close();
			rs.close();
		}
		
		return professor;
	}

}
