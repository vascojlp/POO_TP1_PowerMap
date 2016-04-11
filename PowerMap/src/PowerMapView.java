import isel.leic.pg.Console;

/**
 * Created by Vasco on 08/04/2016.
 */
public class PowerMapView {

    public static int CELL_HEIGHT = 3;
    public static int CELL_WIDTH = 3;
    public int x;
    public int y;
    public char s;

    public static int cordSynbols [][] ;

    public void drawSynbol(char symbol, int x, int y){
        switch (symbol){

            case 'H':
                Console.cursor(x,y);
                Console.color(Console.WHITE,Console.RED);
                Console.println('H');
                Console.cursor(x,y+1);
                Console.color(Console.WHITE,Console.BLACK);
                Console.println('-');
                break;

            case 'P':
                Console.cursor(x,y);
                Console.color(Console.BLUE,Console.YELLOW);
                Console.println('P');
                Console.cursor(x,y+1);
                Console.color(Console.BLUE,Console.YELLOW);
                Console.println('-');
                break;

            case '.':
                Console.cursor(x,y);
                Console.color(Console.WHITE,Console.BLACK);
                Console.println('o');
                Console.cursor(x,y+1);
                Console.color(Console.WHITE,Console.BLACK);
                Console.println('-');
                Console.cursor(x,y-1);
                Console.color(Console.WHITE,Console.BLACK);
                Console.println('-');
                break;

            case 'c':   //nao esta a desenhar
                Console.cursor(x,y);
                Console.color(Console.WHITE,Console.BLACK);
                Console.println('o');
                Console.cursor(x,y-1);
                Console.color(Console.WHITE,Console.BLACK);
                Console.println('-');
                Console.cursor(x+1,y);
                Console.color(Console.WHITE,Console.BLACK);
                Console.println('|');

                break;

            case 'T':
                Console.cursor(x,y);
                Console.color(Console.WHITE,Console.BLACK);
                Console.println('o');
                Console.cursor(x-1,y);
                Console.color(Console.WHITE,Console.BLACK);
                Console.println('|');
                Console.cursor(x,y-1);
                Console.color(Console.WHITE,Console.BLACK);
                Console.println('-');
                Console.cursor(x+1,y);
                Console.color(Console.WHITE,Console.BLACK);
                Console.println('|');

                break;

            default:break;
        }

    }


    public void setViews(PowerMapModel model) {

        //sacar coordenadas dos simbolos e guardalas noa array
        for(int i = 1; i < PowerMapModel.bufferLine.length; ++i) {
            for (int j = 0; j < PowerMapModel.bufferLine[i].length(); ++j) {
                s = PowerMapModel.bufferLine[i].charAt(j);
                y = (j*PowerMapView.CELL_HEIGHT)+1;
                x = (i*PowerMapView.CELL_WIDTH)-2;
                drawSynbol(s,x,y);
            }
            //drawSynbol('H',11,11);drawSynbol('H',9,9);drawSynbol('H',7,7);drawSynbol('H',5,5);drawSynbol('H',3,3);drawSynbol('H',1,1);
        }

    }

    public void repaintAll(PowerMapModel model) {

        //TODO: Colocar a imprimir o array que vem de setViews() na consola
        for(int i = 1; i < PowerMapModel.bufferLine.length; ++i){
            for (int j = 0; j < PowerMapModel.bufferLine[i].length(); ++j){
                Console.cursor(i-1, j+1);
                Console.println(PowerMapModel.bufferLine[i].charAt(j));
            }
        }

    }
}
