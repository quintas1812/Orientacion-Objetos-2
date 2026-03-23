package Main.ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaveBD implements Save{
    private String DRIVER;
    private String URL_DB ;
    private String USER ;
    private String PASS;
    private static Connection conn = null;
    public SaveBD(String DRIVER, String URL_DB, String USER, String PASS) {
        this.DRIVER = DRIVER;
        this.URL_DB = URL_DB;
        this.USER = USER;
        this.PASS = PASS;
    }
    @Override
    public void guardar(String datos) {
        try {
            connect();
            String[] partes = datos.split(", ");
            String fecha = partes[0];
            String concurso = partes[1];
            String participante = partes[2];

            String sql = "INSERT INTO Concurso-Participante (fecha, codCurso, participante) VALUES (?,?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, fecha);
            stmt.setString(2, concurso);
            stmt.setString(3, participante);
            stmt.executeUpdate();
            disconnect();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void connect() {
        try {
            // Cargar el driver
            Class.forName(this.DRIVER);
            // Crear la conexión
            conn = DriverManager.getConnection(this.URL_DB, this.USER, this.PASS);
            System.out.println("✅ Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException ("❌ Driver no encontrado: " + this.DRIVER);

        } catch (SQLException e) {
            throw new RuntimeException("❌ No se ha podido conectar a " + this.URL_DB + ". " + e.getMessage());
        }
    }

    public  void disconnect() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

}
