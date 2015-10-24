package edu.ucsd.H;

import com.alibaba.fastjson.JSON;
import edu.ucsd.H.dao.DataStream;
import edu.ucsd.H.entity.PersonInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author shuaiqi.xsq, 15/10/23
 */
public class Test {
    public void testWriteData() {
        List<PersonInfo> personInfoList = new ArrayList<PersonInfo>();

        for (int i = 0; i < 50; i++) {
            PersonInfo temp = new PersonInfo();
            temp.setName("" + (i + 1));
            temp.setStatus("1");
            temp.setCity("0");
            int money = (int) (40000 + Math.random() * 20000);
            temp.setMoney("" + money);
            temp.setX("" + (int)(Math.random() * 400));
            temp.setY("" + (int)(Math.random() * 400));

            personInfoList.add(temp);
        }

        for (int i = 0; i < 50; i++) {
            PersonInfo temp = new PersonInfo();
            temp.setName("" + (i + 1));
            temp.setStatus("1");
            temp.setCity("1");
            int money = (int) (40000 + Math.random() * 20000);
            temp.setMoney("" + money);
            temp.setX("" + (int)(Math.random() * 400));
            temp.setY("" + (int)(Math.random() * 400));

            personInfoList.add(temp);
        }

        DataStream.writeData(personInfoList);
    }

    public void testMonitor() {
        List<PersonInfo> personInfoList = DataStream.readData();
        List<String> logs = new ArrayList<String>();
        System.out.println(personInfoList.size() + "!!!!!");

        // connect
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            if (Math.random() < 0.15) {
                if (personInfoList.get(i).getStatus().equals("1")) {
                    personInfoList.get(i).setStatus("0");

                    int rdm = (int) (Math.random() * 100);

                    if (Math.random() < 0.3) {
                        logs.add(personInfoList.get(i).getName() + " is killed by tornado and lost $" + personInfoList.get(i).getMoney());
                        personInfoList.get(i).setMoney("0");
                    } else {
                        while (personInfoList.get(rdm).getStatus().equals("0") || rdm == i) {
                            rdm = (int) (Math.random() * 100);
                        }
                        personInfoList.get(rdm).setMoney("" + (Integer.parseInt(personInfoList.get(i).getMoney()) + Integer.parseInt(personInfoList.get(rdm).getMoney())));
                        logs.add(personInfoList.get(i).getName() + " is killed by " + personInfoList.get(rdm).getName() + ", and lost $" + personInfoList.get(i).getMoney());
                        personInfoList.get(i).setMoney("0");
                    }
                }
            }
        }

        System.out.println(personInfoList.size() + "!!!!!");
        DataStream.writeData(personInfoList);
        String jsonString = JSON.toJSONString(personInfoList);
    }

    public void testWriteLog() {
        List<String> logs = new ArrayList<String>();
        logs.add("111");
        logs.add("222");

        DataStream.writeLog(logs);
    }

    public void testReadLog() {
        List<String> logs = DataStream.readLog();

        System.out.println(logs.toString());
    }

    public static void main(String[] args) {
//        new Test().testWriteLog();
//        new Test().testReadLog();
//        new Test().testMonitor();
        new Test().testWriteData();
//        new Test().testMonitor();
    }
}
