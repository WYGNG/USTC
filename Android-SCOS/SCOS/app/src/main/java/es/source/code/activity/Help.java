package es.source.code.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.source.code.model.MailSenderInfo;
import es.source.code.model.SimpleMailSender;
import xq.scos.R;

public class Help extends AppCompatActivity {
    private GridView gridView;
    private List<Map<String, Object>> dataList;
    private SimpleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);

        gridView = (GridView) findViewById(R.id.gridview);
        initData();

        String[] from={"img","text"};

        int[] to={R.id.grid_view_image,R.id.grid_view_textview};

        adapter=new SimpleAdapter(this, dataList, R.layout.layout_grid_view_item, from, to);

        gridView.setAdapter(adapter);
        gridView.setNumColumns(2);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            Intent intent = null;
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long arg3) {
                switch(position){
                    case 0:
                        //协议
                        Toast.makeText(Help.this,"by冰水鉴心",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        //关于
                        Toast.makeText(Help.this,"SCOS点餐系统",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        //电话
                        intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+5554));
                        startActivity(intent);
                        break;
                    case 3:
                        //短信

                        /*String phone = "5554";
                        String context = "test scos help";
                        SmsManager manager = SmsManager.getDefault();
                        ArrayList<String> list = manager.divideMessage(context);  //因为一条短信有字数限制，因此要将长短信拆分
                        for(String text:list){
                            manager.sendTextMessage(phone, null, text, null, null);
                        }
                        Toast.makeText(getApplicationContext(), "发送完毕", Toast.LENGTH_SHORT).show();
                        */
                        String tel = "5554";
                        String content = "test scos help";
                        if (PhoneNumberUtils.isGlobalPhoneNumber(tel)) {

                            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + tel));
                            intent.putExtra("sms_body", content);
                            startActivity(intent);
                        }

                        Toast.makeText(getApplicationContext(), "求助短信发送成功", Toast.LENGTH_SHORT).show();

                        break;
                    case 4:
                        //邮件
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                sendEmail();

                            }

                        }).start();
                        Toast.makeText(Help.this,"求助邮件已发送成功",Toast.LENGTH_SHORT).show();
                        break;



                }
                //AlertDialog.Builder builder= new AlertDialog.Builder(Help.this);
                //builder.setTitle("提示").setMessage(dataList.get(position).get("text").toString()).create().show();
            }
        });

    }


    public void helpToMainscreen(View view){
        Intent intent = new Intent(this,MainScreen.class);
        startActivity(intent);
    }


    void initData() {
        //图标
        int icno[] = { R.drawable.free04,R.drawable.free08,R.drawable.free21,R.drawable.free28 ,R.drawable.free38};
        //图标下的文字
        String name[]={"用户使用协议","关于系统", "电话人工帮助","短信帮助","邮件帮助"};
        dataList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i <icno.length; i++) {
            Map<String, Object> map=new HashMap<String, Object>();
            map.put("img", icno[i]);
            map.put("text",name[i]);
            dataList.add(map);
        }
    }

    private void sendEmail() {
        try {
            MailSenderInfo mailInfo = new MailSenderInfo();
            mailInfo.setMailServerHost("smtp.163.com");
            mailInfo.setMailServerPort("25");
            mailInfo.setValidate(true);
            mailInfo.setUserName("18207162619@163.com");  //你的邮箱地址
            mailInfo.setPassword("xq19920909xq");//您的邮箱密码
            mailInfo.setFromAddress("18207162619@163.com");//和上面username的邮箱地址一致
            mailInfo.setToAddress("773939719@qq.com");
            mailInfo.setSubject("邮件主题");
            mailInfo.setContent("邮件内容");

            //这个类主要来发送邮件
            SimpleMailSender sms = new SimpleMailSender();
            boolean b = sms.sendTextMail(mailInfo);//发送文体格式,返回是否发送成功的boolean类型

            Log.e("MainActivity", "MainActivity sendEmail()"+b);//sms.sendHtmlMail(mailInfo);//发送html格式

        } catch (Exception e) {
            Log.e("SendMail", e.getMessage(), e);
        }
    }




}
