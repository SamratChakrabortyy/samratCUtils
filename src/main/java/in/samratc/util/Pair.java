package in.samratc.util;

import java.util.Objects;

public class Pair<E,F>{
    public E val1;
    public F val2;
    
    public Pair(E x, F y){
        val1=x;
        val2=y;
    }
    
    public String toString(){
        return String.format("(%s, %s)",val1, val2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(val1, pair.val1) &&
                Objects.equals(val2, pair.val2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val1, val2);
    }
}
