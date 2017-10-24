import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class DespachadorDemo {
	public static int micros=2;
	public static int cuantum=3000;
	public static int tcc=15;
	public static int tb=15;

	public static void main(String[] args) {

		Scanner scn =new Scanner(System.in);
		
		System.out.println("¿Desea utilizar los valores por default? 1. Sí   2. No");
		System.out.print("Ingrese opción: ");
		int opcion = Integer.parseInt(scn.nextLine());

		if (opcion == 2)
		{
			System.out.print("Ingresa el numero de microprocesadores: ");
			micros = Integer.parseInt(scn.nextLine());
			
			System.out.print("Ingresa el valor del cuantum: ");
			cuantum = Integer.parseInt(scn.nextLine());
			
			System.out.print("Ingresa el tiempo de cambio de contexto: ");
			tcc = Integer.parseInt(scn.nextLine());
			
			System.out.print("Ingresa el tiempo de bloqueo: ");
			tb = Integer.parseInt(scn.nextLine());
		}
		
		ArrayList<Microprocesador> micros = new ArrayList<Microprocesador>();
		for(int i=0;i<DespachadorDemo.micros;i++){
			micros.add(new Microprocesador(cuantum));
		}
		
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
		
		
		
		
		while(!despachador.isEmpty()){
			Proceso p = despachador.poll();
		
			Microprocesador temp = micros.get(0);
			
			boolean bandera=false;
			for(Microprocesador o:micros){
				if(o.getTiempoTotal()==0){
					bandera=true;
					temp=o;
					break;
				}
			}
			//Calcular tiempo muerto 
			if(!bandera){
				for(Microprocesador m : micros){
					if(m.getTiempoTotal()<p.getTiempoListo()){
						temp=m;
						break;
						
					}else if(m.getTiempoTotal()<temp.getTiempoTotal()){
						temp=m;
					}
					
				}
			}
			
			temp.agregarProceso(p);
		}
		
		for(Microprocesador m: micros){
			System.out.println(m);
		}
		
		
		
	}

}
