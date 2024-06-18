package kolizie;

import postavy.Hrac;
import postavy.Nepriatel;
import postavy.Votrelec;
import statickeTriedy.Skore;

import java.util.ArrayList;

/**
 * @version 1.5 finálna verzia
 */

/**
 * @author Ján Drugda
 */

/**
 * Implementuje Interface Kolizie
 */

public class KoliziaHracaSNabojom implements Kolizie {

    /**
     * Detekuje kolízie Nepriateľskej strely a hráča, keď nastane kolízia tak sa uberie život hráčovi
     * @param nepriatelia je to list, cez ktorí sa prechádza
     * @param hrac z neho sa berie pozicia nábojom
     */

    @Override
    public void detekujKolizie(ArrayList<Nepriatel> nepriatelia, Hrac hrac) {
        for (int i = 0; i < nepriatelia.size(); i++) {
            if (nepriatelia.get(i) instanceof Votrelec) {
                for (int j = 0; j < ((Votrelec)nepriatelia.get(i)).getZbran().getZasobnikVotrelca().get().size(); j++) {
                    boolean kolizia = KoliziaObjektov.kolizia(hrac.getX(),
                            hrac.getY(), hrac.getSirka(), hrac.getVyska(),
                            ((Votrelec)nepriatelia.get(i)).getZbran().getZasobnikVotrelca().get().get(j).getX(),
                            ((Votrelec)nepriatelia.get(i)).getZbran().getZasobnikVotrelca().get().get(j).getY(),
                            ((Votrelec)nepriatelia.get(i)).getZbran().getZasobnikVotrelca().get().get(j).getSirka(),
                            ((Votrelec)nepriatelia.get(i)).getZbran().getZasobnikVotrelca().get().get(j).getVyska());

                    if (kolizia) {
                        ((Votrelec)nepriatelia.get(i)).getZbran().getZasobnikVotrelca().get().get(j).skry();
                        ((Votrelec)nepriatelia.get(i)).getZbran().getZasobnikVotrelca().get().remove(j);
                        hrac.uberZivoty(1);
                        Skore.odcitajSkotePoStateZivota();
                        break;
                    }
                }
            }
        }
    }
}
