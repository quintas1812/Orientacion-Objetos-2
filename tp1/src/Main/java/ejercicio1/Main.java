package ejercicio1;

public class Main {
    public static void main(String[] args) {
        // Ejemplo de uso del sistema de Concurso
        java.time.LocalDate hoy = java.time.LocalDate.now();
        Concurso concurso = new Concurso(hoy, hoy.plusDays(10));
        Participante p1 = new Participante(12345678, "Juan", "Perez");

        System.out.println("Inscribiendo participante...");
        Save save = new SaveFile("pruebaconcurso.txt");
        concurso.agregarA(p1, save);
        System.out.println("Puntos del participante: " + concurso.puntosDe(p1));
        System.out.println("Cantidad de inscriptos: " + concurso.cantidadadParticipantes());
    }

}
