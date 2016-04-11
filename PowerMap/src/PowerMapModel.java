import java.io.*;

/**
 * Created by Vasco on 08/04/2016.
 */
public class PowerMapModel {
    private boolean DEBUG = true;

    public static String[] bufferLine = new String [6];
    public static String board [][];

    public static int HEIGHT;
    public static int WIDTH;



    public int getNumLines() {
        String CH = "";
        int i  = 0;

        while ( i < bufferLine[0].length() && bufferLine[0].charAt(i) != ' ') {
                CH += bufferLine[0].charAt(i);
                ++i;
        }

        HEIGHT = Integer.parseInt(CH, 10);

        System.out.println("\nCELL_HEIGHT = " + HEIGHT);

        return HEIGHT;
    }

    public int getNumColumns() {
        String CW = "";
        int j  = 4;

        while (j < bufferLine[0].length()){
            CW += bufferLine[0].charAt(j);
            ++j;
        }

        WIDTH = Integer.parseInt(CW, 10);
        System.out.println("CELL_WIDTH = " + WIDTH);

        return WIDTH;
    }

    public void setChangeListener(PowerMapView view) {   }

    public boolean isCompleted() {
        return false;
    }


    public void rotate(int lin, int col) {    }



    public void loadLevel(FileReader file) throws IOException {

        BufferedReader buffer = new BufferedReader(file);
        int i = 0;

        // if no more lines the readLine() returns null
        for(String line; (line = buffer.readLine()) != null; ) {
            bufferLine[i] = line;
            if(DEBUG)System.out.println("linha " + i + ": "+ bufferLine[i]);
            ++i;
        }
    }



}
