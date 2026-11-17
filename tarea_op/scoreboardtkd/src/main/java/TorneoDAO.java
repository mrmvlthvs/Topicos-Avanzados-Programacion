import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TorneoDAO {
    private Connection conexion;

    public boolean conectar() {
        try {
            // Driver JDBC para MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url;
            url = "jdbc:mysql://localhost:3306/db_taekwondo?useSSL=false&serverTimezone=UTC";
            conexion = DriverManager.getConnection(url, "root", "linux00killer");
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error de conexion: " + e.getMessage());
            return false;
        }
    }

    public boolean registrarCompetidor(String nombre, String categoria, String cinta, String institucion) {
        String sql = "INSERT INTO competidor (nombre, categoria, cinta, institucion) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, categoria);
            pstmt.setString(3, cinta);
            pstmt.setString(4, institucion);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al insertar: " + e.getMessage());
            return false;
        }
    }

    public String consultarCompetidores() {
        StringBuilder sb = new StringBuilder();
        String sql = "SELECT * FROM competidor";
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            sb.append("ID | NOMBRE | CATEGORIA | CINTA | INSTITUCION\n");
            sb.append("--------------------------------------------------\n");
            while (rs.next()) {
                sb.append(rs.getInt("id")).append(" | ")
                        .append(rs.getString("nombre")).append(" | ")
                        .append(rs.getString("categoria")).append(" | ")
                        .append(rs.getString("cinta")).append(" | ")
                        .append(rs.getString("institucion")).append("\n");
            }
        } catch (SQLException e) {
            sb.append("Error al consultar datos: ").append(e.getMessage());
        }
        return sb.toString();
    }
}