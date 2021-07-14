import java.util.Scanner;

public class Players {
    Scanner scanner = new Scanner(System.in);
    String player;
    int number;

    //Метод объявляющий имя игроку
    public void getPlayer(int number){
        System.out.print("Введите имя игрока " + number + ":");
        player = scanner.next();
    }

    public Players(int number) {
        this.number = number;
    }

}
