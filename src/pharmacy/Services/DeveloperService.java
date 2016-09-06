package pharmacy.Services;
import pharmacy.Models.Developer;
import pharmacy.DAO.DevelopersList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by User on 05.09.2016.
 */
public class DeveloperService {
    List<Developer> developers;
    DevelopersList db;

    public DeveloperService() {
        db = new DevelopersList();
        developers = db.getList();
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

}
