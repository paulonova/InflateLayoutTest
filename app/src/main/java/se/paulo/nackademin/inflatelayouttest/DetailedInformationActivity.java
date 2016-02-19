package se.paulo.nackademin.inflatelayouttest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class DetailedInformationActivity extends AppCompatActivity {

    ImageView animalPortrait;
    TextView animalHeadline;
    TextView animalDescription;
    Button shareBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);

        Intent intent = getIntent();
        String animalToDisplay = intent.getStringExtra("animal");

        MyZoo myZoo = new MyZoo();
        Animal animal = myZoo.getAnimalString(animalToDisplay);

        // Setting tag in button
        shareBtn = (Button)findViewById(R.id.detail_shareBtn);
        shareBtn.setTag(animalToDisplay);

        animalPortrait = (ImageView)findViewById(R.id.detail_animal_image);
        animalHeadline = (TextView)findViewById(R.id.detail_animal_name);
        animalDescription = (TextView)findViewById(R.id.detail_animal_description);

        if(animal != null){
            animalPortrait.setImageResource(animal.getAnimalImage());
            animalHeadline.setText(animal.getAnimalName());
            animalDescription.setText(animal.getAnimalDescription());
        }


    }

    // Share button listener..
    public void shareInformation(View v) {
        String animalName = "";
        String animalDescription = "";
        String tag = (String) v.getTag();
        MyZoo myZoo = new MyZoo();

        Toast.makeText(this, "Tag är: " + tag, Toast.LENGTH_SHORT).show();

        for (int i = 0; i < myZoo.getNumberOfAnimals(); i++) {
            Animal theAnimal = myZoo.getAnimal(i);
            animalDescription = theAnimal.getAnimalDescription();
            animalName = theAnimal.getAnimalName();

            if (tag.equalsIgnoreCase(animalName)) {
                // Visa upp en "Toast" med att vi klickat på knappen...
                //Toast.makeText(this, "Animal: " + tag, Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, animalDescription);
                intent.setType("text/plain");
                startActivity(intent);

            }

        }

    }

    public void backToAnimalList(View v){
        Intent intent = new Intent(this, ListOfAnimals.class);
        startActivity(intent);

    }

}
