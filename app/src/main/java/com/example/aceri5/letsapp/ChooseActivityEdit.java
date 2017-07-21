package com.example.aceri5.letsapp;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.List;
public class ChooseActivityEdit extends AppCompatActivity/* implements AdapterView.OnItemSelectedListener */{

    public Activity choose_activity_edit_pointer = this;
    int icons[] = {R.drawable.verysmalllogo, R.drawable.iconsport, R.drawable.iconbeer, R.drawable.iconcoffee, R.drawable.iconlunch,
                    R.drawable.iconpray, R.drawable.icondance};

    protected CharSequence categories[] = {"Café", "Fast Food", "Bars", "Night Clubs",
            "Sports", "Entertainment", "Shopping", "Others"};
    protected ArrayList<CharSequence> selectedCategories = new ArrayList<CharSequence>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_activity_edit);
        //addItemsOnSpinner();
        //addIconsOnSpinner();
        final EditText ActivityName = (EditText) findViewById(R.id.NameYourActivityET);
        //final String activity_name = ActivityName.getText().toString();
        Button next = (Button) findViewById(R.id.next);
        Button back = (Button) findViewById(R.id.back);
        final Button categoryChooseButton = (Button) findViewById(R.id.chooseCategory);
        //ImageButton icons_ = (ImageButton) findViewById(R.id.iconsBTN);

        final Spinner icons_spin = (Spinner) findViewById(R.id.icon_spinner);
        //icons_spin.setOnItemSelectedListener(this);

        CustomIconSpinner customIconSpinner = new CustomIconSpinner(getApplicationContext(), icons);
        icons_spin.setAdapter(customIconSpinner);


        //addListenerOnButton();
       // addListenerOnSpinnerItemSelection();


        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String activity_name = ActivityName.getText().toString();
                int activity_icon = icons_spin.getId();
                if (activity_name.matches("")){
                    Toast.makeText(ChooseActivityEdit.this, "Please name your Activity", Toast.LENGTH_LONG).show();
                } else {
                    EventActivity event= new EventActivity(activity_name, activity_icon);
                    ChooseActivity.events_list.add(event);
                    Intent intent = new Intent(choose_activity_edit_pointer, ChooseActivity.class);
                    startActivity(intent);
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(choose_activity_edit_pointer,ChooseActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        categoryChooseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                ShowSelectCategoryDialog();
            }

            protected void ShowSelectCategoryDialog(){

                int count = categories.length;
                boolean[] checkedCategories = new boolean[count];
                for (int i = 0; i < count; i++){
                    checkedCategories[i] = selectedCategories.contains(categories[i]);
                }
                DialogInterface.OnMultiChoiceClickListener categoryDialogListener =
                        new DialogInterface.OnMultiChoiceClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked){
                                if (isChecked)
                                    selectedCategories.add(categories[which]);
                                else
                                    selectedCategories.remove(categories[which]);
                                onChangeSelectedCategories();
                                //Should we add "ALL" option?
                            }
                        };
                AlertDialog.Builder builder = new AlertDialog.Builder(choose_activity_edit_pointer);
                builder.setTitle("Select Relevant Categories");
                builder.setMultiChoiceItems(categories, checkedCategories, categoryDialogListener);
                AlertDialog dialog = builder.create();
                dialog.show();
                Window window = dialog.getWindow();
                window.setLayout(1000, 1200);
            }

            protected void onChangeSelectedCategories(){
                StringBuilder stringBuilder = new StringBuilder();
                for (CharSequence category : selectedCategories){
                    if (selectedCategories.get(0) == category){
                        stringBuilder.append(category);
                    }
                    else {
                        stringBuilder.append(", " + category);
                    }
                }
                categoryChooseButton.setText(stringBuilder.toString());
            }

        });

    }




    // private Spinner spinner_choose_icon; simple_spinner_item
   // private void addIconsOnSpinner() {simple_spinner_dropdown_item

    //}


    //@Override
    //public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    //}

    //@Override
    //public void onNothingSelected(AdapterView<?> parent) {

    //}
}
