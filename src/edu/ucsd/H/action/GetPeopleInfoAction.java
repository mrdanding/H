package edu.ucsd.H.action;

import com.alibaba.fastjson.JSON;
import edu.ucsd.H.dao.DataStream;
import edu.ucsd.H.entity.PersonInfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shuaiqi.xsq, 15/10/23
 */
public class GetPeopleInfoAction extends BaseAction {
    public void getPeopleInfoAction() throws IOException {
        System.out.println("request happens");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        //response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        List<PersonInfo> personInfoList = DataStream.readData();
        List<String> logs = new ArrayList<String>();

        // connect
        for (int i = 0; i < 100; i++) {
            if (Math.random() < 0.10) {
                System.out.println("kill will happen !!!!!!!");
                if (personInfoList.get(i).getStatus().equals("1")) {
                    personInfoList.get(i).setStatus("0");

                    int rdm = (int) (Math.random() * 100);
                    while (personInfoList.get(rdm).getStatus().equals("0") || rdm == i) {
                        rdm = (int) (Math.random() * 100);
                    }

                    if (Math.random() < 0.3) {
                        logs.add(personInfoList.get(i).getName() + " is killed by tornado and lost $" + personInfoList.get(i).getMoney());
                        personInfoList.get(i).setMoney("0");
                    } else {
                        int temp = Integer.parseInt(personInfoList.get(i).getMoney()) + Integer.parseInt(personInfoList.get(rdm).getMoney());
                        personInfoList.get(rdm).setMoney("" + temp);
                        logs.add(personInfoList.get(i).getName() + " is killed by " + personInfoList.get(rdm).getName() + ", and lost $" + personInfoList.get(i).getMoney());
                        personInfoList.get(i).setMoney("0");
                    }
                }
            }
        }

        System.out.println(personInfoList.size() + "!!!!!");

        DataStream.writeData(personInfoList);
        DataStream.writeLog(logs);
        String jsonString = JSON.toJSONString(personInfoList);
        out.println(jsonString);
        out.flush();
        out.close();
    }
}
