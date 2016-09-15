package Escola.Main;

import Escola.Aluno.Aluno;
import Escola.Contato.Contato;
import Escola.Contrato.Contrato;
import Escola.Curso.Curso;
import Escola.Endereco.Endereco;
import Escola.Fachada.Fachada;
import Escola.Professor.Professor;

public class Main {
	public static void main(String[] args) throws Exception {
		Fachada fachada = Fachada.getInstance();
		//Curso cursos = new Curso("digitação", "quarta", "12");
		//fachada.cursoCadastrar(cursos);
  
		// fachada.cursoAtualizar(new Curso("7", "viadagem", "quinta", "4"));

		// consulta professor
		// cosulta o curso com a chave estrangeira do professor
		// a consulta retorna um objeto curso que ser add no professor
		
		//fachada.cursoRemover("22");
		System.out.println(fachada.cursoListarLog());
		
		//Contato contato = new Contato("maria@zembrax.com", "8137266097", "8196831733");
		//Endereco endereco = new Endereco("rua jose", "50", "maria cristina", "belo jardim", "PE", "55155410");
	    //Aluno aluno = new Aluno("maria", "08000096498", "F", contato, endereco, 23);
		
		
		
		//fachada.alunoCadastrar(aluno);
		//System.out.println(fachada.alunoListar());
	//System.out.println(fachada.contratoProcurar(41));
	
		//Contrato contrato = new Contrato(23, 21, "pegou");
		//fachada.contratoCadastrar(contrato);
		//System.out.println(fachada.contratoListar());
		//fachada.contratoAtualizar(new Contrato(41, 1, 1, "top"));
		//System.out.println(fachada.cursoListar());
		//fachada.cursoRemover("1");
		//System.out.println(fachada.cursoListar());
	  //Contato contato = new Contato("maria@zembrax.com", "8137266097", "8196831733");
		//	Endereco endereco = new Endereco("rua jose", "50", "maria cristina", "belo jardim", "pe", "55155410");
		//fachada.AlunoAtualizar(new Aluno("maria", "08000096498", "F", contato, endereco, 21));
		//System.out.println(fachada.alunoListar());
		
		//fachada.alunoRemover("08000096498");
	}

}
