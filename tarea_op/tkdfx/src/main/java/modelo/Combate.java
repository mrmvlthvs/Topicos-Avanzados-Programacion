package modelo;

public class Combate {
    private Competidor chung;
    private Competidor hong;
    private int tiempoRestanteSegundos;
    private int duracionInicialSegundos;
    private boolean enCurso;

    public Combate(Competidor chung, Competidor hong, int duracionSegundos) {
        this.chung = chung;
        this.hong = hong;
        this.duracionInicialSegundos = duracionSegundos;
        this.tiempoRestanteSegundos = duracionSegundos;
        this.enCurso = false;
    }

    public void descontarSegundo() {
        if (enCurso && tiempoRestanteSegundos > 0) {
            tiempoRestanteSegundos--;
        }
        if (tiempoRestanteSegundos == 0) {
            enCurso = false;
        }
    }

    public void penalizarChung() {
        chung.agregarGamJeom();
        hong.sumarPuntos(1); // Gam-jeom otorga 1 punto al oponente
    }

    public void penalizarHong() {
        hong.agregarGamJeom();
        chung.sumarPuntos(1); // Gam-jeom otorga 1 punto al oponente
    }

    public String obtenerTiempoFormateado() {
        int minutos = tiempoRestanteSegundos / 60;
        int segundos = tiempoRestanteSegundos % 60;
        return String.format("%02d:%02d", minutos, segundos);
    }

    public String determinarGanador() {
        if (chung.getGamJeoms() >= 5) {
            return "GANADOR: " + hong.getNombre() + " (HONG) por penalizaciones";
        }
        if (hong.getGamJeoms() >= 5) {
            return "GANADOR: " + chung.getNombre() + " (CHUNG) por penalizaciones";
        }
        if (chung.getPuntos() > hong.getPuntos()) {
            return "GANADOR: " + chung.getNombre() + " (" + chung.getEquipo() + ") - CHUNG";
        } else if (hong.getPuntos() > chung.getPuntos()) {
            return "GANADOR: " + hong.getNombre() + " (" + hong.getEquipo() + ") - HONG";
        } else {
            return "EMPATE - Se requiere Round de Desempate (Punto de Oro)";
        }
    }

    public Competidor getChung() { return chung; }
    public Competidor getHong() { return hong; }
    public int getTiempoRestanteSegundos() { return tiempoRestanteSegundos; }
    public boolean isEnCurso() { return enCurso; }
    public void setEnCurso(boolean enCurso) { this.enCurso = enCurso; }
}