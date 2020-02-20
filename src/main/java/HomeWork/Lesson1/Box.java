package HomeWork.Lesson1;

import java.util.ArrayList;

public class Box<Fruit> {

    ArrayList<Fruit> list = new ArrayList<>();

    public void addFruit(Fruit f) {
        if (!list.isEmpty()) {
            if (this.list.get(0).getClass().getName().equals(f.getClass().getName())) {
                System.out.println("В ящик добавлен " + (f.getClass().getName()));
                list.add(f);
            } else {
                System.out.println("В зтот ящик добавить нельзя");
            }
        } else {
            list.add(f);
            System.out.println("В ящик добавлен " + (f.getClass().getName()));
        }

    }

    public void pourOutAll() {
        this.list.clear();
    }

    public void removeFruit() {
        int last = this.list.size() - 1;
        if (!this.list.isEmpty()) this.list.remove(last);
        else System.out.println("В ящике этого нет!");
    }

    public Float getWeight() {
        Float boxWeight = 0f;
        if (this.list.isEmpty()) return boxWeight;
        if (this.list.get(0) instanceof Apple) {
            return boxWeight + this.list.size();
        } else return boxWeight + this.list.size() * 1.5f;
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
