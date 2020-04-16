package ru.geekbrains.J1.L3.hometask;

        import java.util.Random;
        import java.util.Scanner;

public class HomeTask03 {
    private static final int maxDigit = 10;
    private static int guessDigit;

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();


    private static void initDigit() {
        guessDigit = RANDOM.nextInt(maxDigit);;
    }

    private static boolean checkWin(int digit){
        System.out.println("");
        System.out.println("Отладка | Проверка победы ");
        System.out.println("Отладка | Цифру получил " + digit + " цифру загадал компьютер " + guessDigit);

        if (digit == guessDigit) return true;
        return false;
    }

    private static boolean checkContinueGame(int digit){
        if (digit == 0) return true;
        return false;
    }

    private static boolean isValidValue(int digit){
        if (digit > 0 && digit < 10) {
            System.out.println("Цифра верная");
            return true;
        }
        System.out.println("Цифра не верная");
        return false;
    }


    private static int yourTurn() {
        int digit;
        do {
            System.out.println("Введите цифру от 0 до 10 ");
            digit = SCANNER.nextInt();
            System.out.println("Отладка | Вы ввели цифру " + digit);
        } while (!isValidValue(digit));
        System.out.println("Отладка | Вышли из цикла");
        return digit;
    }

    private static int continueGame() {
        int digit;
        do {
            System.out.println("Выхотите сыграть еще один раз, 0 - нет, 1 - да, введите цифру ");
            digit = SCANNER.nextInt();
        } while (digit != 0 && digit != 1);
        return digit;
    }


    public static void main(String[] args) {
        playOneRound();
    }


    private static void playOneRound() {
        initDigit();
        while (true) {
            System.out.println("Отладка | Компьюетре загадал цифру " + guessDigit);
            if (checkWin(yourTurn())) {
                System.out.println("Выиграл игрок!");
                break;
            }

            System.out.println("Вы ввели не правильную цифру, след раунд!");
            System.out.println("");

            if (checkWin(yourTurn())) {
                System.out.println("Выиграл игрок!");
                break;
            }

            System.out.println("Вы ввели не правильную цифру, след раунд!");
            System.out.println("");

            if (checkWin(yourTurn())) {
                System.out.println("Выиграл игрок!");
                break;
            }

            System.out.println("Выиграл компьютер!");
            System.out.println("");

            if (checkContinueGame(continueGame())) {
                System.out.println("Выход!");
                break;
            }
        }
    }
}
