package proiect;

import java.nio.file.Path;
import java.nio.file.Paths;


public class Operatii {

    private Client client;

    private double pret=0;
    private int ok=0;

    static private Path Csv_con = Paths.get("D:/JavaProiecte/Proiect partea 2/src/proiect/concert.csv");
    static private Path Csv_sp = Paths.get("D:/JavaProiecte/Proiect partea 2/src/proiect/sportiv.csv");
    static private Path Csv_st = Paths.get("D:/JavaProiecte/Proiect partea 2/src/proiect/stand_up.csv");
    static private Path Csv_teatru = Paths.get("D:/JavaProiecte/Proiect partea 2/src/proiect/teatru.csv");

    public void constructor()
    {
        ok=1;
        client = new Client();

        client.add(Csv_con);
        client.add(Csv_sp);
        client.add(Csv_st);
        client.add(Csv_teatru);
    }

    public void print_bilete()
    {
        if(ok == 0)
        {
            System.out.println("Nu exista bilete");
        }
        else
        {
            client.show();
        }
    }

    public void preturi_categorii()
    {
        System.out.println("Se aplica discount de 20% pentru achitarea mai multor bilete din aceeasi categorie ");
        System.out.printf("Pret total pentru teatru: %f \n", 0.8* client.pret_teatru);
        System.out.printf("Pret total pentru concerte: %f \n", 0.8* client.pret_concert);
        System.out.printf("Pret total pentru stand_up: %f \n", 0.8* client.pret_stand_up);
        System.out.printf("Pret total pentru evenimente sportive: %f \n\n", 0.8* client.pret_sportiuv);
    }

    public void pret_total()
    {
        System.out.println("Pretul total are discount de 40%");
        pret+=0.6*(client.pret_sportiuv + client.pret_stand_up + client.pret_concert + client.pret_teatru);
        System.out.printf("Pretul total al biletelor %f: \n",pret);

    }

    public void sorteaza()
    {
        client.sortare();
    }



}
