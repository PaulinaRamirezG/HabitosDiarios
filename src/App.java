import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class App {
    static Scanner scn = new Scanner(System.in);
    static ArrayList<HabitoDiario> habitosDiariosList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.out.println("Bienvenido a tu programa de hábitos diarios!");
        opciones();
    }

    private static void opciones() throws ParseException {
        System.out.println("1. Ingresar tu rutina");
        System.out.println("2. Resumen diario");
        System.out.println("3. Resumen semanal");
        System.out.println("0. Salir");
        int opcion = scn.nextInt();
        scn.nextLine(); // <---- Para corregir error del Scanner

        switch (opcion) {
            case 1:
                crearRutina();
                break;
            case 2:
                resumenDiario();
                break;
            case 3:
                resumenSemanal();
                break;
            default:
                scn.close();
                break;
        }
    }

    // Crea la rutina diaria
    private static void crearRutina() throws ParseException {
        Date fecha = obtenerFecha();

        System.out.println("Ingresa la cantidad de líquido que ingeriste hoy (litros)");
        Double cantidadLiquido = scn.nextDouble();

        System.out.println("Ingresa la cantidad de tiempo que leíste (numero)");
        Double tiempoLeer = scn.nextDouble();

        System.out.println("Ingresa la cantidad de tiempo que hiciste ejercicio (numero)");
        Double tiempoEjercicio = scn.nextDouble();

        // Se ingresa en el objeto
        HabitoDiario habitoDiario = new HabitoDiario(fecha, cantidadLiquido, tiempoEjercicio, tiempoLeer);

        // Se adiciona a la lista
        habitosDiariosList.add(habitoDiario);
        opciones();
    }

    private static Date obtenerFecha() throws ParseException {
        System.out.println("Ingresar la fecha de tu rutina (dd/mm/yyyy)");
        String fechaComoTexto = scn.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = sdf.parse(fechaComoTexto);
        return fecha;
    }

    // Obtiene los hábitos de un día específico
    private static void resumenDiario() throws ParseException {
        Date fecha = obtenerFecha();

        // Se busca la fecha
        for (HabitoDiario habitoDiario : habitosDiariosList) {
            if (habitoDiario.getFecha().equals(fecha)) {
                System.out.println("Ingeriste " + habitoDiario.getCantLiquido() + " de liquido. Hiciste ejercicio por "
                        + habitoDiario.getTiempoEjercicio() + " horas y leiste " + habitoDiario.getTiempoLeer()
                        + " horas. Semana:" + habitoDiario.getSemana());
                opciones();
                return;
            }
        }
        // No encontró rutina para ese día
        System.out.println(
                "Oh no! parece que no ingresaste tu hábito para ese día o no hiciste nada. No te preocupes, tienes otra oportunidad");
        opciones();
    }

    // Se recupera el resumen semanal
    private static void resumenSemanal() throws ParseException {
        System.out.println("Ingresa la semana que deseas consultar (1-52)");
        int semana = scn.nextInt();
        scn.nextLine(); // <---- Para corregir error del Scanner

        if(semana <= 0 && semana > 52){
            System.out.println("Ingresa una semana válida");
            resumenSemanal();
            return;
        }

        // Se recorre los días que se tuvo hábito
        double totalLiquido = 0;
        double totalLectura = 0;
        double totalEjercicio = 0;
        final int DIAS_SEMANA = 7;
        for (HabitoDiario habitoDiario : habitosDiariosList) {
            if(habitoDiario.getSemana() ==  semana){
                totalLiquido += habitoDiario.getCantLiquido();
                totalLectura += habitoDiario.getTiempoLeer();
                totalEjercicio += habitoDiario.getTiempoEjercicio();
            }
        }

        System.out.println("promedio de líquido:"+ totalLiquido / DIAS_SEMANA );
        System.out.println("promedio de lectura:"+ totalLectura / DIAS_SEMANA );
        System.out.println("promedio de ejercicio:"+ totalEjercicio / DIAS_SEMANA );
        opciones();
    }

}
