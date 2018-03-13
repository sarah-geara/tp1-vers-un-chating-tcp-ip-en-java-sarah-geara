/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servertcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sarah
 */
public class EchoThread extends Thread {
    protected Socket socket;

    public EchoThread(Socket clientSocket) {
        this.socket = clientSocket;
    }
   private static PrintWriter getoutput(Socket p) throws IOException {
        return new PrintWriter(new OutputStreamWriter(p.getOutputStream()));
    }
   private static BufferedReader getInput(Socket p) throws IOException {
        return new BufferedReader(new InputStreamReader(p.getInputStream()));
    }
    public void run() {
     
                BufferedReader ir = null;
        try {
            System.out.println(socket.getRemoteSocketAddress());
            ir = getInput(socket);
            PrintWriter reply = getoutput(socket);
            String line;
            while ((line = ir.readLine()) != null) {
                System.out.printf("je répond ping %s\n", line);
                reply.printf("je répond ping %s\n", line);
                reply.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(EchoThread.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }
    
}
