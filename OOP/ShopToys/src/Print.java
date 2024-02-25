import java.util.Scanner;

public class Print {

    private static final String line = "----------------------\n";

    public Print() {
    }

    public void noCorrectData () {
        System.out.println("Некорректный формат данных!");
    }
    public void insertData (){
        System.out.println("Введите данные в формате: 'ID' 'Название' 'Вес' и/или введите 'end' для завершения.");
    }
    public void insertNewData (){
        System.out.print(line + "Введите данные для новой игрушки: 'ID' 'Название' 'Вес' => ");
    }
    public void dataFromFile (String file) {
        System.out.println(line + "Загружены данные из файла " + file);
    }

    public void newData (int id, String name, int weight) {
        System.out.println("ID: " + id + ", Название: " + name + ", Вес: " + weight);
    }

    public void emptyFile(String file) {
        System.out.println(line + "Файл "+ file +" пуст.");
    }

    public void nomLottery() {
        System.out.println(line + "Введите количество розыгрышей: => ");
    }

    public void noToys() {
        System.out.println("Ошибка: Нет доступных игрушек для розыгрыша.");
    }

    public void errorMessage(String message, String file) {
        System.out.println("Ошибка " + message + " при чтении файла " + file);
    }

    public String dataLottery(int i, String name) {
        String output = "Розыгрыш " + (i + 1) + " - Выиграла игрушка " + name + "\n";
        System.out.print(output);
        return output;
    }
    public void noID(int result) {
        System.out.println("Ошибка: игрушка с ID " + result + " не найдена.");
    }

    public void percent(){
        System.out.println(line + "Процент выпадения каждой игрушки:");
    }

    public void percentToy(int toyId, double percentage){
        System.out.println("Игрушка № " + toyId + ": " + percentage + "%");
    }
    public void resultLottery(String file) {
        System.out.println(line + "Результаты розыгрышей записаны в " + file);
    }
    public String newToyData(int id, String name, int weight) {
        System.out.println("Игрушка '" + name + "' успешно добавлена для розыгрышей.");
        //String output = id + " " + name + " " + weight + "\n";
        return id + " " + name + " " + weight + "\n";
    }

    public void nextLottery(boolean tr){
        if (tr == true) {
            System.out.println(line + "Список игрушек для следующего розыгрыша:");
        }
        else {
            System.out.println(line + "Ошибка: Список игрушек для следующего розыгрыша пуст.");
        }
    }
    public void dataPriseToy(){
        System.out.println(line + "Список призовых игрушек для выдачи:");
    }
    public void allClear(){
        System.out.println("Все призовые игрушки уже выданы.");
    }
    public void toyInLine(){
        System.out.println(line + "Оставшиеся игрушки в очереди:");
    }
    public void toyFromFile(String file){
        System.out.println(line + "Выданные игрушки из файла " + file);
    }

    public void priseToy(String toyLine, String file){
        System.out.println(line + "Призовая игрушка " + toyLine + " записана в файл " + file);
    }
}
