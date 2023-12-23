import java.time.LocalDate;

public class Nurse extends Doctor {
    public Nurse(String name, LocalDate birthDate, String univesity) {
        super(name, birthDate, univesity);
    }

    @Override
    public String work() {
        System.out.printf("%s - helping Doctor", type);
        return type;
    }

}
