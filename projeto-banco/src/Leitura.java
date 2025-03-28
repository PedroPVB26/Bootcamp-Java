
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Leitura{

	public String entDados(String rotulo){
        InputStreamReader tec = new InputStreamReader(System.in);
        BufferedReader buff =  new BufferedReader(tec);
		String ret = "";
		
		System.out.println(rotulo);

		try{
			ret = buff.readLine();
		}catch(IOException ioe){
			System.out.println("ERRO" + ioe);
		}
		return ret;
	}
}

