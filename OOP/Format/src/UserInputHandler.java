
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
            errorMessage = "Неверное количество данных. Введите ровно 6 значений.";
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
                    System.out.println("Данные успешно добавлены в файл " + lastName + ".txt");
                }
            } catch (ParseException e) {
                errorCode = 2;
                errorMessage = "Ошибка валидации данных: " + e.getMessage();
            }
            if (errorCode != 0) {
                System.out.println("Код ошибки: " + errorCode);
                System.out.println("Причина ошибки: " + errorMessage);
            }
        }
    }
}