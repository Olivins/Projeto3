package pratica3;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args){ //não usamos o throw para poder tratar o erro localmente e enviar uma resposta amigavel ao cliente
        try {       
            Socket s = new Socket("127.0.0.1",2001);
            
            DataOutputStream saida = new DataOutputStream(s.getOutputStream());
            DataInputStream entrada = new DataInputStream(s.getInputStream());
            
            String linha;
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            while(true) {
            	System.out.println(">");
	            linha = teclado.readLine();
	            saida.writeUTF(linha);
	            linha = entrada.readUTF();
	            if(linha.equalsIgnoreCase("")) {
	            	System.out.println("conexao encerrada");
	            	break;
	            }
	            System.out.println(linha);
            }

        } catch (IOException ex) {
            //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        
    }
    
}
