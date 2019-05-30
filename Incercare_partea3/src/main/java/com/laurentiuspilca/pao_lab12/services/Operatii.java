package com.laurentiuspilca.pao_lab12.services;

import com.laurentiuspilca.pao_lab12.model.Eveniment;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Operatii {

    private Client client;
    private double pret=0;
    private double pret_lista = 0;
    private int ok=0;
    private Map<Eveniment, Integer> lista;

    static private Path Csv_con = Paths.get("D:/JavaProiecte/Proiect partea 2/src/proiect/concert.csv");
    static private Path Csv_sp = Paths.get("D:/JavaProiecte/Proiect partea 2/src/proiect/sportiv.csv");
    static private Path Csv_st = Paths.get("D:/JavaProiecte/Proiect partea 2/src/proiect/stand_up.csv");
    static private Path Csv_teatru = Paths.get("D:/JavaProiecte/Proiect partea 2/src/proiect/teatru.csv");
    static private String logp = "D:/JavaProiecte/Proiect partea 2/src/proiect/log.csv";


    public void constructor()
    {
        ok=1;
        client = new Client();

        client.add(Csv_con);
        client.add(Csv_sp);
        client.add(Csv_st);
        client.add(Csv_teatru);

        lista = new HashMap<Eveniment,Integer>();

        try
        {
            PrintWriter s = new PrintWriter(new File(logp));
            s.print("");
            s.close();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }

        logwriter(null, "Pornire: ");
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

    public void pret_lista()
    {
        for(Eveniment ev : lista.keySet())
        {
            pret_lista += ev.price;
        }

        System.out.printf("Pret total: %f\n ", pret_lista);
    }

    public void print_lista()
    {
        System.out.println("Lista curenta: ");
        for(Eveniment ev : lista.keySet())
        {
            ev.print();
            System.out.printf("Nr de bilete: %d\n",lista.get(ev));
        }
    }

    public void sorteaza()
    {
        client.sortare();
    }

    private void logwriter(Eveniment ev, String d)
    {
        try
        {
            FileWriter fw = new FileWriter(logp,true);
            BufferedWriter bw = new BufferedWriter(fw);
            Date data = new Date();
            DateFormat format_data = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss") ;
            String str = format_data.format(data);
            StringBuffer linie = new StringBuffer();
            if(ev != null)
            {
                linie.append(d);
                linie.append(",");
                linie.append(ev.getId());
                linie.append(",");
                linie.append(str);
                linie.append(",");
                linie.append(ev.price);
            }
            else
            {
                linie.append(d);
                linie.append(",");
                linie.append(str);
            }

            bw.write(linie.toString());
            bw.newLine();
            bw.flush();
            bw.close();
        }
        catch(UnsupportedEncodingException ex){}
        catch (FileNotFoundException ex){}
        catch (IOException ex){}


    }

    public void tag_id()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduceti numarul biletului pe care doriti sa-l cumparati ");
        int id = Integer.parseInt(scan.nextLine());
        Eveniment ev_scan = client.get_ID(id);

        if(lista.containsKey(ev_scan))
        {
            lista.put(ev_scan, lista.get(ev_scan)+1);
        }
        else
        {
            lista.put(ev_scan,1);
        }

        System.out.println("Ati adaugat la lista produsul: ");
        System.out.printf("Cantitate : %d\n",lista.get(ev_scan));
        ev_scan.print();


        logwriter(ev_scan,"Citire");
    }

    public void plata_grup()
    {
        int c;
        double platit=0;
        double ramas=0;
        boolean limita=false;
        Scanner bani;
        System.out.println("Introduceti suma: ");
        bani=new Scanner(System.in);
        platit+=Integer.parseInt(bani.nextLine());
        Scanner b;
        System.out.println("1 pentru teatru, 2 pentru eveniment sportiv, 3 pentru stand up , 4 pentru concerter, 5 pentru toate,6 pentru plata individuala: ");
        b=new Scanner(System.in);
        c=b.nextInt();


        switch(c)
        {
            case 1:
                if(platit < 0.8*client.pret_teatru)
                {
                    System.out.println("Mai baga bani: ");
                }
                else
                {
                    ramas = platit - 0.8*client.pret_teatru;
                    System.out.printf("Plata a fost inregistrata si v-au ramas %f\n",ramas);

                }
                break;

            case 2:
                if(platit < 0.8*client.pret_sportiuv)
                {
                    System.out.println("Mai baga bani: ");
                }
                else
                {
                    ramas = platit - 0.8*client.pret_sportiuv;
                    System.out.printf("Plata a fost inregistrata si v-au ramas %f\n",ramas);

                }
                break;

            case 3:
                if(platit < 0.8*client.pret_stand_up)
                {
                    System.out.println("Mai baga bani: ");
                }
                else
                {
                    ramas = platit - 0.8*client.pret_stand_up;
                    System.out.printf("Plata a fost inregistrata si v-au ramas %f\n",ramas);

                }
                break;

            case 4:
                if(platit < 0.8*client.pret_concert)
                {
                    System.out.println("Mai baga bani: ");
                }
                else
                {
                    ramas = platit - 0.8*client.pret_concert;
                    System.out.printf("Plata a fost inregistrata si v-au ramas %f\n",ramas);

                }
                break;

            case 5:
                if(platit < 0.6*(client.pret_sportiuv+client.pret_concert+client.pret_stand_up+client.pret_teatru))
                {
                    System.out.println("Mai baga bani: ");
                }
                else
                {
                    ramas = platit - 0.6*(client.pret_sportiuv+client.pret_concert+client.pret_stand_up+client.pret_teatru);
                    System.out.printf("Plata a fost inregistrata si v-au ramas %f\n",ramas);

                }
                break;

            default:
                break;

        }

    }

    public void plata()
    {
        Scanner bani;
        double platit=0;
        double ramas=0;
        boolean limita=false;


        while(limita == false)
        {
            System.out.println("Introduceti suma: ");
            bani=new Scanner(System.in);
            platit += Integer.parseInt(bani.nextLine());
            System.out.printf("S-au introdus %f ",platit);
            if(platit < pret_lista)
            {
                System.out.println("Mai baga bani: ");
            }
            else
            {
                ramas = platit - pret_lista;
                System.out.printf("Plata a fost inregistrata si v-au ramas %f\n",ramas);
                limita=true;
            }

        }
        logwriter(null,"Plata procesata");

    }



}
