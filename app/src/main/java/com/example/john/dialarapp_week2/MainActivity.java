package com.example.john.dialarapp_week2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;

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

    public void btCallphone(View view){

        makePhonecall();

    }

    public void makePhonecall(){

        String number  = edtPhoneNo.getText().toString();

        if(number.trim().length() > 0){


            if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){

                ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CALL_PHONE},REQUEST_CALL);

            }else{

                String dial = "tel:"+number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));

            }


        }else{

            Toast.makeText(this,"Please Enter Phone Number ",Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {


        if(requestCode == REQUEST_CALL){

            if(grantResults.length > 0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){

                makePhonecall();
                edtPhoneNo.setText("");


            }else{

                Toast.makeText(this,"Permission Denied",Toast.LENGTH_SHORT).show();


            }


        }


    }
}