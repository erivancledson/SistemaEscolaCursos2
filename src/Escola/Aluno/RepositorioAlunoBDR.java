package Escola.Aluno;

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

public class RepositorioAlunoBDR implements IRepositorioAlunoBDR{

	
private Connection conectar = null;
	
	
	
	public RepositorioAlunoBDR() throws Exception {

		this.conectar = Conexao.getConnection(Database.ORACLE);
	}
	
	
	@Override
	public void Cadastrar(Aluno aluno)
			throws AlunoJaCadastradoException, SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql;
		if(aluno != null){
			try{
				sql = "insert into aluno(cod_aluno, nome_aluno, cpf, sexo, email, telefone, celular, logradouro, numero, bairro, cidade, estado, cep, cod_curso) " +
						"values (cod_aluno.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				stmt = this.conectar.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, aluno.getNome_aluno());
				stmt.setString(2, aluno.getCpf());
				stmt.setString(3, aluno.getSexo());
				stmt.setString(4, aluno.getContato().getEmail());
				stmt.setString(5, aluno.getContato().getTelefone());
				stmt.setString(6, aluno.getContato().getCelular());
				stmt.setString(7, aluno.getEndereco().getLogradouro());
				stmt.setString(8, aluno.getEndereco().getNumero());;
				stmt.setString(9, aluno.getEndereco().getBairro());
				stmt.setString(10, aluno.getEndereco().getCidade());
				stmt.setString(11, aluno.getEndereco().getEstado());
				stmt.setString(12, aluno.getEndereco().getCep());
				stmt.setInt(13, aluno.getCod_curso());	
				
				rs = stmt.getGeneratedKeys();
				stmt.execute();
				int mestreId = 0;
				while(rs.next()){
					aluno.getCod_aluno();
				}
				
			}finally{
				stmt.close();
				rs.close();
			}
		}
	     }
		
	
	@Override
	public Aluno procurar(String cpf)
			throws AlunoNaoEncontradoException, SQLException {
		Aluno alunos = null;
		String complemento = " and aluno.cpf = " + cpf;
		ArrayList<Aluno> Aluno = this.listar(complemento);
		if(Aluno.isEmpty()){
			throw new AlunoNaoEncontradoException();
		}
		return Aluno.get(0);
	}
	
	
	@Override
	public void atualizar(Aluno aluno)
			throws AlunoNaoEncontradoException, SQLException {
		PreparedStatement stmt = null;
		try{
			if(aluno != null){
				String sql = "update aluno set nome_aluno = ?, sexo = ?, email = ?, "
						+ "telefone = ?, celular = ?,  logradouro = ?, numero = ?, bairro = ?, "
						+ "cidade = ?, estado = ?, cep = ?, cod_curso = ?" ;
				sql += " where cpf = ?";
				stmt = this.conectar.prepareStatement(sql);
				stmt.setString(1, aluno.getNome_aluno());
				stmt.setString(2, aluno.getSexo());
				stmt.setString(3, aluno.getContato().getEmail());
				stmt.setString(4, aluno.getContato().getTelefone());
				stmt.setString(5, aluno.getContato().getCelular());
				stmt.setString(6, aluno.getEndereco().getLogradouro());
				stmt.setString(7, aluno.getEndereco().getNumero());
				stmt.setString(8, aluno.getEndereco().getBairro());
				stmt.setString(9, aluno.getEndereco().getCidade());
				stmt.setString(10, aluno.getEndereco().getEstado());
				stmt.setString(11, aluno.getEndereco().getCep());
				stmt.setInt(12, aluno.getCod_curso());	
				stmt.setString(13, aluno.getCpf());
				Integer resultado = stmt.executeUpdate();
				
				if(resultado == 0){
					throw new AlunoNaoEncontradoException();
				}
			}
			
		}finally{
			stmt.close();
		}
		
	}
	
	@Override
	public void remover(String cpf) throws AlunoNaoEncontradoException,
			SQLException {
			PreparedStatement stmt = null;
			try{
				String sql ="delete from aluno where cpf = ?" ;
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
			String sql ="select count(*) as quantidade from aluno where cpf = ?";
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
	public ArrayList<Aluno> listar() throws SQLException {
		PreparedStatement stmt = null;
		ArrayList<Aluno> aluno = new ArrayList<Aluno>();
		String sql = "";
		ResultSet rs = null;
		try{
			sql += "select * from aluno";
			sql += " where cod_aluno is not null";
			stmt = this.conectar.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				Aluno alunos = new Aluno(rs.getString("cod_aluno"), rs.getString("nome_aluno"), rs.getString("cpf"), rs.getString("sexo"), rs.getString("email"), rs.getString("telefone"), rs.getString("celular"), rs.getString("logradouro"), rs.getString("numero"), rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("cep"), rs.getInt("cod_curso"));
				
				
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
				
				
				alunos.setContato(contato);
				alunos.setEndereco(endereco);
				aluno.add(alunos);
				
            
			}
		}finally{
			stmt.close();
			rs.close();
		}
		
		return aluno;
	}
	
	
	@Override
	public ArrayList<Aluno> listar(String complemento) throws SQLException {
		PreparedStatement stmt = null;
		ArrayList<Aluno> aluno = new ArrayList<Aluno>();
		String sql = "";
		ResultSet rs = null;
		try{
			sql += "select * from aluno";
			sql += " where cod_aluno is not null";
			sql += complemento;
			stmt = this.conectar.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				Aluno alunos = new Aluno(rs.getString("cod_aluno"), rs.getString("nome_aluno"), rs.getString("cpf"), rs.getString("sexo"), rs.getString("email"), rs.getString("telefone"), rs.getString("celular"), rs.getString("logradouro"), rs.getString("numero"), rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("cep"), rs.getInt("cod_curso"));
				
				
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
				
				
				alunos.setContato(contato);
				alunos.setEndereco(endereco);
				aluno.add(alunos);
				
            
			}
		}finally{
			stmt.close();
			rs.close();
		}
		
		return aluno;

}
	
	
	public ArrayList<Aluno> listarVisao() throws SQLException {
		PreparedStatement stmt = null;
		ArrayList<Aluno> aluno = new ArrayList<Aluno>();
		String sql = "";
		ResultSet rs = null;
		try{
			sql += "select * from visao_aluno";
			sql += " where cod_aluno is not null";
			stmt = this.conectar.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				Aluno alunos = new Aluno(rs.getInt("cod_curso"), rs.getString("cod_aluno"), rs.getString("nome_aluno"));
				
				
				
				
				
				
			   aluno.add(alunos);
				
            
			}
		}finally{
			stmt.close();
			rs.close();
		}
		
		return aluno;
	}
}
