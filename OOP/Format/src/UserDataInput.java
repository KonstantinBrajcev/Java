import java.util.Scanner;

public class UserDataInput {
    public static String getUserInput() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("������� ������ � �������:\n<�������> <���> <��������> <���� �������� (��.��.����)> <������� (12 ����)> <���>");
            String input = scanner.nextLine();
            scanner.close();
            return input;
    }
}
