package in.samratc.util;

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
}
