package homework;

import java.io.IOException;

public class Main{

    public static void main(String[] args) throws IOException {// ����� ����� � ���������
        User user = new User("Bob");// ������� ������ �����
        user.report();// ������� �����
        user.save();// ��������� ����� (��������)
        user.delete();// ������� ����� (��������)
    }
}