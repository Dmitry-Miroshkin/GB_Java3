package HomeWork.Lesson1;

import java.util.ArrayList;

public class Box<Fruit> {

    ArrayList<Fruit> list = new ArrayList<>();

    public void addFruit(Fruit f) {
        if (!list.isEmpty()) {
            if (this.list.getClass().getName().equals(f.getClass().getName())) {
                System.out.println("В ящик добавлен "+ (f.getClass().getName()));
                list.add(f);
            }
            else {System.out.println("В зтот ящик добавить нельзя");
            }
        } else list.add(f);

    }

    public void pourOutAll() {
        this.list.clear();
    }

    public void removeFruit(Fruit f) {
        if (!list.isEmpty() && list.contains(f)) list.remove(f);
        else System.out.println("В ящике этого нет!");
    }

    public Float getWeight() {
        Float boxWeight = 0f;

        return boxWeight * this.list.size();
    }

    public boolean isEmpty() {

        return this.list.isEmpty();
    }

    public boolean compare(Box box) {

        return (this.getWeight().equals(box.getWeight()));
    }

    public void pourToBox(Box box) {

    }
}
