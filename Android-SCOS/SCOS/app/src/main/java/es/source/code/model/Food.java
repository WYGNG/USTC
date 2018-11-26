package es.source.code.model;

import android.widget.Button;

import es.source.code.fragment.SeaFoodViewFragment;
import xq.scos.R;

public class Food extends Object{
    private String name;
    private int price;
    private int imageResourceId;
    private int count;
    private boolean state;
    private boolean inlist;
    private int last;
    /*public static final Food [] foods = {
            new Food("1",10, R.drawable.beer),
        new Food("2",10,R.drawable.bread)
    };*/

    public Food(String name, int price,int imageResourceId,int last) {
        this.name = name;
        this.price = price;
        this.imageResourceId = imageResourceId;
        this.count = 0;
        this.state = true;
        this.inlist = false;
        this.last = last;


    }
    public int addcount(){
        this.count++;
        return this.count;
    }
    public int reducecount(){
        this.count--;
        return this.count;
    }

    public boolean getInlist() {
        return inlist;
    }

    public void setInlist(boolean inlist) {
        this.inlist = inlist;
    }

    public int getPrice(){
        return price;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public boolean isState() {
        return state;
    }

    public int getCount() {
        return count;
    }

    public int getLast() {
        return last;
    }

    public void setName(String name){
        this.name = name;
    }


    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public void initFood() {
        this.name = "";
        this.price = 0;
        this.imageResourceId = 0;
        this.count = 0;
        this.state = true;
        this.inlist = false;

    }

    public void setLast(int last) {
        this.last = last;
    }
}
