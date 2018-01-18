import java.math.BigInteger;
import java.io.InputStream;
import java.util.Scanner;

class eucalg{
	
	public static void main ( String args[]){
		
		Scanner scanner = new Scanner (System.in);
		
		System.out.println("Input a");	
		BigInteger A = scanner.nextBigInteger();
		
		System.out.println("Input b");
		BigInteger B = scanner.nextBigInteger();
		
		System.out.println(A + " " + B);
		
		BigInteger U = new BigInteger("1");
		BigInteger G = A;
		BigInteger X = new BigInteger("0");
		BigInteger Y = B;
		
		if (Y.equals(0)){
			BigInteger V = (G.subtract(A.multiply(U))).divide(B);
			System.out.println(G + ", " + U + ", " + V);
			System.exit(0);
		}
		
		while ( !B.equals(0)){
			
			BigInteger Q = G.divide(Y);
			BigInteger R = G.remainder(Y);
			
			G = Y;
			Y = R;
			
			
			
		}
		
	}
}
