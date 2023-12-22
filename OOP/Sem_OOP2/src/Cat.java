import java.time.LocalDate;
import java.util.List;

public class Cat extends Animal implements Goable{
    private int legsCount;
    public Cat(String name, LocalDate birthDate, List<String> vaccination, String illness, String ownerName, int legsCount) {
        super(name, birthDate, vaccination, illness, ownerName);
        this.legsCount = legsCount;
    }

    public int getLegsCount() {
        return legsCount;
    }

    @Override
    public double run() {
        System.out.printf("%s going", type);
        return 10.0;
    }

}
