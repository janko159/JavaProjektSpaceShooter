package strelba;
import fri.shapesge.Obrazok;
import java.util.ArrayList;
import java.util.Optional;

/**
 * @version 1.5 finálna verzia
 */

/**
 * @author Ján Drugda
 */

/**
 * Trieda, ktorá implementuje interface Zbran.
 * V tejto triede sa rieši a riadi streľba pre Votrelcov
 */

public class ZbranVotrelec implements Zbran {
    private Naboj naboj;
    private ArrayList<Naboj> zasobnikVotrelca;

    /**
     * Konštruktor triedy, vytvara sa tu inštancia ArrayListu
     */

    public ZbranVotrelec() {
        this.zasobnikVotrelca = new ArrayList<>();
    }

    /**
     * @return Poskytuje list nábojov, ktoré Votrelec vystrelil
     */

    public Optional<ArrayList<Naboj>> getZasobnikVotrelca() {
        return Optional.ofNullable(this.zasobnikVotrelca);
    }

    /**
     * Každých 20ms sa táto metóda vola a pohne nábojmi Votrelca smerom do dola
     */

    public void tikPohybuStrielNepriatela() {
        this.pohniNabojmi();
    }

    /**
     * Vytváraju sa tu náboje a pridavajú do lista, taktiež sa určuje kde vznikne vytvorený náboj
     * @param x vytvorí sa náboj na tejto súradnici
     * @param y vytvorí sa náboj na tejto súradnici
     */

    @Override
    public void strel(int x, int y) {
        this.naboj = new Naboj(x, y, new Obrazok("Bullet.png"));
        this.naboj.presunObrazokNa(x - (this.naboj.getSirka() / 2), y - this.naboj.getSirka());
        this.naboj.setX(x - (this.naboj.getSirka() / 2));
        this.naboj.setY(y - this.naboj.getSirka());
        this.zasobnikVotrelca.add(this.naboj);
    }

    /**
     * Prejde sa cez celý list a posunie naboje
     */

    @Override
    public void pohniNabojmi() {
        if (this.getZasobnikVotrelca().isPresent()) {
            for (int i = 0; i < this.zasobnikVotrelca.size(); i++) {
                this.zasobnikVotrelca.get(i).posunNaboj(10);
                this.detekciaPozicieNabojov(i);
            }
        }
    }

    /**
     * Keď sú už náboje mimo plochy tak sa skryju
     * @param index podľa indexu prejdeme cez list a budeme detekovat y súradnicu náboja
     */

    @Override
    public void detekciaPozicieNabojov(int index) {
        if (this.zasobnikVotrelca.get(index).getY() > 800) {
            this.naboj = this.zasobnikVotrelca.get(index);
            this.zasobnikVotrelca.remove(this.naboj);
            this.naboj.skry();
        }
    }
}
