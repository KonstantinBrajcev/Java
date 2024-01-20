package notebook.view;

import notebook.controller.UserController;
import notebook.model.User;
import notebook.util.Commands;

import java.util.Scanner;
// ������� ���������������� ��������� ��� ������ USER
public class UserView {
    // ���������� ��������� ���� USERCONTROLLER
    private final UserController userController;
    // ��������� � �������� ��������� USERCONTROLLER
    public UserView(UserController userController) {
        this.userController = userController;
    }
    // ����� ������� ������� �����
    public void run(){
        Commands com;
        // ������ ���� ������� ������ � ������������
        while (true) {
            String command = prompt("������� ��������: ");
            com = Commands.valueOf(command);
            if (com == Commands.EXIT) return;
            // �������� ��� ���� ������������
            switch (com) {
                // �������� ������
                case CREATE:
                    User u = createUser();
                    userController.saveUser(u);
                    break;
                // ������ ������ �� ID
                case READ:
                    String id = prompt("������� ID ��� ������: ");
                    try {
                        User user = userController.readUser(Long.parseLong(id));
                        System.out.println(user);
                        System.out.println();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                // ��������� ������ �� ID
                case UPDATE:
                    String userId = prompt("������� ID ��� ���������: ");
                    userController.updateUser(userId, createUser());
                // �������� ������ �� ID
                case DELETE:
                    String userIdToDelete = prompt("������� ID ��� ��������: ");
                    try {
                        userController.delete(userIdToDelete);
                        System.out.println("ID ������ �������");
                        System.out.println();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                // �������� ���� �������
                case LIST:
                    System.out.println(userController.readAll());

            }
        }
    }
    // ����� ��� ������� ������ � ������������
    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
    // ������� ����� ������ USER
    private User createUser() {
        // ����������� ���� ��� � ��������
        String firstName = prompt("�������: ");
        String lastName = prompt("���: ");
        String phone = prompt("�������: ");
        // ���������� ��� � �������
        return new User(firstName, lastName, phone);
    }
}
