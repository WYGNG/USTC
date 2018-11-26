package esd.scos.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.AudioFormat;
import java.io.IOException;
import java.util.regex.Pattern;

import net.sf.json.JSONObject;

@WebServlet(name = "LoginValidator")
public class LoginValidator extends HttpServlet {
    private static final Pattern pattern = Pattern.compile("^[A-Za-z1-9_-]+$");


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        String name="";
        String password = "";
        name = request.getParameter("name");
        password = request.getParameter("password");

        String result = "";
        //模拟数据库获取数据并判断
        if (startValid(name,password)) {
            result="success";
        }else{
            result = "error";
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", result);
        response.getWriter().print(jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    private boolean startValid(String name,String password) {
        return pattern.matcher(name.trim()).matches() && pattern.matcher(password.trim()).matches();
    }
}
