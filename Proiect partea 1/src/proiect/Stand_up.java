package proiect;

public class Stand_up extends Eveniment {
    private String comedian;

    public String getComedian() {
        return comedian;
    }

    public void setComedian(String comedian) {
        this.comedian = comedian;
    }

    public Stand_up(int duration_h, int duration_m, double price,int locuri, String comedian) {
        super(duration_h, duration_m, price,locuri);
        this.comedian = comedian;
    }

        public void print()
        {
            System.out.println("Stand-up:\n"+"Spectacolul dureaza "+this.getDuration_h()+" ore si "+this.getDuration_m()+" de minute\n"+
                    "Pretul este de: "+this.getPrice()+"lei \n"+
                    "Sunt disponibile "+this.getLocuri()+" locuri\n"+
                    "Comedianul ce va sustine show-ul este: "+this.comedian+"\n\n");
        }

}
