import java.time.LocalDate;
import java.util.List;

public class Eagle extends Animal implements Flyble, Goable{
    public Eagle(String name, LocalDate birthDate, List<String> vaccination, String illness, String ownerName) {
        super(name, birthDate, vaccination, illness, ownerName);
    }

    @Override
    public double fly() {
        System.out.printf("%s flying", type);
        return 20.0;
    }

    @Override
    public double run() {
        System.out.printf("%s going", type);
        return 2.0;
    }
}
