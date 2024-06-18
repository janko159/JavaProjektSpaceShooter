package kolizie;

/**
 * @version 1.5 finálna verzia
 */

/**
 * @author Ján Drugda
 */

/**
 * Je tu metóda ktorá detekuje kolízie
 */
public class KoliziaObjektov {

    /**
     * Metóda vráti true alebo false
     * Na základe porovnávania vstupných parametrov
     * Metóda porovnáva súradnice 2 rôznych objektov
     * Metóda na základe pozície a rozmeru objetu zistije či sa z niektorej strany objekty prekrývajú
     * Ak áno vráti true
     * @param prvyObjektX poskytuje suradnicu x prveho kolízneho objektu
     * @param prvyObjektY poskytuje suradnicu y prveho kolízneho objektu
     * @param prvyObjektSirka poskytuje šírku prveho kolízneho objektu
     * @param prvyObjektVyska poskytuje výšku prveho kolízneho objektu
     * @param druhyObjektX poskytuje x druheho kolizneho objektu
     * @param druhyObjektY poskytuje y druheho kolizneho objektu
     * @param druhyObjektSirka poskytuje šírku druheho kolízneho objektu
     * @param druhyObjektVyska poskytuje výšku druheho kolízneho objektu
     * @return vráti true alebo false, podľa toho či došlo ku kolizii
     */

    public static boolean kolizia (int prvyObjektX, int prvyObjektY, int prvyObjektSirka, int prvyObjektVyska,
        int druhyObjektX, int druhyObjektY, int druhyObjektSirka, int druhyObjektVyska) {
        return prvyObjektX < druhyObjektX + druhyObjektSirka && prvyObjektX + prvyObjektSirka > druhyObjektX &&
                prvyObjektY < druhyObjektY + druhyObjektVyska && prvyObjektY + prvyObjektVyska > druhyObjektY;
    }

}
