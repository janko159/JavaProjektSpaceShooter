package strelba;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @version 1.5 finálna verzia
 */

/**
 * @author Ján Drugda
 */


/**
 * Trieda, ktorá implementuje interface Zbran.
 * V tejto triede sa rieši a riadi streľba pre Hráča
 */

public class ZbranHrac implements Zbran {
    private Naboj naboj;
    private ArrayList<Naboj> zasobnik;

    /**
     * Konštruktor triedy ZbranHrac, inicializuje sa tu ArrayList
     */

    public ZbranHrac() {
        this.zasobnik = new ArrayList<>();

    }

    /**
     * @return Poskytuje list zasobnika s nábojmi
     */

    public Optional<ArrayList<Naboj>> getZasobnik() {
        return Optional.ofNullable(this.zasobnik);
    }

    /**
     * Kotroluje sa, či je zásobník prázdny
     * @return vráti true alebo false, podľa stavu zásobníku
     */

    public boolean kontrolujZasobnik() {
        if (this.zasobnik.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * Vykonáva sa každých 22ms
     */

    public void tikPohybuStrielHraca() {
        this.pohniNabojmi();
    }

    /**
     * Vytvorí náboj na pozícii hráča, náboj sa následne prida do listu
     * @param x vytvorí sa náboj na tejto súradnici
     * @param y vytvorí sa náboj na tejto súradnici
     */

    @Override
    public void strel(int x, int y) {
        if (this.kontrolujZasobnik()) {
            this.naboj = new Naboj(x, y);
            this.naboj.presunObrazokNa(x - (this.naboj.getSirka() / 2), y - this.naboj.getSirka());
            this.naboj.setX(x - (this.naboj.getSirka() / 2));
            this.naboj.setY(y - this.naboj.getSirka());
            this.zasobnik.add(this.naboj);
        }
    }

    /**
     * Prejde cez celý list a posunie náboje
     */

    @Override
    public void pohniNabojmi() {
        if (this.getZasobnik().isPresent()) {
            for (int i = 0; i < this.zasobnik.size(); i++) {
                this.zasobnik.get(i).posunNaboj(-10);
                this.detekciaPozicieNabojov(i);
            }
        }
    }

    /**
     * Kontroluje, či náboj nie je mimo plochy. Ak áno tak ho skryje
     * @param index podľa indexu prejdeme cez list a budeme detekovat y súradnicu náboja
     */

    @Override
    public void detekciaPozicieNabojov(int index) {
        if (this.zasobnik.get(index).getY() < 0) {
            this.naboj = this.zasobnik.get(index);
            this.zasobnik.remove(this.naboj);
            this.naboj.skry();
        }
    }
}
