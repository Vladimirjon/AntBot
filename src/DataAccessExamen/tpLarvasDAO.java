package DataAccessExamen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import DataAccessExamen.DTO.tpLarvasDTO;


public class tpLarvasDAO extends tpSQLiteDataHelper implements tpIDAO<tpLarvasDTO> {

    @Override
    public tpLarvasDTO readBy(Integer id) throws Exception {
        tpLarvasDTO dT = new tpLarvasDTO();
        String query = "SELECT IdHormiga, codigoHormiga, clasificacion, Comio, Estado, Recogio FROM Larva WHERE IdHormiga = ?";
        try (Connection conn = openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    dT = new tpLarvasDTO(rs.getInt("IdHormiga"),
                            rs.getString("codigoHormiga"),
                            rs.getString("clasificacion"),
                            rs.getString("Comio"),
                            rs.getString("Estado"),
                            rs.getString("Recogio"));
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return dT;
    }

    @Override
    public List<tpLarvasDTO> readAll() throws Exception {
        List<tpLarvasDTO> lst = new ArrayList<>();
        String query = "SELECT IdHormiga, codigoHormiga, clasificacion, Comio, Estado, Recogio FROM Larva";
        try (Connection conn = openConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                tpLarvasDTO s = new tpLarvasDTO(rs.getInt("IdHormiga"),
                        rs.getString("codigoHormiga"),
                        rs.getString("clasificacion"),
                        rs.getString("Comio"),
                        rs.getString("Estado"),
                        rs.getString("Recogio"));
                lst.add(s);
            }
        } catch (SQLException e) {
            throw e;
        }
        return lst;
    }

    @Override
    public boolean create(tpLarvasDTO entity) throws Exception {
        String query = "INSERT INTO Larva (codigoHormiga, clasificacion, Comio, Estado, Recogio) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, entity.getCodHormiga());
            pstmt.setString(2, entity.getClasificacion());
            pstmt.setString(3, entity.getComio());
            pstmt.setString(4, entity.getEstado());
            pstmt.setString(5, entity.getRecogio());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean update(tpLarvasDTO entity) throws Exception {
        String query = "UPDATE Larva SET codigoHormiga = ?, clasificacion = ?, Comio = ?, Estado = ?, Recogio = ? WHERE IdHormiga = ?";
        try (Connection conn = openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, entity.getCodHormiga());
            pstmt.setString(2, entity.getClasificacion());
            pstmt.setString(3, entity.getComio());
            pstmt.setString(4, entity.getEstado());
            pstmt.setString(5, entity.getRecogio());
            pstmt.setInt(6, entity.getIdHormiga());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "DELETE FROM Larva WHERE IdHormiga = ?";
        try (Connection conn = openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }
}
