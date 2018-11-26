package es.source.code.fragment;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import es.source.code.activity.FoodDetailed;
import es.source.code.adapter.ListViewAdapter;
import es.source.code.model.Food;
import es.source.code.model.Foods;
import xq.scos.R;

public class FoodViewFragment extends Fragment {
    private ListView mListView;
    private ListViewAdapter mListViewAdapter;
    private Activity activity;
    private List<Food> foods = new ArrayList<>();
    public static ListViewAdapter listViewAdapter = null;
    public FoodViewFragment(){

    }


    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout_fragment_food_view, container,false);
        mListView = (ListView)view.findViewById(R.id.food_view_fragment);
        listViewAdapter = new ListViewAdapter(getActivity(),foods);
        mListView.setAdapter(listViewAdapter );
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putString("name",foods.get(position).getName());
                bundle.putInt("id",foods.get(position).getImageResourceId());
               // bundle.putInt("price",foods.get(position).getPrice());
                Intent intent = new Intent(getActivity(),FoodDetailed.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

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


}

