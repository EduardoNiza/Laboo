package EX1;

import java.math.BigInteger;

/**
 * FUI FAZER O EXERCICIO 4 E ACABEI QUEBRANDO O PROJETO, MAS ESTAVA TUDO FUNCIONANDO DO EXERCICIO 1, 2,3 E 5
 */


public class Controller
{
	public static BigInteger factorial(long n) throws ArithmeticException
	{
		BigInteger nAux;
		if (n < 0)
		{
			throw new ArithmeticException();
		} else if (n == 0)
		{
			return (BigInteger.ONE);
		}
		nAux = BigInteger.valueOf(n);
		return (factorial(n - 1).multiply(nAux));
	}

	public static void main(String[] args)
	{
		new View();
	}
}
