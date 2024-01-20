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

// ����� ��� ���������� ���������� GBRepository
public class UserRepository implements GBRepository {
    // �������� ��������� ������ UserMapper (��� �������������� ������ ������������)
    private final UserMapper mapper;

    // �������� ��������� ������ FileOperation (���������� �������� �����/������)
    private final FileOperation operation;
    //
    public UserRepository(FileOperation operation) {
        this.mapper = new UserMapper();
        this.operation = operation;
    }

    @Override
    // ��������� ��� ������ �� ��
    public List<User> findAll() {
        List<String> lines = operation.readAll();
        List<User> users = new ArrayList<>();
        for (String line : lines) {
            users.add(mapper.toOutput(line));
        }
        // ��������� ������ ���� USER��
        return users;
    }

    @Override
    // ������� ������ USER� � ��
    public User create(User user) {
        // �������� ������ ������ USER��
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
    // ���� USER� �� ID --> ���������� empty
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    // ��������� ���������� USER� �� ID --> ��������� ���������
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
    // ������� USER� �� ID --> ����������
    public boolean delete(Long id) {
        List<User> users = findAll();
        // ������������� ���� ��������
        boolean resultDelete = false;
        // �������� �� ������ USER��
        for (Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
            User user = iterator.next();
            if (user.getId().equals(id)) { // ���� � USER� ��������� � � ����������
                iterator.remove(); // ������� ������������ �� ������
                resultDelete = true; // ������������� ���� ��������� ��������
                break; // ��������� ����, ��� ��� ������������ ������ � ������
            }
        }
        if (resultDelete) {
            write(users);
            return true;
        } else {
            throw new RuntimeException("������ ��������!");
        }
    }
    // ��������� ���� USER�� --> ����������� � ������ --> ���������
    private void write(List<User> users) {
        List<String> lines = new ArrayList<>();
        for (User u: users) {
            lines.add(mapper.toInput(u));
        }
        operation.saveAll(lines);
    }
    // ��������� USER��
    public void userValid (User user){
        UserValidator valedator = new UserValidator();
        user.setFirstName(valedator.isNameValid(user.getFirstName()));
        user.setLastName(valedator.isNameValid(user.getLastName()));

    }

}
