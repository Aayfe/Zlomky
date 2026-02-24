package cz.uhk.merapp;

import cz.uhk.merapp.data.Mereni;
import cz.uhk.zlomky.data.Zlomek;

public class MereniApp {

    static void main() {

        Mereni mereni = new Mereni();


        mereni.pridejMereni(10);
        mereni.pridejMereni(1.05f);
        mereni.pridejMereni(100.1556);
        mereni.pridejMereni(456);
        mereni.pridejMereni(new Zlomek(5, 6));
        mereni.pridejMereni(new Zlomek(1, 2));
        mereni.pridejMereni(new Zlomek(10000000, 78));


        IO.println("Max: " + mereni.max());
        IO.println("Min: " + mereni.min());
        IO.println("Průměr: "+ mereni.prumer());
        IO.println("Index: "+ mereni.getIndex(6));


    }
}
