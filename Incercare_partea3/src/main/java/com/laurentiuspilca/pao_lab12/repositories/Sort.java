package com.laurentiuspilca.pao_lab12.repositories;

import com.laurentiuspilca.pao_lab12.model.Eveniment;

import java.util.Comparator;

public  class Sort implements Comparator<Eveniment> {
    public int compare(Eveniment a,Eveniment b)
    {
        if(a.duration_h == a.duration_m)
        {
            return a.duration_m - b.duration_m;
        }
        else
        {
            return a.duration_h - b.duration_h;
        }
    }
}
