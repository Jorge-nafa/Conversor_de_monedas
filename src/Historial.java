import java.time.LocalDate;
import java.time.LocalTime;

public class Historial {
    private String monedaAcambiar;
    private String cambioRealizado;
    private double monto;
    private LocalTime hora;
    private LocalDate dia;

    public Historial(String monedaAcambiar, String cambioRealizado, double monto) {
        this.monedaAcambiar = monedaAcambiar;
        this.cambioRealizado = cambioRealizado;
        this.monto = monto;
        this.hora=LocalTime.now();
        this.dia=LocalDate.now();
    }

    @Override
    public String toString() {
        return "( " + "MonedaAcambiar=" + monedaAcambiar +
                ", CambioRealizado=" + cambioRealizado  +
                ", Monto=" + monto +", Dia="+dia+", Hora="+hora+
                ") \n";
    }
}
