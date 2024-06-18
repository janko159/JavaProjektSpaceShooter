package levely;

import postavy.Nepriatel;
import postavy.Prisera;
import postavy.Votrelec;
import statickeTriedy.RandomCislo;

import java.util.ArrayList;

/**
 * @version 1.5 finlana verzia
 */

/**
 * @author Ján Drugda
 */

/**
 * Generuje Level3
 */

public class Level3 implements Level {
    private Votrelec votrelec;
    private Prisera prisera;

    private ArrayList<Nepriatel> nepriatelia;

    private Generator generator;

    /**
     * Konštruktor triedy Level3, inicializujú sa tu základné hodnoty
     */

    public Level3() {
        this.nepriatelia = new ArrayList<>();
        this.generator = new GeneratorMix();
    }

    /**
     * Poskytuje list nepriateľov
     * @return vráti list nepriatelov
     */

    public ArrayList<Nepriatel> getNepriatelia() {
        return this.nepriatelia;
    }

    /**
     * Generuje nepriateľov pre level3
     */

    @Override
    public void generujNepriatelov() {
        this.generator.generuj(this.votrelec, this.prisera, this.nepriatelia);
    }

    /**
     * Vymaže nepriateľa z listu
     * @param nepriatel vymaze ho z listu nepriatelia
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
     * Pohybuje nepraitelov doprava alebo dolava
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
     * Kontroluje či nie je list nepriatelov prazdny
     * Vykonava strelbu votrelcov
     */

    public void tikVystrelu() {
        if (!this.nepriatelia.isEmpty()) {
            for (int i = 0; i < this.nepriatelia.size(); i++) {
                if (this.nepriatelia.get(i) instanceof Votrelec) {
                    this.strielaj();
                }
            }
        }
    }
}
