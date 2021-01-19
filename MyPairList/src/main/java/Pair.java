import java.util.Objects;

public class Pair<T extends Comparable<T>, S extends Comparable<S>> implements Comparable<Pair<T, S>> {

    private T first;
    private S second;

    public Pair(T first, S second){
        this.first = first;
        this.second = second;
    }

    public int compareTo(Pair<T, S> o) {
        int compareFirst = o.getFirst().compareTo(getFirst());

        if (compareFirst != 0) {
            return compareFirst;
        } else {
            return o.getSecond().compareTo(getSecond());
        }

    }

    public T getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return getFirst().equals(pair.getFirst()) &&
                getSecond().equals(pair.getSecond());
    }

}
