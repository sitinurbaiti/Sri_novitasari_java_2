package com.example.contohproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class login extends Activity implements OnClickListener {

// deklarasi variable
 Button masuk;
 AlertDialog alert;
 EditText password;
 EditText user;
 String isi_passwd, username;

/** Called when the activity is first created. */
 @Override
 public void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
  setContentView(R.layout.login_activity);

 // inisialisasi variabel
 masuk = (Button) this.findViewById(R.id.masuk);
 masuk.setOnClickListener(this);
 
 // edit text untuk username
 user = (EditText) findViewById(R.id.username);
 user.getText();
 
 // edit text untuk password
 password = (EditText) findViewById(R.id.passwd_input);
 password.getText();
 
 username="sri";
 isi_passwd = "baik";

}

@Override
// method untuk override tombol masuk
public void onClick(View tombol_act) {
// TODO Auto-generated method stub
if (tombol_act == masuk) {

 if (password.getText().toString().equals(isi_passwd) && user.getText().toString().equals(username)) {
 AlertDialog.Builder pesan = new AlertDialog.Builder(this);
 pesan.setMessage("Username dan password anda benar")
 .setCancelable(false).setPositiveButton("OK",
 new DialogInterface.OnClickListener() {

@Override
public void onClick(DialogInterface dialog,
int which) {

 Intent intent = new Intent(getApplicationContext(), MainActivity.class);
 startActivity(intent);
 }
});
  alert = pesan.create();
  alert.show();
  } else {
  AlertDialog.Builder pesan = new AlertDialog.Builder(this);
  pesan.setMessage("Username :" + user.getText() + " dan password :"+ password.getText() + "anda masih salah")
  .setCancelable(false).setPositiveButton("OK",
  new DialogInterface.OnClickListener() {
  
  @Override
  public void onClick(DialogInterface dialog,
  int which) {
  // TODO Auto-generated method stub
  user.setText("");
  password.setText("");
  }
  });
  alert = pesan.create();
  alert.show();
   }
  }

 }
}

