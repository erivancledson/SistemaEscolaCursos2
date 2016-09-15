package Escola.Contrato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Escola.Aluno.Aluno;
import Escola.Aluno.AlunoNaoEncontradoException;
import Escola.Contato.Contato;
import Escola.Curso.Curso;
import Escola.Endereco.Endereco;
import Escola.Professor.Professor;
import Escola.Util.Conexao;
import Escola.Util.Database;

public class RepositorioContratoBDR  implements IRepositorioContrato {

	private Connection conectar = null;
	private int database = 0;

	public RepositorioContratoBDR() throws Exception {
		this.conectar = Conexao.getConnection(Database.ORACLE);
	}

	public void cadastrar(Contrato contrato) throws SQLException {

		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql;
		if(contrato != null){
			try{
				sql = "insert into contrato(cod_contrato, cod_curso, cod_aluno, descricao) " +
						"values (cod_contrato.nextval, ?, ?, ?)";
				stmt = this.conectar.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				
				stmt.setInt(1, contrato.getCod_curso());
				stmt.setInt(2, contrato.getCod_aluno());
				stmt.setString(3, contrato.getDescricao());
	              
				rs = stmt.getGeneratedKeys();
				stmt.execute();
				int cursoCod = 0;
				while(rs.next()){
					contrato.getCod_curso();
				}
				
			}finally{
				stmt.close();
				rs.close();
			}
		}

		}
		public void atualizar(Contrato contrato) throws SQLException, ContratoNaoEncontradoException {
			
			PreparedStatement stmt = null;
			try{
				if(contrato != null){
					String sql = "update contrato set cod_curso = ?, cod_aluno = ?, descricao = ? ";
			
					sql += " where cod_contrato = ?";
					stmt = this.conectar.prepareStatement(sql);
					stmt.setInt(1, contrato.getCod_curso());
					stmt.setInt(2, contrato.getCod_aluno());
					stmt.setString(3, contrato.getDescricao());
					stmt.setInt(4, contrato.getCod_contrato());
					Integer resultado = stmt.executeUpdate();
					
					if(resultado == 0){
						throw new ContratoNaoEncontradoException();
					}
			}
			}finally{
				stmt.close();
			}
		
		}


		public Contrato contratoProcurar(int cod_contrato) throws SQLException, ContratoNaoEncontradoException {
			PreparedStatement stmt = null;
			String sql = "";
			ResultSet rs = null;
			Contrato contrato = null;
			try{
				sql += "select * from contrato";
				sql += " where cod_contrato = ?";
				stmt = this.conectar.prepareStatement(sql);
				stmt.setInt(1, cod_contrato);
				rs = stmt.executeQuery();
				if(rs.next()){
					contrato = new Contrato(rs.getInt("cod_curso"), rs.getInt("cod_aluno"), rs.getString("descricao"));
				}
			}finally{
				stmt.close();
				rs.close();
			}
			
             return contrato;
		}
		
		public ArrayList<Contrato> listar() throws SQLException, ContratoNaoEncontradoException {
			PreparedStatement stmt = null;
			ArrayList<Contrato> contratos = new ArrayList<Contrato>();
			String sql = "";
			ResultSet rs = null;
			try {
				
				sql = "select contrato.cod_contrato as contrato, aluno.nome_aluno as aluno, curso.nome as curso, "
						+ "contrato.descricao as descricao "
						+ "from aluno, curso, contrato "
						+ "where contrato.cod_aluno = aluno.cod_aluno "
						+ "and contrato.cod_curso = curso.cod_curso";
						
				stmt = this.conectar.prepareStatement(sql);
				rs = stmt.executeQuery();
				while (rs.next()) {

					Contrato contrato = new Contrato(rs.getInt("contrato"),
							rs.getString("curso"), rs.getString("aluno"),
							rs.getString("descricao"));

					Curso curso = new Curso();
					Aluno aluno = new Aluno();
				

					curso.setNome(rs.getString("curso"));
					aluno.setNome_aluno(rs.getString("aluno"));
					
					contrato.setCurso(curso);
					contrato.setAluno(aluno);
				

					contratos.add(contrato);

				}
			} finally {
				stmt.close();
				rs.close();
			}

			return contratos;
		}
		
		public ArrayList<Contrato> listar(String complemento) throws SQLException, ContratoNaoEncontradoException {
			PreparedStatement stmt = null;

			ArrayList<Contrato> contratos = new ArrayList<Contrato>();
			String sql = "";
			ResultSet rs = null;
			try {
				
				sql = "select contrato.cod_contrato as contrato, aluno.nome_aluno as aluno, curso.nome as curso, "
						+ "contrato.descricao as descricao "
						+ "from aluno, curso, contrato "
						+ "where contrato.cod_aluno = aluno.cod_aluno "
						+ "and contrato.cod_curso = curso.cod_curso";
						
				stmt = this.conectar.prepareStatement(sql);
				rs = stmt.executeQuery();
				while (rs.next()) {

					Contrato contrato = new Contrato(rs.getInt("contrato"),
							rs.getString("curso"), rs.getString("aluno"),
							rs.getString("descricao"));

					Curso curso = new Curso();
					Aluno aluno = new Aluno();
				

					curso.setNome(rs.getString("curso"));
					aluno.setNome_aluno(rs.getString("aluno"));
					
					contrato.setCurso(curso);
					contrato.setAluno(aluno);
				

					contratos.add(contrato);

				}

			} finally {
				stmt.close();
				rs.close();
			}

			return contratos;
		}
		

		@Override
		public void remover(int cod_contrato) throws SQLException {
			PreparedStatement stmt = null;
			try {
				String sql = "delete from contrato where cod_contrato = ?";
				stmt = this.conectar.prepareStatement(sql);
				stmt.setInt(1, cod_contrato);
				stmt.execute();

			} finally {
				stmt.close();
			}
		}
}
