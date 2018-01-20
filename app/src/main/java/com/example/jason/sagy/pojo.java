package com.example.jason.sagy;

/**
 * Created by goa on 20/1/18.
 */

public class pojo {

    String id;
    String user;
    String spindata;



    public pojo(String id,String user, String spindata) {
        this.id=id;
        this.user = user;
        this.spindata = spindata;
    }
    public String getId(){
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getSpindata() {
        return spindata;
    }
}
