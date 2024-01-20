package notebook.model;
// ������� ��������� ����� USER
public class User {
    // ��������� ID
    private Long id;
    // ��������� ���
    private String firstName;
    // ��������� �������
    private String lastName;
    // ��������� �������
    private String phone;

    // ������� ����������� ������ USER
    public User(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    // ������� ����������� ������ USER � ������� �������� ������������
    public User(Long id, String firstName, String lastName, String phone) {
        this(firstName, lastName, phone);
        this.id = id;
    }
    // ������ - ���������� ID
    public Long getId() {
        return id;
    }
    // ������ - ������ ID
    public void setId(Long id) {
        this.id = id;
    }
    // ������ - �������
    public String getFirstName() {
        return firstName;
    }
    // ������ - ������ �������
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    // ������ - �������� ���
    public String getLastName() {
        return lastName;
    }
    // ������ - ������ ���
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    // ������ - ���������� �������
    public String getPhone() {
        return phone;
    }
    // ������ - �������� �������
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    // �������������� ����� USER�
    public String toString() {
        return String.format("�������������: %s\n���: %s,\n�������: %s,\n�������: %s", id, firstName, lastName, phone);
    }
}
