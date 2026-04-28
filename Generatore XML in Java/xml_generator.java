package xml;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
 
public class xml_generator{
 
    public static void main(String[] args) throws IOException {
 
        Scanner sc = new Scanner(System.in);
 
        System.out.print("Nome file XML (es. output.xml): ");
        String nomeFile = sc.nextLine();
 
        System.out.print("Nome classe: ");
        String radice = sc.nextLine();
 
        System.out.print("Nome elemento di primo livello: ");
        String tipoN = sc.nextLine();
 
        System.out.print("Quanti elementi di primo livello (N)? ");
        int N = Integer.parseInt(sc.nextLine());
 
        System.out.print("Quanti attributi per ognuno (M)? ");
        int M = Integer.parseInt(sc.nextLine());
 
        // Chiedo i nomi dei sotto-elementi una volta sola
        String[] nomiSottoElementi = new String[M];
        for (int j = 0; j < M; j++) {
            System.out.print("Nome sotto-elemento " + (j + 1) + ": ");
            nomiSottoElementi[j] = sc.nextLine();
        }
 
        // Scrittura file XML
        FileWriter fw = new FileWriter(nomeFile);
 
        fw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        fw.write("<" + radice + ">\n");
 
        for (int i = 1; i <= N; i++) {
            fw.write("\t<" + tipoN + " id=\"" + i + "\">\n");
 
            for (int j = 0; j < M; j++) {
                System.out.print("Valore per <" + nomiSottoElementi[j] + "> del " + tipoN + " " + i + ": ");
                String valore = sc.nextLine();
                fw.write("\t\t<" + nomiSottoElementi[j] + ">" + valore + "</" + nomiSottoElementi[j] + ">\n");
            }
 
            fw.write("\t</" + tipoN + ">\n");
        }
 
        fw.write("</" + radice + ">\n");
        fw.close();
 
        System.out.println("\nFile \"" + nomeFile + "\" generato con successo!");
    }
}
 