package notebook;

import notebook.controller.UserController;
import notebook.model.dao.impl.FileOperation;
import notebook.model.repository.GBRepository;
import notebook.model.repository.impl.UserRepository;
import notebook.view.UserView;
import java.lang.String;

import static notebook.util.DBConnector.DB_PATH;
import static notebook.util.DBConnector.createDB;

public class Main {
    public static void main(String[] args) {
        // Создаем БД
        createDB();
        // Создаем редактор файла
        FileOperation fileOperation = new FileOperation(DB_PATH);
        // Создаем новый репозиторий
        GBRepository repository = new UserRepository(fileOperation);
        // Создаем новый контроллер
        UserController controller = new UserController(repository);
        // Создаем новый
        UserView view = new UserView(controller);
        // Запускаем
        view.run();

    }
}
