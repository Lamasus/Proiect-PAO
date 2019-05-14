package proiect;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        /*
        Client c1=new Client("Murgu",20,300);

        Concert s1=new Concert(2,30,150,100, Tip_Concert.Metal,4);

        Teatru t1=new Teatru(3,45,60,200,Tip_Teatru.Drama);

        Stand_up s2=new Stand_up(2,15,45,75,"Alunelu");

        Sportiv s3=new Sportiv(2,5,120,4000,"Atletico","Real",Tip_Sportiv.Fotbal);


        t1.print();
        s1.print();
        s2.print();
        s3.print();

        ArrayList<Eveniment> bilete=new ArrayList<Eveniment>();

        bilete.add(t1);
        bilete.add(s1);
        bilete.add(s2);
        bilete.add(s3);

        c1.showBilet();
        */

        Operatii o1 = new Operatii();
        o1.constructor();
        o1.print_bilete();
        o1.sorteaza();
        o1.print_bilete();
        o1.preturi_categorii();
        o1.pret_total();
        o1.plata_grup();
        o1.tag_id();
        o1.tag_id();
        o1.tag_id();
        o1.print_lista();
        o1.pret_lista();
        o1.plata();

    }
}
