package ch.macrozone.zhaw.randomnumbergenerator.ch.macrozone.zhaw.randomnumbergenerator;

import java.math.BigInteger;

public class lcg {

	public static BigInteger[] computeX(BigInteger a, BigInteger c,
			BigInteger m, BigInteger x0, int n) {

		

		BigInteger x = x0;

		BigInteger[] array = new BigInteger[n + 1];

		for (int i = 0; i < n + 1; i++) {
			x = (a.multiply(x).add(c).mod(m)); // LCG formula
			System.out.println(x);
			array[i] = x;
		}
		return array;
	}

	
}