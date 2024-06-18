package postavy;

import statickeTriedy.Skore;

/**
 * @version 1.5 finálna verzia
 */

/**
 * @author Ján Drugda
 */

/**
 * Trieda, ktorá dedí od nepriateľa, a upravuje vlastnosti Príšery
 */

public class Prisera extends Nepriatel {

    /**
     * Konštruktor triedy Príšera, inicializujú sa tu základné hodnoty
     * @param x nastaví x súradnicu príšeri
     * @param y nastaví y súradnicu príšeri
     */

    public Prisera(int x, int y) {
        super(TypPostavy.PRISERA, 2, x, y);
        this.zobraz();
        this.setSirka(102);
        this.setVyska(75);
    }

    /**
     * Posunie dole príšeru po y súradnici
     */

    @Override
    public void posunDole() {
        this.zmenY(75);
        this.presunObrazokNa(this.getX(), this.getY());
        if (this.getY() > 680) {
            this.skry();
        }
    }

    /**
     * Posunie príšeru do prava, keď je súradnica viacej 1500, tak sa začne posúvať do ľava
     */

    @Override
    public void posunDoPrava() {
        super.posunDoPrava();
        if (this.getX() >= 1500 - this.getSirka()) {
            this.zmenSmer();
            this.posunDole();
            Skore.odcitajSkore();
        }
    }

    /**
     * Posunie príšeru do ľava, keď je súradnica menej ako 0, tak sa začne posúvať do prava
     */

    @Override
    public void posunDoLava() {
        super.posunDoLava();
        if (this.getX() <= 0) {
            this.zmenSmer();
            this.posunDole();
            Skore.odcitajSkore();
        }
    }
}
