import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Создаем зверушек
        Cat cat = new Cat("Barsik", LocalDate.of(1993, 6, 6), new ArrayList<>(), "Chumka", "Boss", 4);
        Duck duck = new Duck("Donald", LocalDate.of(1934, 5, 3), new ArrayList<>(), "Flu", "Walter");
        Penguin penguin = new Penguin("Lolo", LocalDate.of(1987, 6, 26), new ArrayList<>(), "Flu", "Gennady");
        Animal eagle = new Eagle("Kesha", LocalDate.of(1993, 6, 6), new ArrayList<>(), "Chumka", "Boss");
        Fish fish = new Fish("Pepe", LocalDate.of(1997, 2, 6), new ArrayList<>(), "Flu", "Harry");

        // Сохраняем Зверушек
        List<Animal> animals = new ArrayList<>();
        animals.add(cat);
        animals.add(eagle);
        animals.add(penguin);
        animals.add(duck);
        animals.add(fish);

        // Создаем Клинику
        VeterinaryClinic clinic = new VeterinaryClinic();

        // Создаем докторов и медсестр
        Doctor james = new Doctor("James", LocalDate.of(1983, 6, 6), "Medical University");
        Nurse dasha = new Nurse("Dasha", LocalDate.of(1983, 6, 6), "Nurse Technikum");
        Nurse glasha = new Nurse("Glasha", LocalDate.of(1973, 3, 1), "Nurse Technikum");

        //Печатаем докторов и медсестр
        System.out.println(james.name);
        System.out.println(dasha.name);
        System.out.println(glasha.name);

        //Печатаем наших пациентов
        clinic.addPatients(cat, eagle, penguin, duck, fish);
        System.out.println(clinic.getPatients());
        System.out.println(clinic.getGoables());
        System.out.println(clinic.getFlyables());
        System.out.println(clinic.getSwimbles());
    }
}