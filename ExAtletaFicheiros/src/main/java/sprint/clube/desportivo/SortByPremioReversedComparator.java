package sprint.clube.desportivo;

import java.util.Comparator;

public class SortByPremioReversedComparator implements Comparator<Atleta> {

    @Override
    public int compare(Atleta o1, Atleta o2) {
        if (o1.getPremioAcumulado() < o2.getPremioAcumulado()) {
            return 1;
        } else if (o1.getPremioAcumulado() > o2.getPremioAcumulado()) {
            return -1;
        } else {
            return 0;
            //Alternativa -> return Double.compare(o2.getPremioAcumulado(), o1.getPremioAcumulado());
        }
    }
}
