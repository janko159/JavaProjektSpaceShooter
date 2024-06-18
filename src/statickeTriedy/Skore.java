package statickeTriedy;

/**
 * @version 1.5 finálna verzia
 */

/**
 * @author Ján Drugda
 *
 * Statická trieda, ktorá informuje o skóre alebo ho mení
 */

public class Skore {
    private static int skore;

    /**
     * Inicializuje sa tu základná hodnota skóre
     */

    public Skore() {
        skore = 0;
    }

    /**
     * Poskytne hodnotu skóre
     * @return vráti skóre
     */

    public static int getSkore() {
        return skore;
    }

    /**
     * Zvýši skóre o 25
     */

    public static void setSkoreZabitim() {
        skore += 50;
    }

    /**
     * Zvýši skóre o 250 po zabití bossa
     */

    public static void zabitieBossa() {
        skore += 250;
    }

    /**
     * Odčíta skóre o 5
     */

    public static void odcitajSkore() {
        skore -= 5;
    }

    /**
     * Odčíta skóre 50 keď hráč stratí život
     */

    public static void odcitajSkotePoStateZivota() {
        skore -= 150;
    }

}
