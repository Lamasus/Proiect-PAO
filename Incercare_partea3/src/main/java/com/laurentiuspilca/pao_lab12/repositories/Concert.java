package com.laurentiuspilca.pao_lab12.repositories;


import com.laurentiuspilca.pao_lab12.model.Eveniment;

public class Concert extends Eveniment {
        private Tip_Concert tip_concert;
        private int trupe;

    public String getTrupa() {
        return trupa;
    }

    public void setTrupa(String trupa) {
        this.trupa = trupa;
    }

    private String trupa;



    public Tip_Concert getTip_concert() {
        return tip_concert;
    }

    public void setTip_concert(Tip_Concert tip_concert) {
        this.tip_concert = tip_concert;
    }

    public int getTrupe() {
        return trupe;
    }

    public void setTrupe(int trupe) {
        this.trupe = trupe;
    }


    public Concert(int duration_h, int duration_m, double price, int locuri, int id, Tip_Concert tip_concert, int trupe, String trupa) {
        super(duration_h, duration_m, price, locuri, id);
        this.tip_concert = tip_concert;
        this.trupe = trupe;
        this.trupa = trupa;
    }

    public Concert(Tip_Concert tip_concert, int trupe, String trupa) {
        this.tip_concert = tip_concert;
        this.trupe = trupe;
        this.trupa = trupa;
    }

    public void print()
    {
        System.out.println("Nr produs: "+this.getId()+"\n"+"Concert:\n"+"Spectacolul dureaza "+this.getDuration_h()+" ore si "+this.getDuration_m()+" de minute\n"+
                "Pretul este de: "+this.getPrice()+"lei \n"+
                "Sunt disponibile "+this.getLocuri()+" locuri\n"+
                "Tipul concertului este "+this.tip_concert+"\n"+
                "Numele capului de afis este: "+ this.trupa+"\n"+
                "Vor fi prezente "+this.trupe+" trupe\n\n");
    }
}
