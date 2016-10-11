/**
 * Created by Stephan D on 10.10.2016.
 */
public class Fibonacci {

    // rekursive Berechnung
    public static long berechneRekursiv(final int n) {

        if (n <= 0) {
            return 0;
        }
        if ( n == 1) {
            return 1;
        }
        return berechneRekursiv(n - 1) + berechneRekursiv(n - 2);
    }

    // iterative Berechnung
    public static long berechneIterativ(final int n) {

        if (n <= 0) {
            return 0;
        }
        if ( n == 1) {
            return 1;
        }
        long zahl1 = 0;
        long zahl2 = 1;
        for (int i = 1; i < n; i++) {
            final long result = zahl1 + zahl2;
            zahl1 = zahl2;
            zahl2 = result;
        }
        return zahl2;
    }


    public static void main(final String[] args) throws Exception {
        System.out.println(berechneRekursiv(10) + ", " + berechneIterativ(10));
        System.out.println("iterativTest: " + berechneIterativ(40) + berechneIterativ(39) + berechneIterativ(38) + berechneIterativ(37) + berechneIterativ(36));
        System.out.println("rekursivTest: " + berechneRekursiv(40) + berechneRekursiv(39) + berechneRekursiv(38) + berechneRekursiv(37) + berechneRekursiv(36));
    }
}
