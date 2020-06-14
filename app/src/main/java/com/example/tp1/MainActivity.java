package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nom;
    private EditText age;
    private EditText taille;
    private Button envoyer;
    public  static final String Tag="MainActivity";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       initviews();
    }
    public  void initviews(){
        this.nom = findViewById(R.id.edit3);
        this.age = findViewById(R.id.edit2);
        this.taille = findViewById(R.id.edit);
        this.envoyer= findViewById(R.id.button);
        envoyer.setOnClickListener(this);
    }


    public void onClick(View v) {
        if (v.getId() == R.id.button) {
            if (isEditTextEmpty(nom) || isEditTextEmpty(age)||isEditTextEmpty(age)||verfierType(age)||verfierType(taille))
                return;
            Intent other = new Intent(getApplicationContext(), MainActivity2.class);
            other.putExtra("nom", nom.getText().toString());
            other.putExtra("age", age.getText().toString());
            other.putExtra("taille", taille.getText().toString());

            startActivity(other);
            finish();
            Log.e(Tag, "donnes envoyees avec succes\"");
        }
    }
    private boolean isEditTextEmpty(EditText editText) {
        if (editText.getText().toString().isEmpty()) {
            editText.requestFocus();
            editText.setError("Champ obligatoire!");
            return true;
        }
        return false;
    }
    private boolean verfierType(EditText editText) {
        boolean error = true;
        Float val;
        String str =editText.getText().toString();
        if (!TextUtils.isEmpty(str)) {
                try {
                    val=Float.parseFloat(str);
                    error = false;
                }
                catch(Exception e) {
                    Log.w("XXx", "erreur de conversion", e);
                    editText.requestFocus();
                    editText.setError("saisissez un  type valide");
                }
            }


        return error;
    }
}