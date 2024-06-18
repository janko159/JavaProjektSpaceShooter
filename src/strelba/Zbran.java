package strelba;

/**
 * @version 1.5 finálna verzia
 */

/**
 * @author Ján Drugda
 */

/**
 * Interface Zbran, definujú sa tú metódy interface
 */

public interface Zbran {

    /**
     * Podla pozície zbrane sa bude vytvára%t náboj
     * @param x poskytne pozíciu x, kde sa má náboj vytvoriť
     * @param y poskytne pozíciu y, kde sa má náboj vytvoriť
     */

    void strel(int x, int y);

    /**
     * pohyb nábojov
     */

    void pohniNabojmi();

    /**
     * Bude sa skúmať, kde sa nachádza náboj na ploche
     * @param index bude volať náboje zo zásobníku a tak prejdeme všetkými nábojmi
     */

    void detekciaPozicieNabojov(int index);
}
