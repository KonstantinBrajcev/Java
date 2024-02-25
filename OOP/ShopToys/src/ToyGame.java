import java.io.*;
import java.util.*;

public class ToyGame {
    private final PriorityQueue<Toy> toyQueue;
    private final Scanner scanner;
    private final Print print;

    public ToyGame() {
        toyQueue = new PriorityQueue<>();
        scanner = new Scanner(System.in);
        print = new Print();
    }


    // Получаем данные из введенных строк
    public void put(String file_toys) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file_toys));
             FileWriter writer = new FileWriter(file_toys, true)) {
            String line;
            if ((line = fileReader.readLine()) != null) {
                print.dataFromFile(file_toys);
                do {
                    String[] parts = line.split(" ");
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    int weight = Integer.parseInt(parts[2]);
                    toyQueue.add(new Toy(id, name, weight));
                    print.newData(id, name, weight);
                } while ((line = fileReader.readLine()) != null);
            } else {
                print.emptyFile(file_toys);
                print.insertData();
                while (true) {
                    String input = scanner.nextLine();
                    if (input.equalsIgnoreCase("end")) {
                        break;
                    }
                    String[] parts = input.split(" ");
                    if (parts.length == 3) {
                        int id = Integer.parseInt(parts[0].trim());
                        String name = parts[1].trim();
                        int weight = Integer.parseInt(parts[2].trim());
                        toyQueue.add(new Toy(id, name, weight));
                        writer.write(id + " " + name + " " + weight + "\n");
                    } else {
                        print.noCorrectData();
                        print.insertData();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Вычисляем результаты розыгрышей
    public int get() {
        Random random = new Random();
        int totalWeight = calculateTotalWeight();
        // Генерируем случайное число
        int randomNumber = random.nextInt(totalWeight) + 1;
        int cumulativeWeight = 0;
        for (Toy toy : toyQueue) {
            cumulativeWeight += toy.getWeight();
            if (randomNumber <= cumulativeWeight) {
                return toy.getId();
            }
        }
        return -1; // В случае ошибки
    }

    // Вычисляем общую сумму весов всех игрушек
    private int calculateTotalWeight() {
        int totalWeight = 0;
        for (Toy toy : toyQueue) {
            totalWeight += toy.getWeight();
        }
        return totalWeight;
    }

    // Записываем полученные результаты в файл
    public void getLotteryToy(String file_dir) {
        print.nomLottery();
        int numberOfTimes = Integer.parseInt(scanner.next());
        try (FileWriter writer = new FileWriter(file_dir)) {
            Map<Integer, Integer> toyCounts = new HashMap<>();
            if (toyQueue.isEmpty()) {
                print.noToys();
            } else {
                for (int i = 0; i < numberOfTimes; i++) {
                    int result = get(); // Получаем данные из GET
                    Toy toy = null;
                    for (Toy t : toyQueue) {
                        if (t.getId() == result) {
                            toy = t;
                            break;
                        }
                    }
                    if (toy != null) {
                        toyCounts.put(result, toyCounts.getOrDefault(result, 0) + 1);
                        writer.write(print.dataLottery(i, toy.getName())); // Записываем строку в файл
                    } else {
                        print.noID(result);
                    }
                }
                // Вычисляем и выводим проценты выпадения каждой игрушки
                print.percent();
                for (Map.Entry<Integer, Integer> entry : toyCounts.entrySet()) {
                    int toyId = entry.getKey();
                    int count = entry.getValue();
                    double percentage = ((double) count / numberOfTimes) * 100;
                    print.percentToy(toyId, percentage);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        print.resultLottery(file_dir);
    }

    // Метод добавления новой игрушки в список
    public void addToy(String file_toys) {
        print.insertNewData();
        try (FileWriter writer = new FileWriter(file_toys, true)) {
            int id = Integer.parseInt(scanner.next());
            String name = scanner.next();
            int weight = Integer.parseInt(scanner.next());
            Toy newToy = new Toy(id, name, weight);
            toyQueue.add(newToy);
            writer.write(print.newToyData(id, name, weight));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Просмотр игрушек для следующего розыгрыша
    public void viewToys(String file_toys) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file_toys))) {
            String line;
            if ((line = reader.readLine()) != null) {
                print.nextLottery(true);
                do {
                    String[] parts = line.split(" ");
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    int weight = Integer.parseInt(parts[2]);
                    print.newData(id, name, weight);
                } while ((line = reader.readLine()) != null);
            } else {
                print.nextLottery(false);
            }
        } catch (IOException e) {
            print.errorMessage(e.getMessage(), file_toys);
        }
    }

    public void viewPrizeToys(String file_dir) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file_dir))) {
            print.dataPriseToy();
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            print.errorMessage(e.getMessage(), file_dir);
        }
    }

    // Метод получения призовой игрушки и записи ее в файл
    public void getPrizeToy(String filename, String file_dir) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file_dir));
             BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            String line;
            if ((line = reader.readLine()) != null) {
                writer.write(line + "\n"); // Записываем призовую игрушку в файл prize.txt
                print.priseToy(line, filename);
                // Удаляем запись из result.txt
                List<String> remainingToys = new ArrayList<>();
                while ((line = reader.readLine()) != null) {
                    remainingToys.add(line);
                }
                // Перезаписываем result.txt без удаленной записи
                try (BufferedWriter resultWriter = new BufferedWriter(new FileWriter(file_dir))) {
                    for (String toy : remainingToys) {
                        resultWriter.write(toy + "\n");
                    }
                }
                // Выводим оставшиеся игрушки в очереди
                print.toyInLine();
                for (String toy : remainingToys) {
                    System.out.println(toy);
                }
            } else {
                print.allClear();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void viewGetToys(String file_prize) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file_prize))) {
            print.toyFromFile(file_prize);
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            print.errorMessage(e.getMessage(), file_prize);
        }
    }
}

