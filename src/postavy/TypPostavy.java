package postavy;

/**
 * @version 1.5 finálna verzia
 */

/**
 * @author Ján Drugda
 */


/**
 * Enum, v ktorom sa rozhoduje o obrázku postavy
 */
public enum TypPostavy {

    HRAC("hrac.png"),
    PRISERA("Prisera.png"),
    VOTRELEC("Votrelec.png"),

    BOSS("Fly/0.png");

    private String cesta;

    TypPostavy(String cesta) {
        this.cesta = cesta;
    }

    /**
     * @return poskytne cestu k obrázku
     */

    public String getCesta() {
        return this.cesta;
    }
}
