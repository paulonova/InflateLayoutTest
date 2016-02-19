package se.paulo.nackademin.inflatelayouttest;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class ListOfAnimals extends AppCompatActivity {


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lit_of_animals);

        MyZoo myZoo = new MyZoo();
        //myZoo.getNumberOfAnimals();

        // Hämta det som ska innehålla animal_card, d.v.s. vår card_container
        LinearLayout animalCardContainer = (LinearLayout) findViewById(R.id.card_container);

        for (int i = 0; i < myZoo.getNumberOfAnimals(); i++) {

            //Hämta ett vist animal (i)..
            Animal theAnimal = myZoo.getAnimal(i);

            String name = theAnimal.getAnimalName();
            String description = theAnimal.getAnimalDescription();
            int image = theAnimal.getAnimalImage();

            // INFLATE starts here..
            // Hämta XML-koden för ett kort och gör om till ett objekt i Java (inflate)
            View animalCard = getLayoutInflater().inflate(R.layout.animal_card, animalCardContainer, false);

            // The Views hämtas ifrån animalCard.findViewById
            TextView animalName = (TextView) animalCard.findViewById(R.id.animal_name);
            TextView animalDescription = (TextView) animalCard.findViewById(R.id.animal_description);
            ImageView animalImage = (ImageView) animalCard.findViewById(R.id.animal_image);

            // Skappar TAG till varenda button..???
            Button animalExplore = (Button) animalCard.findViewById(R.id.exploreBtn);
            Button animalShare = (Button) animalCard.findViewById(R.id.shareBtn);
            animalShare.setTag(name.toLowerCase());
            animalExplore.setTag(name.toLowerCase());

            animalName.setText(name);
            animalDescription.setText(description);
            animalImage.setImageResource(image);
            animalCardContainer.addView(animalCard);


        }

    }


    // Share button listener..
    public void shareInformation(View v) {
        String animalName = "";
        String animalDescription = "";
        String tag = (String) v.getTag();
        MyZoo myZoo = new MyZoo();

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


    public void exploreAnimal(View v){
        String tag = (String) v.getTag();
        String name = "";

        switch (tag){

            case "labrador":
                name = "labrador";
                break;

            case "dolphin":
                name = "dolphin";
                break;

            case "black horse":
                name = "black horse";
                break;

            case "panda":
                name = "panda";
                break;
        }

        Intent intent = new Intent(this, DetailedInformationActivity.class);
        intent.putExtra("animal", name);
        startActivity(intent);
    }

}
