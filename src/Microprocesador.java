import java.util.ArrayList;

public class Microprocesador {

	public static int microCount=0;
	private int id;
	private Proceso procesoActivo;
	private ArrayList<Proceso> listaProcesos = new ArrayList<Proceso>();
	private int tiempoTotal;
	private int tamanoCuantum;
	

	public Microprocesador(int tamanoCuantum) {
		Microprocesador.microCount++;
		id=Microprocesador.microCount;
		this.tamanoCuantum=tamanoCuantum;
		tiempoTotal=0;
	}
	
	public void agregarProceso(Proceso p){
		if(tiempoTotal==0){
			tiempoTotal=p.getTiempoListo();
			p.setTiempoCambiodeContexto(0);
		}
		else if(tiempoTotal<p.getTiempoListo()){
			Proceso pMuerto= new Proceso();
			pMuerto.setTiempoInicial(tiempoTotal);
			pMuerto.setTiempoFinal(p.getTiempoListo());
			pMuerto.setTiempoEjecucion(pMuerto.getTiempoFinal()-pMuerto.getTiempoInicial());
			pMuerto.setNombre("Tiempo Muerto");
			tiempoTotal=p.getTiempoListo();
			p.setTiempoCambiodeContexto(0);
			listaProcesos.add(pMuerto);
		}else{
			p.setTiempoCambiodeContexto(DespachadorDemo.tcc);
		}
		
		p.CalcTiempoTotal();
	
		
		p.setTiempoInicial(tiempoTotal);
		p.setTiempoFinal(p.getTiempoInicial()+p.getTiempoTotalProceso());
		procesoActivo=p;
		tiempoTotal+=p.getTiempoTotalProceso();
		listaProcesos.add(p);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Proceso getProcesoActivo() {
		return procesoActivo;
	}

	public void setProcesoActivo(Proceso procesoActivo) {
		this.procesoActivo = procesoActivo;
	}

	public ArrayList<Proceso> getListaProcesos() {
		return listaProcesos;
	}

	public void setListaProcesos(ArrayList<Proceso> listaProcesos) {
		this.listaProcesos = listaProcesos;
	}

	public int getTiempoTotal() {
		return tiempoTotal;
	}

	public void setTiempoTotal(int tiempoTotal) {
		this.tiempoTotal = tiempoTotal;
	}

	public int getTamanoCuantum() {
		return tamanoCuantum;
	}

	public void setTamanoCuantum(int tamanoCuantum) {
		this.tamanoCuantum = tamanoCuantum;
	}
	
	public String toString(){
		String mensaje = "Microprocesador: "+id;
		for(Proceso p: listaProcesos){
			mensaje+=p.getNombre()+" ,,,, ";
		}
		return mensaje; 
		
	}
	
	

}
