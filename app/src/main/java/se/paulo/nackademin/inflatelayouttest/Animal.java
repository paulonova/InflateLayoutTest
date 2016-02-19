package se.paulo.nackademin.inflatelayouttest;


public class Animal {

    private String animalName;
    private int animalImage;
    private String animalDescription;

    public Animal(int animalImage, String animalName, String animalDescription) {
        this.animalImage = animalImage;
        this.animalName = animalName;
        this.animalDescription = animalDescription;
    }

    public Animal() {
    }


    //Getters and Setters
    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public int getAnimalImage() {
        return animalImage;
    }

    public void setAnimalImage(int animalImage) {
        this.animalImage = animalImage;
    }

    public String getAnimalDescription() {
        return animalDescription;
    }

    public void setAnimalDescription(String animalDescription) {
        this.animalDescription = animalDescription;
    }
}
