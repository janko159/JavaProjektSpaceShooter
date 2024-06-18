package levely;

import postavy.Nepriatel;
import postavy.Votrelec;
import statickeTriedy.RandomCislo;

import java.util.ArrayList;

/**
 * @verison 1.5 finalna verzia
 */

/**
 * @author Ján Drugda
 */

/**
 * Generuje Level2
 */

public class Level2 implements Level {
    private Votrelec votrelec;

    private ArrayList<Nepriatel> nepriatelia;

    private Generator generator;

    /**
     * Konštruktor triedy Level2, inicializujú sa tu základné hodnoty
     */

    public Level2() {
        this.nepriatelia = new ArrayList<>();
        this.generator = new GeneratorVotrelcov();
    }

    /**
     * Poskytuje list nepriateľov
     * @return vrati list nepriatelov
     */

    public ArrayList<Nepriatel> getNepriatelia() {
        return this.nepriatelia;
    }

    /**
     * Generuje nepriateľov pre level2
     */

    @Override
    public void generujNepriatelov() {
        this.generator.generuj(this.votrelec, this.nepriatelia);
    }

    /**
     * Vymaže nepriateľa z listu
     * @param nepriatel vymaze ho z listu
     */

    @Override
    public void vymazNepriatela(Nepriatel nepriatel) {
        this.nepriatelia.remove(nepriatel);
    }

    /**
     * Zavolá sa metódá, keď budú votrelci strieľať v leveli
     */

    public void strielaj() {
        int randomCislo = RandomCislo.vratRandomCisloMedzi(this.nepriatelia.size());
        if (this.nepriatelia.get(randomCislo) instanceof Votrelec nepriatel) {
            nepriatel.strelaj();
        }
    }

    /**
     * Vykoná sa každých 50ms
     * Pohybuje hraca doprava alebo dolava
     */

    public void tikNepriatela() {
        for (int i = 0; i < this.nepriatelia.size(); i++) {
            if (this.nepriatelia.get(i).getDoPrava()) {
                this.nepriatelia.get(i).posunDoPrava();
            } else {
                this.nepriatelia.get(i).posunDoLava();
            }
        }
    }

    /**
     * Vykoná sa každých 750ms
     * Ked nie je list nepraitelov prazdny, tak nepraitel vystreli
     */

    public void tikVystrelu() {
        if (!this.nepriatelia.isEmpty()) {
            this.strielaj();
        }
    }
}
