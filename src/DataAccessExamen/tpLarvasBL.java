package DataAccessExamen;

import java.util.List;

import DataAccessExamen.DTO.tpLarvasDTO;

public class tpLarvasBL {
    private tpLarvasDTO tplarvas;
    private tpLarvasDAO tplarvaDAO = new tpLarvasDAO();
    public tpLarvasBL(){}

    public List<tpLarvasDTO> getAll() throws Exception{
        return tplarvaDAO.readAll();
    }
    public tpLarvasDTO getByIdDato(int idHormiga) throws Exception{
        tplarvas = tplarvaDAO.readBy(idHormiga);
        return tplarvas;
    }
    public boolean create(tpLarvasDTO riegoDTO) throws Exception{   
        return tplarvaDAO.create(riegoDTO);
    }
    public boolean update(tpLarvasDTO riegoDTO) throws Exception{
        return tplarvaDAO.update(riegoDTO);
    }
    public boolean delete(int idHormiga) throws Exception{
        return tplarvaDAO.delete(idHormiga);
    }
}
