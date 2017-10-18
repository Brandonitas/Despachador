import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class DespachadorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn =new Scanner(System.in);
		
		/*System.out.println("Ingresa el numero de microprocesadores");
		int micros = scn.nextInt();
		
		System.out.println("Ingresa el valor del cuantum");
		int cuantum = scn.nextInt();
		
		System.out.println("Ingresa el tiempo de cambio de contexto");
		int tcc = scn.nextInt();
		
		System.out.println("Ingresa el tiempo de bloqueo");
		int tb= scn.nextInt();
		*/
		
		Queue<String> q=new LinkedList<String>();
		
		try{
			File f = new File("Demo.txt");
			Scanner s = new Scanner(f);
			while(s.hasNextLine()){
				String line = s.nextLine();
				String[] micros = line.split(",");
				for(int i = 0; i<micros.length; i++){
					//System.out.println(micros[i]);
					q.add(micros[i]);
				}
			}
			s.close(); 
		}catch(FileNotFoundException e){
			System.out.println("El archivo no existe...");
		}
		
		System.out.println(q.poll());

	}

}
