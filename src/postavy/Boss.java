package postavy;

import fri.shapesge.Obrazok;

import java.util.ArrayList;

/**
 * @version 1.5 finalna verzia
 */

/**
 * @author Ján Drugda
 */

/**
 * Dedí z triedy nepriateľ, určuje vlastnosti Bossa, framy, pohyb
 */

public class Boss extends Nepriatel {
    private Obrazok obrazok;

    private int pocitadlo;

    private ArrayList<Obrazok> obrazkyLietania;

    private boolean setSmerVertikal;

    private boolean somDole;

    private boolean doPrava;

    /**
     * Konštruktor triedy Boss, inicializujú sa tu základné hodnoty
     * @param zivoty udáva počet životov bossa
     */

    public Boss(int zivoty) {
        super(TypPostavy.BOSS, zivoty, 500, 50);
        this.obrazkyLietania = new ArrayList<>();

        this.nacitajObrazkyLietanie();

        this.setSirka(534);
        this.setVyska(419);

        this.zmenX(-this.getSirka());

        this.somDole = false;
        this.setSmerVertikal = false;
        this.doPrava = true;
    }

    /**
     * Zvýši hodnotu počítadla o 1
     */

    public void pripocitaj() {
        this.pocitadlo++;
    }

    /**
     * Skryje všetky snímky
     */

    public void skryAnimaciu() {
        for (int i = 0; i < 8; i++) {
            this.obrazkyLietania.get(i).skry();
        }
    }

    /**
     * Vracia Bossa spať hore na Y súradnice
     */

    public void pohybujSaHore() {
        this.zmenY(-20);
        for (Obrazok obraz : this.obrazkyLietania) {

            obraz.posunZvisle(-30);
            if (this.getY() <= 0) {
                this.somDole = false;
            }
        }
    }

    /**
     * Načíta obrázky do listu
     */

    public void nacitajObrazkyLietanie() {
        for (int i = 0; i < 8; i++) {
            this.obrazok = new Obrazok("Fly/" + i + ".png");
            this.obrazkyLietania.add(this.obrazok);
        }
    }

    /**
     * Zobrazuje aktuálny obrazok bossa a skrýva ten predchádzajúci
     * @param frame poskytuje aktualny snímok obrazovky, ktorí sa má zobraziť
     */

    public void lietanieAnimacia(int frame) {
        this.obrazkyLietania.get(frame).zobraz();
        if (frame == 0) {
            this.obrazkyLietania.get(7).skry();
        }
        if (frame != 0) {
            this.obrazkyLietania.get(frame - 1).skry();
        }
    }

    /**
     * Posunie bossa dole po Y súradniciach
     */

    @Override
    public void posunDole() {
        this.zmenY(20);
        for (Obrazok obraz : this.obrazkyLietania) {
            obraz.posunZvisle(30);
            if (this.getY() >= 300) {
                this.setSmerVertikal = false;
                this.somDole = true;
            }
        }
    }

    /**
     * Posunie bossa doprava po X súradniciach
     */

    @Override
    public void posunDoPrava() {
        super.posunDoPrava();
        for (Obrazok obraz : this.obrazkyLietania) {
            obraz.posunVodorovne(10);
            if (this.getX() >= 1500 - this.getSirka()) {
                this.doPrava = false;
            }
        }
    }

    /**
     * Posunie bossa doľava po X súradniciach
     */

    @Override
    public void posunDoLava() {
        super.posunDoLava();
        for (Obrazok obraz : this.obrazkyLietania) {
            obraz.posunVodorovne(-10);
            if (this.getX() <= this.getSirka() - 500) {
                this.doPrava = true;
            }
        }
    }

    /**
     * Zavolá sa každých 75ms kontroluje sa tu pobyb Bossa
     */

    public void tikAnimacie() {
        this.pripocitaj();
        if (this.pocitadlo < 8 && this.pocitadlo >= 0) {
            this.lietanieAnimacia(this.pocitadlo);
        } else if (this.pocitadlo >= 8) {
            this.pocitadlo = -1;
        }
        if (this.setSmerVertikal) {
            this.posunDole();
        } else if (this.somDole) {
            this.pohybujSaHore();
        } else {
            if (this.doPrava) {
                this.posunDoPrava();
            } else {
                this.posunDoLava();
            }
        }
    }

    /**
     * Zavolá sa každých 5s
     */

    public void utok() {
        this.setSmerVertikal = !this.setSmerVertikal;
    }
}
