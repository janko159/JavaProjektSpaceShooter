package statickeTriedy;

import java.util.Random;

/**
 * version 1.5 finálna verzia
 */

/**
 * @author Ján Drugda
 */

/**
 * Vytvárajú sa tu a poskytujú náhodné čísla pre rôzne potreby
 */

public class RandomCislo {
    private static int pocetNepriatelov;

    private static int medzera;

    /**
     * Statická metóda, ktorá poskytuje číslo o tom, koľko sa nám má vytvoriť nepriateľov
     * @return vráti číslo 6,12 alebo 18 podľa generovania
     */

    public static int vygenerujRandNepriatelov() {
        Random cislo = new Random();
        pocetNepriatelov = cislo.nextInt(1, 4);
        if (pocetNepriatelov == 1) {
            pocetNepriatelov = 6;
            System.out.println("pocet nepriatelov: " + pocetNepriatelov);
            return pocetNepriatelov;
        } else if (pocetNepriatelov == 2) {
            pocetNepriatelov = 12;
            System.out.println("pocet nepriatelov: " + pocetNepriatelov);
            return 12;
        } else {
            pocetNepriatelov = 18;
            System.out.println("pocet nepriatelov: " + pocetNepriatelov);
            return pocetNepriatelov;
        }
    }

    /**
     * Statická metóda, ktorá generuje random počet príšer pre level3
     * @return vráti počet nepriateľov 6 alebo 12
     */

    public static int generujRandomCisloPriserNaLevel3() {
        Random cislo = new Random();
        pocetNepriatelov = cislo.nextInt(1, 3);
        if (pocetNepriatelov == 1) {
            pocetNepriatelov = 6;
            System.out.println("pocet nepriatelov: " + pocetNepriatelov);
            return pocetNepriatelov;
        } else {
            pocetNepriatelov = 12;
            System.out.println("pocet nepriatelov: " + pocetNepriatelov);
            return pocetNepriatelov;
        }
    }

    /**
     * Statická metóda, ktorá generuje random počet Votrelcov pre level3
     * @return vráti random číslo od 5 do 8
     */

    public static int generujRandomPocetVotrelcovNaLevel3 () {
        Random cislo = new Random();
        pocetNepriatelov = cislo.nextInt(5, 8);

        return pocetNepriatelov;
    }

    /**
     * Statická metóda, ktorá generuje random číslo na medzery pre nepriateľov
     * @return vráti random vygenerovanú medzeru
     */

    public static  int vygenerujRandMedzeru() {
        int max = 175;
        int min = 110;
        Random cislo = new Random();
        medzera = cislo.nextInt(max - min + 1) + min;
        return medzera;
    }

    /**
     * Statická metóda, ktorá vráti random číslo medzi 0 a poskytnutým číslom
     * @param y pouziva sa na random generovanie čísla v rozsahu
     * @return vráti random číslo od 0 po zadané y
     */

    public static int vratRandomCisloMedzi(int y) {
        Random cislo = new Random();
        return cislo.nextInt(0, y);
    }

}
