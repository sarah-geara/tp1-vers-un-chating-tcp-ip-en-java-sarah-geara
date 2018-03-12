package Clienttcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Pascal Fares
 */
public class ClientTCP {

    /**
     * Récupère le flux d'entrée d'une Socket et l'encapsule dans un BufferedReader 
     * Un BufferedReader permet de Lire le texte à partir d'un flux d'entrée de caractères, en mettant
     * en mémoire tampon les caractères afin de permettre une lecture efficace 
     * des caractères, des tableaux et des lignes.
     * @param p la SOcket
     * @return le BufferedReader crée
     * @throws IOException 
     */
    private static BufferedReader getInput(Socket p) throws IOException {
        return new BufferedReader(new InputStreamReader(p.getInputStream()));
    }
  
    /**
     * Récupère le flus de sortie de la socket et l'encapsule dans un PrintWriter
     * Imprime des représentations formatées d'objets dans un 
     * flux de sortie de texte. Cette classe implémente toutes les méthodes 
     * d'impression trouvées dans PrintStream.
     * @param p la Socket
     * @return le PrintWriter crée
     * @throws IOException 
     */
    private static PrintWriter getoutput(Socket p) throws IOException{
        return new PrintWriter (new OutputStreamWriter(p.getOutputStream()));
    }
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        //Se connecté au port 2000
        Socket l = new Socket("localhost",2000);
        System.out.println(l.getLocalSocketAddress());
        //
        BufferedReader entreeSock = getInput(l);
        PrintWriter sortieSock = getoutput(l);
        //Envoyer une chaine
        sortieSock.printf("Bonjour\n");sortieSock.flush();
        //Récupérer la réponse puis l'afficher
        System.out.println(entreeSock.readLine());
    }
    
}
