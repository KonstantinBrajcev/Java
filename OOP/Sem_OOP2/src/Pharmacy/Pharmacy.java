package Pharmacy;
import java.util.*;
import java.util.List;

public class Pharmacy implements Iterator<Component>, Comparable<Pharmacy> {
    private List<Component> components;

    private int index;
    private int power;

    public Pharmacy() {
        this.index = 0;
        this.components = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "components=" + components +
                ", index=" + index +
                '}';
    }

    public int getPower() {
        int power = 0;
        for (Component com : components) {
            power += com.getPower();
        }
        return power;
    }

    public void addComponents(Component... components) {
        if (components.length == 0) System.out.printf("Вы ничего не добавили ");
        else Collections.addAll(this.components, components);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pharmacy pharmacy = (Pharmacy) o;
        return index == pharmacy.index && Objects.equals(components, pharmacy.components);
    }

    @Override
    public int hashCode() {
        return 29 * Objects.hash(components, index);
    }

    @Override
    public boolean hasNext() {
        return index < components.size();
    }

    @Override
    public Component next() {
        return components.get(index++);
    }
    public int compareTo(Pharmacy o) {
        return Integer.compare(this.getPower(), o.getPower());
    }
}