package proiect;

public class Sportiv extends Eveniment {
    private String echipa1;
    private String echipa2;
    private Tip_Sportiv tip_sportiv;

    public String getEchipa1() {
        return echipa1;
    }

    public void setEchipa1(String echipa1) {
        this.echipa1 = echipa1;
    }

    public String getEchipa2() {
        return echipa2;
    }

    public void setEchipa2(String echipa2) {
        this.echipa2 = echipa2;
    }

    public Tip_Sportiv getTip_sportiv() {
        return tip_sportiv;
    }

    public void setTip_sportiv(Tip_Sportiv tip_sportiv) {
        this.tip_sportiv = tip_sportiv;
    }

    public Sportiv(int duration_h, int duration_m, double price, int locuri, String echipa1, String echipa2, Tip_Sportiv tip_sportiv,int id) {
        super(duration_h, duration_m, price, locuri);
        this.echipa1 = echipa1;
        this.echipa2 = echipa2;
        this.tip_sportiv = tip_sportiv;
        this.setId(id);
    }

    public void print()
    {
        System.out.println("Nr produs: "+this.getId()+"\n"+"Eveniment sportiv:\n"+"Meciul dureaza "+this.getDuration_h()+" ore si "+this.getDuration_m()+" de minute\n"+
                "Pretul este de: "+this.getPrice()+"lei \n"+
                "Sunt disponibile "+this.getLocuri()+" locuri\n"+
                "Meciul este de "+this.tip_sportiv+"\n"+
                "Echipele prezente: "+this.echipa1+" vs "+this.echipa2+"\n\n");
    }
}
