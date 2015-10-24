package edu.ucsd.H.helper;

import edu.ucsd.H.entity.Person;
import java.util.Random;
/**
 * @author shuaiqi.xsq, 15/10/23
 */

public class Mainlogic {
    static Person[] person = new Person[100];

    public static void main(String[] args) {
        Mainlogic logic = new Mainlogic();
        logic.init();
        logic.startOneStep();
        for (int i = 0; i < 10; i++) {
            logic.startOneStep();
        }
    }

    public void init() {
        //Person(int name, int X, int Y, int isKilled,
        //int money, double crimeRate, String city)
        int maxMoney = 50000;
        Random crime = new Random();
        for (int i = 0; i < 50; i++) {
            person[i] = new Person(i, (int) (Math.random() * 400), (int) (Math.random() * 400), 0, (int) (Math.random() * maxMoney), Math.abs(crime.nextGaussian()), "Portland");
        }
        for (int i = 50; i < 100; i++) {
            person[i] = new Person(i, (int) (Math.random() * 400), (int) (Math.random() * 400), 0, (int) (Math.random() * maxMoney), Math.abs(crime.nextGaussian()), "San Diego");
        }
    }

    public void startOneStep() {
        for (int i = 0; i < 100; i++) {
            person[i].X = calcPosition(person[i].X, person[i].Y)[0];
            person[i].Y = calcPosition(person[i].X, person[i].Y)[1];
            if (person[i].isKilled != 1) {
                if (Math.random() > person[i].crimeRate) {
                    killPerson(i);
                }
            }
//			System.out.print(person[i].name + " ");
//			System.out.print(person[i].X + " ");
//			System.out.print(person[i].Y + " ");
//			System.out.print(person[i].isKilled + " ");
//			System.out.print(person[i].money + " ");
//			System.out.print(person[i].crimeRate + " ");
//			System.out.println(person[i].city);
        }

    }

    public void killPerson(int i) {
        double distance_money = 0, distance_money_max = 0;
        int temp = 0;
        for (int j = 0; j < 50; j++) {
            if (j != i && person[j].isKilled != 1) {
                distance_money = Math.sqrt(Math.pow(400 - Math.sqrt(Math.pow(person[i].X - person[j].X, 2) + Math.pow(person[i].Y - person[j].Y, 2)) + Math.pow(person[j].money, 2), 2));
                if (distance_money > distance_money_max) {
                    temp = j;
                    distance_money_max = distance_money;
                }
            }
        }
        person[temp].isKilled = 1;
        System.out.println(temp);
    }

    public int[] calcPosition(int X, int Y) {
        int[] position = new int[2];
        double rand = Math.random();
        if (rand <= 0.25) {
            X += 1;
        } else if (0.25 < rand && rand <= 0.5) {
            X -= 1;
        } else if (0.5 < rand && rand <= 0.75) {
            Y += 1;
        } else if (0.75 <= rand && rand < 1) {
            Y -= 1;
        }

        if (X < 0) X = 0;
        if (Y < 0) Y = 0;
        if (X > 100) X = 400;
        if (Y > 100) Y = 400;

        position[0] = X;
        position[1] = Y;

        return position;
    }
}
