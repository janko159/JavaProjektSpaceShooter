package postavy;
import fri.shapesge.Manazer;
import fri.shapesge.Obrazok;
import statickeTriedy.Skore;
import strelba.Zbran;
import strelba.ZbranHrac;

import javax.swing.JOptionPane;
import java.util.ArrayList;


/**
 * @version 1.5 finálna verzia
 */

/**
 * @author Ján Drugda
 */

/**
 * Trieda, ktorá spravuje hráča, robí jeho základné úkony a poskytuje informácie o ňom
 */

public class Hrac extends Postava {

    private Manazer manazer;
    private Zbran zbranHrac;

    private Obrazok obrazok;

    private ArrayList<Obrazok> zivotyObrazky;
    private boolean hracZomrel;

    private boolean hracZasiahnuty;

    /**
     * Konštruktor triedy Hrac, inicializujú sa tu základné premenné
     */

    public Hrac() {
        super(TypPostavy.HRAC, 3, 700, 680);
        this.zobraz();
        this.setSirka(80);
        this.setVyska(80);

        this.zbranHrac = new ZbranHrac();
        this.manazer = new Manazer();

        this.manazer.spravujObjekt(this.zbranHrac);

        this.zivotyObrazky = new ArrayList<>();

        this.hracZomrel = false;
        this.hracZasiahnuty = false;
    }

    /**
     * Poskytuje informáciu o tom, či bol hráč niečím zasiahnutý
     * @return poskytne informáciu o tom či je hráč zasiahnuty
     */

    public boolean isHracZasiahnuty() {
        return this.hracZasiahnuty;
    }

    /**
     * Zadáva do premennej informáciu o tom či bol hráč zasiahnutý
     * @param zasiahnuty informácia či je hráč zasiahnuty
     */

    public void setHracZasiahnuty(boolean zasiahnuty) {
        this.hracZasiahnuty = zasiahnuty;
    }

    /**
     * Poskytuje zbraň hráča
     * @return poskytne zbran hráča
     */

    public ZbranHrac getZbran() {
        return (ZbranHrac)this.zbranHrac;
    }

    /**
     * Posúva hráča vľavo po x súradnici
     */

    public void posunVlavo() {
        this.zmenX(-15);
        this.presunObrazokNa(this.getX(), this.getY());
    }

    /**
     * Posúva hráča vpravo po x súradnici
     */

    public void posunVpravo() {
        this.zmenX(15);
        this.presunObrazokNa(this.getX(), this.getY());
    }

    /**
     * Prejde cez všetky životy a zobrazí ich
     */

    public void zobrazZivoty() {
        for (int i = 0; i < this.getZivoty(); i++) {
            this.obrazok = new Obrazok("Srdce.png", 1300 + (i * 40), 700);
            this.obrazok.zobraz();
            this.zivotyObrazky.add(this.obrazok);
        }
    }

    /**
     * Vystrelí náboj a spawne ho na pozícii hráča
     */

    public void vystrel() {
        this.zbranHrac.strel(this.getX() + (this.getSirka() / 2), this.getY());
    }

    /**
     * Uberie jeden život hráčovi, keď už nemá životy, tak sa vypíše koncová správa
     * @param zivoty odčíta sa počet životov podla počtu tejto premennej
     */

    @Override
    public void uberZivoty(int zivoty) {
        if (!this.hracZomrel) {
            this.zivotyObrazky.getLast().skry();
            this.zivotyObrazky.removeLast();
            this.setZivoty(-zivoty);
            if (this.getZivoty() <= 0) {
                JOptionPane.showMessageDialog(null, "Prehral si! Tvoje skore je " + Skore.getSkore());
                this.skry();
                this.hracZomrel = true;
            }
        }
    }
}
