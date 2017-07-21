package com.example.aceri5.letsapp;

/**
 * Created by acer i5 on 6/24/2017.
 */
public class EventActivity {
    String event_name;
    int icon;

    EventActivity(String name, int icon){
        event_name = name;
        this.icon = icon;
    }

    public void set_event_name(String name){
        event_name = name;
    }

    public void set_icon (int icon){
        this.icon = icon;
    }

    public String get_event_name(){
        return event_name;
    }

    public int get_icon(){
        return icon;
    }


}
