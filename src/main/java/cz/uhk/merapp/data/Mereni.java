package cz.uhk.merapp.data;

import cz.uhk.util.Seznam;
import cz.uhk.util.impl.SpojovySeznam;

import java.util.ArrayList;
import java.util.List;

public class Mereni {

    public Mereni(){

    }

    private Seznam<Number> data = new SpojovySeznam<>();

    public void pridejMereni(Number mereni){

        data.pridej(mereni);
    }

    public Number getIndex(int index){

        return data.vrat(index);
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
        return  soucet.doubleValue()/data.pocet();
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
