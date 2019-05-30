import java.util.List;

public class Ev_Service {
    private Ev_Repo EvRepo;

    public Ev_Service() {
        EvRepo = new Ev_Repo();
    }

    public void adaugaEv(int duration_h,int duration_m,double price,int locuri)
    {
        Eveniment p = new Eveniment();
        p.setDuration_h(duration_h);
        p.setDuration_m(duration_m);
        p.setPrice(price);
        p.setLocuri(locuri);
        EvRepo.adaugaEv(p);
    }

    public List<Eveniment> getEv()
    {
        return EvRepo.findEvenimente();
    }

    public void deleteEv(Eveniment p)
    {
        EvRepo.stergeEventiment(p);
    }
}
