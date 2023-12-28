package Pharmacy;
import java.util.Iterator;

public class ComponentIterator implements Iterator<Component> {
    private int index = 0;
    private IterablePharmacy pharmacy;

    public ComponentIterator(IterablePharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    @Override
    public boolean hasNext() {
        return index < pharmacy.getComponents().size();
    }

    @Override
    public Component next() {
        return pharmacy.getComponents().get(index++);
    }
    public int getPower(Component c) {
        int power = 0;
        for (Component com : pharmacy) power += com.getPower();
        return power;
    }

}