package Escola.Curso;

public class CodigoInvalidoException extends Exception {

	public CodigoInvalidoException(String cod_curso) {
		super("Codigo : " + cod_curso + "é nulo ou invalido !!!");
		
	}

}
