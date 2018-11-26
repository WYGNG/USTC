package es.source.code.fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import es.source.code.activity.FoodView;
import es.source.code.activity.Help;
import es.source.code.activity.MainScreen;
import es.source.code.activity.SCOSEntry;
import es.source.code.adapter.ListViewAdapter;
import es.source.code.adapter.OrderedListViewAdapter;
import es.source.code.adapter.OrderingListViewAdapter;
import es.source.code.model.Food;
import xq.scos.R;

import static es.source.code.model.Foods.ordered;
import static es.source.code.model.Foods.ordering;

public class OrderedViewFragment extends Fragment {
    private ListView mListView;
    private static OrderedListViewAdapter orderedListViewAdapter;
    private Activity activity;
    private List<Food> foods = new ArrayList<>();
    private ProgressDialog progressDialog;
    private Button button = null;
    private Button button_cancle = null;
    private ProgressBar progressBar = null;
    private TextView textView = null;
    private View view;
    private int count=0;
    private final static int STOP=0x10000;
    private final static int NEXT=0x10001;


    public OrderedViewFragment(){

    }

    public static OrderedListViewAdapter getOrderListViewAdapter(){
        return  orderedListViewAdapter;

    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_fragment_ordered_view, container,false);

        mListView = (ListView)view.findViewById(R.id.ordered_view_fragment);
        orderedListViewAdapter = new OrderedListViewAdapter(getActivity(),foods);
        mListView.setAdapter(orderedListViewAdapter);
        button = (Button) view.findViewById(R.id.ordered_view_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getContext(),"请结账",Toast.LENGTH_SHORT);
                //
                MyAsyncTask myAsyncTask = new MyAsyncTask();
                myAsyncTask.execute();

            }
        });


        button_cancle = (Button) view.findViewById(R.id.ordered_view_button_cancle);
        button_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                for(int i = 0; i < ordered.size();i++){
                    ordered.get(i).setInlist(false);
                    ordered.get(i).setCount(0);
                    ordered.get(i).setState(true);
                }
                ordered.clear();
                Toast.makeText(getActivity(),"已取消",Toast.LENGTH_SHORT).show();

                orderedListViewAdapter.notifyDataSetChanged();
                //Intent intent = new Intent(getContext(),SCOSEntry.class);
                //startActivity(intent);

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
    private class MyAsyncTask extends AsyncTask<String, Object, Boolean>{
        @Override
        protected void onPreExecute() {
            //showProgress("结账中...");
            progressBar = view.findViewById(R.id.progressBar);
            progressBar.setVisibility(View.VISIBLE);
            progressBar.setMax(100);
            progressBar.setProgress(0);
            textView = view.findViewById(R.id.progress_text);
            textView.setVisibility(View.VISIBLE);



        }



        @Override
        protected Boolean doInBackground(String... strings) {
            Thread t = new Thread(new Runnable(){
                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    for(int i=0;i<20;i++){
                        try {
                            count=(i+1)*5;
                            Thread.sleep(300);
                            textView.setText(count+"%");
                            if(count==100){
                                Message msg=new Message();
                                msg.what=STOP;

                                handler.sendMessage(msg);
                                break;
                            }
                            else{
                                Message msg=new Message();
                                msg.what=NEXT;
                                handler.sendMessage(msg);
                            }
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }

                }
            });
            t.start();

            return null;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {

            ordered.clear();
            orderedListViewAdapter.notifyDataSetChanged();

            button.setClickable(false);


            super.onPostExecute(aBoolean);

        }

        @Override
        protected void onProgressUpdate(Object... values) {


            super.onProgressUpdate(values);
        }
    }



    public void showProgress(String messageRes) {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle(getResources().getString(R.string.app_name));
        progressDialog.setMessage(messageRes);
        progressDialog.setCancelable(false);
        progressDialog.show();

    }
    private Handler handler=new Handler(){
        @SuppressWarnings("static-access")
        public void handleMessage(Message msg){
            switch(msg.what){
                case STOP:
                    progressBar.setVisibility(View.GONE);
                    Thread.currentThread().interrupt();
                    progressBar = view.findViewById(R.id.progressBar);
                    progressBar.setVisibility(View.INVISIBLE);
                    textView = view.findViewById(R.id.progress_text);
                    textView.setVisibility(View.INVISIBLE);
                    Toast.makeText(getContext(),"已结账",Toast.LENGTH_SHORT).show();
                    break;
                case NEXT:
                    if(!Thread.currentThread().interrupted()){
                        progressBar.setProgress(count);
                    }
                    break;
            }
        }
    };

}



