package com.example.john.dialarapp_week2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtPhoneNo;
    TextView lblinfo;
    Button delete;

    RelativeLayout lnZero;
    String phoneNo = "";
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPhoneNo = (EditText) findViewById(R.id.edtPhoneNumber);
        edtPhoneNo.setInputType(android.text.InputType.TYPE_NULL);

        lblinfo = (TextView) findViewById(R.id.lblinfo);
        lnZero = (RelativeLayout) findViewById(R.id.btnZero);

        delete = (Button) findViewById(R.id.btndel);
//        fab=(FloatingActionButton)findViewById(R.id.fab);


        delete.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                edtPhoneNo.setText("");
                return false;
            }
        });

        lnZero.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                count = 1;
                return false;
            }
        });

    }

    public void buttonClickEvent(final View view) {
        phoneNo = edtPhoneNo.getText().toString();
        lblinfo.setVisibility(View.GONE);
        try {

            switch (view.getId()) {
                case R.id.btnAterisk:
                    lblinfo.setText("");
                    phoneNo += "*";
                    edtPhoneNo.setText(phoneNo);
                    break;
                case R.id.btnHash:
                    lblinfo.setText("");
                    phoneNo += "#";
                    edtPhoneNo.setText(phoneNo);
                    break;
                case R.id.btnZero:
                    if (count == 0) {
                        lblinfo.setText("");
                        phoneNo += "0";
                        edtPhoneNo.setText(phoneNo);
                    } else {
                        lblinfo.setText("");
                        phoneNo += "+";
                        edtPhoneNo.setText(phoneNo);
                        count = 0;
                    }
                    break;
                case R.id.btnOne:
                    lblinfo.setText("");
                    phoneNo += "1";
                    edtPhoneNo.setText(phoneNo);
                    break;
                case R.id.btnTwo:
                    lblinfo.setText("");
                    phoneNo += "2";
                    edtPhoneNo.setText(phoneNo);
                    break;
                case R.id.btnThree:
                    lblinfo.setText("");
                    phoneNo += "3";
                    edtPhoneNo.setText(phoneNo);
                    break;
                case R.id.btnFour:
                    lblinfo.setText("");
                    phoneNo += "4";
                    edtPhoneNo.setText(phoneNo);
                    break;
                case R.id.btnFive:
                    lblinfo.setText("");
                    phoneNo += "5";
                    edtPhoneNo.setText(phoneNo);
                    break;
                case R.id.btnSix:
                    lblinfo.setText("");
                    phoneNo += "6";
                    edtPhoneNo.setText(phoneNo);
                    break;
                case R.id.btnSeven:
                    lblinfo.setText("");
                    phoneNo += "7";
                    edtPhoneNo.setText(phoneNo);
                    break;
                case R.id.btnEight:
                    lblinfo.setText("");
                    phoneNo += "8";
                    edtPhoneNo.setText(phoneNo);
                    break;
                case R.id.btnNine:
                    lblinfo.setText("");
                    phoneNo += "9";
                    edtPhoneNo.setText(phoneNo);
                    break;
                case R.id.btndel:
                    lblinfo.setText("");
                    if (phoneNo != null && phoneNo.length() > 0) {
                        phoneNo = phoneNo.substring(0, phoneNo.length() - 1);
                    }

                    edtPhoneNo.setText(phoneNo);
                    break;
            }

        } catch (Exception ex) {

        }
    }



}