package edu.ucab.controller;

import java.util.HashMap;
import java.util.Map;

public final class Context {
    
    private static Context instance;
    private final Map<String, Object> context;
    
    private Context(){
        context = new HashMap<>();
    }
    
    public static Context getInstance(){
        if(instance == null){
            instance = new Context();
        }
        return instance;
    }
    
    public Map<String, Object> getContext(){
        return this.context;
    }
}
