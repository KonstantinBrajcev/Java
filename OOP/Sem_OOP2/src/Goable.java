import java.io.Serializable;

@FunctionalInterface
public interface Goable {
    public final static int i = 0;

    double run();

    default double acceleration() {
        return 9.8;
    }
}
