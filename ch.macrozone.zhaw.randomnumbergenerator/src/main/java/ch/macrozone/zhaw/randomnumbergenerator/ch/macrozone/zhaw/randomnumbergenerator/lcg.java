package ch.macrozone.zhaw.randomnumbergenerator.ch.macrozone.zhaw.randomnumbergenerator;

import java.math.BigInteger;

public class lcg {

	public static BigInteger[] computeX(BigInteger a, BigInteger b,
			BigInteger m, BigInteger x0, int n) {

		

		BigInteger x = x0;

		BigInteger[] array = new BigInteger[n + 1];

		for (int i = 0; i < n + 1; i++) {
			x = (a.multiply(x).add(b).mod(m)); // LCG formula
			System.out.println(x);
			array[i] = x;
		}
		return array;
	}

	public static void main(String[] args) {

		BigInteger a = BigInteger.valueOf(12345);

		BigInteger b = BigInteger.valueOf(12345);
		BigInteger m = BigInteger.valueOf(27182819);
		BigInteger x0 = BigInteger.valueOf(1111);

		BigInteger[] array = computeX(a, b, m, x0, 128);

		BigInteger a_our = (array[2].subtract(array[1])).multiply(
				(array[1].subtract(array[0])).modInverse(m)).mod(m);

		BigInteger c_our = array[1].subtract(array[0].multiply(a_our)).mod(m);
		System.out.println("our a: " + a_our);
		System.out.println("our c: " + c_our);
		System.out.println(array);
	}
}