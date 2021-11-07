package com.tevin.kitchen_time;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    //VARIABLE DECLARATIONS
    private EditText RecipeName;
    private String recipe_name;

    private EditText OriginalServings;
    private int original_servings;

    private EditText DesiredServings;
    private int desired_servings;

    private EditText Quantity1;
    private int qnty1;

    private EditText Quantity2;
    private int qnty2;

    private EditText Quantity3;
    private int qnty3;

    private EditText Ingredient1;
    private String ingredient1;

    private EditText Ingredient2;
    private String ingredient2;

    private EditText Ingredient3;
    private String ingredient3;

    private String mySpinner;
    private String mySpinner2;
    private String mySpinner3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*  SPINNER SETUP */
        Spinner spinner1 = findViewById(R.id.measure1);
        Spinner spinner2 = findViewById(R.id.measure2);
        Spinner spinner3 = findViewById(R.id.measure3);

        if((spinner1 != null) && (spinner2 != null) && (spinner3 != null))
        {
            //SET SPINNER LISTENER
            spinner1.setOnItemSelectedListener(this);
            spinner2.setOnItemSelectedListener(this);
            spinner3.setOnItemSelectedListener(this);

            //SET SPINNER SELECTED VALUE
            spinner1.setSelection(1);
            spinner2.setSelection(1);
            spinner3.setSelection(1);

        }

        ArrayAdapter <CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.measurements_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        if((spinner1 != null) && (spinner2 != null) && (spinner3 != null))
        {
            spinner1.setAdapter(adapter);
            spinner2.setAdapter(adapter);
            spinner3.setAdapter(adapter);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
    {
        //SELECTION OF SPINNER 1
        if (adapterView.getId() == R.id.measure1)
        {
            mySpinner = adapterView.getItemAtPosition(position).toString();
//            Toast myToast = Toast.makeText(this, "Selected Measure1 as: " + mySpinner, Toast.LENGTH_SHORT);
//            myToast.show();
        }
        //SELECTION OF SPINNER 2
        else if (adapterView.getId() == R.id.measure2)
        {
            mySpinner2 = adapterView.getItemAtPosition(position).toString();
//            Toast myToast = Toast.makeText(this, "Selected Measure2 as: " + mySpinner2, Toast.LENGTH_SHORT);
//            myToast.show();
        }
        // SELECTION OF SPINNER 3
        else if (adapterView.getId() == R.id.measure3)
        {
            mySpinner3 = adapterView.getItemAtPosition(position).toString();
//            Toast myToast = Toast.makeText(this, "Selected Measure3 as: " + mySpinner3, Toast.LENGTH_SHORT);
//            myToast.show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {
        Toast toast = Toast.makeText(this, "Nothing Selected", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void Results(View view)
    {
        // FINDING VALUES BY ID AND ASSIGNING VALUES TO VARIABLES
        RecipeName = findViewById(R.id.RecipeName);
        recipe_name = RecipeName.getText().toString();

        OriginalServings = findViewById(R.id.OriginalServings);

        DesiredServings = findViewById(R.id.DesiredServings);

        Quantity1 = findViewById(R.id.qnty1);

        Quantity2 = findViewById(R.id.qnty2);

        Quantity3 = findViewById(R.id.qnty3);

        Ingredient1 = findViewById(R.id.ingredient1);
        ingredient1 = Ingredient1.getText().toString();

        Ingredient2 = findViewById(R.id.ingredient2);
        ingredient2 = Ingredient2.getText().toString();

        Ingredient3 = findViewById(R.id.ingredient3);
        ingredient3 = Ingredient3.getText().toString();

        /* CALCULATIONS */
        // ALL FIELDS ARE EMPTY
        if (Quantity1.getText().toString().isEmpty() && Quantity2.getText().toString().isEmpty() && Quantity3.getText().toString().isEmpty() && OriginalServings.getText().toString().isEmpty() && DesiredServings.getText().toString().isEmpty())
        {
            Toast.makeText(MainActivity.this, "All Fields are Required", Toast.LENGTH_SHORT).show();
        }
        else
        {
            // ORIGINAL AND DESIRED SERVINGS LEFT EMPTY WHILE QUANTITIES HAVE VALUES
            if (!Quantity1.getText().toString().isEmpty() && !Quantity2.getText().toString().isEmpty() && !Quantity3.getText().toString().isEmpty() && DesiredServings.getText().toString().isEmpty() && OriginalServings.getText().toString().isEmpty())
            {
                Toast.makeText(MainActivity.this, "Enter: Desired Servings and Original Servings", Toast.LENGTH_SHORT).show();
                return;
            }
            else if (!Quantity1.getText().toString().isEmpty() && !Quantity2.getText().toString().isEmpty() && DesiredServings.getText().toString().isEmpty() && OriginalServings.getText().toString().isEmpty())
            {
                Toast.makeText(MainActivity.this, "Enter: Desired Servings and Original Servings", Toast.LENGTH_SHORT).show();
                return;
            }
            else if (!Quantity2.getText().toString().isEmpty() && !Quantity3.getText().toString().isEmpty() && DesiredServings.getText().toString().isEmpty() && OriginalServings.getText().toString().isEmpty())
            {
                Toast.makeText(MainActivity.this, "Enter: Desired Servings and Original Servings", Toast.LENGTH_SHORT).show();
                return;
            }
            else if (!Quantity1.getText().toString().isEmpty() && !Quantity3.getText().toString().isEmpty() && DesiredServings.getText().toString().isEmpty() && OriginalServings.getText().toString().isEmpty())
            {
                Toast.makeText(MainActivity.this, "Enter: Desired Servings and Original Servings", Toast.LENGTH_SHORT).show();
                return;
            }
            else if (!Quantity1.getText().toString().isEmpty() && DesiredServings.getText().toString().isEmpty() && OriginalServings.getText().toString().isEmpty())
            {
                Toast.makeText(MainActivity.this, "Enter: Desired Servings and Original Servings", Toast.LENGTH_SHORT).show();
                return;
            }
            else if (!Quantity2.getText().toString().isEmpty() && DesiredServings.getText().toString().isEmpty() && OriginalServings.getText().toString().isEmpty())
            {
                Toast.makeText(MainActivity.this, "Enter: Desired Servings and Original Servings", Toast.LENGTH_SHORT).show();
                return;
            }
            else if (!Quantity3.getText().toString().isEmpty() && DesiredServings.getText().toString().isEmpty() && OriginalServings.getText().toString().isEmpty())
            {
                Toast.makeText(MainActivity.this, "Enter: Desired Servings and Original Servings", Toast.LENGTH_SHORT).show();
                return;
            }

            //DESIRED SERVINGS LEFT EMPTY
            else if (!Quantity1.getText().toString().isEmpty() && !Quantity2.getText().toString().isEmpty() && !Quantity3.getText().toString().isEmpty() && DesiredServings.getText().toString().isEmpty())
            {
                Toast.makeText(MainActivity.this, "Enter: Desired Servings", Toast.LENGTH_SHORT).show();
                return;
            }
            else if (!Quantity1.getText().toString().isEmpty() && !Quantity2.getText().toString().isEmpty() && DesiredServings.getText().toString().isEmpty())
            {
                Toast.makeText(MainActivity.this, "Enter: Desired Servings", Toast.LENGTH_SHORT).show();
                return;
            }
            else if (!Quantity2.getText().toString().isEmpty() && !Quantity3.getText().toString().isEmpty() && DesiredServings.getText().toString().isEmpty())
            {
                Toast.makeText(MainActivity.this, "Enter: Desired Servings", Toast.LENGTH_SHORT).show();
                return;
            }
            else if (!Quantity1.getText().toString().isEmpty() && !Quantity3.getText().toString().isEmpty() && DesiredServings.getText().toString().isEmpty())
            {
                Toast.makeText(MainActivity.this, "Enter: Desired Servings", Toast.LENGTH_SHORT).show();
                return;
            }
            else if ((!Quantity1.getText().toString().isEmpty() || !Quantity2.getText().toString().isEmpty() || !Quantity3.getText().toString().isEmpty()) & DesiredServings.getText().toString().isEmpty())
            {
                Toast.makeText(MainActivity.this, "Enter: Desired Servings", Toast.LENGTH_SHORT).show();
                return;
            }

            // ORIGINAL SERVINGS LEFT EMPTY
            else if (!Quantity1.getText().toString().isEmpty() && !Quantity2.getText().toString().isEmpty() && !Quantity3.getText().toString().isEmpty() && OriginalServings.getText().toString().isEmpty())
            {
                Toast.makeText(MainActivity.this, "Enter: Original Servings", Toast.LENGTH_SHORT).show();
                return;
            }
            else if (!Quantity1.getText().toString().isEmpty() && !Quantity2.getText().toString().isEmpty() && OriginalServings.getText().toString().isEmpty())
            {
                Toast.makeText(MainActivity.this, "Enter: Original Servings", Toast.LENGTH_SHORT).show();
                return;
            }
            else if (!Quantity2.getText().toString().isEmpty() && !Quantity3.getText().toString().isEmpty() && OriginalServings.getText().toString().isEmpty())
            {
                Toast.makeText(MainActivity.this, "Enter: Original Servings", Toast.LENGTH_SHORT).show();
                return;
            }
            else if (!Quantity1.getText().toString().isEmpty() && !Quantity3.getText().toString().isEmpty() && OriginalServings.getText().toString().isEmpty())
            {
                Toast.makeText(MainActivity.this, "Enter: Original Servings", Toast.LENGTH_SHORT).show();
                return;
            }
            else if ((!Quantity1.getText().toString().isEmpty() || !Quantity2.getText().toString().isEmpty() || !Quantity3.getText().toString().isEmpty()) & OriginalServings.getText().toString().isEmpty())
            {
                Toast.makeText(MainActivity.this, "Enter: Original Servings", Toast.LENGTH_SHORT).show();
                return;
            }

            //QUANTITIES WITH VALUE = 0
            if (Quantity1.getText().toString().isEmpty() && Quantity2.getText().toString().isEmpty() && Quantity3.getText().toString().isEmpty())
            {
                Toast.makeText(MainActivity.this, "Quantities cannot be 0", Toast.LENGTH_SHORT).show();
                return;
            }

            //GET VALUE OF ORIGINAL AND DESIRED SERVINGS ARE INTEGER
            try
            {
                original_servings = Integer.parseInt((OriginalServings.getText().toString()));
                desired_servings = Integer.parseInt((DesiredServings.getText().toString()));
            } catch(NumberFormatException nfe) {
                System.out.println("Could not parse this " + nfe);
            }

            // SERVINGS SET TO 0?
            if (((desired_servings == 0) && (original_servings == 0)) || (desired_servings == 0 || original_servings == 0))
            {
                Toast.makeText(MainActivity.this, "Servings cannot be 0", Toast.LENGTH_SHORT).show();
            }

            //MULTIPLIER RESIZER
            else if(desired_servings > original_servings)
            {
                if (!Quantity1.getText().toString().isEmpty() && !Quantity2.getText().toString().isEmpty() && !Quantity3.getText().toString().isEmpty())
                {
                    qnty1 = Integer.parseInt(Quantity1.getText().toString());
                    qnty2 = Integer.parseInt(Quantity2.getText().toString());
                    qnty3 = Integer.parseInt(Quantity3.getText().toString());
                    if ((qnty1 > 0) && (qnty2 > 0) && (qnty3 > 0))
                    {
                        //ENSURING INGREDIENTS ARE ENTERED
                        if (ingredient1.isEmpty() && ingredient2.isEmpty() && ingredient3.isEmpty())
                        {
                            Toast.makeText(MainActivity.this, "Enter Ingredients 1, 2 and 3", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else if (ingredient1.isEmpty() && ingredient2.isEmpty())
                        {
                            Toast.makeText(MainActivity.this, "Enter Ingredients 1 and 2", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else if (ingredient2.isEmpty() && ingredient3.isEmpty())
                        {
                            Toast.makeText(MainActivity.this, "Enter Ingredients 2 and 3", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else if (ingredient1.isEmpty() && ingredient3.isEmpty())
                        {
                            Toast.makeText(MainActivity.this, "Enter Ingredients 1 and 3", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else if (ingredient1.isEmpty())
                        {
                            Toast.makeText(MainActivity.this, "Enter Ingredients 1", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else if (ingredient2.isEmpty())
                        {
                            Toast.makeText(MainActivity.this, "Enter Ingredients 2", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else if (ingredient3.isEmpty())
                        {
                            Toast.makeText(MainActivity.this, "Enter Ingredients 3", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        qnty1 = qnty1 * desired_servings;
                        qnty2 = qnty2 * desired_servings;
                        qnty3 = qnty3 * desired_servings;
                        RecipeResults(mySpinner, mySpinner2, mySpinner3);
                    }
                    else if ((qnty1 == 0) && (qnty2 == 0) && (qnty3 == 0))
                    {
                        Toast.makeText(MainActivity.this, "Quantities cannot be 0", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Invalid Quantities", Toast.LENGTH_SHORT).show();
                    }
                }
                else if (!Quantity1.getText().toString().isEmpty() && !Quantity2.getText().toString().isEmpty())
                {
                    qnty1 = Integer.parseInt(Quantity1.getText().toString());
                    qnty2 = Integer.parseInt(Quantity2.getText().toString());
                    if (qnty1 > 0 && qnty2 > 0)
                    {
                        if (ingredient1.isEmpty() && ingredient2.isEmpty())
                        {
                            Toast.makeText(MainActivity.this, "Enter Ingredients 1 and 2", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else if (ingredient1.isEmpty())
                        {
                            Toast.makeText(MainActivity.this, "Enter Ingredients 1", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else if (ingredient2.isEmpty())
                        {
                            Toast.makeText(MainActivity.this, "Enter Ingredients 2", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        qnty1 = qnty1 * desired_servings;
                        qnty2 = qnty2 * desired_servings;
                        RecipeResults(mySpinner, mySpinner2);
                    }
                    else if ((qnty1 == 0) && (qnty2 == 0))
                    {
                        Toast.makeText(MainActivity.this, "Quantities cannot be 0", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Invalid Quantities", Toast.LENGTH_SHORT).show();
                    }
                }
                else if (!Quantity2.getText().toString().isEmpty() && !Quantity3.getText().toString().isEmpty())
                {
                    qnty2 = Integer.parseInt(Quantity2.getText().toString());
                    qnty3 = Integer.parseInt(Quantity3.getText().toString());
                    if (qnty2 > 0 && qnty3 > 0)
                    {
                        if (ingredient2.isEmpty() && ingredient3.isEmpty())
                        {
                            Toast.makeText(MainActivity.this, "Enter Ingredients 2 and 3", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else if (ingredient2.isEmpty())
                        {
                            Toast.makeText(MainActivity.this, "Enter Ingredients 2", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else if (ingredient3.isEmpty())
                        {
                            Toast.makeText(MainActivity.this, "Enter Ingredients 3", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        qnty2 = qnty2 * desired_servings;
                        qnty3 = qnty3 * desired_servings;
                        RecipeResults(mySpinner2, mySpinner3);
                    }
                    else if ((qnty2 == 0) && (qnty3 == 0))
                    {
                        Toast.makeText(MainActivity.this, "Quantities cannot be 0", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Invalid Quantities", Toast.LENGTH_SHORT).show();
                    }
                }
                else if (!Quantity1.getText().toString().isEmpty() && !Quantity3.getText().toString().isEmpty())
                {
                    qnty1 = Integer.parseInt(Quantity1.getText().toString());
                    qnty3 = Integer.parseInt(Quantity3.getText().toString());
                    if ((qnty1 > 0 && qnty3 > 0))
                    {
                        if (ingredient1.isEmpty() && ingredient3.isEmpty())
                        {
                            Toast.makeText(MainActivity.this, "Enter Ingredients 1 and 3", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else if (ingredient1.isEmpty())
                        {
                            Toast.makeText(MainActivity.this, "Enter Ingredients 1", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else if (ingredient3.isEmpty())
                        {
                            Toast.makeText(MainActivity.this, "Enter Ingredients 3", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        qnty1 = qnty1 * desired_servings;
                        qnty3 = qnty3 * desired_servings;
                        RecipeResults(mySpinner, mySpinner3);
                    }
                    else if ((qnty1 == 0) && (qnty3 == 0))
                    {
                        Toast.makeText(MainActivity.this, "Quantities cannot be 0", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Invalid Quantities", Toast.LENGTH_SHORT).show();
                    }
                }
                else if (!Quantity1.getText().toString().isEmpty() && Quantity2.getText().toString().isEmpty() && Quantity3.getText().toString().isEmpty())
                {
                    qnty1 = Integer.parseInt(Quantity1.getText().toString());
                    if (qnty1 > 0)
                    {
                        if (ingredient1.isEmpty())
                        {
                            Toast.makeText(MainActivity.this, "Enter Ingredients 1", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        qnty1 = qnty1 * desired_servings;
                        RecipeResults(mySpinner);
                        Log.d("Thing", "I did the thing boss");
                    }
                    else if ((qnty1 == 0))
                    {
                        Toast.makeText(MainActivity.this, "Quantities cannot be 0", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Invalid Quantity", Toast.LENGTH_SHORT).show();
                    }
                }
                else if (!Quantity2.getText().toString().isEmpty() && Quantity1.getText().toString().isEmpty() && Quantity3.getText().toString().isEmpty())
                {
                    if (qnty2 > 0)
                    {
                        if (ingredient2.isEmpty())
                        {
                            Toast.makeText(MainActivity.this, "Enter Ingredients 2", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        qnty2 = qnty2 * desired_servings;
                        RecipeResults(mySpinner2);
                        Log.d("Thing", "I did the thing boss");
                    }
                    else if ((qnty2 == 0))
                    {
                        Toast.makeText(MainActivity.this, "Quantities cannot be 0", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Invalid Quantity", Toast.LENGTH_SHORT).show();
                    }
                }
                else if (!Quantity3.getText().toString().isEmpty() && Quantity1.getText().toString().isEmpty() && Quantity2.getText().toString().isEmpty())
                {
                    if (qnty3 > 0)
                    {
                        if (ingredient3.isEmpty())
                        {
                            Toast.makeText(MainActivity.this, "Enter Ingredients 3", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        qnty3 = qnty3 * desired_servings;
                        RecipeResults(mySpinner3);
                        Log.d("Thing", "I did the thing boss");
                    }
                    else if ((qnty3 == 0))
                    {
                        Toast.makeText(MainActivity.this, "Quantities cannot be 0", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Invalid Quantity", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            //DIVIDER RESIZER
            else
            {
                if (!Quantity1.getText().toString().isEmpty() && !Quantity2.getText().toString().isEmpty() && !Quantity3.getText().toString().isEmpty())
                {
                    if (ingredient1.isEmpty() && ingredient2.isEmpty() && ingredient3.isEmpty())
                    {
                        Toast.makeText(MainActivity.this, "Enter Ingredients 1, 2 and 3", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    else if (ingredient1.isEmpty() && ingredient2.isEmpty())
                    {
                        Toast.makeText(MainActivity.this, "Enter Ingredients 1 and 2", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    else if (ingredient2.isEmpty() && ingredient3.isEmpty())
                    {
                        Toast.makeText(MainActivity.this, "Enter Ingredients 2 and 3", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    else if (ingredient1.isEmpty() && ingredient3.isEmpty())
                    {
                        Toast.makeText(MainActivity.this, "Enter Ingredients 1 and 3", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    else if (ingredient1.isEmpty())
                    {
                        Toast.makeText(MainActivity.this, "Enter Ingredients 1", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    else if (ingredient2.isEmpty())
                    {
                        Toast.makeText(MainActivity.this, "Enter Ingredients 2", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    else if (ingredient3.isEmpty())
                    {
                        Toast.makeText(MainActivity.this, "Enter Ingredients 3", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    qnty1 = Integer.parseInt(Quantity1.getText().toString());
                    qnty2 = Integer.parseInt(Quantity2.getText().toString());
                    qnty3 = Integer.parseInt(Quantity3.getText().toString());
                    if ((qnty1 > 0) && (qnty2 > 0) && (qnty3 > 0))
                    {
                        qnty1 = qnty1 / desired_servings;
                        qnty2 = qnty2 / desired_servings;
                        qnty3 = qnty3 / desired_servings;
                        RecipeResults(mySpinner, mySpinner2, mySpinner3);
                    }
                    else if ((qnty1 == 0) && (qnty2 == 0) && (qnty3 == 0))
                    {
                        Toast.makeText(MainActivity.this, "Quantities cannot be 0", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Invalid Quantities", Toast.LENGTH_SHORT).show();
                    }
                }
                else if (!Quantity1.getText().toString().isEmpty() && !Quantity2.getText().toString().isEmpty())
                {
                    qnty1 = Integer.parseInt(Quantity1.getText().toString());
                    qnty2 = Integer.parseInt(Quantity2.getText().toString());
                    if (qnty1 > 0 && qnty2 > 0)
                    {
                        if (ingredient1.isEmpty() && ingredient2.isEmpty())
                        {
                            Toast.makeText(MainActivity.this, "Enter Ingredients 1 and 2", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else if (ingredient1.isEmpty())
                        {
                            Toast.makeText(MainActivity.this, "Enter Ingredients 1", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else if (ingredient2.isEmpty())
                        {
                            Toast.makeText(MainActivity.this, "Enter Ingredients 2", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        qnty1 = qnty1 / desired_servings;
                        qnty2 = qnty2 / desired_servings;
                        RecipeResults(mySpinner, mySpinner2);
                    }
                    else if ((qnty1 == 0) && (qnty2 == 0))
                    {
                        Toast.makeText(MainActivity.this, "Quantities cannot be 0", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Invalid Quantities", Toast.LENGTH_SHORT).show();
                    }
                }
                else if (!Quantity2.getText().toString().isEmpty() && !Quantity3.getText().toString().isEmpty())
                {
                    qnty2 = Integer.parseInt(Quantity2.getText().toString());
                    qnty3 = Integer.parseInt(Quantity3.getText().toString());
                    if (qnty2 > 0 && qnty3 > 0)
                    {
                        if (ingredient2.isEmpty() && ingredient3.isEmpty())
                        {
                            Toast.makeText(MainActivity.this, "Enter Ingredients 2 and 3", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else if (ingredient2.isEmpty())
                        {
                            Toast.makeText(MainActivity.this, "Enter Ingredients 2", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else if (ingredient3.isEmpty())
                        {
                            Toast.makeText(MainActivity.this, "Enter Ingredients 3", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        qnty2 = qnty2 / desired_servings;
                        qnty3 = qnty3 / desired_servings;
                        RecipeResults(mySpinner2, mySpinner3);
                    }
                    else if ((qnty2 == 0) && (qnty3 == 0))
                    {
                        Toast.makeText(MainActivity.this, "Quantities cannot be 0", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Invalid Quantities", Toast.LENGTH_SHORT).show();
                    }
                }
                else if (!Quantity1.getText().toString().isEmpty() && !Quantity3.getText().toString().isEmpty())
                {
                    if (ingredient1.isEmpty() && ingredient3.isEmpty())
                    {
                        Toast.makeText(MainActivity.this, "Enter Ingredients 1 and 3", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    else if (ingredient1.isEmpty())
                    {
                        Toast.makeText(MainActivity.this, "Enter Ingredients 1", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    else if (ingredient3.isEmpty())
                    {
                        Toast.makeText(MainActivity.this, "Enter Ingredients 3", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    qnty1 = Integer.parseInt(Quantity1.getText().toString());
                    qnty3 = Integer.parseInt(Quantity3.getText().toString());
                    if ((qnty1 > 0 && qnty3 > 0))
                    {
                        qnty1 = qnty1 / desired_servings;
                        qnty3 = qnty3 / desired_servings;
                        RecipeResults(mySpinner, mySpinner3);
                    }
                    else if ((qnty1 == 0) && (qnty3 == 0))
                    {
                        Toast.makeText(MainActivity.this, "Quantities cannot be 0", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Invalid Quantities", Toast.LENGTH_SHORT).show();
                    }
                }
                else if (!Quantity1.getText().toString().isEmpty() && Quantity2.getText().toString().isEmpty() && Quantity3.getText().toString().isEmpty())
                {
                    qnty1 = Integer.parseInt(Quantity1.getText().toString());
                    if (qnty1 > 0)
                    {
                        if (DesiredServings.getText().toString().isEmpty())
                        {
                            Toast.makeText(MainActivity.this, "Enter: Desired Servings", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if (ingredient1.isEmpty())
                        {
                            Toast.makeText(MainActivity.this, "Enter Ingredients 1", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        qnty1 = qnty1 / desired_servings;
                        RecipeResults(mySpinner);
                    }
                    else if ((qnty1 == 0))
                    {
                        Toast.makeText(MainActivity.this, "Quantities cannot be 0", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Invalid Quantity", Toast.LENGTH_SHORT).show();
                    }
                }
                else if (!Quantity2.getText().toString().isEmpty() && Quantity1.getText().toString().isEmpty() && Quantity3.getText().toString().isEmpty())
                {
                    if (qnty2 > 0)
                    {
                        if (ingredient2.isEmpty())
                        {
                            Toast.makeText(MainActivity.this, "Enter Ingredients 2", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        qnty2 = qnty2 / desired_servings;
                        RecipeResults(mySpinner2);
                        Log.d("Thing", "I did the thing boss");
                    }
                    else if ((qnty2 == 0))
                    {
                        Toast.makeText(MainActivity.this, "Quantities cannot be 0", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Invalid Quantity", Toast.LENGTH_SHORT).show();
                    }
                }
                else if (!Quantity3.getText().toString().isEmpty() && Quantity1.getText().toString().isEmpty() && Quantity2.getText().toString().isEmpty())
                {
                    if (qnty3 > 0)
                    {
                        if (ingredient3.isEmpty())
                        {
                            Toast.makeText(MainActivity.this, "Enter Ingredients 3", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        qnty3 = qnty3 / desired_servings;
                        RecipeResults(mySpinner3);
                        Log.d("Thing", "I did the thing boss");
                    }
                    else if ((qnty3 == 0))
                    {
                        Toast.makeText(MainActivity.this, "Quantities cannot be 0", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Invalid Quantity", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }

    //ONLY ONE ROW, THUS ONLY ONE SPINNER ACTIVE
    private void RecipeResults(String t)
    {
        Log.d("Button Clicked", "(1 Param) Button has been clicked");

        Intent intent = new Intent(MainActivity.this, Resized_Recipe.class);
        intent.putExtra(("Name"), recipe_name);
        intent.putExtra("Quantity", qnty1);
        intent.putExtra("SpinnerValue", t);
        intent.putExtra("Ingredient1", ingredient1);
        Log.d("Thing", "I did the thing boss");
        startActivity(intent);
    }

    //TWO ROWS, THUS TWO SPINNERS ACTIVE
    private void RecipeResults(String t, String s)
    {
        Log.d("Button Clicked", "(2 Params) Button has been clicked");

        Intent intent = new Intent(MainActivity.this, Resized_Recipe.class);
        intent.putExtra(("Name"), recipe_name);
        intent.putExtra("Quantity", qnty1);
        intent.putExtra("Quantity2", qnty2);
        intent.putExtra("SpinnerValue", t);
        intent.putExtra("Spinner2", s);
        intent.putExtra("Ingredient1", ingredient1);
        intent.putExtra("Ingredient2", ingredient2);
        startActivity(intent);
    }

    //THREE ROWS, THUS THREE SPINNERS ACTIVE
    private void RecipeResults(String t, String s, String r)
    {
        Log.d("Button Clicked", "(3 Params) Button has been clicked");

        Intent intent = new Intent(MainActivity.this, Resized_Recipe.class);
        intent.putExtra(("Name"), recipe_name);
        intent.putExtra("Quantity", qnty1);
        intent.putExtra("Quantity2", qnty2);
        intent.putExtra("Quantity3", qnty3);
        intent.putExtra("SpinnerValue", t);
        intent.putExtra("Spinner2", s);
        intent.putExtra("Spinner3", r);
        intent.putExtra("Ingredient1", ingredient1);
        intent.putExtra("Ingredient2", ingredient2);
        intent.putExtra("Ingredient3", ingredient3);
        startActivity(intent);
    }
}