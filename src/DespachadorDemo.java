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
		Queue<Proceso> despachador=new LinkedList<Proceso>();
	
		ArrayList<Proceso> listprocesos = new ArrayList<Proceso>();
		
		try{
			File f = new File("Demo.txt");
			Scanner s = new Scanner(f);
			while(s.hasNextLine()){
				String line = s.nextLine();
				String[] proceso = line.split(",");
				Proceso p = new Proceso();
				p.setNombre(proceso[0]);
				p.setTiempoEjecucion(Integer.parseInt(proceso[1]));
				p.setNumeroBloqueo(Integer.parseInt(proceso[2]));
				p.setPrioridad(Integer.parseInt(proceso[3]));
				p.setTiempoListo(Integer.parseInt(proceso[4]));
				listprocesos.add(p);
				//System.out.println(line);
			
			}
			s.close(); 
		}catch(FileNotFoundException e){
			System.out.println("El archivo no existe...");
		}
		
		
		Collections.sort(listprocesos);
		
		for(Proceso p : listprocesos){
			despachador.add(p);
		}
		
		
		

	}

}
