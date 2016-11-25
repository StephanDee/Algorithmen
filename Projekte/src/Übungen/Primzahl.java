package Übungen;

import java.security.InvalidAlgorithmParameterException;

/**
 * Created by Stephan D on 17.10.2016.
 */
public class Primzahl {

    /**
     * Funktion zur Bestimmung, ob eine Zahl Übungen.Primzahl ist
     *
     * @param n die zu ueberpruefende Zahl
     * @return true g.d.w. n eine Übungen.Primzahl ist
     * @throws InvalidAlgorithmParameterException wenn n < 2
     */
    public static boolean isPrime(int n) throws InvalidAlgorithmParameterException {
        if (n < 2) {
            throw new InvalidAlgorithmParameterException(new String("Falscher Parameter " + n));
        }

        int div = 2;
        while (div <= n / 2) {
            if (n % div == 0) // Teiler gefunden
                return false;
            div++;
        }
        return true;
    }

    /**
     * Funktion, zum Test, ob isPrime bei Eingabe einer Übungen.Primzahl das korrekte Ergebnis liefert
     *
     * @param zahl eine Übungen.Primzahl
     * @return true g.d.w. isPrime(zahl) das Ergebnis true liefert
     */
    public static boolean testPrimeExpected(int zahl) {
        // Testen von Primzahlen
        try {
            if (!isPrime(zahl)) {
                System.out.println("Fehler bei " + zahl + "unerwartetes Ergebnis bei Übungen.Primzahl");
                return false;
            }
        } catch (InvalidAlgorithmParameterException e) {
            System.out.println("Fehler bei " + zahl + "unerwartete Ausnahme bei Übungen.Primzahl");
            return false;
        }
        return true;
    }

    /**
     * Funktion zum Test, ob isPrime bei Eingabe einer Nicht-Übungen.Primzahl das korrekte Ergebnis liefert
     *
     * @param zahl eine Nicht-Übungen.Primzahl
     * @return true g.d.w. isPrime(zahl) das Ergebnis false liefert
     */
    public static boolean testNotPrimeExpected(int zahl) {
        // Testen von Nicht-Primzahlen
        try {
            if (isPrime(zahl)) {
                System.out.println("Fehler bei " + zahl + " unerwartetes Ergebnis bei Nichtprimzahl");
                return false;
            }
        } catch (InvalidAlgorithmParameterException e) {
            System.out.println("Fehler bei " + zahl + " unerwartete Ausnahme bei Nichtprimzahl");
            return false;
        }
        return true;
    }

    /**
     * Funktion zur Überprüfung, ob bei falschen Eingaben eine Ausnahme geworfen wird
     *
     * @param zahl ein Wert < 2
     * @return true g.d.w. die Ausnahme InvalidAlgorithmParameterException bei Aufruf von isPrime geworfen wird
     */
    public static boolean testExceptionExpected(int zahl) {
        try {
            isPrime(zahl);
            System.out.println("Erwartete Ausnahme bei " + zahl + " nicht aufgetreten");
        } catch (InvalidAlgorithmParameterException e) {
        }
        return true;
    }

    /**
     * Funktion zum Testen der Methode isPrime
     *
     * @return die Anzahl der aufgetretenen Fehler
     */
    public static int testIsPrime() {
        int noErr = 0;
        int zahl = 0;

        // Testreihe Primzahlen
        // Test kleinste Übungen.Primzahl
        zahl = 2;
        if (!testPrimeExpected(zahl)) {
            noErr++;
        }

        // Test mittlere Übungen.Primzahl
        zahl = 17;
        if (!testPrimeExpected(zahl)) {
            noErr++;
        }

        // Test große Übungen.Primzahl
        zahl = 8999;
        if (!testPrimeExpected(zahl)) {
            noErr++;
        }


        // Testreihe gerade Nichtprimzahlen
        // Test kleinste gerade Nichtprimzahl (nach 2)
        zahl = 4;
        if (!testNotPrimeExpected(zahl)) {
            noErr++;
        }

        // Test mittlere gerade Nichtprimzahl
        zahl = 100;
        if (!testNotPrimeExpected(zahl)) {
            noErr++;
        }

        // Test große gerade Nichtprimzahl
        zahl = 124568;
        if (!testNotPrimeExpected(zahl)) {
            noErr++;
        }

        // Testreihe ungerade Nichtprimzahlen
        // Test kleinste ungerade Nichtprimzahl
        zahl = 9;
        if (!testNotPrimeExpected(zahl)) {
            noErr++;
        }

        // Test mittlere ungerade Nichtprimzahl
        zahl = 153;
        if (!testNotPrimeExpected(zahl)) {
            noErr++;
        }

        // Test große ungerade Nichtprimzahl
        zahl = 168651;
        if (!testNotPrimeExpected(zahl)) {
            noErr++;
        }

        // Test falsche Parameter
        // größer falscher Parameter
        zahl = 1;
        if (!testExceptionExpected(zahl)) {
            noErr++;
        }

        // 0 ist oft Sonderfall
        zahl = 0;
        if (!testExceptionExpected(zahl)) {
            noErr++;
        }

        // Test negativer falscher Parameter
        zahl = -5;
        if (!testExceptionExpected(zahl)) {
            noErr++;
        }
        return noErr;
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws InvalidAlgorithmParameterException {
        int rc = 0;
        if ((rc = testIsPrime()) > 0) {
            System.out.println("Test war nicht erfolgreich in " + rc + " Faellen!!!");
        }
    }
}
