/**
 * 
 * @author Florin Babusca Voicu
 * @version 2
 */
package calculadora;
public class Calculadora implements ICalculadora{
	/**
	 * Sumamos dos numeros
	 * @throws ArithmeticException si no existe suficiente precision
	 */
	@Override
	public double suma(double a, double b) {
		double resultado = a + b;
		if( resultado - a != b || resultado - b != a) {
			throw new ArithmeticException("Precision insuficiente");
		}
		return resultado;
	}
	/**
	 * Restamos a el primer numero el segundo
	 * @throws ArithmeticException si no existe suficiente precision
	 */
	@Override
	public double resta(double a, double b) {
		double resultado = a - b;
		if( -resultado + a != b || resultado + b != a) {
			throw new ArithmeticException("Precision insuficiente");
		}
		return resultado;
	}
	/**
	 * Multiplicacion de dos numeros
	 * @throws ArithmeticException si no existe suficiente precision
	 */
	@Override
	public double mult(double a, double b) {
		double resultado = a * b;
		if(a == 0 || b == 0) {
			resultado = 0;
		}
		else if( resultado/a != b || resultado/b != a) {
			throw new ArithmeticException("Precision insuficiente");
		}
		return resultado;
		
	}

	@Override
	public double divide(double a, double b) {
		double valor;
		if (b == 0) {
			throw new ArithmeticException("Divison por 0");
		}
		valor = a / b;
		if (valor * b != a) {
			throw new ArithmeticException("Mala precision del calculo");
		}
		return valor;
	}
/**
 * Calculamos el factorial de un numero
 * @param n es el numero al que le vamos a hacer el factorial
 * @throws IllegalArgumentException si no se puede calcular el factorial
 */
	@Override
	public int fact(int n) {
		if(n < 0) {
			throw new IllegalArgumentException("El numero para calcular el factorial no puede ser negativo");
		} else {
			int valor = 1;
			int i = 2;
			while (i <= n) {
				valor *= i;
				i++;
			}
			return valor;
		}
		
	}

	@Override
	public boolean esPrimo(int n) {
		boolean primo = true;
		if (n > 1) {
			int contador = 2;
			while ((primo) && (contador < n)) {
				if (n % contador == 0) {
					primo = false;
				}
				contador++;
			}
		} else {
			primo = false;
		}
		return primo;
	}

}
