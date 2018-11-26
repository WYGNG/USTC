package es.source.code.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import es.source.code.model.User;
import xq.scos.R;
import static es.source.code.model.Foods.coldfoods;
import static es.source.code.model.Foods.drinkfoods;
import static es.source.code.model.Foods.foods;
import static es.source.code.model.Foods.initfoods;
import static es.source.code.model.Foods.seafoods;
public class MainScreen extends AppCompatActivity {
    private Button mLoginButton;
    private Button mOrderButton;
    private Button mMenuButton;
    private Button mHelpButton;
    private ImageView mHomeImage;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainscreen);
        mLoginButton = (Button) findViewById(R.id.HomeLoginButton);
        mOrderButton = (Button) findViewById(R.id.HomeOrderButton);
        mMenuButton = (Button) findViewById(R.id.HomeMenuButton);
        mHelpButton = (Button) findViewById(R.id.HomeHelpButton);
        mHomeImage = (ImageView) findViewById(R.id.HomeLogo);

        Intent intent = getIntent();
        String string = intent.getStringExtra("from");

        /*if(string.isEmpty()){

        }

        if(string.equals("FromEntry")){

        }
        else{
            mOrderButton.setVisibility(View.INVISIBLE);
            mMenuButton.setVisibility(View.INVISIBLE);
        }
        if(string.equals("LoginSuccess")){
            if(mOrderButton.getVisibility()==View.INVISIBLE){
                mOrderButton.setVisibility(View.VISIBLE);
            }
            if(mMenuButton.getVisibility()==View.INVISIBLE){
                mMenuButton.setVisibility(View.VISIBLE);
            }
            user=(User)intent.getSerializableExtra("loginuser");
        }
        else if(string.equals("RegisterSuccess")) {
            if (mOrderButton.getVisibility() == View.INVISIBLE) {
                mOrderButton.setVisibility(View.VISIBLE);
            }
            if (mMenuButton.getVisibility() == View.INVISIBLE) {
                mMenuButton.setVisibility(View.VISIBLE);
            }
            user=(User)intent.getSerializableExtra("loginuser");
        }
        else{
            user = null;
        }*/
        /*SharedPreferences.Editor editor = getSharedPreferences("User",MODE_PRIVATE).edit();
        editor.putString("userName",null);
        editor.putInt("loginState",0);
        editor.commit();*/
        SharedPreferences sharedPreferences = this.getSharedPreferences("User",MODE_PRIVATE);
        int loginState = sharedPreferences.getInt("loginState",0);
        if(loginState == 0){
            mOrderButton.setVisibility(View.INVISIBLE);
            mMenuButton.setVisibility(View.INVISIBLE);
        }
        if(loginState == 1){
            if (mOrderButton.getVisibility() == View.INVISIBLE) {
                mOrderButton.setVisibility(View.VISIBLE);
            }
            if (mMenuButton.getVisibility() == View.INVISIBLE) {
                mMenuButton.setVisibility(View.VISIBLE);
            }
        }



        setListeners();






    }
    private void setListeners(){
        OnClick onClick = new OnClick();
        mLoginButton.setOnClickListener(onClick);
        mOrderButton.setOnClickListener(onClick);
        mMenuButton.setOnClickListener(onClick);
        mHelpButton.setOnClickListener(onClick);
        mHomeImage.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View view){
            Intent intent = null;
            switch (view.getId()){
                case R.id.HomeLoginButton:
                    intent = new Intent(MainScreen.this,LoginOrRegister.class);
                    intent.putExtra("from","FromMain");
                    break;
                case R.id.HomeOrderButton:

                    intent = new Intent(MainScreen.this,FoodView.class);
                    intent.putExtra("from","FromMain");
                    Bundle bundle = new Bundle();
                    break;
                case R.id.HomeMenuButton:
                    intent = new Intent(MainScreen.this,FoodOrderView.class);
                    intent.putExtra("from","FromMain");
                    break;
                case R.id.HomeHelpButton:
                    intent = new Intent(MainScreen.this,Help.class);
                    intent.putExtra("from","FromMain");
                    break;
                case R.id.HomeLogo:
                    intent = new Intent(MainScreen.this,SCOSEntry.class);
                    intent.putExtra("from","FromMain");
                    break;


            }
            startActivity(intent);

        }

    }

}
