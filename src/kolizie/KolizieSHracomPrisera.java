package kolizie;

import postavy.Boss;
import postavy.Hrac;
import postavy.Nepriatel;
import statickeTriedy.Skore;

import java.util.ArrayList;

/**
 * @version 1.5 finalna verzia
 */

/**
 * @author Ján Drugda
 */

/**
 * Implementuje Interface Kolizie
 */

public class KolizieSHracomPrisera implements Kolizie {

    /**
     * Detekuje kolízie medzi príšerou a hráčom, keď nastane kolízia tak sa uberie život hráčovi
     * @param nepriatelia prechadza cez tento list
     * @param hrac pouziva hráča na detekciu jeho polohy
     */

    @Override
    public void detekujKolizie(ArrayList<Nepriatel> nepriatelia, Hrac hrac) {
        for (int i = 0; i < nepriatelia.size(); i++) {
            boolean kolizia = KoliziaObjektov.kolizia(hrac.getX(),
                    hrac.getY(), hrac.getSirka(), hrac.getVyska(),
                    nepriatelia.get(i).getX(), nepriatelia.get(i).getY(),
                    nepriatelia.get(i).getSirka(), nepriatelia.get(i).getVyska());

            if (kolizia) {
                if (nepriatelia.get(i) instanceof Boss boss) {
                    hrac.skry();
                    if (!hrac.isHracZasiahnuty()) {
                        hrac.uberZivoty(1);
                    }
                    hrac.setHracZasiahnuty(true);
                    Skore.odcitajSkotePoStateZivota();
                    break;
                }
                nepriatelia.get(i).skry();
                nepriatelia.remove(i);
                hrac.uberZivoty(1);
                Skore.odcitajSkotePoStateZivota();
                break;
            }
        }
    }
}
