package proiect;

import java.util.ArrayList;

public class Client  {
    private String name;
    private int age;
    private int money;
    ArrayList<Eveniment> bilete=new ArrayList<Eveniment>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Client(String name, int age,int money)
    {
        this.name=name;
        this.age=age;
        this.money=money;

    }

    public void addBilet(Eveniment ev)
    {
        bilete.add(ev);
    }

    public void showBilet()
    {
        for(int j=0;j<bilete.size();j++)
        {
            System.out.println(bilete.get(j));
        }
    }





}
