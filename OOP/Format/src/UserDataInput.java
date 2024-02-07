import java.util.Scanner;

public class UserDataInput {
    public static String getUserInput() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите данные в формате:\n<Фамилия> <Имя> <Отчество> <Дата рождения (дд.мм.гггг)> <Телефон (12 цифр)> <Пол>");
            String input = scanner.nextLine();
            scanner.close();
            return input;
    }
}
