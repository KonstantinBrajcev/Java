import java.time.LocalDate;
import java.util.List;

public class Fish extends Animal implements Swimble{
    public Fish(String name, LocalDate birthDate, List<String> vaccination, String illness, String ownerName) {
        super(name, birthDate, vaccination, illness, ownerName);
    }

    @Override
    public double swim() {
        System.out.printf("%s swimming", type);
        return 20.0;
    }
}
