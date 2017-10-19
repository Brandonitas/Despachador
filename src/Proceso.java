
public class Proceso implements Comparable<Proceso>{
	String nombre;
	int tiempoEjecucion;
	int tiempoBloqueo;
	int numeroBloqueo;
	int tiempoInicial;
	int tiempoFinal;
	int prioridad;
	
	public int compareTo(Proceso proceso){
		if(this.prioridad<proceso.getPrioridad()){
			return -1;
		}else return 1;
	}
	
	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	Microprocesador microprocesadorId;
	int tiempoListo;
	
	public Proceso() {
		
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTiempoEjecucion() {
		return tiempoEjecucion;
	}

	public void setTiempoEjecucion(int tiempoEjecucion) {
		this.tiempoEjecucion = tiempoEjecucion;
	}

	public int getTiempoBloqueo() {
		return tiempoBloqueo;
	}

	public void setTiempoBloqueo(int tiempoBloqueo) {
		this.tiempoBloqueo = tiempoBloqueo;
	}

	public int getNumeroBloqueo() {
		return numeroBloqueo;
	}

	public void setNumeroBloqueo(int numeroBloqueo) {
		this.numeroBloqueo = numeroBloqueo;
	}

	public int getTiempoInicial() {
		return tiempoInicial;
	}

	public void setTiempoInicial(int tiempoInicial) {
		this.tiempoInicial = tiempoInicial;
	}

	public int getTiempoFinal() {
		return tiempoFinal;
	}

	public void setTiempoFinal(int tiempoFinal) {
		this.tiempoFinal = tiempoFinal;
	}

	public Microprocesador getMicroprocesadorId() {
		return microprocesadorId;
	}

	public void setMicroprocesadorId(Microprocesador microprocesadorId) {
		this.microprocesadorId = microprocesadorId;
	}

	public int getTiempoListo() {
		return tiempoListo;
	}

	public void setTiempoListo(int tiempoListo) {
		this.tiempoListo = tiempoListo;
	}

}
