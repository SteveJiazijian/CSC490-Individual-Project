/*
This app will let the user set a calories intake goal, by putting
what they eat in the day, they can print a report at the
end of the day to see of the achieve their goal and how many calories
did they get from the food.

Steve Jia
Reference:
Spinner tutorial on google Android developer
getSelectedItem Class information on Java developer

 */
package com.example.calcal;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String foodName;
    int totalCal = 0;
    int plan = 0;
    int largestCal = 0;
    String largestCalFood = "";
    String bkString = "";
    String luString = "";
    String diString = "";
    ArrayList<Integer> calList;
    TextView bk;
    TextView lu;
    TextView di;
    TextView planText;
    EditText cp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner catSpinner = findViewById(R.id.catSpin);
        final Button breakfast = findViewById(R.id.BreakfestButton);
        final Button lunch = findViewById(R.id.LunchButton);
        final Button dinner = findViewById(R.id.DinnerButton);
        final Button compute = findViewById(R.id.report);
        final Button set = findViewById(R.id.setButton);
        final Button reset = findViewById(R.id.resetButton);
        bk = findViewById(R.id.blist);
        lu = findViewById(R.id.llist);
        di = findViewById(R.id.dlist);
        cp = findViewById(R.id.calPlan);
        planText = findViewById(R.id.setPlanText);
        calList = new ArrayList<>();
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.catName, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        catSpinner.setAdapter(adapter);
        catSpinner.setOnItemSelectedListener(this);
        set.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                    try{
                        plan = Integer.parseInt(cp.getText().toString());
                        planText.setText("Your Calories Goal is: " + plan);
                    }catch (NumberFormatException e){
                        AlertDialog.Builder build = new AlertDialog.Builder(MainActivity.this);
                        build.setCancelable(true);
                        build.setTitle("Warning");
                        build.setMessage("Please enter a Integer Number");
                        build.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                    }
            }
        });
        /*
        handle the reset function, after the button is clicked restart the activity
         */
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                overridePendingTransition(0,0);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
                startActivity(intent);

            }
        });
        /*
        Put the name of the food to the textView under each meal
         */
        breakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bk.append(foodName + "\n");
                bkString += bk.toString();
                calList.add(getCal(foodName));
                if(getCal(foodName) > largestCal){
                    largestCal = getCal(foodName);
                    largestCalFood = foodName;
                }
            }
        });
        lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lu.append(foodName + "\n");
                luString += lu.toString();
                calList.add(getCal(foodName));
                if(getCal(foodName) > largestCal){
                    largestCal = getCal(foodName);
                    largestCalFood = foodName;
                }
            }
        });
        dinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                di.append(foodName + "\n");
                diString += di.toString();
                calList.add(getCal(foodName));
                if(getCal(foodName) > largestCal){
                    largestCal = getCal(foodName);
                    largestCalFood = foodName;
                }
            }
        });
        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Calories Report");
                for(int i = 0; i < calList.size(); i++){
                    totalCal += calList.get(i);
                }
                builder.setMessage("Your total calories intake today is " + totalCal + " " + "\n" +
                                   " Your calories intake plan is " + plan + "\n" + " " +
                                    resultD(totalCal, plan) + "\n" +
                                   " The largest Calories food you eat is: " + largestCalFood + "\n" +
                                   " that is " + largestCal + " cal.");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            foodName = parent.getItemAtPosition(position).toString();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
    public int getCal(String name){
        int cal;
        switch (name) {
            case "Apple":
                cal = 95;
                break;
            case "Apricot":
                cal = 79;
                break;
            case "Banana":
                cal = 105;
                break;
            case "Peach":
                cal = 59;
                break;
            case "Plum":
                cal = 30;
                break;
            case "Cherry":
                cal = 77;
                break;
            case "Kiwi":
                cal = 42;
                break;
            case "Mango":
                cal = 201;
                break;
            case "Chicken":
                cal = 335;
                break;
            case "Beef":
                cal = 213;
                break;
            case "Pork":
                cal = 206;
                break;
            case "Pepper":
                cal = 30;
                break;
            case "Lemon":
                cal = 17;
                break;
            case "Duck":
                cal = 472;
                break;
            case "Noodle":
                cal = 221;
                break;
            case "Water":
                cal = 0;
                break;
            case "RootBeer":
                cal = 152;
                break;
            case "Cola":
                cal = 182;
                break;
            case "Soda":
                cal = 150;
                break;
            default:
                cal = 2;
                break;
        }
        return cal;
    }

    public String resultD(int total, int plan){
        if(total > plan){
            return "Your Calories intake is more than the plan you set, try harder next time!";
        }else{
            return "Good job you did it!";
        }
    }
}
