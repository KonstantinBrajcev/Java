
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class UserInputHandler {
    public static void main(String[] args) throws ParseException {
        Map<String, StringBuilder> lastNameMap = new HashMap<>();
        String input = UserDataInput.getUserInput();
        String[] userData = input.split("\\s");
        String errorMessage = "";
        int errorCode = 0;

        if (userData.length != 6) {
            errorCode = 1;
            errorMessage = "�������� ���������� ������. ������� ����� 6 ��������.";
        } else {
            String lastName = userData[0];
            String firstName = userData[1];
            String middleName = userData[2];
            String birthDate = userData[3];
            String phoneNumber = userData[4];
            String gender = userData[5];

            try {
                if (DataValidator.isValidDate(birthDate) && DataValidator.isValidPhoneNumber(phoneNumber) && DataValidator.isValidGender(gender)) {
                    lastNameMap.put(lastName, new StringBuilder());

                    StringBuilder dataBuilder = lastNameMap.get(lastName);
                    dataBuilder.append(lastName).append(" ").append(firstName).append(" ").append(middleName).append(" ").append(birthDate).append(" ").append(phoneNumber).append(" ").append(gender).append("\n");

                    FileHandler.writeToFile(lastName + ".txt", dataBuilder.toString());
                    System.out.println("������ ������� ��������� � ���� " + lastName + ".txt");
                }
            } catch (ParseException e) {
                errorCode = 2;
                errorMessage = "������ ��������� ������: " + e.getMessage();
            }
            if (errorCode != 0) {
                System.out.println("��� ������: " + errorCode);
                System.out.println("������� ������: " + errorMessage);
            }
        }
    }
}