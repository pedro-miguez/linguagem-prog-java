import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyPairList<T extends Comparable<T>, S extends Comparable<S>> {

    private List< Pair<T, S> > listaPares;

    public MyPairList() {
        listaPares = new ArrayList<Pair<T, S>>();
    }

    public void addPair(T first, S second) {
        listaPares.add(new Pair<T, S>(first, second));
    }

    public void sort(){
        Collections.sort(listaPares);
    }

    public List< Pair<T, S> > getListaPares() {
        return new ArrayList<Pair<T, S>>(listaPares);
    }

}
