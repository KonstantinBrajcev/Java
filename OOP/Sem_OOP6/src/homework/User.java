package homework;

public class User{// ��������� ����� ����

    private final String name;// ���������� ���������� ����������

    public User(String name){// ����������� ��� ������������� �����
        this.name = name;
    }

    public String getName(){// ����� - �������� ��� �����
        return name;
    }

    public void save(){// ������� � ��������� ������ �����
        Persist persist = new Persist(this);// �������
        persist.save();// ���������
    }

    public void report(){// �������� ��� �����
        System.out.println("Report for user: " + name);
    }

    public void delete(){//������� �����
        return;
    }
}
