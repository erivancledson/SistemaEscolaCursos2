package Escola.Curso;

public class CodigoInvalidoException extends Exception {

	public CodigoInvalidoException(String cod_curso) {
		super("Codigo : " + cod_curso + "� nulo ou invalido !!!");
		
	}

}
