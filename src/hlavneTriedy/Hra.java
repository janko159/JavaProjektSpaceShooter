package hlavneTriedy;
import kolizie.KolizieSNepriatelom;
import kolizie.KolizieSHracomPrisera;
import kolizie.KoliziaHracaSNabojom;
import kolizie.Kolizie;
import fri.shapesge.Manazer;
import levely.Level1;
import levely.Level2;
import levely.Level3;
import levely.Level4;
import levely.Level;
import postavy.Hrac;
import postavy.Nepriatel;
import java.util.ArrayList;

/**
 * @version 1.1 Finalna verzia projektu
 */

/**
 * @author Ján Drugda
 */

/**
 * Hlavna trieda, v ktorej sa ovláda, spravuje väčšina vecí
 */

public class Hra {
    private Nepriatel nepriatel;
    private ArrayList<Nepriatel> nepriatelia;
    private Hrac hrac;
    private Manazer manazer;
    private Menu menu;

    private ArrayList<Level> levely;

    private ArrayList<Kolizie> kolizie;

    private Level level;

    private Kolizie kolizia;


    private int indexLevelu;

    private int pocetNepriatelov;

    private int hraZacala;

    /**
     * Konštruktor triedy hra, inicializujú sa tu premenné
     */

    public Hra() {
        this.menu = new Menu();
        this.manazer = new Manazer();
        this.hrac = new Hrac();
        this.hrac.skry();

        this.spravujObjekty();


        this.nepriatelia = new ArrayList<>();
        this.levely = new ArrayList<>();

        this.kolizie = new ArrayList<>();

        this.nacitajLevely();

        this.indexLevelu = 0;
    }

    /**
     * Na zadaných súradniciach sa vykoná klik, čiže táto metóda sníma, kde klikáme
     * @param x prvá súradnica kliknutia
     * @param y druhá súradnica kliknutia
     */

    public void vyberSuradnice(int x, int y) {
        this.hraZacala = this.menu.vyberSuradnice(x, y);
        if (this.hraZacala == 1) {
            this.hrac.zobraz();
            this.hrac.zobrazZivoty();
            this.spustiLevel(this.indexLevelu);
        }
    }

    /**
     * Volá sa tu detekcia kolízii, podľa toho ktorá je práve skrytá v kolízii, využíva sa tu polymorfizmus
     * @param kolizia je to premená, ktorá v sebe skrýva rôzne detekcie kolízií
     */

    public void detekujKolizie(Kolizie kolizia) {
        kolizia.detekujKolizie(this.nepriatelia, this.hrac);
        if (this.hrac.getZivoty() <= 0) {
            this.manazer.prestanSpravovatObjekt(this.hrac);
            System.exit(0);
        }

    }

    /**
     * Na základe vstupného parametra sa spustí aktuálny level, ktorý je na rade
     * @param index podľa veľkosti sa spúšťa daný level
     */

    public void spustiLevel(int index) {
        this.levely.get(index).generujNepriatelov();
        if (this.levely.get(index) instanceof Level1 level1) {
            this.manazer.spravujObjekt(level1);
            this.nepriatelia = level1.getNepriatelia();
        } else if (this.levely.get(index) instanceof  Level2 level2) {
            this.manazer.spravujObjekt(level2);
            this.nepriatelia = level2.getNepriatelia();
        } else if ( this.levely.get(index) instanceof  Level3 level3) {
            this.manazer.spravujObjekt(level3);
            this.nepriatelia = level3.getNepriatelia();
        } else if (this.levely.get(index) instanceof  Level4 level4) {
            this.manazer.spravujObjekt(level4);
            this.nepriatelia = level4.getNepriatelia();
            System.out.println("prvy nepriatel " + this.nepriatelia.getFirst());
        }
    }

    /**
     * Tu sa pridávajú všetky levely do ArrayListu
     */

    public void nacitajLevely () {
        this.level = new Level1();
        this.levely.add(this.level);
        this.level = new Level2();
        this.levely.add(this.level);
        this.level = new Level3();
        this.levely.add(this.level);
        this.level = new Level4();
        this.levely.add(this.level);
    }

    /**
     * Manažer tu začína spravovat objekty
     */

    public void spravujObjekty() {
        this.manazer.spravujObjekt(this);
        this.manazer.spravujObjekt(this.menu);
        this.manazer.spravujObjekt(this.hrac);
    }

    /**
     * Po stačení Esc sa hra vypne
     */

    public void vypniHru() {
        System.exit(0);
    }

    /**
     * Vykoná sa každých 100ms
     * Ked hrac nema prazdny zasobnik tak detekuje koliziu s nepratelmi
     */

    public void tik() {
        if (!this.hrac.getZbran().getZasobnik().get().isEmpty()) {
            this.detekujKolizie(new KolizieSNepriatelom());
        }
    }

    /**
     * Vykoná sa každých 100ms
     * Keď hra začala, tak sa detekuje ci uz nie su vsetci nepriatelia zabitý
     */

    public void tikKolizieHracaSPriserou () {
        if (this.hraZacala == 1) {
            if (!this.nepriatelia.isEmpty()) {
                this.detekujKolizie(new KolizieSHracomPrisera());
            } else if (this.nepriatelia.isEmpty() && this.indexLevelu < this.levely.size()) {
                if (this.indexLevelu == this.levely.size() - 1) {
                    return;
                }
                this.indexLevelu++;
                this.spustiLevel(this.indexLevelu);
            }
        }
    }

    /**
     * Vykoná sa každých 50ms
     * Ked sú nejaký nepriatelia, tak sa detekuje či sa nezrazili s nabojom
     */

    public void tikKolizii () {
        if (!this.nepriatelia.isEmpty()) {
            this.detekujKolizie(new KoliziaHracaSNabojom());
        }
    }

    /**
     * Vykoná sa každých 3000ms
     * Zobrazí hráča, ked ho boss trafí
     */

    public void ozivHraca () {
        this.hrac.setHracZasiahnuty(false);
        this.hrac.zobraz();
    }
}
