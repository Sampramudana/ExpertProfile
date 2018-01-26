package com.pramudana.sam.expertprofile;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUser, etFullname, etEmail, etPass, etPlace, etAddress;
    Button btnSubmit, btnExit;
    Spinner spinJob, spinGender;
    DatePicker dateBorn;
    TextView txtUser, txtFullname, txtEmail, txtPass, txtPlace, txtAddress, txtJob, txtGender, txtDate;
    Context context = this;
    String itemGender;
    String itemJob;
    String[] dataGender = new String[]{

            "L", "P", "None"
    };
    String[] dataJob = new String[]{

            "Student", "Teacher", "PNS", "Engineering", "Manager", "Networker", "Programmer", "Architecture", "Designer"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinJob = (Spinner)findViewById(R.id.spinJob);
        spinGender = (Spinner)findViewById(R.id.spinGender);
        etUser = (EditText)findViewById(R.id.etUser);
        etFullname = (EditText)findViewById(R.id.etFullname);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etAddress = (EditText)findViewById(R.id.etAddress);
        etPass = (EditText)findViewById(R.id.etPass);
        etPlace = (EditText)findViewById(R.id.etPlace);
        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        btnExit = (Button)findViewById(R.id.btnExit);
        dateBorn = (DatePicker)findViewById(R.id.dateBorn);
        txtFullname = (TextView)findViewById(R.id.txtFullname);
        txtEmail = (TextView)findViewById(R.id.txtEmail);
        txtAddress = (TextView)findViewById(R.id.txtAddress);
        txtGender = (TextView)findViewById(R.id.txtGender);
        txtJob = (TextView)findViewById(R.id.txtJob);
        txtPass = (TextView)findViewById(R.id.txtPass);
        txtPlace = (TextView)findViewById(R.id.txtPlace);
        txtAddress = (TextView)findViewById(R.id.txtAddress);
        txtUser = (TextView)findViewById(R.id.txtUser);
        txtDate = (TextView)findViewById(R.id.txtDate);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataGender);
        spinGender.setAdapter(adapter);

        spinGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                itemGender = parent.getItemAtPosition(position).toString();

                if (itemGender == "None"){

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.prompts);
                    dialog.setTitle("Warning !!");
                    Button btnOK = (Button)dialog.findViewById(R.id.btnOk);
                    btnOK.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            dialog.dismiss();
                        }
                    });
                    dialog.show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataJob);
        spinJob.setAdapter(adapter1);

        spinJob.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                itemJob = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sUser = etUser.getText().toString();
                String sFullname = etFullname.getText().toString();
                String sEmail = etEmail.getText().toString();
                String sPass = etPass.getText().toString();
                String sPlace = etPlace.getText().toString();
                String sAddress = etAddress.getText().toString();

                if (sUser.isEmpty() && sFullname.isEmpty() && sEmail.isEmpty() && sPass.isEmpty() && sPlace.isEmpty() && sAddress.isEmpty()){

                    etUser.setError("Cant Not Be Empty");
                    etFullname.setError("Cant Not Be Empty");
                    etEmail.setError("Cant Not Be Empty");
                    etPass.setError("Cant Not Be Empty");
                    etPlace.setError("Cant Not Be Empty");
                    etAddress.setError("Cant Not Be Empty");

                }else {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                    alertDialog.setTitle("Confirmation");
                    alertDialog.setMessage("Are You Sure ??")
                            .setCancelable(false)
                            .setPositiveButton("Sudah", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    String sUser = etUser.getText().toString();
                                    String sFullname = etFullname.getText().toString();
                                    String sEmail = etEmail.getText().toString();
                                    String sPass = etPass.getText().toString();
                                    String sPlace = etPlace.getText().toString();
                                    String sAddress = etAddress.getText().toString();

                                    txtUser.setText("Hallo, " + sUser);
                                    txtEmail.setText("Email : " + sEmail);
                                    txtAddress.setText("Address : " + sAddress);
                                    txtFullname.setText("Fullname : " + sFullname);
                                    txtPass.setText("Password : " + sPass);
                                    txtPlace.setText("Born Place : " + sPlace);
                                    txtGender.setText("Gender : " + itemGender);
                                    txtJob.setText("Job : " + itemJob);
                                    txtDate.setText("Date : " + dateBorn.getDayOfMonth() +""+ dateBorn.getMonth() +""+ dateBorn.getYear());
                                    if (itemGender == "L"){
                                        txtGender.setText("Laki - Laki");
                                    }else if (itemGender == "P"){
                                        txtGender.setText("Perempuan");
                                    }
                                }
                            })
                            .setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert = alertDialog.create();
                    alert.show();
                }
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                alertDialog.setTitle("You Know?? This is an Alert Dialog");
                alertDialog.setMessage("Do you want to close from this apps ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                MainActivity.this.finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                dialog.cancel();
                            }
                        });
                AlertDialog alert = alertDialog.create();
                alert.show();
            }
        });
    }
}
