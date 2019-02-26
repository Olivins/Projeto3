package pratica3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args)  {
        
        try {
            ServerSocket s = new ServerSocket(2000);//o server socket tem um serviço que espera conexao (implementado abaixo)

            
            while(true) {
                System.out.println("Esperando conexao..........");
                Socket conexao = s.accept();
                System.out.println("Conectou");
                DataInputStream entrada = new DataInputStream(conexao.getInputStream());
                DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());
                String linha = entrada.readUTF();
                while (linha != null && !(linha.trim().contentEquals(""))) {
                	saida.writeUTF(linha);
                	linha = entrada.readUTF();
                }
            
            saida.writeUTF(linha);
            conexao.close();
            }
                       
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }}
        
    
