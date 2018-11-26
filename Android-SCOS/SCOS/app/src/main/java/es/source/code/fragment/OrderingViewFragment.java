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
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import es.source.code.activity.FoodView;
import es.source.code.adapter.ListViewAdapter;
import es.source.code.adapter.OrderedListViewAdapter;
import es.source.code.adapter.OrderingListViewAdapter;
import es.source.code.model.Food;
import xq.scos.R;

import static es.source.code.fragment.OrderedViewFragment.getOrderListViewAdapter;
import static es.source.code.model.Foods.ordered;
import static es.source.code.model.Foods.ordering;
public class OrderingViewFragment extends Fragment {
    private ListView mListView;
    private OrderingListViewAdapter orderingListViewAdapter;
    private OrderedListViewAdapter orderedListViewAdapter;
    private Activity activity;
    private List<Food> foods = new ArrayList<>();

    public OrderingViewFragment(){
        //initFoods();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout_fragment_ordering_view, container,false);

        mListView = (ListView)view.findViewById(R.id.ordering_view_fragment);
        orderingListViewAdapter = new OrderingListViewAdapter(getActivity(),foods);

        mListView.setAdapter(orderingListViewAdapter);
        Button button = (Button) view.findViewById(R.id.ordering_view_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"提交订单",Toast.LENGTH_SHORT).show();
                ordered.addAll(ordering);
                ordering.clear();
                orderingListViewAdapter.notifyDataSetChanged();
                orderedListViewAdapter = getOrderListViewAdapter();
                orderedListViewAdapter.notifyDataSetChanged();
            }
        });
        Button button_cancle = (Button) view.findViewById(R.id.ordering_view_button_cancle);
        button_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"取消订单",Toast.LENGTH_SHORT).show();

                //ordered.addAll(ordering);
                for(int i = 0; i < ordering.size();i++){
                    ordering.get(i).setInlist(false);
                    ordering.get(i).setCount(0);
                    ordering.get(i).setState(true);
                }
                ordering.clear();
                orderingListViewAdapter.notifyDataSetChanged();
                Intent intent = new Intent(getContext(),FoodView.class);
                startActivity(intent);
                //orderedListViewAdapter = getOrderListViewAdapter();
                //orderedListViewAdapter.notifyDataSetChanged();
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
        //foods.add(new Food("",0,R.drawable.wine));

    }


}

