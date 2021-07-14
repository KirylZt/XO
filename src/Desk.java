public class Desk {
    //Данный класс нужен для создания и отрисовки игрового поля
    //В этом классе будут обрабатываться и отрисовываться элементы игры
    //Класс типа int нужен для обработки, а типа char для отрисовки в консоли
    private final int[][] desk = new int[3][3];
    private final char[][] deskVisual = new char[3][3];

    //Метод который регистрирует результат хода, если такой ход возможен
    public void move(int x, int y, int round){
        if (round % 2 == 1){
            desk[x-1][y-1] = 1;
        }else {
            desk[x-1][y-1] = 2;
        }
    }

    //Метод который проверяет пуста ли клетка
    boolean check(int x, int y){
        boolean check;
        check = desk[x - 1][y - 1] == 0;
        return check;
    }

    //Метод проверки ячеек на победу игрока
    boolean isVictory(){
        boolean victory = false;
        for (int i = 0; i < desk.length; i++){
            int sumG = 0;
            int sumV = 0;
            for (int j = 0; j<desk[i].length; j++){
                sumG += desk[i][j];
                sumV += desk[j][i];
                switch (sumG){
                    case 3:
                        if (desk[i][0] == desk[i][1] && desk[i][1] == desk[i][2]){
                            victory = true;
                        }
                        break;
                    case 6:
                        victory = true;
                        break;
                }
                switch (sumV){
                    case 3:
                        if (desk[0][i] == desk[1][i] && desk[1][i] == desk[2][i]){
                            victory = true;
                        }
                        break;
                    case 6:
                        victory = true;
                        break;
                }
            }
        }
        switch (desk[0][0]+desk[1][1]+desk[2][2]){
            case 3:
                if (desk[0][0] == desk[1][1] && desk[1][1] == desk[2][2]){
                    victory = true;
                }
                break;
            case 6:
                victory = true;
                break;
        }
        switch (desk[0][2]+desk[1][1]+desk[2][0]){
            case 3:
                if (desk[0][2] == desk[1][1] && desk[1][1] == desk[2][0]){
                    victory = true;
                }
                break;
            case 6:
                victory = true;
                break;
        }
        return victory;
    }


    //Метод отрисовывающий поле в консоль на основе игрового поля представленного в типе int
    public void paint(){
        for (int i = 0; i < deskVisual.length; i++){
            for (int j = 0; j < deskVisual[i].length; j++){
                switch (desk[i][j]){
                    case 0:
                        deskVisual[i][j] = '.';
                        break;
                    case 1:
                        deskVisual[i][j] = 'X';
                        break;
                    case 2:
                        deskVisual[i][j] = 'O';
                        break;
                }
                System.out.print(deskVisual[i][j] + " ");
            }
            System.out.println();
        }

    }



}
