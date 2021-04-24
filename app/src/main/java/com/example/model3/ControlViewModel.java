package com.example.model3;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ControlViewModel extends ViewModel {

    //DatabaseReference dref;


    private MutableLiveData<String> mText;


    public ControlViewModel() {

        mText = new MutableLiveData<>();
        mText.setValue("23.4");
    }

    public LiveData<String> getText() {
        return mText;
    }

}

