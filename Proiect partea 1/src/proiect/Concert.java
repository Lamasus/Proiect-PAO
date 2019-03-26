package proiect;




public class Concert extends Eveniment {
        private Tip_Concert tip_concert;
        private int trupe;



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


    public Concert(int duration_h, int duration_m, double price,int locuri, Tip_Concert tip_concert, int trupe) {
        super(duration_h, duration_m, price,locuri);
        this.tip_concert = tip_concert;
        this.trupe = trupe;
    }

    public void print()
    {
        System.out.println("Concert:\n"+"Spectacolul dureaza "+this.getDuration_h()+" ore si "+this.getDuration_m()+" de minute\n"+
                "Pretul este de: "+this.getPrice()+"lei \n"+
                "Sunt disponibile "+this.getLocuri()+" locuri\n"+
                "Tipul concertului este "+this.tip_concert+"\n"+
                "Vor fi prezente "+this.trupe+" trupe\n\n");
    }
}
