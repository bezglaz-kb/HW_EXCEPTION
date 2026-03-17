import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PasswordChecker checker = new PasswordChecker();

        try {
            System.out.print("Введите мин. длину пароля: ");
            int passLength = Integer.parseInt(scanner.nextLine());
            checker.setMinLength(passLength);

            System.out.print("Введите макс. допустимое количество повторений символа подряд: ");
            int charRepeat = Integer.parseInt(scanner.nextLine());
            checker.setMaxRepeats(charRepeat);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        while (true) {
            System.out.print("Введите пароль или end: ");
            String password = scanner.nextLine();
            if (password.equals("end"))
                break;
            if (checker.verify(password)) {
                System.out.println("Подходит!");
                System.out.println();
            } else {
                System.out.println("Не подходит!");
                System.out.println();
            }
        }
    }
}
