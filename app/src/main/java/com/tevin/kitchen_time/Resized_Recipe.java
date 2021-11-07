package com.tevin.kitchen_time;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;

public class Resized_Recipe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resized_recipe);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Intent myIntent = getIntent();

        TextView Name = findViewById(R.id.RecipeName);

        TextView Q1 = findViewById(R.id.qnty1);
        TextView Q2 = findViewById(R.id.qnty2);
        TextView Q3 = findViewById(R.id.qnty3);

        TextView spinner = findViewById(R.id.measure1);
        TextView spinner2 = findViewById(R.id.measure2);
        TextView spinner3 = findViewById(R.id.measure3);

        TextView Ingred1 = findViewById(R.id.ingredient1);
        TextView Ingred2 = findViewById(R.id.ingredient2);
        TextView Ingred3 = findViewById(R.id.ingredient3);

        //**QUANTITIES
        if (myIntent.hasExtra("Quantity"))
        {
           String name = myIntent.getExtras().get("Name").toString();
           Name.setText(name);
        }

        if (myIntent.hasExtra("Quantity") && myIntent.hasExtra("Quantity2") && myIntent.hasExtra("Quantity3"))
        {
            String quantity1 = myIntent.getExtras().get("Quantity").toString();
            Q1.setText(quantity1);
            String quantity2 = myIntent.getExtras().get("Quantity2").toString();
            Q2.setText(quantity2);
            String quantity3 = myIntent.getExtras().get("Quantity3").toString();
            Q3.setText(quantity3);
        }
        else if (myIntent.hasExtra("Quantity") && myIntent.hasExtra("Quantity2"))
        {
            String quantity1 = myIntent.getExtras().get("Quantity").toString();
            Q1.setText(quantity1);
            String quantity2 = myIntent.getExtras().get("Quantity2").toString();
            Q2.setText(quantity2);
        }
        else if (myIntent.hasExtra("Quantity2") && myIntent.hasExtra("Quantity3"))
        {
            String quantity2 = myIntent.getExtras().get("Quantity2").toString();
            Q2.setText(quantity2);
            String quantity3 = myIntent.getExtras().get("Quantity3").toString();
            Q3.setText(quantity3);
        }
        else if (myIntent.hasExtra("Quantity") && myIntent.hasExtra("Quantity3"))
        {
            String quantity1 = myIntent.getExtras().get("Quantity").toString();
            Q1.setText(quantity1);
            String quantity3 = myIntent.getExtras().get("Quantity3").toString();
            Q3.setText(quantity3);
        }
        else if (myIntent.hasExtra("Quantity"))
        {
            String quantity1 = myIntent.getExtras().get("Quantity").toString();
            Q1.setText(quantity1);
        }
        else if (myIntent.hasExtra("Quantity2"))
        {
            String quantity2 = myIntent.getExtras().get("Quantity2").toString();
            Q2.setText(quantity2);
        }
        else if (myIntent.hasExtra("Quantity3"))
        {
            String quantity3 = myIntent.getExtras().get("Quantity3").toString();
            Q3.setText(quantity3);
        }

        // ** SPINNERS **

        if ((myIntent.hasExtra("SpinnerValue")) && (myIntent.hasExtra("Spinner2")) && (myIntent.hasExtra("Spinner3")))
        {
            String val = myIntent.getExtras().get("SpinnerValue").toString();
            spinner.setText(val);
            String val2 = myIntent.getExtras().get("Spinner2").toString();
            spinner2.setText(val2);
            String val3 = myIntent.getExtras().get("Spinner3").toString();
            spinner3.setText(val3);
        }
        else if ((myIntent.hasExtra("SpinnerValue")) && (myIntent.hasExtra("Spinner2")))
        {
            String val = myIntent.getExtras().get("SpinnerValue").toString();
            spinner.setText(val);
            String val2 = myIntent.getExtras().get("Spinner2").toString();
            spinner2.setText(val2);
        }

        else if ((myIntent.hasExtra("Spinner2")) && (myIntent.hasExtra("Spinner3")))
        {
            String val2 = myIntent.getExtras().get("Spinner2").toString();
            spinner2.setText(val2);
            String val3 = myIntent.getExtras().get("Spinner3").toString();
            spinner3.setText(val3);
        }

        else if ((myIntent.hasExtra("SpinnerValue")) && (myIntent.hasExtra("Spinner3")))
        {
            String val = myIntent.getExtras().get("SpinnerValue").toString();
            spinner.setText(val);
            String val3 = myIntent.getExtras().get("Spinner3").toString();
            spinner3.setText(val3);
        }
        else if (myIntent.hasExtra("Spinner2"))
        {
            String val2 = myIntent.getExtras().get("Spinner2").toString();
            spinner2.setText(val2);
        }
        else if (myIntent.hasExtra("SpinnerValue"))
        {
            String val = myIntent.getExtras().get("SpinnerValue").toString();
            spinner.setText(val);
        }
        else if (myIntent.hasExtra("Spinner2"))
        {
            String val2 = myIntent.getExtras().get("Spinner2").toString();
            spinner2.setText(val2);
        }

        // ** INGREDIENTS **
        if (myIntent.hasExtra("Ingredient1") && myIntent.hasExtra("Ingredient2") && myIntent.hasExtra("Ingredient3"))
        {
            String first_ingredient = myIntent.getExtras().get("Ingredient1").toString();
            Ingred1.setText(first_ingredient);
            String second_ingredient = myIntent.getExtras().get("Ingredient2").toString();
            Ingred2.setText(second_ingredient);
            String third_ingredient = myIntent.getExtras().get("Ingredient3").toString();
            Ingred3.setText(third_ingredient);
        }
        else if (myIntent.hasExtra("Ingredient1") && myIntent.hasExtra("Ingredient2"))
        {
            String first_ingredient = myIntent.getExtras().get("Ingredient1").toString();
            Ingred1.setText(first_ingredient);
            String second_ingredient = myIntent.getExtras().get("Ingredient2").toString();
            Ingred2.setText(second_ingredient);
        }
        else if (myIntent.hasExtra("Ingredient2") && myIntent.hasExtra("Ingredient3"))
        {
            String second_ingredient = myIntent.getExtras().get("Ingredient2").toString();
            Ingred2.setText(second_ingredient);
            String third_ingredient = myIntent.getExtras().get("Ingredient3").toString();
            Ingred3.setText(third_ingredient);
        }
        else if (myIntent.hasExtra("Ingredient1") && myIntent.hasExtra("Ingredient3"))
        {
            String first_ingredient = myIntent.getExtras().get("Ingredient1").toString();
            Ingred1.setText(first_ingredient);
            String third_ingredient = myIntent.getExtras().get("Ingredient3").toString();
            Ingred3.setText(third_ingredient);
        }
        else if (myIntent.hasExtra("Ingredient1"))
        {
            String first_ingredient = myIntent.getExtras().get("Ingredient1").toString();
            Ingred1.setText(first_ingredient);
        }
        else if (myIntent.hasExtra("Ingredient2"))
        {
            String second_ingredient = myIntent.getExtras().get("Ingredient2").toString();
            Ingred2.setText(second_ingredient);
        }
        else if (myIntent.hasExtra("Ingredient3"))
        {
            String third_ingredient = myIntent.getExtras().get("Ingredient3").toString();
            Ingred3.setText(third_ingredient);
        }
    }
}