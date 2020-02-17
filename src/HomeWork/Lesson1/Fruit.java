package HomeWork.Lesson1;

public  abstract class Fruit {
    String name;
    Float weight;

    public Fruit(String name, Float weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }


    public Float getWeight() {
        return weight;
    }
}
