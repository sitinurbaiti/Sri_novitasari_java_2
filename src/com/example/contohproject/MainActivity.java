package com.example.contohproject;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
 
public class MainActivity extends Activity {
@Override
public boolean onCreateOptionsMenu(Menu menu) {
 // Inflate the menu; this adds items to the action bar if it is present.
 getMenuInflater().inflate(R.menu.main, menu);
 return true;
}
 
public void onBackPressed() {
  exit();
}
 
private void exit() {
 AlertDialog.Builder builder = new AlertDialog.Builder(this);
 builder.setMessage("Are You Sure Want to Exit?")
 .setCancelable(false)
 .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
  public void onClick(DialogInterface dialog, int id) {
   finish();
  }
 })
 .setNegativeButton("No", new DialogInterface.OnClickListener() {
	 
  public void onClick(DialogInterface dialog, int id) {
   dialog.cancel();
  }
 }).show();
}
 
private Spinner sp;
 private EditText edt_awal, edt_C, edt_R, edt_F, edt_K;
 private String[] list={"C","R","F","K"};
 Double awal, celcius, reamur, fahrenheit, kelvin;
 ArrayAdapter<String> adapter;
 
@Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 sp=(Spinner) findViewById(R.id.spinner1);
 edt_awal=(EditText) findViewById(R.id.editText1);
 edt_C=(EditText) findViewById(R.id.editText2);
 edt_R=(EditText) findViewById(R.id.editText3);
 edt_F=(EditText) findViewById(R.id.editText4);
 edt_K=(EditText) findViewById(R.id.editText5);
 
 adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
 adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
 sp.setAdapter(adapter);
 }
 
 public void Konversi(View v){
 String satuan = String.valueOf(sp.getSelectedItemPosition());
 if(edt_awal.getText().toString().equals("")){
 Toast.makeText(getBaseContext(), "Masukkan suhu awal, default suhu awal = 0 ", Toast.LENGTH_LONG).show();
 awal = 0.0;
 }else{
 awal = Double.parseDouble(edt_awal.getText().toString());
 }
 if(satuan.equals("0")){
 celcius = awal;
 reamur = 0.8 * awal;
 fahrenheit = (1.8 * awal) + 32;
 kelvin = awal + 273;
 
 edt_C.setText(String.valueOf(celcius));
 edt_R.setText(String.valueOf(reamur));
 edt_F.setText(String.valueOf(fahrenheit));
 edt_K.setText(String.valueOf(kelvin));
 }else if(satuan.equals("1")){
 celcius = 1.25 * awal;
 reamur = awal;
 fahrenheit = (2.25 * awal) + 32;
 kelvin = celcius + 273;
 
 edt_C.setText(String.valueOf(celcius));
 edt_R.setText(String.valueOf(reamur));
 edt_F.setText(String.valueOf(fahrenheit));
 edt_K.setText(String.valueOf(kelvin));
 }else if(satuan.equals("2")){
 celcius = 0.55555 *(awal - 32);
 reamur = 0.44444 * (awal-32);
 fahrenheit = awal;
 kelvin = celcius + 273;
 
 edt_C.setText(String.valueOf(celcius));
 edt_R.setText(String.valueOf(reamur));
 edt_F.setText(String.valueOf(fahrenheit));
 edt_K.setText(String.valueOf(kelvin));
 }else if(satuan.equals("3")){
 celcius = awal-273;
 reamur = 0.8 * (awal-273);
 fahrenheit = (1.8 * (awal-273)) + 32;
 kelvin = awal;
 
 edt_C.setText(String.valueOf(celcius));
 edt_R.setText(String.valueOf(reamur));
 edt_F.setText(String.valueOf(fahrenheit));
 edt_K.setText(String.valueOf(kelvin));
 }
 }
}