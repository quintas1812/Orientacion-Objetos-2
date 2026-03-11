package ejercicio1.main;

public class Main {
    public static void main(String[] args) {
        // Ejemplo de uso del sistema de Concurso
        java.time.LocalDate hoy = java.time.LocalDate.now();
        Concurso concurso = new Concurso(hoy, hoy.plusDays(10));
        Participante p1 = new Participante(12345678, "Juan", "Perez");

        System.out.println("Inscribiendo participante...");
        String resultado = concurso.agregarA(p1);

        System.out.println("Resultado: " + resultado);
        System.out.println("Puntos del participante: " + concurso.puntosDe(p1));
        System.out.println("Cantidad de inscriptos: " + concurso.cantidadadParticipantes());
    }

}
