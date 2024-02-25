import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ToyGame toyGame = new ToyGame();
        Scanner scanner = new Scanner(System.in);
        String file_dir = "result.txt";
        String file_prize = "prize.txt";
        String file_toys = "toys.txt";
        toyGame.put(file_toys);

        boolean continueProgram = true;
        while (continueProgram) {
            System.out.print("-----Выберите действие-----\n"+
                    "1. Выполнить розыгрыш\n"+
                    "2. Получение призовой игрушки\n"+
                    "3. Добавление игрушки\n"+
                    "4. Просмотр игрушек для розыгрышей\n"+
                    "5. Просмотр игрушек для выдачи\n"+
                    "6. Просмотр выданных игрушек\n"+
                    "0. ВЫХОД из программы\n"+
                    "-------------------------\n"+
                    "Введите номер действия: => ");

            int action = Integer.parseInt(scanner.next());

            switch (action) {
                case 1 -> toyGame.getLotteryToy(file_dir);
                case 2 -> toyGame.getPrizeToy(file_prize, file_dir);
                case 3 -> toyGame.addToy(file_toys);
                case 4 -> toyGame.viewToys(file_toys);
                case 5 -> toyGame.viewPrizeToys(file_dir);
                case 6 -> toyGame.viewGetToys(file_prize);
                case 0 -> {
                    continueProgram = false;
                    System.out.println("----------------------\nПрограмма завершена.");
                }
                default -> System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }
    }
}
