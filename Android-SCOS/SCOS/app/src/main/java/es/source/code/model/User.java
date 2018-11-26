package es.source.code.model;

import java.io.Serializable;

public class User implements Serializable {
    private String userName;
    private String password;
    private Boolean oldUser;


    public void setUserName(String in){
        userName = in;
    }

    public void setPassword(String in){
        password = in;
    }
    public  void setOldUser(Boolean in){
        oldUser = in;
    }

    public String getUserName(){
        return userName;
    }

    public  String getPassword(){
        return password;
    }

    public Boolean getOldUser(){
        return oldUser;
    }
}
