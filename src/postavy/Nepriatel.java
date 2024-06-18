package postavy;

/**
 * @version 1.5 finálna verzia
 */

/**
 * @author Ján Drugda
 */

/**
 * Trieda, ktorá dedí z Postavy, určuje metódy, ktoré budú mať nepriatelia
 */

public class Nepriatel extends Postava {
    private boolean doPrava;

    /**
     * Konštruktor triedy Nepriatel, inicializujú sa tu základné premenné
     * @param typPostavy poskytuje obrázok pre nepriatela
     * @param zivoty zadáva počet životov nepriateľovi
     * @param x poskytuje súradnicu x nepraiteľovi, kde sa má vytvoriť
     * @param y poskytuje súradnicu y nepraiteľovi, kde sa má vytvoriť
     */

    public Nepriatel(TypPostavy typPostavy, int zivoty, int x, int y) {
        super(typPostavy, zivoty, x, y);
        this.doPrava = true;
    }

    /**
     * Poskytne informáciu, či sa má hýbať do prava
     * @return poskytuje informáciu, či sa má posúvať doprava
     */

    public boolean getDoPrava() {
        return this.doPrava;
    }

    /**
     * Zmení sa informácia o pohybe na opačnú
     */

    public void zmenSmer() {
        this.doPrava = !this.doPrava;
    }

    /**
     * Posunie dole nepriateľa
     */

    public void posunDole() {
        this.zmenY(50);
        this.presunObrazokNa(this.getX(), this.getY());
    }

    /**
     * Posunie nepriateľa do prava
     */

    public void posunDoPrava() {
        this.zmenX(10);
        this.presunObrazokNa(this.getX(), this.getY());
    }

    /**
     * Posunie nepriateľa do ľava
     */

    public void posunDoLava() {
        this.zmenX(-10);
        this.presunObrazokNa(this.getX(), this.getY());
    }
}
