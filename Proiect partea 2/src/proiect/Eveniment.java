package proiect;

abstract public class Eveniment {
    public int duration_h;
    public int duration_m;
    public double price;
    public int locuri;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    public int getLocuri() {
        return locuri;
    }

    public void setLocuri(int locuri) {
        this.locuri = locuri;
    }

    public int getDuration_h() {
        return duration_h;
    }

    public void setDuration_h(int duration_h) {
        this.duration_h = duration_h;
    }

    public int getDuration_m() {
        return duration_m;
    }

    public void setDuration_m(int duration_m) {
        this.duration_m = duration_m;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Eveniment(int duration_h, int duration_m, double price,int locuri) {
        this.duration_h = duration_h;
        this.duration_m = duration_m;
        this.price = price;
        this.locuri=locuri;
    }


    public abstract void print();




}
