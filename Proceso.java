public class Proceso implements Comparable<Proceso> {
    private String proceso;
    private String nombre;
    private int nice;
    private int prioridad;

    public Proceso(String proceso, String nombre, int nice) {
        this.proceso = proceso;
        this.nombre = nombre;
        this.nice = nice;
        this.prioridad = nice + 120;
    }

    public String getProceso() {
        return proceso;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNice() {
        return nice;
    }

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public int compareTo(Proceso o) {
        return Integer.compare(this.prioridad, o.getPrioridad());
    }
}