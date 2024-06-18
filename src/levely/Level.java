package levely;

import postavy.Nepriatel;

/**
 * @author Ján Drugda
 */

/**
 * Interface pre Levely, určujú sa tu metódy
 */

public interface Level {

    /**
     * Budu sa tu generovat nepriatelia podla levelu
     */

    void generujNepriatelov();

    /**
     * Vymaze nepriatelia z levelu
     * @param nepriatel vymaze sa z listu
     */

    void vymazNepriatela(Nepriatel nepriatel);

}
