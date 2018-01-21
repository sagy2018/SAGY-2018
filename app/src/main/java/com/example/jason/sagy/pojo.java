package com.example.jason.sagy;

/**
 * Created by goa on 20/1/18.
 */

public class pojo {

    String id;
    String user;
    String scheme;



    public pojo(String id,String user, String scheme) {
        this.id=id;
        this.user = user;
        this.scheme = scheme;
    }
    public String getId(){
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getScheme() {
        return scheme;
    }
}
