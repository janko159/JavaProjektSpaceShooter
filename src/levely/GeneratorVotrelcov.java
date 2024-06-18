package levely;

import postavy.Nepriatel;
import postavy.Votrelec;
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

public class GeneratorVotrelcov implements Generator {
    /**
     * Generujú sa tu Votrelci do riadkov podľa toho koľko ich je
     * @param votrelec vytvaraju sa tu votrelci
     * @param nepriatelia pridavaju sa do listu votrelci
     */
    @Override
    public void generuj(Nepriatel votrelec, ArrayList<Nepriatel> nepriatelia) {
        int randomVzdialenost = RandomCislo.vygenerujRandMedzeru();
        int pocetNepriatelov = RandomCislo.vygenerujRandNepriatelov();

        for (int i = 0; i < pocetNepriatelov; i++) {
            if (i > 5 && i < 12) {
                votrelec = new Votrelec(randomVzdialenost * (i - 6), 75);
            } else if (i > 11) {
                votrelec = new Votrelec(randomVzdialenost * (i - 12), 150);
            } else {
                votrelec = new Votrelec(randomVzdialenost * i, 0);
            }
            nepriatelia.add(votrelec);
        }
    }

    @Override
    public void generuj(Nepriatel typnNepriatela, Nepriatel druhyTyp, ArrayList<Nepriatel> nepriatelia) {

    }
}
