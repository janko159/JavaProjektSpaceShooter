package levely;

import postavy.Nepriatel;
import postavy.Prisera;
import statickeTriedy.RandomCislo;

import java.util.ArrayList;

/**
 * @version 1.5 finalna verzia
 */

/**
 * @author Ján Drugda
 */

/**
 * Trieda implementuje interface Generator
 */

public class GeneratorPriser implements Generator {

    /**
     * Generujú sa tu Príšery do riadkov podľa toho koľko ich je
     * @param prisera vytvaraju sa tu prisery
     * @param  nepriatelia do listu sa budu pridavat prisery
     */
    @Override
    public void generuj(Nepriatel prisera, ArrayList<Nepriatel> nepriatelia) {
        int randomVzdialenost = RandomCislo.vygenerujRandMedzeru();
        int pocetNepriatelov = RandomCislo.vygenerujRandNepriatelov();

        for (int i = 0; i < pocetNepriatelov; i++) {
            if (i > 5 && i < 12) {
                prisera = new Prisera(randomVzdialenost * (i - 6), 75);
            } else if (i > 11) {
                prisera = new Prisera(randomVzdialenost * (i - 12), 150);
            } else {
                prisera = new Prisera(randomVzdialenost * i, 0);
            }
            nepriatelia.add(prisera);
        }
    }

    @Override
    public void generuj(Nepriatel typnNepriatela, Nepriatel druhyTyp, ArrayList<Nepriatel> nepriatelia) {

    }
}
