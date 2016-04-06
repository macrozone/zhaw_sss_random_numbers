package ch.macrozone.zhaw.randomnumbergenerator.ch.macrozone.zhaw.randomnumbergenerator;

import java.math.BigInteger;

/**
 * Hello world!
 *
 */
public class App {
	
	public static class Result{
		public Result(BigInteger m, BigInteger a, BigInteger c) {
			this.m = m;
			this.c = c;
			this.a = a;
		}
		BigInteger m;
		BigInteger a;
		BigInteger c;
	}

	public static void main(String[] args) {
		BigInteger a = BigInteger.valueOf(12345);

		BigInteger c = BigInteger.valueOf(12343);
		BigInteger m = BigInteger.valueOf(27182819);
		BigInteger x0 = BigInteger.valueOf(1111);
		int n = 128;
		int limit = 5;
		BigInteger[] X = lcg.computeX(a, c, m, x0, n);
		Result result = crack(X, limit);
		
		System.out.println("m real : " + m.toString());
		System.out.println("m found: " + result.m.toString());

		System.out.println("a real : " + a.toString());
		System.out.println("a found: " + result.a.toString());

		System.out.println("c real : " + c.toString());
		System.out.println("c found: " + result.c.toString());

	}

	public static Result crack(BigInteger[] X, int limit) {
		BigInteger m_found = MParallelogram.findMWithPralellogram(X, limit);

		BigInteger a_found = (X[2].subtract(X[1])).multiply(
				(X[1].subtract(X[0])).modInverse(m_found)).mod(m_found);
		BigInteger c_found = X[1].subtract(X[0].multiply(a_found)).mod(m_found);
		
		return new Result(m_found, a_found, c_found);
		
	}
}
