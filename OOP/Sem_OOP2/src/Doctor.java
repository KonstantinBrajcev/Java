import java.time.LocalDate;

public class Doctor {
    protected String name;
    protected LocalDate birthDate;
    protected String univesity;
    protected String type;

    public Doctor(String name, LocalDate birthDate, String univesity) {
        this.name = name;
        this.birthDate = birthDate;
        this.univesity = univesity;
        this.type = getClass().getSimpleName();
    }

    public String getName() {
        return name;
    }

    public LocalDate birthDate() {
        return birthDate;
    }

    public String getUnivesity() {
        return univesity;
    }

    public String work() {
        System.out.printf("%s - Helping animals", type);
        return type;
    }
}
