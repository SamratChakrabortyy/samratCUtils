package in.samratc.util;

public class Pair<E,F>{
    E val1;
    F val2;
    
    public Pair(E x, F y){
        val1=x;
        val2=y;
    }
    
    public String toString(){
        return String.format("(%s, %s)",val1, val2);
    }
}
