package Pharmacy;
import java.util.*;
import java.util.List;

public class IterablePharmacy implements Iterable<Component>, Comparable<Pharmacy> {
    private List<Component> components;

    private int index;
    private int power;

    public IterablePharmacy() {
        this.power = 0;
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

    public void addComponents(Component... components) {
        if (components.length == 0) System.out.printf("Вы ничего не добавили ");
        else Collections.addAll(this.components, components);
    }

    public List<Component> getComponents() {
        return components;
    }

    public int getPower() {
        int power = 0;
        for (Component c : components) {
            power += c.getPower();
        }
        return power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IterablePharmacy that = (IterablePharmacy) o;
        return index == that.index && Objects.equals(components, that.components);
    }

    @Override
    public int hashCode() {
        return 31 * Objects.hash(components, index);
    }

    @Override
    public Iterator<Component> iterator() {
        return new Iterator<Component>() {
            @Override
            public boolean hasNext() {
                return index < components.size();
            }

            @Override
            public Component next() {
                return components.get(index++);
            }
        };
    }

    @Override
    public int compareTo(Pharmacy o) {
        return Integer.compare(this.getPower(), o.getPower());
    }
}