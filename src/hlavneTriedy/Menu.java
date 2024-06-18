package hlavneTriedy;
import fri.shapesge.Obrazok;

/**
 * @version 1.5 finaln verzia
 */

/**
 * @author Ján Drugda
 *
 * Trieda vyobrazuje menu na začiatku hry
 */

public class Menu {
    private Obrazok pozadie;
    private Obrazok playButton;

    private int skryMenu;

    /**
     * Konštruktor, vytvárajú sa tu obrázky, pre menu
     */

    public Menu() {
        this.pozadie = new Obrazok("pozadie.jpg", -250, -250);
        this.playButton = new Obrazok("playButton.png", 525, 350);

        this.zobrazMenu();
        this.skryMenu = 0;
    }

    /**
     * Detekuje súradnice kliknutia
     * @param x udáva súradnicu kliknutia po x osi
     * @param y udáva súradnicu kliknutia po y osi
     * @return skryje menu ked sa uzivatel trafi na button, alebo sa nic nestane
     */

    public int vyberSuradnice(int x, int y) {
        if (x > 525 && x < 960 && y > 350 && y < 470) {
            this.playButton.skry();
            this.skryMenu += 1;
            return this.skryMenu;
        }
        return 0;
    }

    /**
     * Zobrazí pozadie a obrázok tlačidla na ploche
     */

    public void zobrazMenu() {
        this.pozadie.zobraz();
        this.playButton.zobraz();
    }
}
