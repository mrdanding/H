package edu.ucsd.H.action;

import com.alibaba.fastjson.JSON;
import edu.ucsd.H.dao.DataStream;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author shuaiqi.xsq, 15/10/23
 */
public class GetLogAction extends BaseAction {
    public void getLogInfoAction() throws IOException {
        System.out.println("request happens");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        //response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        List<String> logs = DataStream.readLog();

        // connect

        System.out.println("read logs");

        String jsonString = JSON.toJSONString(logs);
        out.println(jsonString);
        out.flush();
        out.close();
    }
}
