package es.source.code.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import es.source.code.activity.FoodView;
import es.source.code.model.Food;
import es.source.code.model.MessageEvent;
import es.source.code.util.Util;
import xq.scos.R;

import static es.source.code.model.Foods.count;
import static es.source.code.model.Foods.ordering;


public class ListViewAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    public List<Food> list;
    private ViewHolder holder = null;
    private int position;
    private Toast toast= null;

    //https://blog.csdn.net/csdn_lexli/article/details/52791422
    private long lastShowTime = 0l;
    private String lastShowMsg = null;
    private String curShowMsg = null;
    private final int TOAST_DURATION = 20000;



    //private String[] nameList = {"面包","啤酒"};
    //private int[] priceList = {20,50};
    //private int[] resourceId = {R.drawable.bread,R.drawable.beer};
    public ListViewAdapter(Context context,List<Food> list){
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.list = list;


    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }




    //重要的方法
    static class ViewHolder{

        public ImageView imageView;
        public TextView tv_1,tv_2,tv_3,tv_4;
        public Button bt_1,bt_2;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Food food = list.get(position);
        this.position = position;
        if(convertView==null){
            convertView = mLayoutInflater.inflate(R.layout.layout_list_item,null);
            holder = new ViewHolder();
            holder.imageView = (ImageView)convertView.findViewById(R.id.layout_list_item_im_1);
            holder.tv_1 = (TextView)convertView.findViewById(R.id.layout_list_item_tv_1);
            holder.tv_2 = (TextView)convertView.findViewById(R.id.layout_list_item_tv_2);
            holder.tv_3 = (TextView)convertView.findViewById(R.id.layout_list_item_tv_3);
            holder.tv_4 = (TextView)convertView.findViewById(R.id.layout_list_item_tv_4);
            holder.bt_1 = (Button)convertView.findViewById(R.id.layout_list_item_bt_1);
            holder.bt_2 = (Button)convertView.findViewById(R.id.layout_list_item_bt_2);
            convertView.setTag(holder);

        }
        else{
            holder = (ViewHolder)convertView.getTag();
        }
        //给控件赋值
        holder.tv_1.setText("菜名:"+list.get(position).getName());
        holder.tv_2.setText("单价:"+list.get(position).getPrice());
        holder.tv_3.setText("已买:"+list.get(position).getCount());
        holder.tv_4.setText("库存:"+ list.get(position).getLast());
        holder.tv_4.setTextColor(Color.BLUE);
        holder.bt_1.setText("+");
        holder.bt_2.setText("-");
        //food.setState(true);
        holder.imageView.setImageResource(food.getImageResourceId());

        final Button btn_1 = (Button) convertView.findViewById(R.id.layout_list_item_bt_1);//重点
        final Button btn_2 = (Button) convertView.findViewById(R.id.layout_list_item_bt_2);
        final TextView tv_1 = (TextView) convertView.findViewById(R.id.layout_list_item_tv_1);
        final TextView tv_2 = (TextView) convertView.findViewById(R.id.layout_list_item_tv_1);
        final TextView tv_3 = (TextView) convertView.findViewById(R.id.layout_list_item_tv_3);
        final TextView tv_4 = (TextView)convertView.findViewById(R.id.layout_list_item_tv_4);
        holder.bt_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;

                // 有库存
                if (food.isState()) {
                    //count++;

                    //Toast.makeText(mContext,"已点餐",Toast.LENGTH_SHORT).show();
                    //food.setState(false);
                    //btn_1.setText("已订购");
                    //if(food.getCount())
                    if(!food.getInlist()){
                        ordering.add(food);
                        food.addcount();
                        food.setInlist(true);
                    }
                    else{
                        Food temp = ordering.get(ordering.indexOf(food));
                        temp.setCount(temp.getCount()+1);
                        ordering.set(ordering.indexOf(food),temp);//以为菜品不一样名字，可以不考虑
                    }
                    //Toast
                    //customShowToast(mContext,"已点餐,已买:"+food.getCount());
                    Util.showToast(mContext, "已点餐,已买:"+food.getCount()+"个"+food.getName());
                    food.setLast(food.getLast()-1);
                    tv_1.setText("菜名:"+food.getName());
                    tv_2.setText("单价:"+food.getPrice());
                    tv_3.setText("已买:"+food.getCount());
                    tv_4.setText("库存:"+food.getLast());
                }

                else{

                }

            }
        });

        holder.bt_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                if(food.isState()){

                    //count--;
                    //Toast.makeText(mContext,"已取消",Toast.LENGTH_SHORT).show();
                    //food.setState(true);
                    //btn_2.setText("已取消");
                    if(food.getCount()>0||food.getInlist())
                    food.reducecount();
                    if(food.getCount()==0){
                        ordering.remove(food);
                        food.setInlist(false);
                    }
                    //Toast
                    //customShowToast(mContext,"已取消,还剩:"+food.getCount());
                    Util.showToast(mContext, "已取消,还剩:"+food.getCount()+"个"+food.getName());
                    food.setLast(food.getLast()+1);
                    tv_1.setText("菜名:"+food.getName());
                    tv_2.setText("单价:"+food.getPrice());
                    tv_3.setText("已买:"+food.getCount());
                    tv_4.setText("库存:"+food.getLast());


                }
                else{

                }

            }
        });



        return convertView;
    }



    //
    public void setcontent(View convertView,String string){
        convertView = mLayoutInflater.inflate(R.layout.layout_list_item,null);
        holder.bt_1 = (Button)convertView.findViewById(R.id.layout_list_item_bt_1);
        Toast.makeText(mContext,string,Toast.LENGTH_SHORT).show();
    }

    //https://blog.csdn.net/csdn_lexli/article/details/52791422
    private void customShowToast(Context context, CharSequence s) {
        curShowMsg = s.toString();
        long curShowTime = System.currentTimeMillis();
        if (curShowMsg.equals(lastShowMsg)) {
            if (curShowTime - lastShowTime > TOAST_DURATION) {
                Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
                lastShowTime = curShowTime;
                lastShowMsg = curShowMsg;
            }
        } else {
            Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
            lastShowTime = curShowTime;
            lastShowMsg = curShowMsg;
        }
    }






}
