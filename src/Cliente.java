import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Cliente {

	public static void main(String[] args) {
		String msg = "";
		try{
			Socket socket = new Socket("localhost", 6500);
			Leitura leitura = new Leitura(socket);
			leitura.start();
			
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			while (!msg.equals("xau")){
				out.writeUTF(JOptionPane.showInputDialog("Digite a msg para o servidor: "));
				System.out.println(msg);
			}
			socket.close();
			
		}catch(IOException ex){
			ex.printStackTrace();
		}

	}

}
