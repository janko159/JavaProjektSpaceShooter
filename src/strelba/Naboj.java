package strelba;

import fri.shapesge.Obrazok;

/**
 * @version 1.5 finálna verzia
 */

/**
 * @author Ján Drugda
 */

/**
 * Základná jednotka streľby, nachádzajú sa tu nejaké základné informácie o naboju
 */

public class Naboj {
    private Obrazok obrazok;

    private int x;
    private int y;

    private int sirka;
    private int vyska;

    private boolean jeMimoDosah;

    /**
     * Konštruktor triedy Náboj. Nastavujú sa tu základné hodnoty
     * @param x vytvorí naboj na tejto súradnici
     * @param y vytvorí náboj na tejto súradnici
     */

    public Naboj(int x, int y) {
        this.obrazok = new Obrazok("Strela.png", x, y);
        this.x = x;
        this.y = y;

        this.sirka = 16;
        this.vyska = 16;

        this.jeMimoDosah = false;
        this.zobraz();
    }

    /**
     * Konštruktor triedy Náboj, navyše sa tu dá nastaviť aj obrázok náboja
     * @param x vytvorí naboj na tejto súradnici
     * @param y vytvorí náboj na tejto súradnici
     * @param obrazok poskytne obrázok náboju
     */

    public Naboj(int x, int y, Obrazok obrazok) {
        this.obrazok = obrazok;
        this.x = x;
        this.y = y;

        this.sirka = 16;
        this.vyska = 16;

        this.jeMimoDosah = false;
        this.zobraz();
    }

    /**
     * @return Poskytne súradnicu X
     */

    public int getX() {
        return this.x;
    }

    /**
     * @return Poskytne súradnicu Y
     */

    public int getY() {
        return this.y;
    }

    /**
     * @return Poskytne šírku
     */

    public int getSirka() {
        return this.sirka;
    }

    /**
     * @return Poskytne výšku
     */

    public int getVyska() {
        return this.vyska;
    }

    /**
     * Nastaví X na dané súradnice podľa parametra
     * @param x podla neho nastaví x náboju
     */

    public void setX(int x) {
        this.x = x;
    }

    /**
     * Nastaví Y na dané súradnice podľa parametra
     * @param y podľa neho nastaví y náboju
     */

    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return Poskytne informáciu o tom či je náboj mimo dosahu
     */

    public boolean isJeMimoDosah() {
        return this.jeMimoDosah;
    }

    /**
     * Nastaví jeMimoDosah na hodnotu true
     */

    public void setJeMimoDosah() {
        this.jeMimoDosah = true;
        this.skry();
    }

    /**
     * Presunie Obrázok na súradnice, ktoré mu poskytneme
     * @param x poskytne nove x, kde sa má presunúť
     * @param y poskytne nove y, kde sa má presunúť
     */

    public void presunObrazokNa(int x, int y) {
        this.obrazok.zmenPolohu(x, y);
    }

    /**
     * Posunie náboj po y osi
     * @param y poskytne veľkosť y o koľko sa má posunúť
     */

    public void posunNaboj(int y) {
        this.y += y;
        this.presunObrazokNa(this.x, this.y);
    }

    /**
     * Zobrazí obrázok náboja
     */

    public void zobraz() {
        this.obrazok.zobraz();
    }

    /**
     * Skryje obrázok náboja
     */

    public void skry() {
        this.obrazok.skry();
    }
}