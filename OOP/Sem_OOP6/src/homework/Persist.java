package homework;

public class Persist {// ����������� �������� � ���������� �����

    private final User user;// ���������� ������

    public Persist(User user){// ������� �����
        this.user = user;
    }

    public void save(){// ��������� �����
        System.out.println("������������ ��������: " + user.getName());
    }
}
