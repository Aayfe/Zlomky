import cz.uhk.zlomky.data.Zlomek;

public class Main {
    public static void main() {
        IO.println("============= PROJEKT ZLOMKY =============");
        IO.println("==========================================");

        Zlomek zlomek = new Zlomek(4, 2);
        Zlomek zlomekB = new Zlomek(3, 4);

        IO.println(zlomek);
        IO.println(zlomekB);

        IO.println("Součet: \n" + zlomek.plus(zlomekB));
        IO.println("Rozdíl: \n" + zlomek.minus(zlomekB));
        IO.println("Součin: \n" + zlomek.krat(zlomekB));
        IO.println("Podíl: \n" + zlomek.deleno(zlomekB));

        IO.println(zlomek.zkratit());

        System.out.println("vypis");


        Zlomek[] pole = new  Zlomek[3];
        pole[0] = new Zlomek(1,1);
        pole[1] = new Zlomek(3,5);
        pole[2] = new Zlomek(1,5);

        for (Zlomek z : pole){
            System.out.println(z);
        }
        IO.println("prumer zlomku z pole je: "+ prumer(pole));

        IO.println(zlomek.intValue());
    }
    public  static  Zlomek prumer(Zlomek[] pole){

        Zlomek soucet = new Zlomek(0,1);


        for (Zlomek z : pole){

            soucet = soucet.plus(z);

        }


        return soucet.zkratit().deleno(pole.length);

    }
}
