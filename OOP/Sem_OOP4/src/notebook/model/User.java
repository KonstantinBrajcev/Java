package notebook.model;
// Создаем публичный класс USER
public class User {
    // Приватный ID
    private Long id;
    // Приватное Имя
    private String firstName;
    // Приватную Фамилию
    private String lastName;
    // Приватный Телефон
    private String phone;

    // Создаем конструктор класса USER
    public User(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    // Создаем конструктор класса USER с вызовом прошлого конструктора
    public User(Long id, String firstName, String lastName, String phone) {
        this(firstName, lastName, phone);
        this.id = id;
    }
    // Геттер - Возвращаем ID
    public Long getId() {
        return id;
    }
    // Сеттер - Вводим ID
    public void setId(Long id) {
        this.id = id;
    }
    // Геттер - Фамилию
    public String getFirstName() {
        return firstName;
    }
    // Сеттер - Вводим Фамилию
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    // Геттер - Получаем Имя
    public String getLastName() {
        return lastName;
    }
    // Сеттер - Вводим Имя
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    // Геттер - Возвращаем Телефон
    public String getPhone() {
        return phone;
    }
    // Сеттер - Получаем Телефон
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    // Переопределяем вывод USERа
    public String toString() {
        return String.format("Идентификатор: %s\nИмя: %s,\nФамилия: %s,\nТелефон: %s", id, firstName, lastName, phone);
    }
}
