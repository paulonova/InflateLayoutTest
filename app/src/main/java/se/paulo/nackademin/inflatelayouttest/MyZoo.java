package se.paulo.nackademin.inflatelayouttest;


import java.util.ArrayList;

public class MyZoo {

    ArrayList<Animal> animals = new ArrayList<>();


    public MyZoo() {

        String dogDescription = "Karaktären hos rasen är en blandning av mjuk tillgivenhet och vaksamhet. Temperamentet beskrivs ofta som lite förnämt skurkaktigt.";
        String horseDescription = "True black horses have dark brown eyes, black skin, and wholly black hair coats without any areas of permanently reddish or brownish hair.";
        String dolphinDescription = "Dolphins are highly intelligent marine mammals and are part of the family of toothed whales that includes orcas and pilot whales.";
        String pandaDescription = "Giant pandas live in a few mountain ranges in central China, in Sichuan, Shaanxi, and Gansu provinces. ";
        Animal dog = new Animal(R.drawable.dog1, "Labrador",dogDescription);
        Animal dolphin = new Animal(R.drawable.dolfin1, "Dolphin",dolphinDescription);
        Animal horse = new Animal(R.drawable.horse1, "Black Horse",horseDescription);
        Animal panda = new Animal(R.drawable.panda, "Panda",pandaDescription);

        animals.add(dog);
        animals.add(dolphin);
        animals.add(horse);
        animals.add(panda);

    }

    public Animal getAnimalString (String whitchAnimal){

        // Gör en sökning efter efterfrågat djur (whichanimal) i vår ArrayList med djur
        for (Animal animal : animals) {
            if(animal.getAnimalName().toLowerCase().equals(whitchAnimal.toLowerCase())){
                return animal;
            }
        }

        // Om inget djur kunde hittas, returnera null
        return null;
    }


    public Animal getAnimalDescription (Animal whitchAnimal){

        // Gör en sökning efter efterfrågat djur (whichanimal) i vår ArrayList med djur
        for (Animal animal : animals) {
            if(animal.getAnimalDescription().toLowerCase().contains(whitchAnimal.getAnimalDescription().toLowerCase())){

                return animal;
            }
        }

        // Om inget djur kunde hittas, returnera null
        return null;
    }




    public Animal getAnimal(int x){
        return animals.get(x);
    }

    public int getNumberOfAnimals(){
        return animals.size();
    }




}
