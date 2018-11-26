package es.source.code.model;

import java.util.ArrayList;
import java.util.List;

import xq.scos.R;

public class Foods {

    public static int count = 0;
    public static List<Food> foods = new ArrayList<>();
    public static List<Food> coldfoods = new ArrayList<>();
    public static List<Food> drinkfoods = new ArrayList<>();
    public static List<Food> seafoods = new ArrayList<>();
    public static List<Food> ordered = new ArrayList<>();
    public static List<Food> ordering = new ArrayList<>();
    public static void initfoods(List<Food> foods, int i){
        if(i==0){
            foods.add(new Food("东北家拌凉菜",10,R.drawable.food_cold_dbjlbc,10));
            foods.add(new Food("椒油素鸡",12,R.drawable.food_cold_jysj,10));
            foods.add(new Food("浇汁豆腐",13,R.drawable.food_cold_jzdf,10));
            foods.add(new Food("开胃泡菜",15,R.drawable.food_cold_kwpc,10));
            foods.add(new Food("凉拌海带丝",15,R.drawable.food_cold_lbhds,10));
            foods.add(new Food("凉拌黄瓜",13,R.drawable.food_cold_lbhg,10));
            foods.add(new Food("卤牛肉",13,R.drawable.food_cold_lnr,10));
            foods.add(new Food("青椒拌干丝",13,R.drawable.food_cold_qjbgs,10));

        }
        else if(i==1){
            foods.add(new Food("干煸豆角",30,R.drawable.food_hot_gbdj,10));
            foods.add(new Food("宫保鸡丁",32,R.drawable.food_hot_gbjd,10));
            foods.add(new Food("红烧茄子",40,R.drawable.food_hot_hsqz,10));
            foods.add(new Food("红烧肉",56,R.drawable.food_hot_hsr,10));
            foods.add(new Food("红烧鱼",56,R.drawable.food_hot_hsy,10));
            foods.add(new Food("可乐鸡翅",30,R.drawable.food_hot_kljc,10));
            foods.add(new Food("麻婆豆腐",32,R.drawable.food_hot_mpdf,10));
            foods.add(new Food("羊肉汤",40,R.drawable.food_hot_yrt,10));
            foods.add(new Food("孜然羊肉",56,R.drawable.food_hot_zryr,10));

        }
        else if(i==2){
            foods.add(new Food("大虾两吃",50,R.drawable.food_sea_dxlc,10));
            foods.add(new Food("海螺炒韭菜",80,R.drawable.food_sea_hlcjc,10));
            foods.add(new Food("海鲜汤",90,R.drawable.food_sea_hxt,10));
            foods.add(new Food("节瓜章鱼鸡脚汤",120,R.drawable.food_sea_jgzyjjt,10));
            foods.add(new Food("麻辣小龙虾",50,R.drawable.food_sea_mlxlx,10));
            foods.add(new Food("啤酒海螺",80,R.drawable.food_sea_pjhl,10));
            foods.add(new Food("清炒虾仁",90,R.drawable.food_sea_qcxr,10));
            foods.add(new Food("清蒸梭子蟹",120,R.drawable.food_sea_qzszx,10));
            foods.add(new Food("水蟹冬瓜汤",50,R.drawable.food_sea_sxdgt,10));
        }
        else if(i==3){
            foods.add(new Food("百香多多",10,R.drawable.food_drink_bxdd,10));
            foods.add(new Food("草莓香蕉奶昔",12,R.drawable.food_drink_cmxjnx,10));
            foods.add(new Food("红茶",15,R.drawable.food_drink_hc,10));
            foods.add(new Food("红枣核桃山药饮",66,R.drawable.food_drink_hzhtsyy,10));
            foods.add(new Food("玫瑰情人露",66,R.drawable.food_drink_mgqrl,10));

        }



    }

}
