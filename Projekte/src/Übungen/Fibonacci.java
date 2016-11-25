package Übungen;

/**
 * Created by Stephan D on 10.10.2016.
 */
public class Fibonacci {

    // rekursive Berechnung
    public static long berechneRekursiv(final int n) {

        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return berechneRekursiv(n - 1) + berechneRekursiv(n - 2);
    }

    // iterative Berechnung
    public static long berechneIterativ(final int n) {

        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
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

        // negativ Test: n = -3 result = 0
        System.out.println(berechneRekursiv(-3) + ", " + berechneIterativ(-3));
        // 0 Test n = 0, result = 0
        System.out.println(berechneRekursiv(0) + ", " + berechneIterativ(0));
        // 1 Test: n = 1, result = 1
        System.out.println(berechneRekursiv(1) + ", " + berechneIterativ(1));
        // 2 Test: n = 2, result = 1
        System.out.println(berechneRekursiv(2) + ", " + berechneIterativ(2));
        // 3 Test: n = 3, result = 2
        System.out.println(berechneRekursiv(3) + ", " + berechneIterativ(3));

        // Aufgabe Test: n = 10, result = 55, Rekursiv, Iterativ
        System.out.println(berechneRekursiv(10) + ", " + berechneIterativ(10));

        // Laufzeit Test
        System.out.println("iterativTest: " + berechneIterativ(40) + berechneIterativ(39) + berechneIterativ(38) + berechneIterativ(37) + berechneIterativ(36));
        // Iterativ: berechneIterativ() wird einmal aufgerufen, die While-Schleife wird n mal durchlaufen, die Laufzeit hängt also nur linear von n ab.
        System.out.println("rekursivTest: " + berechneRekursiv(40) + berechneRekursiv(39) + berechneRekursiv(38) + berechneRekursiv(37) + berechneRekursiv(36));
        // rekursiv: berechneRekursiv() hängt von der Anzahl der Aufrufe ab und wächst damit exponentiell in n.
        // Ergebnis: Die Iterative Fumktion wird schneller durchlaufen als die Rekursive.
    }
}
