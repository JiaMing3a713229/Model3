package com.example.model3;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MonitorViewModel extends ViewModel {
    //DatabaseReference dref;


    private MutableLiveData<String> mText;


    public MonitorViewModel() {

        mText = new MutableLiveData<>();
        mText.setValue("23.4");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
