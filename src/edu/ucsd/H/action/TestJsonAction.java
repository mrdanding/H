package edu.ucsd.H.action;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shuaiqi.xsq, 15/10/23
 */
public class TestJsonAction extends BaseAction {
    private class Person{
        private String name;
        private int age;

        public Person(String name, int age){
            this.name = name;
            this.age = age;
        }

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
    }

    public String getString(){
        Person person = new Person("xia", 10);
        return JSON.toJSONString(person);
    }

    public void getJson() throws IOException {
        System.out.println("request happens");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        //response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        //JSON在传递过程中是普通字符串形式传递的，这里简单拼接一个做测试
        Person person = new Person("xia", 10);
        Person person1 = new Person("Jiang", 9);
        List<Person> list = new ArrayList<Person>();
        list.add(person);
        list.add(person1);

        String jsonString = JSON.toJSONString(list);
        out.println(jsonString);
        out.flush();
        out.close();
    }
}
