import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {
    public static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    public static PrintStream stdout = System.out;
    public static PrintStream stderr = System.err;

    public static void main(String[] args) throws IOException {
        String data;
        Table t = new Table();

//        t.printTable();
//        t.memorizePosition("e2e4");
//        t.Move("pRef");
//        t.memorizePosition("f2f4");
//        t.Move("pRef");
//        t.memorizePosition("f4f5");
//        t.Move("pRef");

//        t.memorizePosition("d8a3");

        for(;;) {
            data = readInput();

            if (data != null) {
                if (data.contains("xboard")) {
                    System.out.println("feature sigint=0 san=0 done=1");
                } else if (data.matches("[\\w][\\d][\\w][\\d]")) {
                    t.memorizePosition(data);
                    System.out.println("move " + t.Move("pRef"));
                }
            }
        }
    }

    public static String readInput() {
        try {
            if (!stdin.ready()) {
                return null;
            } else {
                return stdin.readLine();
            }
        } catch (Exception e) {
            return null;
        }
    }
}