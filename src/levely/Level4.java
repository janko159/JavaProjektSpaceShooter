package levely;

import fri.shapesge.Manazer;
import postavy.Boss;
import postavy.Nepriatel;

import java.util.ArrayList;

/**
 * @version 1.5 finalna verzia
 */

/**
 * @author Ján Drugda
 */

/**
 * Generuje Level4
 */

public class Level4 implements Level {

    private Manazer manazer;

    private ArrayList<Nepriatel> nepriatelia;

    private Boss boss;

    /**
     * Konštruktor triedy Level4, inicializujú sa tu základné hodnoty
     */

    public Level4() {
        this.nepriatelia = new ArrayList<>();
        this.manazer = new Manazer();
    }

    /**
     * @return poskytuje list nepriatelov
     */

    public ArrayList<Nepriatel> getNepriatelia() {
        return this.nepriatelia;
    }

    /**
     * Generuje nepriateľov pre level4
     */

    @Override
    public void generujNepriatelov() {
        this.boss = new Boss(10);
        this.manazer.spravujObjekt(this.boss);
        this.nepriatelia.add(this.boss);
    }

    /**
     * @param nepriatel Vymaže nepriateľa z listu
     */

    @Override
    public void vymazNepriatela(Nepriatel nepriatel) {
        this.nepriatelia.remove(nepriatel);
    }

}
