import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VeterinaryClinic {
    private List<Animal> patients = new ArrayList<>();

    // Добавление одного пациента
    public void addPatient(Animal animal) {
        patients.add(animal);
    }

    // Добавление нескольких пациентов
    public void addPatients(Animal... animals) {
        Collections.addAll(patients, animals);
    }

    // Вывод списка пациентов
    public List<Animal> getPatients() {
        return patients;
    }

    // Вывод животных которые ходят
    public List<Goable> getGoables() {
        List<Goable> result = new ArrayList<>(patients.size());
        for (Animal animal : patients) {
            if (animal instanceof Goable)
                result.add((Goable) animal);
        }
        return result;
    }

    // Вывод животных которые летают
    public List<Flyble> getFlyables() {
        List<Flyble> result = new ArrayList<>(patients.size());
        for (Animal animal : patients) {
            if (animal instanceof Flyble)
                result.add((Flyble) animal);
        }
        return result;
    }

    // Вывод животных которые летают
    public List<Swimble> getSwimbles() {
        List<Swimble> result = new ArrayList<>(patients.size());
        for (Animal animal : patients) {
            if (animal instanceof Swimble)
                result.add((Swimble) animal);
        }
        return result;
    }
}
