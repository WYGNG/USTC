package es.source.code.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import es.source.code.activity.FoodDetailed;
import es.source.code.adapter.ListViewAdapter;
import es.source.code.model.Food;
import xq.scos.R;

public class FoodViewDetialFragment extends Fragment {

    private ImageView imageView;
    private TextView textView;
    private EditText editText;
    private List<Food> foods = new ArrayList<>();

    private Food food = new Food(null,0,0,0);
    public FoodViewDetialFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.recycle_view_item, container,false);
        Intent intent = getActivity().getIntent();
        imageView = view.findViewById(R.id.iv_1);
        imageView.setImageResource(intent.getExtras().getInt("id"));
        textView = view.findViewById(R.id.tv_1);
        textView.setText(intent.getExtras().getString("name"));
        editText = view.findViewById(R.id.ev_1);
        editText.setText("描述还没有想好~");
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public void initFoods(List<Food> foods){

        this.foods = foods;

    }
    public void setfood(Food food){

    }


}

