import java.util.ArrayList;

public class Microprocesador {

	private int id;
	private Proceso procesoActivo;
	private ArrayList<Proceso> listaProcesos = new ArrayList<Proceso>();
	private int tiempoTotal;
	private int tamañoCuantum;
	
	public Microprocesador() {
		// TODO Auto-generated constructor stub
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

	public int getTamañoCuantum() {
		return tamañoCuantum;
	}

	public void setTamañoCuantum(int tamañoCuantum) {
		this.tamañoCuantum = tamañoCuantum;
	}
	
	

}
