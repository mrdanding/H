package edu.ucsd.H.entity;

/**
 * @author shuaiqi.xsq, 15/10/23
 */

public class Person {
    public int name;
    public double crimeRate;
    public int money;
    public int X;
    public int Y;
    public int isKilled;
    public String city;

    public Person() {

    }

    public Person(int name, int X, int Y, int isKilled, int money, double crimeRate, String city) {
        this.name = name;
        this.X = X;
        this.Y = Y;
        this.money = money;
        this.crimeRate = crimeRate;
        this.isKilled = isKilled;
        this.city = city;
    }


}