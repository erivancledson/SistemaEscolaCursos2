package Escola.Curso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Escola.Util.Conexao;
import Escola.Util.Database;

public class RepositorioCursoBDR implements IRepositorioCurso{

	
private Connection conectar = null;
	
	
	
	public RepositorioCursoBDR() throws Exception {

		this.conectar = Conexao.getConnection(Database.ORACLE);
	}
	
	
	@Override
	public void Cadastrar(Curso curso)
			throws CursoJaCadastradoException, SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql;
		if(curso != null){
			try{
				sql = "insert into curso(cod_curso, nome, dia_semana, horario, imagem) " +
						"values (cod_curso.nextval, ?, ?, ?, ?)";
				stmt = this.conectar.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				
				stmt.setString(1, curso.getNome());
				stmt.setString(2, curso.getDia_semana());
				stmt.setString(3, curso.getHorario());
				stmt.setString(4, curso.getImagem());
				
				rs = stmt.getGeneratedKeys();
				stmt.execute();
				int cursoCod = 0;
				while(rs.next()){
					curso.getCod_curso();
				}
				
			}finally{
				stmt.close();
				rs.close();
			}
		}
	     }
		
	
	@Override
	public Curso procurar(String cod_curso)
			throws CursoNaoEncontradoException, SQLException {
		Curso curso = null;
		String complemento = " and curso.cod_curso = " + cod_curso;
		ArrayList<Curso> Curso = this.listar(complemento);
		if(Curso.isEmpty()){
			throw new CursoNaoEncontradoException();
		}
		return Curso.get(0);
	}
	
	
	@Override
	public void atualizar(Curso curso)
			throws CursoNaoEncontradoException, SQLException {
		PreparedStatement stmt = null;
		try{
			if(curso != null){
				String sql = "update curso set nome = ?, dia_semana = ?, "
						+ "horario = ?" ;
				sql += " where cod_curso = ?";
				stmt = this.conectar.prepareStatement(sql);
				
				stmt.setString(1, curso.getNome());
				stmt.setString(2, curso.getDia_semana());
				stmt.setString(3, curso.getHorario());
				stmt.setString(4, curso.getCod_curso());
			
				Integer resultado = stmt.executeUpdate();
				
				if(resultado == 0){
					throw new CursoNaoEncontradoException();
				}
			}
			
		}finally{
			stmt.close();
		}
		
	}
	
	@Override
	public void remover(String cod_curso) throws CursoNaoEncontradoException,
			SQLException {
			PreparedStatement stmt = null;
			try{
				String sql ="delete from curso where cod_curso = ?" ;
				stmt = this.conectar.prepareStatement(sql);
				stmt.setString(1, cod_curso);
				stmt.execute();
			}finally{
				stmt.close();
			}
		
	}

	@Override
	public boolean existe(String cod_curso) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			String sql ="select count(*) as quantidade from curso where cod_curso = ?";
			stmt = this.conectar.prepareStatement(sql);
			stmt.setString(1, cod_curso);
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
	public ArrayList<Curso> listar() throws SQLException {
		PreparedStatement stmt = null;
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		String sql = "";
		ResultSet rs = null;
		try{
			sql += "select * from curso";
			sql += " where cod_curso is not null";
			stmt = this.conectar.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				Curso curso = new Curso(rs.getString("cod_curso"), rs.getString("nome"), rs.getString("dia_semana"), rs.getString("horario"), rs.getString("imagem"));
			    
				
		
				
				
				cursos.add(curso);
				
            
			}
		}finally{
			stmt.close();
			rs.close();
		}
		
		return cursos;
	}
	
	
	
	@Override
	public ArrayList<Curso> listar(String complemento) throws SQLException {
		PreparedStatement stmt = null;
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		String sql = "";
		ResultSet rs = null;
		try{
			sql += "select * from curso";
			sql += " where cod_curso is not null";
			sql += complemento;
			stmt = this.conectar.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
		Curso curso = new Curso(rs.getString("cod_curso"), rs.getString("nome"), rs.getString("dia_semana"), rs.getString("horario"), rs.getString("imagem"));
			    
				
		
				
				
				cursos.add(curso);
				
            
			}
		}finally{
			stmt.close();
			rs.close();
		}
		
		return cursos;

  }
	
	public ArrayList<Curso> listarLog() throws SQLException {
		PreparedStatement stmt = null;
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		String sql = "";
		ResultSet rs = null;
		try{
			sql += "select * from curso_bda_log";
			sql += " where cod_curso is not null";
			stmt = this.conectar.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				Curso curso = new Curso(rs.getString("nome"), rs.getString("dia_semana"), rs.getString("horario"));
			    
				
		
				
				
				cursos.add(curso);
				
            
			}
		}finally{
			stmt.close();
			rs.close();
		}
		
		return cursos;
	}
	
	
	
}
