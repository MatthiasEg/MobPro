package ch.hslu.mobpro.ui_demo;

import android.arch.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    private int counter = 0;

    public int incrementCounter(){
        return ++counter;
    }

    public int getCounter(){
        return this.counter;
    }
}
