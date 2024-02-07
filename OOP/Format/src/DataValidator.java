import java.text.ParseException;

public class DataValidator {
    public static boolean isValidDate(String date) throws ParseException {
        if (date.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
            return true;
        } else {
            throw new ParseException("Неверный формат даты", 0);
        }
    }

    public static boolean isValidPhoneNumber(String phoneNumber) throws ParseException {
        if (phoneNumber.matches("\\d{12}")) {
            return true;
        } else {
            throw new ParseException("Неверный формат телефона", 0);
        }
    }

    public static boolean isValidGender(String gender) throws ParseException {
        if (gender.matches("f") | gender.matches("m")) {
            return true;
        } else {
            throw new ParseException("Неверно указан пол", 0);
        }
    }
}
