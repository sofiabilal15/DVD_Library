package Service;
import DAO.DVD_DAO;
import DAO.DVD_Dao_CollectionImpl;
import Model.DVD;
import java.util.List;

// service layer is the place where you write business logic
// this project is too small to have business logic
// this service layer is just to understand the interaction with DAO layer
// so the service will not be doing anything much, it would just call methods of DAO layer
public class DVDServiceImpl implements DVDService {

    DVD_DAO dvdDao = null; // BookServiceImpl is dependent on BookDaoCollectionImpl

    public DVDServiceImpl() {
        dvdDao = new DVD_Dao_CollectionImpl();
    }

    @Override
    public DVD addDVD(DVD newDvd) {
        return dvdDao.addDVD(newDvd);
    }

    @Override
    public DVD updateDVD(DVD updateDvd) {
        return dvdDao.updateDVD(updateDvd);
    }

    @Override
    public void removeDVD(int DvdId) {
        dvdDao.removeDVD(DvdId);

    }

    @Override
    public List<DVD> fetchAllDVDs()
    {
        return dvdDao.fetchAllDVDs();
    }

    @Override
    public DVD fetchById(int dvdId) {
        return dvdDao.fetchById(dvdId);
    }

    @Override
    public List<DVD> fetchByTitle(String DVD_Title) {
        return dvdDao.fetchByTitle(DVD_Title);
    }

    @Override
    public boolean writeToFile() {
        return dvdDao.writeToFile();
    }
}
