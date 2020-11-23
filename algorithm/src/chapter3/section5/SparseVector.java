package chapter3.section5;

import java.util.HashMap;

public class SparseVector {
    private HashMap<Integer, Double> st;

    public SparseVector() {
        st = new HashMap<>();
    }

    public  int size(){
        return st.size();
    }

    public void put(int i,double x){
        st.put(i, x);
    }

    public double get(int i){
        if(!st.containsKey(i)) return 0.0;
        return st.get(i);
    }

    public double dot(double [] that){
        double sum = 0.0;
        for (int i : st.keySet()) {
            sum += that[i] * get(i);
        }
        return sum;
    }
}
