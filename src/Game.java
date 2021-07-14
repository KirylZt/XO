import java.util.Scanner;

public class Game {
    Desk desk = new Desk();
    Scanner scanner = new Scanner(System.in);
    Players player1 = new Players(1);
    Players player2 = new Players(2);

    int round = 1; //Переменная описывает какой раунд сейчас в игре, начиная с первого


    //Метод, который описывает процесс игры
    public void gameStart(){
        player1.getPlayer(player1.number);
        player2.getPlayer(player2.number);
        while (true){
            System.out.println("Ходит " +getName(round)+ "." );
            System.out.println("Введите координаты от 1 до 3 по горизонтали и вертикали:");
            int x = Coordinate();
            int y = Coordinate();
            if (desk.check(x,y)) {
                desk.move(x, y, round);
                desk.paint();
                if (desk.isVictory()){
                System.out.println(getName(round)+" победил.");
                break;
                }else {
                    round++;
                }
            }else {
                System.out.println("Клетка занята. Попробуйте ещё раз.");
            }
            if (round == 10){
                System.out.println("Ничья!");
                break;
            }
        }

    }

    //Метод возвращающий имя текущего игрока
    public String getName(int round){
        return switch (round % 2) {
            case 1 -> player1.player;
            case 0 -> player2.player;
            default -> "";
        };
    }

    //Метод который мы вызываем для ввода координат и проверки на корректность
    int Coordinate(){
        int point;
        while (true){
         if (scanner.hasNextInt()){
             point = scanner.nextInt();
             if (point >= 1 && point <= 3){
                 return point;
             }else {
                 System.out.println("Введено число вне диапозона, попробуйте ещё раз.");
             }
         }else {
             System.out.println("Вы ввели не число, попробуйте ещё раз!");
             scanner.next();
         }
        }
    }


}
