package DataAcess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DataAcess.DTO.ClasificacionHormigaDTO;
import FrameWork.PException;

public class ClasificacionHormigaDAO extends SQLiteDataHelper implements IDAO<ClasificacionHormigaDTO>{
    @Override
    public ClasificacionHormigaDTO readBy(Integer id) throws Exception {
        ClasificacionHormigaDTO oP = new ClasificacionHormigaDTO();
        String query = " SELECT IdCategoriaHormiga           "
                + " ,ClasificacionHormiga     "
                +" ,FechaCrea"
                +" ,FechaModifica"
                + " FROM    ClasificacionHormigas                "
                +"WHERE IdCategoriaHormiga"+id.toString();
        try {
            Connection conn = openConnection(); // conectar a DB
            Statement stmt = conn.createStatement(); // CRUD : selec t * ...
            ResultSet rs = stmt.executeQuery(query); // ejecutar la
            while (rs.next()) {
                oP = new ClasificacionHormigaDTO(rs.getInt(1) // IdHormiga
                , rs.getString(2) // TipoHormiga
                ,rs.getString(3) // FechaCrea
                ,rs.getString(4)); // FechaModifica
            }
        } catch (SQLException e) {
            throw new PException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return oP;
    }

    @Override
    public List<ClasificacionHormigaDTO> readAll() throws Exception {
        List<ClasificacionHormigaDTO> lst = new ArrayList<>();
        String query = " SELECT IdCategoriaHormiga           "
                + " ,ClasificacionHormiga     "
                + " ,FechaCrea     "
                + " ,FechaModifica     "
                + " FROM    ClasificacionHormigas                ";
        try {
            Connection conn = openConnection(); // conectar a DB
            Statement stmt = conn.createStatement(); // CRUD : select * ...
            ResultSet rs = stmt.executeQuery(query); // ejecutar la
            while (rs.next()) {
                ClasificacionHormigaDTO ClasificacionHormigaDTO = new ClasificacionHormigaDTO(rs.getInt(1) // IdClasificacion
                        , rs.getString(2) // Tipo Hormiga
                        ,rs.getString(3) // FechaCrea
                        ,rs.getString(4));// FechaModifica
                lst.add(ClasificacionHormigaDTO);
            }
        } catch (SQLException e) {
            throw new PException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    // @Override
    // public List<ClasificacionHormigaDTO> readById(Integer id) throws Exception {
    //     List<ClasificacionHormigaDTO> lst = new ArrayList<>();
    //     String query = " SELECT IdCategoriaHormiga           "
    //             + " ,ClasificacionHormiga     "
    //             + " FROM    ClasificacionHormigas                ";
    //     try {
    //         Connection conn = openConnection(); // conectar a DB
    //         Statement stmt = conn.createStatement(); // CRUD : select * ...
    //         ResultSet rs = stmt.executeQuery(query); // ejecutar la
    //         while (rs.next()) {
    //             ClasificacionHormigaDTO ClasificacionHormigaDTO = new ClasificacionHormigaDTO(rs.getInt(1) // IdPregunta
    //             , rs.getString(2),rs.getString(3),rs.getString(4) // IdCategoriaEstructura
    //             );// FechaModifica
    //             lst.add(ClasificacionHormigaDTO);
    //         }
    //     } catch (SQLException e) {
    //         throw new PException(e.getMessage(), getClass().getName(), "readAll()");
    //     }
    //     return lst;
    // }

    @Override
    public boolean create(ClasificacionHormigaDTO entity) throws Exception {
        String query = " INSERT INTO ClasificacionHormigas (IdCategoriaHormiga, ClasificacionHormiga) VALUES (?,?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdCategoriaHormiga());
            pstmt.setString(2, entity.getClasificacionHormiga());
            
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(ClasificacionHormigaDTO entity) throws Exception {
        String query = " UPDATE  ClasificacionHormigas SET ClasificacionHormiga = ?,  WHERE IdCategoriaHormiga = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, entity.getClasificacionHormiga());
            pstmt.setInt(2, entity.getIdCategoriaHormiga());
            // pstmt.setInt(3, dtf.getIdCategoriaHormiga());
            
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "DELETE ClasificacionHormigas WHERE IdCategoriaHormiga = ?";
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
