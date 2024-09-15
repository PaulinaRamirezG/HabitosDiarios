import java.util.Calendar;
import java.util.Date;

public class HabitoDiario {
    Date fecha;
    Double cantLiquido;
    Double tiempoEjercicio;
    Double tiempoLeer;
    int semana;
    
    public HabitoDiario(Date fecha, Double cantLiquido, Double tiempoEjercicio, Double tiempoLeer) {
        this.fecha = fecha;
        this.cantLiquido = cantLiquido;
        this.tiempoEjercicio = tiempoEjercicio;
        this.tiempoLeer = tiempoLeer;
        this.semana = obtenerSemana();
    }

    private int obtenerSemana() {
        Calendar calendar = Calendar. getInstance();
        calendar.setTime(this.fecha);
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getCantLiquido() {
        return cantLiquido;
    }

    public void setCantLiquido(Double cantLiquido) {
        this.cantLiquido = cantLiquido;
    }

    public Double getTiempoEjercicio() {
        return tiempoEjercicio;
    }

    public void setTiempoEjercicio(Double tiempoEjercicio) {
        this.tiempoEjercicio = tiempoEjercicio;
    }

    public Double getTiempoLeer() {
        return tiempoLeer;
    }

    public void setTiempoLeer(Double tiempoLeer) {
        this.tiempoLeer = tiempoLeer;
    }

    public int getSemana() {
        return semana;
    }

    public void setSemana(int semana) {
        this.semana = semana;
    }

}
