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


    public void drawSymbol(char symbol, int x, int y){
        switch (symbol){

            case 'H':
                Console.cursor(x,y);
                Console.color(Console.WHITE,Console.RED);
                Console.println('H');
                Console.cursor(x,y+1);
                Console.color(Console.WHITE,Console.BLACK);
                Console.println('-');   //drt
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
                Console.cursor(x,y+1);  //Drt
                Console.color(Console.WHITE,Console.BLACK);
                Console.println('-');
                Console.cursor(x,y-1);  //Esq
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

        for(int i = 1; i < PowerMapModel.bufferLine.length; ++i) {
            for (int j = 0; j < PowerMapModel.bufferLine[i].length(); ++j) {
                s = PowerMapModel.bufferLine[i].charAt(j);
                y = (j*PowerMapView.CELL_HEIGHT)+1;
                x = (i*PowerMapView.CELL_WIDTH)-2;
                drawSymbol(s,x,y);
            }
        }

    }

    public void repaintAll(PowerMapModel model) {

    }
}
