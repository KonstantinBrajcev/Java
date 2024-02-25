import java.util.Scanner;

public class Print {

    private static final String line = "----------------------\n";

    public Print() {
    }

    public void noCorrectData () {
        System.out.println("������������ ������ ������!");
    }
    public void insertData (){
        System.out.println("������� ������ � �������: 'ID' '��������' '���' �/��� ������� 'end' ��� ����������.");
    }
    public void insertNewData (){
        System.out.print(line + "������� ������ ��� ����� �������: 'ID' '��������' '���' => ");
    }
    public void dataFromFile (String file) {
        System.out.println(line + "��������� ������ �� ����� " + file);
    }

    public void newData (int id, String name, int weight) {
        System.out.println("ID: " + id + ", ��������: " + name + ", ���: " + weight);
    }

    public void emptyFile(String file) {
        System.out.println(line + "���� "+ file +" ����.");
    }

    public void nomLottery() {
        System.out.println(line + "������� ���������� ����������: => ");
    }

    public void noToys() {
        System.out.println("������: ��� ��������� ������� ��� ���������.");
    }

    public void errorMessage(String message, String file) {
        System.out.println("������ " + message + " ��� ������ ����� " + file);
    }

    public String dataLottery(int i, String name) {
        String output = "�������� " + (i + 1) + " - �������� ������� " + name + "\n";
        System.out.print(output);
        return output;
    }
    public void noID(int result) {
        System.out.println("������: ������� � ID " + result + " �� �������.");
    }

    public void percent(){
        System.out.println(line + "������� ��������� ������ �������:");
    }

    public void percentToy(int toyId, double percentage){
        System.out.println("������� � " + toyId + ": " + percentage + "%");
    }
    public void resultLottery(String file) {
        System.out.println(line + "���������� ���������� �������� � " + file);
    }
    public String newToyData(int id, String name, int weight) {
        System.out.println("������� '" + name + "' ������� ��������� ��� ����������.");
        //String output = id + " " + name + " " + weight + "\n";
        return id + " " + name + " " + weight + "\n";
    }

    public void nextLottery(boolean tr){
        if (tr == true) {
            System.out.println(line + "������ ������� ��� ���������� ���������:");
        }
        else {
            System.out.println(line + "������: ������ ������� ��� ���������� ��������� ����.");
        }
    }
    public void dataPriseToy(){
        System.out.println(line + "������ �������� ������� ��� ������:");
    }
    public void allClear(){
        System.out.println("��� �������� ������� ��� ������.");
    }
    public void toyInLine(){
        System.out.println(line + "���������� ������� � �������:");
    }
    public void toyFromFile(String file){
        System.out.println(line + "�������� ������� �� ����� " + file);
    }

    public void priseToy(String toyLine, String file){
        System.out.println(line + "�������� ������� " + toyLine + " �������� � ���� " + file);
    }
}
