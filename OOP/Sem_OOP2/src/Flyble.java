@FunctionalInterface
public interface Flyble {
    public final static int i = 0;

    double fly();

    default double acceleration() {
        return 9.8;
    }
}
