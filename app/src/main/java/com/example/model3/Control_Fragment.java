package com.example.model3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Control_Fragment extends Fragment {

    private ControlViewModel controlViewModel;
    private String Control1;
    private String Control2;
    private Button button1on;
    private Button button1off;
    private Button button2on;
    private Button button2off;

    DatabaseReference dref;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        controlViewModel =
                new ViewModelProvider(this).get(ControlViewModel.class);

        View root = inflater.inflate(R.layout.fragment_control, container, false);


        final TextView textView = root.findViewById(R.id.Control1_result2);
        final TextView textView1 = root.findViewById(R.id.Control2_result2);
        final Button btn1_on = root.findViewById(R.id.Control1_btn2on);
        final Button btn1_off = root.findViewById(R.id.Control1_btn2off);
        final Button btn2_on = root.findViewById(R.id.Control2_btn2on);
        final Button btn2_off = root.findViewById(R.id.Control2_btn2off);




        dref = FirebaseDatabase.getInstance().getReference();
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                Control1=snapshot.child("motor1").getValue().toString();
                Control2=snapshot.child("motor2").getValue().toString();
                textView.setText(Control1);
                textView1.setText(Control2);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btn1_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dref.child("motor1").setValue(1);
                //write GPS location
            }

        });
        btn1_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dref.child("motor1").setValue(0);//write GPS location
            }
        });
        btn2_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dref.child("motor2").setValue(1);//write GPS location
            }
        });
        btn2_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dref.child("motor2").setValue(0);//write GPS location
            }
        });

        return root;
        //return inflater.inflate(R.layout.fragment_badroom,container,false);
    }

}
