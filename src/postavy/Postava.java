package postavy;

import fri.shapesge.Obrazok;

/**
 * @version 1.5 finálna verzia
 */

/**
 * @author Ján Drugda
 */

/**
 * Abstraktná trieda Postava, z nej dedí mnoho ďalších tried.
 * Nastavujú sa tu zákaldné gettery a settery pre všetky postavi v hre
 */

public abstract class Postava {
    private int x;
    private int y;

    private int sirka;

    private int vyska;

    private int zivoty;

    private Obrazok obrazok;

    private TypPostavy typPostavy;

    /**
     * Konštruktor triedy Postava, inicializujú sa tu zákaldné hodnoty do premenných
     * @param typPostavy zadáva typ postavy
     * @param zivoty nastavuje počet zivotov
     * @param x nastavuje x súradnicu
     * @param y nastavuje y súradnicu
     */

    public Postava(TypPostavy typPostavy, int zivoty, int x, int y) {
        this.typPostavy = typPostavy;
        this.x = x;
        this.y = y;
        this.zivoty = zivoty;
        this.nastavObrazok();
    }

    /**
     * @return Poskytuje šírku
     */

    public int getSirka() {
        return this.sirka;
    }

    /**
     * @return Poskytuje výšku
     */

    public int getVyska() {
        return this.vyska;
    }

    /**
     * @return Poskytuje životy
     */

    public int getZivoty() {
        return this.zivoty;
    }

    /**
     * @return Poskytuje X
     */

    public int getX() {
        return this.x;
    }

    /**
     * @return Poskytuje Y
     */

    public int getY() {
        return this.y;
    }

    /**
     * Zmení X podľa hodnoty
     * @param x nastaví sa x
     */

    public void zmenX(int x) {
        this.x += x;
    }

    /**
     * Zmení Y podľa hodnoty
     * @param y nastaví sa y
     */

    public void zmenY(int y) {
        this.y += y;
    }

    /**
     * Nastaví šírku podľa hodnoty
     * @param cislo nastaví šírku podľa čísla
     */

    public void setSirka(int cislo) {
        this.sirka = cislo;
    }

    /**
     * Nastaví výšku podľa hodnoty
     * @param cislo nastaví výšku podľa čísla
     */

    public void setVyska(int cislo) {
        this.vyska = cislo;
    }

    /**
     * Nastaví životy podľa hodnoty
     * @param cislo nastaví zivoty podľa čísla
     */

    public void setZivoty(int cislo) {
        this.zivoty += cislo;
    }

    /**
     * Odčíta život
     * @param zivoty odčíta životy
     */

    public void uberZivoty(int zivoty) {
        this.setZivoty(-zivoty);
        if (this.getZivoty() <= 0) {
            this.skry();
        }
    }

    /**
     * Vytvorí obrázok na dané súradnice
     */

    private void nastavObrazok() {
        this.obrazok = new Obrazok(this.typPostavy.getCesta(), this.getX(), this.getY());
    }

    /**
     * Presunie obrázok na dané súradnice
     * @param x na tejto súradnici vytvorí obrázok
     * @param y na tejto súrdnici  vytvorí obrázok
     */

    public void presunObrazokNa(int x, int y) {
        this.obrazok.zmenPolohu(x, y);
    }

    /**
     * Zobrazí obrázok
     */

    public void zobraz() {
        this.obrazok.zobraz();
    }

    /**
     * Skryje obrázok
     */

    public void skry() {
        this.obrazok.skry();
    }
}
