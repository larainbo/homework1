import java.math.BigInteger;

public class ExtendedEuclid {
    private static final BigInteger ZERO = new BigInteger("0");

    public static BigInteger[] solve(BigInteger a, BigInteger b) {
        // ensure that we don't run into a divide by zero case
        if (b.equals(ZERO)) {
            // Not sure if this is the right way to handle this case
            throw new Error("'b' cannot be zero.");
        }

        BigInteger u = new BigInteger("1");
        BigInteger g = a;
        BigInteger x = ZERO;
        BigInteger y = b;

        // Find g(gcd) & u
        while (!y.equals(ZERO)) {
            BigInteger t = g.mod(y);
            BigInteger q = g.subtract(t).divide(y);
            BigInteger s = u.subtract(q.multiply(x));

            u = x;
            g = y;
            x = s;
            y = t;
        }

        // Calcuate v, and loop until u > 0
        BigInteger v = (g.subtract(a.multiply(u))).divide(b);
        while (u.compareTo(ZERO) == -1) {
            u = u.add(b.divide(g));
            v = v.subtract(a.divide(g));
        }

        // return g(gcd), u & v
        return new BigInteger[] { g, u, v };
    }

    static String format(BigInteger[] result, BigInteger a, BigInteger b) {
        return (
            result[1] + "·" + a +  " + " +
            result[2] + "·" + b +  " = " +
            result[0]
        );
    }

    public static void main(String[] args) {
        BigInteger a = new BigInteger("2024");
        BigInteger b = new BigInteger("748");

        System.out.println("Example from book:");
        System.out.println(format(solve(a, b), a, b));

        System.out.println("\n1.12 Exercise 'c':");

        System.out.print("  i)   ");
        a = new BigInteger("527");
        b = new BigInteger("1258");
        System.out.println(format(solve(a, b), a, b));

        System.out.print("  ii)  ");
        a = new BigInteger("228");
        b = new BigInteger("1056");
        System.out.println(format(solve(a, b), a, b));

        System.out.print("  iii) ");
        a = new BigInteger("163961");
        b = new BigInteger("167181");
        System.out.println(format(solve(a, b), a, b));

        System.out.print("  iv)  ");
        a = new BigInteger("3892394");
        b = new BigInteger("239847");
        System.out.println(format(solve(a, b), a, b));
    }
}
