package pharmacy.Services;
import pharmacy.DAO.DevelopersDAO;
import pharmacy.Models.Developer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by User on 05.09.2016.
 */
public class DeveloperService {
    List<Developer> developers;
    DevelopersDAO dao;

    public DeveloperService() {
        dao = new DevelopersDAO();
        developers = dao.getAll();
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

}
