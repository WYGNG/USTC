package es.source.code.activity;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import net.sf.json.*;

import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import es.source.code.http.MyPOSTHttpURLConnection;
import es.source.code.model.User;
import xq.scos.R;

import static android.content.Context.MODE_PRIVATE;
import static es.source.code.model.Foods.coldfoods;
import static es.source.code.model.Foods.drinkfoods;
import static es.source.code.model.Foods.foods;
import static es.source.code.model.Foods.seafoods;
import static java.net.Proxy.Type.HTTP;

public class LoginOrRegister extends AppCompatActivity {
    private Context context;
    private EditText etName;
    private EditText etPassword;
    private Button mButton_Enter;
    private Button mButton_Login;
    private Button mButton_Return;
    private ProgressDialog progressDialog;
    private static final Pattern pattern = Pattern.compile("^[A-Za-z1-9_-]+$");
    private final int progress = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginorregister);
        mButton_Enter = (Button)findViewById(R.id.enterButton);
        mButton_Login = (Button)findViewById(R.id.loginButton);
        mButton_Return = (Button)findViewById(R.id.returnButton);
        etName = (EditText)findViewById(R.id.userName);
        etPassword = (EditText)findViewById(R.id.userPassword);
        setListeners();

        SharedPreferences sharedPreferences = this.getSharedPreferences("User",MODE_PRIVATE);
        int loginState = sharedPreferences.getInt("loginState",0);
        if(loginState == 0){
            mButton_Enter.setVisibility(View.INVISIBLE);
        }
        else{
            mButton_Login.setVisibility(View.VISIBLE);
        }

    }

    private void setListeners(){
        OnClick onClick = new OnClick();
        mButton_Enter.setOnClickListener(onClick);
        mButton_Login.setOnClickListener(onClick);
        mButton_Return.setOnClickListener(onClick);

    }
    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View view){

            final User loginUser = new User();
            Intent intent = null;
            final SharedPreferences.Editor editor = getSharedPreferences("User",MODE_PRIVATE).edit();
            Thread thread = null;
            switch (view.getId()){
                case R.id.loginButton:
                    showProgress(R.string.registering);

                    thread = new Thread(new Runnable() {
                        @Override
                        public void run() {

                            //sendJson();
                            String url = MyPOSTHttpURLConnection.BASE_URL + "/LoginValidator";
                            Map<String,String > parms = new HashMap<String, String>();
                            String name = etName.getText().toString();
                            String password = etPassword.getText().toString();
                            parms.put("name",name);
                            parms.put("password",password);


                            String result = MyPOSTHttpURLConnection.getContextByHttp(url,parms);
                            Log.d("result",result);


                            Message msg = new Message();
                            msg.what = 0x12;
                            Bundle data = new Bundle();

                            data.putString("result",result);
                            msg.setData(data);

                            handler.sendMessage(msg);
                        }


                        Handler handler = new Handler(){
                            @Override
                            public void handleMessage(Message msg) {
                                if(msg.what==0x12){
                                    Bundle data = msg.getData();
                                    String key = data.getString("result");
                                    Log.d("key",key);
                                    try{
                                        JSONObject json = new JSONObject(key);
                                        String result = (String)json.get("result");
                                        if(result.equals("success")){
                                            mButton_Enter.setVisibility(View.VISIBLE);
                                            mButton_Login.setVisibility(View.INVISIBLE);
                                            loginUser.setOldUser(false);
                                            loginUser.setUserName(etName.getText().toString());
                                            loginUser.setPassword(etPassword.getText().toString());
                                            Toast.makeText(LoginOrRegister.this,"欢迎您成为 SCOS 新用户",Toast.LENGTH_SHORT).show();
                                            //intent = new Intent(LoginOrRegister.this,MainScreen.class);
                                            //intent.putExtra("from","RegisterSuccess");



                                            String string = mButton_Enter.getText().toString();
                                            editor.putString("userName",string);
                                            editor.putInt("loginState",1);
                                            editor.commit();
                                            Toast.makeText(LoginOrRegister.this,"注册成功",Toast.LENGTH_LONG).show();
                                        }
                                        else{
                                            Toast.makeText(LoginOrRegister.this,"输入内容不符合规则",Toast.LENGTH_SHORT).show();
                                            //Toast.makeText(LoginOrRegister.this,"注册失败",Toast.LENGTH_LONG).show();
                                        }


                                    }
                                    catch (Exception e){
                                        e.printStackTrace();
                                    }
                                }
                            }
                        };


                    });

                    thread.start();



                    /*
                    if(startValid()) {

                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                //spandTimeMethod();// 耗时的方法
                                handler.sendEmptyMessage(0);// 执行耗时的方法之后发送消给handler
                            }

                        }).start();
                        mButton_Enter.setVisibility(View.VISIBLE);
                        mButton_Login.setVisibility(View.INVISIBLE);
                        loginUser.setOldUser(false);
                        loginUser.setUserName(etName.getText().toString());
                        loginUser.setPassword(etPassword.getText().toString());
                        Toast.makeText(LoginOrRegister.this,"欢迎您成为 SCOS 新用户",Toast.LENGTH_SHORT).show();
                        //intent = new Intent(LoginOrRegister.this,MainScreen.class);
                        //intent.putExtra("from","RegisterSuccess");



                        String string = mButton_Enter.getText().toString();
                        editor.putString("userName",string);
                        editor.putInt("loginState",1);
                        editor.commit();

                    }
                    else{

                        Toast.makeText(LoginOrRegister.this,"输入内容不符合规则",Toast.LENGTH_SHORT).show();
                        //intent = new Intent(LoginOrRegister.this,MainScreen.class);
                        //intent.putExtra("from","LoginFail");dismissProgress();
                    }*/
                    dismissProgress();
                    break;
                case R.id.enterButton:
                    showProgress(R.string.logining);



                    thread = new Thread(new Runnable() {
                        @Override
                        public void run() {

                            //sendJson();
                            String url = MyPOSTHttpURLConnection.BASE_URL + "/LoginValidator";
                            Map<String,String > parms = new HashMap<String, String>();
                            String name = etName.getText().toString();
                            String password = etPassword.getText().toString();
                            parms.put("name",name);
                            parms.put("password",password);
                            String result = MyPOSTHttpURLConnection.getContextByHttp(url,parms);
                            Log.d("result",result);
                            Message msg = new Message();
                            msg.what = 0x11;
                            Bundle data = new Bundle();
                            data.putString("result",result);
                            msg.setData(data);

                            handler.sendMessage(msg);
                        }


                        Handler handler = new Handler(){
                            @Override
                            public void handleMessage(Message msg) {
                                if(msg.what==0x11){
                                    Bundle data = msg.getData();
                                    String key = data.getString("result");
                                    Log.d("key",key);
                                    try{
                                        JSONObject json = new JSONObject(key);
                                        String result = (String)json.get("result");
                                        if(result.equals("success")){
                                            loginUser.setOldUser(true);
                                            loginUser.setUserName(etName.getText().toString());
                                            loginUser.setPassword(etPassword.getText().toString());
                                            Toast.makeText(LoginOrRegister.this,"已登录",Toast.LENGTH_SHORT).show();
                                            //
                                            String string = mButton_Enter.getText().toString();
                                            editor.putString("userName",string);
                                            editor.putInt("loginState",1);
                                            editor.commit();

                                            Intent intent = new Intent(LoginOrRegister.this,MainScreen.class);
                                            //intent.putExtra("from","LoginSuccess");
                                            startActivity(intent);
                                            Toast.makeText(LoginOrRegister.this,"登录成功",Toast.LENGTH_LONG).show();
                                        }
                                        else{
                                            Toast.makeText(LoginOrRegister.this,"输入内容不符合规则",Toast.LENGTH_SHORT).show();
                                            //Toast.makeText(LoginOrRegister.this,"登录失败",Toast.LENGTH_LONG).show();
                                        }


                                    }
                                    catch (Exception e){
                                        e.printStackTrace();
                                    }
                                }
                            }
                        };


                    });

                    thread.start();





                    /* 开启一个新线程，在新线程里执行耗时的方法 */


                    /*

                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            spandTimeMethod();// 耗时的方法
                            handler.sendEmptyMessage(0);// 执行耗时的方法之后发送消给handler
                        }

                    }).start();
                    if(startValid()){

                        loginUser.setOldUser(true);
                        loginUser.setUserName(etName.getText().toString());
                        loginUser.setPassword(etPassword.getText().toString());
                        Toast.makeText(LoginOrRegister.this,"已登录",Toast.LENGTH_SHORT).show();
                        //
                        String string = mButton_Enter.getText().toString();
                        editor.putString("userName",string);
                        editor.putInt("loginState",1);
                        editor.commit();
                        Intent intent;
                        intent = new Intent(LoginOrRegister.this,MainScreen.class);
                        //intent.putExtra("from","LoginSuccess");
                        startActivity(intent);


                    }
                    else{
                        Toast.makeText(LoginOrRegister.this,"输入内容不符合规则",Toast.LENGTH_SHORT).show();
                        //intent = new Intent(LoginOrRegister.this,MainScreen.class);
                        //intent.putExtra("from","LoginFail");

                    }

                    */
                    dismissProgress();
                    break;


                case R.id.returnButton:
                    String string = mButton_Enter.getText().toString();
                    editor.putString("userName",string);
                    editor.putInt("loginState",0);
                    editor.commit();
                    intent = new Intent(LoginOrRegister.this,MainScreen.class);
                    startActivity(intent);
                    break;

            }

            //Intent intent_User = new Intent(LoginOrRegister.this,MainScreen.class);
            //Bundle bundle = new Bundle();
            //bundle.putSerializable("loginuser",loginUser);
            //intent.putExtras(bundle);
            //startActivity(intent_User);




        }

    }

    private boolean startValid() {
        return pattern.matcher(etName.getText().toString().trim()).matches() && pattern.matcher(etPassword.getText()
                .toString().trim()).matches();
    }

    public void showProgress(int messageRes) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle(getResources().getString(R.string.app_name));
        progressDialog.setMessage(getResources().getString(messageRes));
        progressDialog.setCancelable(false);
        progressDialog.show();

    }
    public void dismissProgress() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
    public void spandTimeMethod() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {// handler接收到消息后就会执行此方法
            dismissProgress();// 关闭ProgressDialog
        }
    };


    private void sendJson(){
        //boolean loginValidate = false;
        Log.d("url","成功");



        try{
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name",etName.getText().toString());
            jsonObject.put("password",etPassword.getText().toString());
            URL url = new URL("http://192.168.1.144:8080");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Charset", "UTF-8");
            conn.setRequestProperty("contentType", "application/json");

            //urlConnection.setRequestProperty("accept","*/*");
            //urlConnection.setRequestProperty("connection","Keep-Alive");
            conn.connect();
            OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
            // 发送给服务器
            writer.write(jsonObject.toString());
            writer.flush();
            writer.close();
            //接收服务器返回信息
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8")) ;
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            int RESULTCODE = 0;
                RESULTCODE = sb.toString().indexOf("RESULTCODE");

            if(RESULTCODE == 1){
                Log.d("RESULTCODE",RESULTCODE+"");
            }
            else if(RESULTCODE == 0){
                Log.d("RESULTCODE",RESULTCODE+"");
            }
            else{
                Log.d("RESULTCODE","no");
            }
            conn.disconnect();

            /*
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(urlConnection.getOutputStream()));
            printWriter.print(etName.getText().toString());
            printWriter.print(etPassword.getText().toString());
            printWriter.flush();

            //向服务器写json
            jsonObject.put("name",etName.getText().toString());
            jsonObject.put("password",etPassword.getText().toString());
            final String content = String.valueOf(jsonObject);

            OutputStream os = urlConnection.getOutputStream();
            os.write(content.getBytes());
            os.close();
            */

        }catch(Exception exception){
            exception.printStackTrace();
        }


    }

    public String JSONTokener(String in) {
        // consume an optional byte order mark (BOM) if it exists
        if (in != null && in.startsWith("\ufeff")) {
            in = in.substring(1);
        }
        return in;
    }



}
