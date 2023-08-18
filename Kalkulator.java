
import java.util.Scanner;

public class Kalkulator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число, операцию, число.");
        String del = in.nextLine();
        String[] urav = del.split(" ");
        String[] rim = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        int count = 0;

        for (String Proof : rim) {
            if (Proof.equals(urav[0]) && Proof.equals(urav[2])) {
                count += 2;
            } else if (Proof.equals(urav[0]) || Proof.equals(urav[2])) {
                count++;
            }
            if (count == 1 && Proof == rim[9]) {
                System.out.println("Неверные или слишком большие числа");
                System.exit(1);
            }
        }

        if (count == 2) {
            for (int i = 0; i < 3; i++) {
                switch (urav[i]) {
                    case "I":
                        urav[i] = "1";
                        break;
                    case "II":
                        urav[i] = "2";
                        break;
                    case "III":
                        urav[i] = "3";
                        break;
                    case "IV":
                        urav[i] = "4";
                        break;
                    case "V":
                        urav[i] = "5";
                        break;
                    case "VI":
                        urav[i] = "6";
                        break;
                    case "VII":
                        urav[i] = "7";
                        break;
                    case "VIII":
                        urav[i] = "8";
                        break;
                    case "IX":
                        urav[i] = "9";
                        break;
                    case "X":
                        urav[i] = "10";
                        break;
                    case "+":
                    case "-":
                    case "/":
                    case "*":
                    case ":":
                        break;
                    default:
                        System.out.println("Неверные числа");
                        System.exit(0);
                        break;

                }
            }
        }

        try {
            int x = Integer.parseInt(urav[0]);
            int y = Integer.parseInt(urav[2]);
            if (x >= 11 || x >=11){
                System.out.println("Есть цифра больше 10");
                System.exit(0);
            }
            int z = 0;
            switch (urav[1]) {
                case ("+"):
                    z = x + y;
                    break;
                case ("-"):
                    z = x - y;
                    break;
                case ("/"):
                    z = x / y;
                    break;
                case (":"):
                    z = x / y;
                    break;
                case ("*"):
                    z = x * y;
                    break;
                default:
                    System.out.println("У нас есть лишь 4 операции!");
                    System.exit(1);
            }
            if (count == 0) {
                System.out.println(z);
            }
            else if ((count == 2) && (z == 0)) {
                System.out.println("Римский 0... Рим Пал");
                System.exit(0);
            }
            else if (count == 2) {
                String s = "";
                while (z == 100) {
                    s += "C";
                    z -= 100;
                }
                while (z >= 90) {
                    s += "XC";
                    z -= 90;
                }
                while (z >= 60) {
                    s += "LX";
                    z -= 60;
                }
                while (z >= 50) {
                    s += "L";
                    z -= 50;
                }
                while (z >= 40) {
                    s += "XL";
                    z -= 40;
                }
                while (z >= 30) {
                    s += "XXX";
                    z -= 30;
                }
                while (z >= 20) {
                    s += "XX";
                    z -= 20;
                }
                while (z >= 10) {
                    s += "X";
                    z -= 10;
                }
                while (z >= 9) {
                    s += "IX";
                    z -= 9;
                }
                while (z >= 8) {
                    s += "VIII";
                    z -= 8;
                }
                while (z >= 7) {
                    s += "VII";
                    z -= 7;
                }
                while (z >= 6) {
                    s += "VI";
                    z -= 6;
                }
                while (z >= 5) {
                    s += "V";
                    z -= 5;
                }
                while (z >= 4) {
                    s += "IV";
                    z -= 4;
                }
                while (z >= 1) {
                    s += "I";
                    z -= 1;
                }
                System.out.println(s);
            }
        } catch (NumberFormatException e) {
            System.out.println("фигню ввёл");
        }
    }
}

