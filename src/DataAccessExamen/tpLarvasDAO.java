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
        String query = " SELECT IdHormiga  "
                + " ,codigoHormiga        "
                + " ,clasificacion        "
                + " ,Comio     "
                + " ,Estado "
                + " ,Recogio "
                + " FROM    Larva   "
                + " WHERE   IdHormiga =   " + id.toString();
        try {
            Connection conn = openConnection(); // conectar a DB
            Statement stmt = conn.createStatement(); // CRUD : select * ...
            ResultSet rs = stmt.executeQuery(query); // ejecutar la
            while (rs.next()) {
                dT = new tpLarvasDTO(rs.getInt(1) // IdHormiga
                        , rs.getString(2) // CodigoHormiga
                        , rs.getString(3) // clasificacion
                        , rs.getString(4) // Comio
                        , rs.getString(5) // Estado
                        , rs.getString(6)); // Recogio
            }
        } catch (SQLException e) {
            throw e;
        }
        return dT;
    }

    @Override
    public List<tpLarvasDTO> readAll() throws Exception {
        List<tpLarvasDTO> lst = new ArrayList<>();
        String query = " SELECT IdHormiga  "
                + " ,codigoHormiga        "
                + " ,clasificacion        "
                + " ,Comio     "
                + " ,Estado "
                + " ,Recogio "
                + " FROM    Larva   ";

        try {
            Connection conn = openConnection(); // conectar a DB
            Statement stmt = conn.createStatement(); // CRUD : select * ...
            ResultSet rs = stmt.executeQuery(query); // ejecutar la
            while (rs.next()) {
                tpLarvasDTO s = new tpLarvasDTO(rs.getInt(1) // IdHormiga
                        , rs.getString(2) // CodigoHormiga
                        , rs.getString(3) // clasificacion
                        , rs.getString(4) // Comio
                        , rs.getString(5) // Estado
                        , rs.getString(6)); // Recogio
    
                lst.add(s);
            }
        } catch (SQLException e) {
            throw e;
        }
        return lst;
    }

    @Override
    public boolean create(tpLarvasDTO entity) throws Exception {
        String query = " INSERT INTO Larva (Humedad, IdTipoRiego) VALUES (?,?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getHumedadSuelo());
            pstmt.setInt(2, entity.getIdTipoRiego());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean update(tpLarvasDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE Larva SET Humedad = ?, FechaModificacion = ? WHERE IdHormiga = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getHumedadSuelo());
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3, entity.getIdDato());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " Delete Larva WHERE IdHormiga = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;
        }
    }

}
