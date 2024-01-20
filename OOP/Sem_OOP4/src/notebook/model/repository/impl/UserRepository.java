package notebook.model.repository.impl;

import notebook.model.dao.impl.FileOperation;
import notebook.util.UserValidator;
import notebook.util.mapper.impl.UserMapper;
import notebook.model.User;
import notebook.model.repository.GBRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

// Класс для реализации интерфейса GBRepository
public class UserRepository implements GBRepository {
    // включаем экземпляр класса UserMapper (для преобразования данных пользователя)
    private final UserMapper mapper;

    // включаем экземпляр класса FileOperation (выполнения операций ввода/вывода)
    private final FileOperation operation;
    //
    public UserRepository(FileOperation operation) {
        this.mapper = new UserMapper();
        this.operation = operation;
    }

    @Override
    // Извлекаем все строки из БД
    public List<User> findAll() {
        List<String> lines = operation.readAll();
        List<User> users = new ArrayList<>();
        for (String line : lines) {
            users.add(mapper.toOutput(line));
        }
        // Возвращем список всех USERов
        return users;
    }

    @Override
    // Создаем нового USERа в БД
    public User create(User user) {
        // получаем полный список USERов
        List<User> users = findAll();

        long max = 0L;
        for (User u : users) {
            long id = u.getId();
            if (max < id){
                max = id;
            }
        }
        long next = max + 1;
        user.setId(next);
        users.add(user);
        write(users);
        return user;
    }

    @Override
    // Ищем USERа по ID --> Возвращаем empty
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    // Обновляем информацию USERа по ID --> Сохраняем изменения
    public Optional<User> update(Long userId, User update) {
        List<User> users = findAll();
        User editUser = users.stream()
                .filter(u -> u.getId()
                        .equals(userId))
                .findFirst().orElseThrow(() -> new RuntimeException("User not found"));
        editUser.setFirstName(update.getFirstName());
        editUser.setLastName(update.getLastName());
        editUser.setPhone(update.getPhone());
        write(users);
        return Optional.of(update);
    }

    @Override
    // Удаляем USERа по ID --> Возвращаем
    public boolean delete(Long id) {
        List<User> users = findAll();
        // Устанавливаем флаг удаления
        boolean resultDelete = false;
        // Проходим по списку USERов
        for (Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
            User user = iterator.next();
            if (user.getId().equals(id)) { // Если № USERа совпадает с № Удаляемого
                iterator.remove(); // Удаляем пользователя из списка
                resultDelete = true; // Устанавливаем флаг успешного удаления
                break; // Прерываем цикл, так как пользователь найден и удален
            }
        }
        if (resultDelete) {
            write(users);
            return true;
        } else {
            throw new RuntimeException("Ошибка удаления!");
        }
    }
    // Считываем всех USERов --> преобразуем в СТРОКИ --> Сохраняем
    private void write(List<User> users) {
        List<String> lines = new ArrayList<>();
        for (User u: users) {
            lines.add(mapper.toInput(u));
        }
        operation.saveAll(lines);
    }
    // Валидатор USERов
    public void userValid (User user){
        UserValidator valedator = new UserValidator();
        user.setFirstName(valedator.isNameValid(user.getFirstName()));
        user.setLastName(valedator.isNameValid(user.getLastName()));

    }

}
