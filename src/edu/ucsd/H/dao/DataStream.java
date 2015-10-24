package edu.ucsd.H.dao;

import edu.ucsd.H.entity.PersonInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shuaiqi.xsq, 15/10/23
 */
public class DataStream {
    public static void writeLog(List<String> logList) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("/Users/natsushuaiqi/IdeaProjects/Biyouwoshi/H/data/log.txt")));

            if (logList != null) {
                for (String log : logList) {
                    bufferedWriter.write(log);
                    bufferedWriter.newLine();
                }
            }

            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readLog() {
        List<String> logList = new ArrayList<String>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/Users/natsushuaiqi/IdeaProjects/Biyouwoshi/H/data/log.txt")));

            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                logList.add(line);
            }

            return logList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void writeData(List<PersonInfo> personInfoList) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("/Users/natsushuaiqi/IdeaProjects/Biyouwoshi/H/data/data.txt")));

            if (personInfoList != null) {
                for (PersonInfo personInfo : personInfoList) {
                    bufferedWriter.write(personInfo.getName() + "*" + personInfo.getStatus() + "*" +
                            personInfo.getCity() + "*" + personInfo.getX() + "*" + personInfo.getY() + "*" + personInfo.getMoney());
                    bufferedWriter.newLine();
                }
            }

            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<PersonInfo> readData() {
        List<PersonInfo> personInfoList = new ArrayList<PersonInfo>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/Users/natsushuaiqi/IdeaProjects/Biyouwoshi/H/data/data.txt")));

            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split("\\*");
                if (temp != null && temp.length == 6) {
                    personInfoList.add(new PersonInfo(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]));
                }
            }

            return personInfoList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
