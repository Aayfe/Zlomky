package cz.uhk.zlomky.data;

public class Zlomek extends java.lang.Number{
    private int citatel, jmenovatel;

    public Zlomek(){

    }
    public Zlomek(int citatel, int jmenovatel){
        this.citatel = citatel;
        this.jmenovatel = jmenovatel;
    }

    public int getCitatel(){
        return citatel;
    }
    public int getJmenovatel(){
        return jmenovatel;
    }
    public void setCitatel(int citatel){
        this.citatel = citatel;
    }
    public void setJmenovatel(int jmenovatel){
        this.jmenovatel = jmenovatel;
    }

    //operace


    public Zlomek plus(Zlomek zlomekB){

        int citatel, jmenovatel;

        citatel = (this.citatel * zlomekB.jmenovatel) + (zlomekB.citatel * this.jmenovatel);
        jmenovatel = this.jmenovatel * zlomekB.jmenovatel;
        return new Zlomek(citatel, jmenovatel);
    }

    public Zlomek minus(Zlomek zlomekB){

        int citatel, jmenovatel;

        citatel = this.citatel * zlomekB.jmenovatel - zlomekB.citatel * this.jmenovatel;
        jmenovatel = this.jmenovatel * zlomekB.jmenovatel;
        return new Zlomek(citatel, jmenovatel);
    }

    public Zlomek krat(Zlomek zlomekB){

        int citatel, jmenovatel;

        citatel = this.citatel * zlomekB.citatel;
        jmenovatel = this.jmenovatel * zlomekB.jmenovatel;
        return new Zlomek(citatel, jmenovatel);
    }

    public Zlomek deleno(Zlomek zlomekB){

        int citatel, jmenovatel;

        citatel = this.citatel * zlomekB.jmenovatel;
        jmenovatel = this.jmenovatel * zlomekB.citatel;
        return new Zlomek(citatel, jmenovatel);
    }

    public Zlomek deleno(int num){

        int citatel, jmenovatel;

        citatel = this.citatel;
        jmenovatel = this.jmenovatel * num;
        return new Zlomek(citatel, jmenovatel);
    }

    public Zlomek zkratit(){
        int delitel = spolecnyDelitel(citatel, jmenovatel);
        return new Zlomek(citatel/delitel, jmenovatel/delitel);

    }
    private int spolecnyDelitel(int cisloA, int cisloB){

        int delitel, moduloVysledek;

        if (cisloA<cisloB){
            int tmp = cisloA;
            cisloA = cisloB;
            cisloB = tmp;
        }
        do {
            moduloVysledek = cisloA % cisloB;
            delitel = cisloB;

            cisloA = cisloB;
            cisloB = moduloVysledek;
        }while (moduloVysledek != 0);

        return  delitel;
    }

    @Override
    public int intValue() {

        return citatel/jmenovatel;
    }
    @Override
    public long longValue(){
        return  citatel/jmenovatel;
    }
    @Override
    public float floatValue(){
        return  citatel/(float)jmenovatel;
    }
    @Override
    public double doubleValue(){
        return  citatel/(double)jmenovatel;
    }

    @Override
    public String toString() {
        return citatel + "/" +jmenovatel;
    }
}
