package levely;

import postavy.Nepriatel;
import postavy.Prisera;

import java.util.ArrayList;

/**
 * @version 1.5 finalna verzia
 */

/**
 * @author Ján Drugda
 */

/**
 * Generuje Level1
 */

public class Level1 implements Level {
    private Prisera prisera;

    private ArrayList<Nepriatel> nepriatelia;

    private Generator generator;

    /**
     * Konštruktor triedy Level1, inicializujú sa tu základné hodnoty
     */

    public Level1() {
        this.nepriatelia = new ArrayList<>();
        this.generator = new GeneratorPriser();
    }

    /**
     * Poskytuje list nepriateľov
     */

    public ArrayList<Nepriatel> getNepriatelia() {
        return this.nepriatelia;
    }

    /**
     * Generuje nepriateľov pre level2
     */

    @Override
    public void generujNepriatelov() {
        this.generator.generuj(this.prisera, this.nepriatelia);
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
     * Vykoná sa každých 50ms
     * pohybuje nepriatelov doprava alebo dolava
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
}
