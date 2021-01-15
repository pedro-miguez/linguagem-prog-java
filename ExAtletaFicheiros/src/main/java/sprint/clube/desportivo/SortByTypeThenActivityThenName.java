package sprint.clube.desportivo;

import java.util.Comparator;

public class SortByTypeThenActivityThenName implements Comparator<Atleta> {

        @Override
        public int compare(Atleta a1, Atleta a2) {
            String className1 = a1.getClass().getSimpleName();
            String className2 = a2.getClass().getSimpleName();
            int compareClass = className1.compareToIgnoreCase(className2);

            String activity1 = a1.getAtividade();
            String activity2 = a2.getAtividade();
            int compareActivity = activity1.compareToIgnoreCase(activity2);

            String name1 = a1.getNome();
            String name2 = a2.getNome();
            int compareName = name1.compareToIgnoreCase(name2);

            if (compareClass != 0) {
                return compareClass;
            } else if (compareActivity != 0){
                return compareActivity;
            } else {
                return compareName;
            }
        }
}



