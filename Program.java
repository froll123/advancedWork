import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите данные (Фамилия Имя Отчество номертелефона):");
            String input = scanner.nextLine();

            String[] data = input.split(" ");
            if (data.length != 4) {
                throw new IllegalArgumentException("Количество данных не соответствует требованиям");
            }

            String lastName = data[0];
            String firstName = data[1];
            String patronymic = data[2];
            long phoneNumber = Long.parseLong(data[3]);

            String fileName = lastName + "11111.txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write(lastName + firstName + patronymic + phoneNumber);
            writer.newLine();
            writer.close();

            System.out.println("Данные успешно записаны в файл " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат номера телефона");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}