package edu.ucsd.H.entity;

/**
 * @author shuaiqi.xsq, 15/10/23
 */
public class PersonInfo {
    private String name;
    private String status;
    private String city;
    private String x;
    private String y;

    private String money;

    public PersonInfo() {

    }
    public PersonInfo(String name, String status, String city, String x, String y, String money) {
        this.name = name;
        this.status = status;
        this.city = city;
        this.x = x;
        this.y = y;
        this.money = money;
    }


    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}