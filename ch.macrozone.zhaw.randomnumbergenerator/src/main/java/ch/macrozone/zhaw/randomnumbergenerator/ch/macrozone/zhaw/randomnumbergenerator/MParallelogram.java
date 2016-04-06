package ch.macrozone.zhaw.randomnumbergenerator.ch.macrozone.zhaw.randomnumbergenerator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class MParallelogram {

	public static class Point {

		public Point(BigInteger x, BigInteger y) {
			this.x = x;
			this.y = y;
		}

		public BigInteger x;
		public BigInteger y;

	}

	public static void main(String[] args) {
		BigInteger a = BigInteger.valueOf(12345);

		BigInteger b = BigInteger.valueOf(12345);
		BigInteger m = BigInteger.valueOf(1234134343);
		BigInteger x0 = BigInteger.valueOf(1111);

		BigInteger[] X = lcg.computeX(a, b, m, x0);
		BigInteger m_found = crackWithPralellogram(X);
		System.out.println("m found: " + m_found.toString());
		System.out.println("m real : " + m.toString());
	}

	private static BigInteger crackWithPralellogram(BigInteger[] X) {
		Point x0 = new Point(X[0], X[1]);

		BigInteger gcd_of_ms = null;
		for (int i = 1; i < X.length - 1; i++) {
			for (int j = 1; j < X.length - 1; j++) {
				if (i != j) {

					Point xi = new Point(X[i], X[i + 1]);
					Point xj = new Point(X[j], X[j + 1]);
					BigInteger multiple_of_m = calcArea(x0, xi, xj);
					if (gcd_of_ms == null) {
						gcd_of_ms = multiple_of_m;
					} else {
						gcd_of_ms = gcd_of_ms.gcd(multiple_of_m);
					}
					System.out.println("[" + i + "][" + j
							+ "] Multiply of m is " + multiple_of_m);
					System.out.println("[" + i + "][" + j + "] GCD of ms is "
							+ gcd_of_ms);
				}
			}
		}
		return gcd_of_ms;
	}

	public static BigInteger calcArea(Point x0, Point xi, Point xj) {
		return xi.x.subtract(x0.x).multiply(xj.y.subtract(x0.y))
				.subtract(xj.x.subtract(x0.x).multiply(xi.y.subtract(x0.y)));
	}
}
