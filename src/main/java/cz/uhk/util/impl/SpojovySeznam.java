package cz.uhk.util.impl;

import cz.uhk.merapp.data.Mereni;
import cz.uhk.util.Seznam;

import java.util.Iterator;
import java.util.concurrent.ExecutionException;

//generická třída spojového lineárního seznamu
public class SpojovySeznam<E> implements Seznam<E> {


    private PrvekSeznamu<E> prvni, posledni;

    public void pridejPrvekNaPozici(E hodnota, int index) {

        if (index < 0 || index > this.pocet()) {
            throw new IndexOutOfBoundsException();
        }

        var novyPrvek = new PrvekSeznamu<E>(hodnota);

        if (index == 0) {
            novyPrvek.dalsi = prvni;
            prvni = novyPrvek;

            if (posledni == null) {
                posledni = novyPrvek;
            }
            return;
        }

        var predchoziPrvek = vratPrvek(index - 1);
        novyPrvek.dalsi = predchoziPrvek.dalsi;


        predchoziPrvek.dalsi = novyPrvek;

        if (novyPrvek.dalsi == null) {
            posledni = novyPrvek;
        }
    }

    @Override
    public void pridej(E hodnota) {

        var novy = new PrvekSeznamu<E>(hodnota);
        if (prvni == null) {
            prvni = novy;
            posledni = novy;
        } else {
            posledni.dalsi = novy;
            posledni = posledni.dalsi;
        }


    }

    @Override
    public void smaz(int pozice) {
        if (pozice == 0) {
            prvni = prvni.dalsi;
        } else {
            var predchozi = vratPrvek(pozice - 1);
            if (predchozi != null && predchozi.dalsi != null) {
                predchozi.dalsi = predchozi.dalsi.dalsi;
            }
        }

    }

    @Override
    public E vrat(int pozice) {
        var prvek = vratPrvek(pozice);

        if (prvek == null || prvek.hodnota == null) {
            throw new NullPointerException();
        }

        return prvek.hodnota;
    }

    private PrvekSeznamu<E> vratPrvek(int pozice) {
        if (pozice < 0) {
            return null;
        }
        var pom = prvni;

        for (int cislo = 0; cislo < pozice; cislo++) {
            pom = pom.dalsi;
        }
        return pom;
    }

    @Override
    public int pocet() {
        var pom = prvni;
        var pocet = 0;

        while (pom != null) {
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
                return aktualni != null;
            }

            @Override
            public E next() {
                E hodnota = aktualni.hodnota;
                aktualni = aktualni.dalsi;
                return hodnota;
            }
        };
    }

    class PrvekSeznamu<T> {
        T hodnota;
        PrvekSeznamu<T> dalsi;

        public PrvekSeznamu(T hodnota) {

            this.hodnota = hodnota;
        }
    }
}
