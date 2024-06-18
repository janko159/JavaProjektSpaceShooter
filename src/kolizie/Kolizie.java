package kolizie;

import postavy.Hrac;
import postavy.Nepriatel;

import java.util.ArrayList;

/**
 * @version 1.5 finálna verzia
 */

/**
 * @author Ján Drugda
 */

/**
 * Interface pre Kolízie, určujú sa tu metódy
 */

public interface Kolizie {
    /**
     * Budú sa tu detekovat kolizie v hre
     * @param nepriatelia bude sa poskytovat list nepraitelov
     * @param hrac podla potreby sa bude poskytovat poloha hraca alebo poyicia jeho nabojov
     */
    void detekujKolizie(ArrayList<Nepriatel> nepriatelia, Hrac hrac);
}
