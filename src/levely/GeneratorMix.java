package levely;

import postavy.Nepriatel;
import postavy.Prisera;
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

public class GeneratorMix implements Generator {
    @Override
    public void generuj(Nepriatel typnNepriatela, ArrayList<Nepriatel> nepriatelia) {

    }

    /**
     * Generujú sa tu Príšery aj Votrelci do riadkov podľa toho koľko ich je
     * @param votrelec vytvara sa tu typ nepraitela votrelec
     * @param prisera vytvara sa tu typ nepriatela prisera
     * @param nepriatelia pridavaju sa do listu vytvoreny nepratelia
     */

    @Override
    public void generuj(Nepriatel votrelec, Nepriatel prisera, ArrayList<Nepriatel> nepriatelia) {
        int randomVzdialenost = RandomCislo.vygenerujRandMedzeru();
        int pocetVotrelcov = RandomCislo.generujRandomPocetVotrelcovNaLevel3();
        int pocetPriser = RandomCislo.generujRandomCisloPriserNaLevel3();

        for (int i = 0; i < pocetVotrelcov; i++) {
            votrelec = new Votrelec(randomVzdialenost * i, 75);
            nepriatelia.add(votrelec);
        }

        for (int i = 0; i < pocetPriser; i++) {
            if (i > 6) {
                prisera = new Prisera(randomVzdialenost * (i - 7), 245);
            } else {
                prisera = new Prisera(randomVzdialenost * i, 170);
            }
            nepriatelia.add(prisera);
        }
    }
}
