package cz.uhk.merapp.data;

import java.util.ArrayList;
import java.util.List;

public class Mereni {

    public Mereni(){

    }

    private List<Number> data = new ArrayList<>();

    public void pridejMereni(Number mereni){

        data.add(mereni);
    }

    public Number getIndex(int index){

        return data.get(index);
    }

    public Number soucet(){

        Number soucet = 0;

        for (Number n : data){
            soucet = soucet.doubleValue() +  n.doubleValue();
        }
        return soucet;
    }

    public Number prumer(){

        Number soucet = 0;

        for (Number n : data){
            soucet = soucet.doubleValue() +  n.doubleValue();
        }
        return  soucet.doubleValue()/data.size();
    }

    public Number min(){

        Number min = Integer.MAX_VALUE;

        for (Number n : data){
            if (n.doubleValue() < min.doubleValue()){
                min = n.doubleValue();
            }
        }

        return min.doubleValue();
    }

    public Number max(){

        Number max = Integer.MIN_VALUE;

        for (Number n : data){
            if (n.doubleValue() > max.doubleValue()){
                max = n.doubleValue();
            }
        }
        return max.doubleValue();
    }



}
