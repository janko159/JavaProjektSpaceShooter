package postavy;

import fri.shapesge.Manazer;
import statickeTriedy.Skore;
import strelba.Zbran;
import strelba.ZbranVotrelec;

/**
 * version 1.5 finálna verzia
 */

/**
 * @author Ján Drugda
 */

/**
 * Trieda, ktorá dedí od Nepriateľa, upravuje to ako sa má správať votrelec
 */

public class Votrelec extends Nepriatel {

    private Manazer manazer;
    private Zbran zbran;

    /**
     * Konštruktor triedy Votrelec, inicializujú sa tu základné hodnoty
     * @param x nastaví x súradnicu votrelcovi
     * @param y nastaví y spradnicu votrelcovi
     */

    public Votrelec(int x, int y) {
        super(TypPostavy.VOTRELEC, 1, x, y);
        this.zobraz();
        this.setSirka(95);
        this.setVyska(90);

        this.manazer = new Manazer();
        this.zbran = new ZbranVotrelec();
        this.manazer.spravujObjekt(this.zbran);
    }

    /**
     * @return poskytne zbran, ktorú má votrelec
     */

    public ZbranVotrelec getZbran() {
        return  (ZbranVotrelec)this.zbran;
    }

    /**
     * Metóda, pomocou ktorej sa vytvori (vystrelí) náboj
     */

    public void strelaj() {
        this.zbran.strel(this.getX() + (this.getSirka() / 2), this.getY() + (this.getVyska() / 2));
    }

    /**
     * Posunú sa y-nove súradnice Votrelca, keď sú väčšie ako 680 tak sa Votrelec skryje
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
     * Posúva Votrelca do prava, číže mu zväčšuje X súradnice
     */

    @Override
    public void posunDoPrava() {
        super.posunDoPrava();
        if (this.getX() >= 1300 - this.getSirka()) {
            this.zmenSmer();
            this.posunDole();
            Skore.odcitajSkore();
        }
    }

    /**
     * Posúva Votrelca do ľava, čiže mu zmenšuje X súradnice
     */

    @Override
    public void posunDoLava() {
        super.posunDoLava();
        if (this.getX() <= 200) {
            this.zmenSmer();
            this.posunDole();
            Skore.odcitajSkore();
        }
    }

}
