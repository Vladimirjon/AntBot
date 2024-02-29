package DataAcess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DataAcess.DTO.HormigaDTO;
import FrameWork.PException;

public class HormigaDAO extends SQLiteDataHelper implements IDAO<HormigaDTO>{
        @Override
    public HormigaDTO readBy(Integer id) throws Exception {
        HormigaDTO oP = new HormigaDTO();
        String query = " SELECT IdHormiga               "
        + " ,CodigoHormiga     "
        + " ,IdCategoriaHormigas                       "
        + " ,SerieAntBot                         "
        + " FROM    Antbot                ";
        try {
            
            Connection conn = openConnection(); // conectar a DB
            Statement stmt = conn.createStatement(); // CRUD : selec t * ...
            ResultSet rs = stmt.executeQuery(query); // ejecutar la
            while (rs.next()) {
                oP = new HormigaDTO(rs.getInt(1) // IdPregunta
                        , rs.getString(2) // IdCategoriaEstructura
                        , rs.getInt(3) // Enunciado
                        , rs.getInt(4)); // FechaModifica
            }
        } catch (SQLException e) {
            throw new PException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return oP;
    }

    @Override
    public List<HormigaDTO> readAll() throws Exception {
        List<HormigaDTO> lst = new ArrayList<>();
        String query = " SELECT IdHormiga               "
                + " ,CodigoHormiga     "
                + " ,IdCategoriaHormigas                       "
                + " ,SerieAntBot                         "
                + " FROM    Antbot                ";
        try {
            Connection conn = openConnection(); // conectar a DB
            Statement stmt = conn.createStatement(); // CRUD : select * ...
            ResultSet rs = stmt.executeQuery(query); // ejecutar la
            while (rs.next()) {
                HormigaDTO HormigaDTO = new HormigaDTO(rs.getInt(1) // IdPregunta
                        , rs.getString(2) // IdCategoriaEstructura
                        , rs.getInt(3) // Enunciado
                        , rs.getInt(4));// FechaModifica
                lst.add(HormigaDTO);
            }
        } catch (SQLException e) {
            throw new PException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public List<HormigaDTO> readById(Integer id) throws Exception {
        List<HormigaDTO> lst = new ArrayList<>();
        String query = " SELECT IdHormiga               "
        + " ,CodigoHormiga     "
        + " ,IdCategoriaHormigas                       "
        + " ,SerieAntBot                         "
        + " FROM    Antbot                ";
        try {
            Connection conn = openConnection(); // conectar a DB
            Statement stmt = conn.createStatement(); // CRUD : select * ...
            ResultSet rs = stmt.executeQuery(query); // ejecutar la
            while (rs.next()) {
                HormigaDTO HormigaDTO = new HormigaDTO(rs.getInt(1) // IdPregunta
                        , rs.getString(2) // IdCategoriaEstructura
                        , rs.getInt(3) // Enunciado

                        , rs.getInt(4));// FechaModifica
                lst.add(HormigaDTO);
            }
        } catch (SQLException e) {
            throw new PException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean create(HormigaDTO entity) throws Exception {
        String query = " INSERT INTO Antbot (IdHormiga, CodigoHormiga, IdCategoriaHormigas, SerieAntBot) VALUES (?,?,?,?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdHormiga());
            pstmt.setString(2, entity.getCodigoHormiga());
            pstmt.setInt(3, entity.getIdCategoriaHormigas());
            pstmt.setInt(4, entity.getSerieAntBot());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(HormigaDTO entity) throws Exception {
        String query = " UPDATE Antbot SET CodigoHormiga = ?, IdCategoriaHormigas = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, entity.getCodigoHormiga());
            pstmt.setInt(2, entity.getIdCategoriaHormigas());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "DELETE Antbot WHERE IdHormiga = ?";
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
