package levely;

import postavy.Nepriatel;

import java.util.ArrayList;


/**
 * @version 1.5 finalna verzia
 */

/**
 * @author Ján Drugda
 */

/**
 * Interface pre Generátory, určujú sa tu metódy
 */

public interface Generator {

    /**
     * Budú sa tu generovat nepraitelia podla levelu
     * @param typnNepriatela vygeneruje sa dany typ nepratela
     * @param nepriatelia podľa velkosti listu sa vygeneruje dane mnozstvo nepriatelov
     */
    void generuj(Nepriatel typnNepriatela, ArrayList<Nepriatel> nepriatelia);

    void generuj(Nepriatel typnNepriatela, Nepriatel druhyTyp, ArrayList<Nepriatel> nepriatelia);
}
