import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

    private static final String PAPA_NOEL_NOMBRE = "Papa Noel";
    private static final String RENO_NOMBRE = "Reno";
    private static final String DUENDE_NOMBRE = "Duende";
    private static final String PAPA = "\\*<]:-DOo";
    private static final String RENO = ">:o\\)";
    private static final String DUENDE = "[^\\*]<]:-D";

    public static void main (String[] args){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(App.class.getResource("listacaras.txt").openStream()));
            String linia;
            while ((linia = reader.readLine()) != null) {
                Buscar(PAPA, linia, PAPA_NOEL_NOMBRE);
                Buscar(RENO, linia, RENO_NOMBRE);
                Buscar(DUENDE, linia, DUENDE_NOMBRE);
                System.out.println("");
            }
            reader.close();
            System.out.println("Archivo Correcto");
        } catch (IOException e) {
            System.err.format("Exception ocurred trying to read listacaras.txt.");
            e.printStackTrace();
        }
    }

    private static void Buscar(String pat,String linia,String text){
        Pattern pattern = Pattern.compile(pat);
        Matcher matcher = pattern.matcher(linia);
        int count = 0;

        while (matcher.find()) {
            count++;
        }
        if (count != 0) {
            System.out.print(text + "(" + count + ") ");
        }
    }
}
