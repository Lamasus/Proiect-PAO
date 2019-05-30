package com.laurentiuspilca.pao_lab12.services;


import com.laurentiuspilca.pao_lab12.model.Eveniment;
import com.laurentiuspilca.pao_lab12.repositories.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class Client {
        ArrayList<Eveniment> bilete=new ArrayList<Eveniment>();

        public double pret_concert=0;
        public double pret_sportiuv=0;
        public double pret_stand_up=0;
        public double pret_teatru=0;

        public Eveniment get_ID(int id)
        {
            return bilete.get(id-1);
        }

        public void add(Path path)
        {
            try
            {
                Files.lines(path)
                        .flatMap(line -> Arrays.stream(line.split(System.getProperty("line.separator"))))
                        .forEach(line -> bilete.add(functie(line)));
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }

        }
    public void sortare()
    {
        Collections.sort(bilete, new Sort());
    }

        public void show()
        {
            Iterator<Eveniment> i = bilete.iterator();
            while(i.hasNext())
            {
                i.next().print();
            }
        }

        private Eveniment functie(String l)
        {
            String[] cuv = l.split(",");

            switch (cuv[0])
            {
                case "Concert":

                    Tip_Concert tip = Tip_Concert.valueOf(cuv[1]);
                    int duration_h  = Integer.parseInt(cuv[2]);
                    int duration_m = Integer.parseInt(cuv[3]);
                    double price = Integer.parseInt(cuv[4]);
                    int locuri = Integer.parseInt(cuv[5]);
                    int trupe = Integer.parseInt(cuv[6]);
                    String trupa  = cuv[7];


                    Concert c = new Concert(duration_h,duration_m,price,locuri,tip,trupe,trupa,Id_bilete.getInstance().id);
                    pret_concert+=price;
                    return c;

                case "Sportiv":

                    Tip_Sportiv tip1 = Tip_Sportiv.valueOf(cuv[1]);
                    int duration_h1  = Integer.parseInt(cuv[2]);
                    int duration_m1 = Integer.parseInt(cuv[3]);
                    double price1 = Integer.parseInt(cuv[4]);
                    int locuri1 = Integer.parseInt(cuv[5]);
                    String e1 = cuv[6];
                    String e2 = cuv[7];


                    Sportiv s = new Sportiv(duration_h1,duration_m1,price1,locuri1,e1,e2,tip1,Id_bilete.getInstance().id);
                    pret_sportiuv+=price1;
                    return s;

                case "Teatru":
                    Tip_Teatru tip2 = Tip_Teatru.valueOf(cuv[1]);
                    int duration_h2  = Integer.parseInt(cuv[2]);
                    int duration_m2 = Integer.parseInt(cuv[3]);
                    double price2 = Integer.parseInt(cuv[4]);
                    int locuri2 = Integer.parseInt(cuv[5]);
                    String nume = cuv[6];

                    Teatru t = new Teatru(duration_h2,duration_m2,price2,locuri2,tip2,nume,Id_bilete.getInstance().id);
                    pret_teatru+=price2;
                    return t;

                case "Stand_up":
                    int duration_h3  = Integer.parseInt(cuv[1]);
                    int duration_m3 = Integer.parseInt(cuv[2]);
                    double price3 = Integer.parseInt(cuv[3]);
                    int locuri3 = Integer.parseInt(cuv[4]);
                    String name = cuv[5];



                    Stand_up st = new Stand_up(duration_h3,duration_m3,price3,locuri3,name,Id_bilete.getInstance().id);
                    pret_stand_up+=price3;
                    return st;







            }
            return null;
        }

}
