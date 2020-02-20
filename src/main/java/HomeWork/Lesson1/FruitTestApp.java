package HomeWork.Lesson1;

public class FruitTestApp {
    public static void main(String[] args) {
        Box box1 = new Box();
        Box box2 = new Box();
        box1.addFruit(new Apple());
        System.out.println("box1 весит: " + box1.getWeight());
        box2.addFruit(new Orange());
        System.out.println("box2 весит: " + box2.getWeight());
        box1.addFruit(new Orange());
        box2.addFruit(new Apple());
        box1.addFruit(new Apple());
        box1.addFruit(new Apple());
        box1.addFruit(new Apple());
        System.out.println("box1 весит: " + box1.getWeight());
        System.out.println("Равен ли вес box1 b box2? " + box1.compare(box2));
        box2.addFruit(new Orange());
        box1.removeFruit();
        System.out.println("Равен ли вес box1 b box2? " + box1.compare(box2));
        box1.pourOutAll();
        System.out.println("box1 весит: " + box1.getWeight());
    }
}
