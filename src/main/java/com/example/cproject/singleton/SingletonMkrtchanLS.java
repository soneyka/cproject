package com.example.cproject.singleton;

import java.io.Serializable;

public class SingletonMkrtchanLS implements Serializable {
    private static final long serialVersionUID = -7604766932017737115L;

    private static class LazyHolder{
        private static final SingletonMkrtchanLS INSTANCE = new SingletonMkrtchanLS();
    }

    public static SingletonMkrtchanLS getInstance(){
        return LazyHolder.INSTANCE;
    }

    protected Object readResolve() {
        return getInstance();
    }
}
