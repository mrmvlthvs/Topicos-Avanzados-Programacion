package modelo;

public class Competidor {
    private String nombre;
    private String equipo;
    private String peto; // "CHUNG" o "HONG"
    private int puntos;
    private int gamJeoms;

    public Competidor(String nombre, String equipo, String peto) {
        this.nombre = nombre;
        this.equipo = equipo;
        this.peto = peto;
        this.puntos = 0;
        this.gamJeoms = 0;
    }

    public void sumarPuntos(int cantidad) {
        this.puntos += cantidad;
        if (this.puntos < 0) {
            this.puntos = 0;
        }
    }

    public void agregarGamJeom() {
        this.gamJeoms++;
    }

    public void quitarGamJeom() {
        if (this.gamJeoms > 0) this.gamJeoms--;
    }

    public String getNombre() { return nombre; }
    public String getEquipo() { return equipo; }
    public String getPeto() { return peto; }
    public int getPuntos() { return puntos; }
    public int getGamJeoms() { return gamJeoms; }
}