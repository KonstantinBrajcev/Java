import java.time.LocalDate;

public class Nurse {
    protected String name;
    protected LocalDate birthDate;
    protected String univesity;
    protected String type;

    public Nurse(String name, LocalDate birthDate, String univesity) {
        this.name = name;
        this.birthDate = birthDate;
        this.univesity = univesity;
        this.type = getClass().getSimpleName();
    }

    public String work() {
        System.out.printf("%s - helping Doctor", type);
        return type;
    }

}
