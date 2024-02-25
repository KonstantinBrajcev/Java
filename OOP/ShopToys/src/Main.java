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
            System.out.print("-----�������� ��������-----\n"+
                    "1. ��������� ��������\n"+
                    "2. ��������� �������� �������\n"+
                    "3. ���������� �������\n"+
                    "4. �������� ������� ��� ����������\n"+
                    "5. �������� ������� ��� ������\n"+
                    "6. �������� �������� �������\n"+
                    "0. ����� �� ���������\n"+
                    "-------------------------\n"+
                    "������� ����� ��������: => ");

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
                    System.out.println("----------------------\n��������� ���������.");
                }
                default -> System.out.println("������������ �����. ���������� �����.");
            }
        }
    }
}
