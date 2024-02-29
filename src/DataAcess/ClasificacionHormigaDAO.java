package DataAcess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DataAcess.DTO.ClasificacionHormigaDTO;
import DataAcess.DTO.HormigaDTO;
import FrameWork.PException;

public class ClasificacionHormigaDAO extends SQLiteDataHelper implements IDAO<ClasificacionHormigaDTO>{
    @Override
    public ClasificacionHormigaDAO readBy(Integer id) throws Exception {
        ClasificacionHormigaDAO oP = new ClasificacionHormigaDAO();
        String query = " SELECT IdCategoriaHormiga           "
                + " ,ClasificacionHormiga     "
                + " FROM    ClasificacionHormigas                ";
        try {
            Connection conn = openConnection(); // conectar a DB
            Statement stmt = conn.createStatement(); // CRUD : selec t * ...
            ResultSet rs = stmt.executeQuery(query); // ejecutar la
            while (rs.next()) {
                oP = new ClasificacionHormigaDAO(rs.getInt(1) // IdPregunta
                        , rs.getInt(2) // IdCategoriaEstructura
                        , rs.getString(3) // Enunciado
                        , rs.getInt(4)); // FechaModifica
            }
        } catch (SQLException e) {
            throw new PException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return oP;
    }

    @Override
    public List<ClasificacionHormigaDAO> readAll() throws Exception {
        List<ClasificacionHormigaDAO> lst = new ArrayList<>();
        String query = " SELECT IdRespuesta               "
                + " ,IdPregunta     "
                + " ,RespuestaUsuario                       "
                + " ,Aprobada                         "
                + " FROM    Respuesta                ";
        try {
            Connection conn = openConnection(); // conectar a DB
            Statement stmt = conn.createStatement(); // CRUD : select * ...
            ResultSet rs = stmt.executeQuery(query); // ejecutar la
            while (rs.next()) {
                ClasificacionHormigaDAO ClasificacionHormigaDAO = new ClasificacionHormigaDAO(rs.getInt(1) // IdPregunta
                        , rs.getInt(2) // IdCategoriaEstructura
                        , rs.getString(3) // Enunciado

                        , rs.getInt(4));// FechaModifica
                lst.add(ClasificacionHormigaDAO);
            }
        } catch (SQLException e) {
            throw new PException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public List<ClasificacionHormigaDAO> readById(Integer id) throws Exception {
        List<ClasificacionHormigaDAO> lst = new ArrayList<>();
        String query = " SELECT IdRespuesta               "
                + " ,IdPregunta     "
                + " ,RespuestaUsuario                       "
                + " ,Aprobada                         "
                + " FROM    Respuesta                "
                + " WHERE   IdPregunta =   " + id.toString();
        try {
            Connection conn = openConnection(); // conectar a DB
            Statement stmt = conn.createStatement(); // CRUD : select * ...
            ResultSet rs = stmt.executeQuery(query); // ejecutar la
            while (rs.next()) {
                ClasificacionHormigaDAO ClasificacionHormigaDAO = new ClasificacionHormigaDAO(rs.getInt(1) // IdPregunta
                        , rs.getInt(2) // IdCategoriaEstructura
                        , rs.getString(3) // Enunciado

                        , rs.getInt(4));// FechaModifica
                lst.add(ClasificacionHormigaDAO);
            }
        } catch (SQLException e) {
            throw new PException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean create(ClasificacionHormigaDAO entity) throws Exception {
        String query = " INSERT INTO Respuesta (IdPregunta, RespuestaUsuario, Aprobada) VALUES (?,?,?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdPregunta());
            pstmt.setString(2, entity.getRespuestaUsuario());
            pstmt.setInt(3, entity.getAprobada());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(ClasificacionHormigaDAO entity) throws Exception {
        String query = " UPDATE Respuesta SET RespuestaUsuario = ?, Aprobada = ? WHERE IdRespuesta = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, entity.getRespuestaUsuario());
            pstmt.setInt(2, entity.getAprobada());
            pstmt.setInt(3, entity.getIdRespuesta());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "DELETE Respuesta WHERE IdRespuesta = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PException(e.getMessage(), getClass().getName(), "delete()");
        }
    }
}
