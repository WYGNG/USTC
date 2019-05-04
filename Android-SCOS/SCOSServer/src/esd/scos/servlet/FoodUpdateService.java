package esd.scos.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FoodUpdateService")
public class FoodUpdateService extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        JSONArray jsonArray = new JSONArray();


        jsonArray.add(updateFoods("东北家拌凉菜",10,10,"冷菜"));
        jsonArray.add(updateFoods("椒油素鸡",20,10,"冷菜"));
        jsonArray.add(updateFoods("浇汁豆腐",30,10,"冷菜"));
        jsonArray.add(updateFoods("开胃泡菜",40,10,"冷菜"));
        jsonArray.add(updateFoods("凉拌海带丝",50,10,"冷菜"));
        jsonArray.add(updateFoods("凉拌黄瓜",60,10,"冷菜"));
        jsonArray.add(updateFoods("卤牛肉",70,10,"冷菜"));
        jsonArray.add(updateFoods("青椒拌干丝",80,10,"冷菜"));

        jsonArray.add(updateFoods("干煸豆角",0,10,"热菜"));








        response.getWriter().print(jsonArray);
    }
    private JSONObject updateFoods(String name,int last,int price, String category){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("last",last);
        jsonObject.put("price",price);
        jsonObject.put("category",category);
        return jsonObject;
    }
}
