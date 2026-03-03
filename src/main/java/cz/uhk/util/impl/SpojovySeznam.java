package cz.uhk.util.impl;

import cz.uhk.merapp.data.Mereni;
import cz.uhk.util.Seznam;

import java.util.Iterator;

//generická třída spojového lineárního seznamu
public class SpojovySeznam<E> implements Seznam<E> {

    private PrvekSeznamu<E> prvni, posledni;
    @Override
    public void pridej(E hodnota) {

        var novy = new PrvekSeznamu<E>(hodnota);
        if (prvni == null){
            prvni = novy;
            posledni = novy;
        }else{
            posledni.dalsi = novy;
            posledni=posledni.dalsi;
        }


    }

    @Override
    public void smaz(int pozice) {
        if (pozice == 0){
            prvni = prvni.dalsi;
        }else{
            var predchozi = vratPrvek(pozice-1);
            if (predchozi != null &&predchozi.dalsi !=null) {
                predchozi.dalsi = predchozi.dalsi.dalsi;
            }
        }

    }

    @Override
    public E vrat(int pozice) {
        E hodnota = vratPrvek(pozice).hodnota;
        if (hodnota==null)
        {
            return null;

        }else {
            return hodnota;

        }
    }
    private PrvekSeznamu<E> vratPrvek(int pozice) {
        if (pozice<0){
            return null;
        }
        var pom = prvni;

        for (int cislo = 0; cislo < pozice ; cislo++){
            pom =  pom.dalsi;
        }
        return pom;
    }

    @Override
    public int pocet() {
        var pom = prvni;
        var pocet = 0;

        while (pom != null){
            pocet++;
            pom = pom.dalsi;
        }

        return pocet;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            PrvekSeznamu<E> aktualni = prvni;
            @Override
            public boolean hasNext() {

                return aktualni != null && aktualni.dalsi!=null;
            }

            @Override
            public E next() {
                if (aktualni == null){
                    return null;
                }else{
                    aktualni = aktualni.dalsi;
                    return aktualni.hodnota;
                }

            }
        };
    }
}

class PrvekSeznamu<T> {
     T hodnota;
     PrvekSeznamu<T> dalsi;

    public PrvekSeznamu(T hodnota) {

        this.hodnota = hodnota;
    }
}
