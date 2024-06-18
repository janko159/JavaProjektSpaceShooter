package kolizie;

import postavy.Boss;
import postavy.Hrac;
import postavy.Nepriatel;
import statickeTriedy.Skore;

import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 * @author Ján Drugda
 */

/**
 * Implementuje Interface Kolizie
 */

public class KolizieSNepriatelom implements Kolizie {

    /**
     * Detekuje kolízie s nepriateľom, keď nastane kolízia tak sa uberie život nepriateľovi,
     * Keď už nemá nepriateľ životy, tak sa skryje a vymaže zo zoznamu
     * @param nepriatelia prechadza cez tento list nepriatelov
     * @param hrac pouziva sa z neho zbran na detekciu pozicie nabojov
     */

    @Override
    public void detekujKolizie(ArrayList<Nepriatel> nepriatelia, Hrac hrac) {
        for (int i = 0; i < nepriatelia.size(); i++) {
            boolean kolizia = KoliziaObjektov.kolizia(hrac.getZbran().getZasobnik().get().getFirst().getX(),
                    hrac.getZbran().getZasobnik().get().getFirst().getY(),
                    hrac.getZbran().getZasobnik().get().getFirst().getSirka(),
                    hrac.getZbran().getZasobnik().get().getFirst().getVyska(),
                    nepriatelia.get(i).getX(), nepriatelia.get(i).getY(),
                    nepriatelia.get(i).getSirka(), nepriatelia.get(i).getVyska());

            if (kolizia) {
                hrac.getZbran().getZasobnik().get().getFirst().skry();
                hrac.getZbran().getZasobnik().get().removeFirst();
                nepriatelia.get(i).uberZivoty(1);
                if (nepriatelia.get(i).getZivoty() <= 0) {
                    if (nepriatelia.get(i) instanceof Boss boss) {
                        boss.skryAnimaciu();
                        JOptionPane.showMessageDialog(null, "Dokazal si to!! Vyhral si! Tvoje skore je: " + Skore.getSkore());
                        System.exit(0);
                    }
                    nepriatelia.remove(i);
                    Skore.setSkoreZabitim();
                }
                break;
            }
        }
    }
}
