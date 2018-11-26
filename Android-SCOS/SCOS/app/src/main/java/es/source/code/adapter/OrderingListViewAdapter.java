package es.source.code.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import es.source.code.model.Food;
import xq.scos.R;


public class OrderingListViewAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<Food> list;
    private int position;
    ViewHolder holder = null;
    //private String[] nameList = {"面包","啤酒"};
    //private int[] priceList = {20,50};
    //private int[] resourceId = {R.drawable.bread,R.drawable.beer};
    public OrderingListViewAdapter(Context context, List<Food> list){
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
        public TextView tv_1,tv_2,tv_3;
        public EditText et_1;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Food food = list.get(position);
        this.position = position;
        if(convertView==null){
            convertView = mLayoutInflater.inflate(R.layout.layout_ordering_list_item,null);
            holder = new ViewHolder();
            holder.imageView = (ImageView)convertView.findViewById(R.id.layout_ordering_list_item_im_1);
            holder.tv_1 = (TextView)convertView.findViewById(R.id.layout_ordering_list_item_tv_1);
            holder.tv_2 = (TextView)convertView.findViewById(R.id.layout_ordering_list_item_tv_2);
            holder.tv_3 = (TextView)convertView.findViewById(R.id.layout_ordering_list_item_tv_3);
            holder.et_1 = (EditText)convertView.findViewById(R.id.layout_ordering_list_item_et1) ;
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder)convertView.getTag();
        }
        //给控件赋值
        holder.tv_1.setText("菜名:"+food.getName());
        holder.tv_2.setText("单价:"+food.getPrice());
        holder.tv_3.setText("数量:"+food.getCount());
        holder.imageView.setImageResource(food.getImageResourceId());
        holder.et_1.setText("");

        return convertView;
    }


}
