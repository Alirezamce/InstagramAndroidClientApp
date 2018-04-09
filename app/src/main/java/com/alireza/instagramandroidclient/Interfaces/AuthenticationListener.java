package com.alireza.instagramandroidclient.Interfaces;

/**
 * Created by alireza on 4/8/18.
 */

public interface AuthenticationListener {

    void onCodeReceived(String auth_token);
}
