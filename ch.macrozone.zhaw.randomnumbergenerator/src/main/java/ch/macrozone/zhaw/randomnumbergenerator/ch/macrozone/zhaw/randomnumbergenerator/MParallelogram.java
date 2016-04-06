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



	public static BigInteger findMWithPralellogram(BigInteger[] X, int limit) {
		Point x0 = new Point(X[0], X[1]);

		BigInteger gcd_of_ms = null;
		for (int i = 1; i < Math.min(limit,X.length - 1); i++) {
			for (int j = 1; j < Math.min(limit, X.length - 1); j++) {
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
				.subtract(xj.x.subtract(x0.x).multiply(xi.y.subtract(x0.y))).abs();
	}
}
