import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Table {
    private ArrayList<String>[] matrix;
//    private String PRef = "PRef";
FileWriter fstream = new FileWriter("/mnt/c/Users/alexa/Desktop/anul 2/sem2/pa/pa-proiect/out/artifacts/proiect_pa_mirabela_jar/write.txt");
    BufferedWriter out = new BufferedWriter(fstream);
//	  out.write("Line Added on: " + new java.util.Date()+"\n");
//	  out.close();

    public Table() throws IOException {
        matrix = new ArrayList[8];
        for (int i = 0; i < 8; i++) {
            matrix[i] = new ArrayList<String>();
        }
        populateMatrix();
    }

    public void populateMatrix() {
        matrix[0].add(0, "R");
        matrix[0].add(1, "N");
        matrix[0].add(2, "B");
        matrix[0].add(3, "Q");
        matrix[0].add(4, "K");
        matrix[0].add(5, "B");
        matrix[0].add(6, "N");
        matrix[0].add(7, "R");

        matrix[1].add(0, "P");
        matrix[1].add(1, "P");
        matrix[1].add(2, "P");
        matrix[1].add(3, "P");
        matrix[1].add(4, "PRef");
        matrix[1].add(5, "P");
        matrix[1].add(6, "P");
        matrix[1].add(7, "P");

        for (int i = 2; i < 6; i++) {

            matrix[i].add(0, "0");
            matrix[i].add(1, "0");
            matrix[i].add(2, "0");
            matrix[i].add(3, "0");
            matrix[i].add(4, "0");
            matrix[i].add(5, "0");
            matrix[i].add(6, "0");
            matrix[i].add(7, "0");

        }

        matrix[7].add(0, "r");
        matrix[7].add(1, "n");
        matrix[7].add(2, "b");
        matrix[7].add(3, "q");
        matrix[7].add(4, "k");
        matrix[7].add(5, "b");
        matrix[7].add(6, "n");
        matrix[7].add(7, "r");

        matrix[6].add(0, "p");
        matrix[6].add(1, "p");
        matrix[6].add(2, "p");
        matrix[6].add(3, "p");
        matrix[6].add(4, "pRef");
        matrix[6].add(5, "p");
        matrix[6].add(6, "p");
        matrix[6].add(7, "p");

    }

    public void printTable() throws IOException {
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
//                System.out.print(matrix[i].get(j) + "        ");
                out.write(matrix[i].get(j) + "      ");
            }
//            System.out.println("\n");
            out.write("\n");
        }
    }

    // litere mari 65, litere mici 97
    public void memorizePosition(String data) {
        int oldPosLinie = data.charAt(0) - 97;
        int newPosLinie = data.charAt(2) - 97;

        int oldPosCol = data.charAt(1) - 49;
        int newPosCol = data.charAt(3) - 49;

        String piece = matrix[oldPosCol].get(oldPosLinie);
        matrix[oldPosCol].set(oldPosLinie,"0");
        matrix[newPosCol].set(newPosLinie,piece);
//        System.out.println(oldPosCol + " " + oldPosLinie + " vechi");
//        System.out.println(newPosCol + " " + newPosLinie + " nou");
//        System.out.println(matrix[oldPosCol].get(oldPosLinie));
//        System.out.println(matrix[newPosCol].get(newPosLinie));


//        printTable();

    }

    public int getLinie(String pion) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (pion.equals(matrix[i].get(j))) {
                    return i;
                }
            }
        }
        return -1;
    }
    public int getColoana(String pion) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(pion.equals(matrix[i].get(j))) {
                    return j;
                }
            }
        }
        return -1;
    }

    public boolean checkInitial(String pion) {
        int linie = 0;
        if(Character.isLowerCase(pion.charAt(0))) {
            System.out.println("It's black");
            System.out.println("linie "  + getLinie(pion));
            if(getLinie(pion) == 6)
                return true;
        }
        return false;
    }

    public String firstMove(int indice, int linie, int col) {
        String sameCol;
        switch (col) {
            case 0:
                sameCol = "a";
                break;
            case 1:
                sameCol = "b";
                break;
            case 2:
                sameCol = "c";
                break;
            case 3:
                sameCol = "d";
                break;
            case 4:
                sameCol = "e";
                break;
            case 5:
                sameCol = "f";
                break;
            case 6:
                sameCol = "g";
                break;
            default:
                sameCol = "h";
        }

        int oldLinieI = linie + 1;
        int newLinieI = linie - indice + 1;

        String oldLinie = String.valueOf(oldLinieI);
        String newLinie = String.valueOf(newLinieI);

        String mutare = sameCol + oldLinie + sameCol + newLinie;
        memorizePosition(mutare);
        System.out.println("move " + mutare);
        return mutare;
    }

    public String getMove(int linie, int col) {
        String sameCol;
        switch (col) {
            case 0:
                sameCol = "a";
                break;
            case 1:
                sameCol = "b";
                break;
            case 2:
                sameCol = "c";
                break;
            case 3:
                sameCol = "d";
                break;
            case 4:
                sameCol = "e";
                break;
            case 5:
                sameCol = "f";
                break;
            case 6:
                sameCol = "g";
                break;
            default:
                sameCol = "h";
        }


        String oldLinie = String.valueOf(linie);
        String newLinie = String.valueOf(col);

        String mutare = sameCol + oldLinie + sameCol + newLinie;
//        memorizePosition(mutare);
//        System.out.println("move " + mutare);
        return mutare;
    }


    public String Move(String pion) {
        int col = getColoana(pion);
        int linie = getLinie(pion);

        if(checkInitial(pion)) {
            if(matrix[linie - 1].get(col).equals("0")) {
                if(matrix[linie - 2].get(col).equals("0")) {
                    int indice = (int) (Math.random() * 2 + 1);
                    return firstMove(indice,linie,col);
                }
                else {
                    return firstMove(1,linie,col);
                }
            }
            else {
                return "resign";
            }
        }
        else {
            if(matrix[linie - 1].get(col + 1).equals("0") == false) {
                matrix[linie].set(col,"0");
                matrix[linie - 1].set(col + 1, "pRef");
                return getMove(linie - 1, col + 1);
            } else if(matrix[linie - 1].get(col - 1).equals("0") == false) {
                matrix[linie].set(col,"0");
                matrix[linie - 1].set(col - 1, "pRef");
                return getMove(linie - 1, col - 1);
            } else if(matrix[linie - 1].get(col).equals("0")) {
                    return firstMove(1,linie,col);
                }
        }
        return null;
    }
}
