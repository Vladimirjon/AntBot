package DataAcess;

import java.util.List;

import DataAcess.DTO.ClasificacionHormigaDTO;


public class HormigaBL {
    private ClasificacionHormigaDTO hormigaDTO;
    private ClasificacionHormigaDAO hormigaDAO = new ClasificacionHormigaDAO();

    public HormigaBL(){}

    public List<ClasificacionHormigaDTO> getAll() throws Exception{
        return  hormigaDAO.readAll();
    }
    public ClasificacionHormigaDTO getByIdClasificacion(int idHormiga) throws Exception{
        hormigaDTO = hormigaDAO.readBy(idHormiga);
        return hormigaDTO;
    }
    public boolean create(ClasificacionHormigaDTO sexoDTO) throws Exception{   
        return hormigaDAO.create(sexoDTO);
    }
    public boolean update(ClasificacionHormigaDTO sexoDTO) throws Exception{
        return hormigaDAO.update(sexoDTO);
    }
    public boolean delete(int idHormiga) throws Exception{
        return hormigaDAO.delete(idHormiga);
    }
    // public Integer getMaxRow() throws Exception{
    //     return hormigaDAO.getMaxRow();
    // }

}
