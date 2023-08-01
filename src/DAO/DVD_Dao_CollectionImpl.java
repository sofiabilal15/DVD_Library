package DAO;
import Model.DVD;
import java.util.ArrayList;
import java.util.List;

public class DVD_Dao_CollectionImpl implements DVD_DAO {

    List<DVD> DVD_Data_Store = new ArrayList();
    @Override
    public DVD addDVD(DVD newDVD) {
        //int newBookId = DVD_Data_Store.get(DVD_Data_Store.size()-1).getDVDId() + 1;
        //newDVD.setDVDId(newBookId);
        //DVD_Data_Store.add(newDVD.copyDVDData());
        //return newDVD;

        if (DVD_Data_Store.isEmpty()) {
            newDVD.setDVDId(1); // Assuming 1 is the initial ID when the list is empty
        } else {
            int newBookId = DVD_Data_Store.get(DVD_Data_Store.size() - 1).getDVDId() + 1;
            newDVD.setDVDId(newBookId);
        }
        DVD_Data_Store.add(newDVD.copyDVDData());
        return newDVD;
    }

    @Override
    public DVD updateDVD(DVD updateDVD) {
        for (int i=0;i<DVD_Data_Store.size();i++)
        {
            if (DVD_Data_Store.get(i).getDVDId() == updateDVD.getDVDId()) {
                DVD_Data_Store.set(i, updateDVD.copyDVDData());
            }
        }
        return updateDVD;
    }

    @Override
    public void removeDVD(int DVDId) {
        for(int i = 0; i < this.DVD_Data_Store.size(); ++i) {
            if (((DVD)this.DVD_Data_Store.get(i)).getDVDId() == DVDId) {
                this.DVD_Data_Store.remove(i);
            }
        }


    }

    @Override
    public List<DVD> fetchAllDVDs() {
        List <DVD> returnDVDDataStore = new ArrayList<DVD>(DVD_Data_Store);
        return DVD_Data_Store;
    }

    @Override
    public DVD fetchById(int DVDId) {
        DVD returnDVD = null;
        for (int i=0;i<DVD_Data_Store.size();i++)
        {
            if (DVD_Data_Store.get(i).getDVDId() == DVDId) {
                returnDVD = DVD_Data_Store.get(i).copyDVDData();
            }
        }
        return returnDVD;
    }

    @Override
    public List<DVD> fetchByTitle(String DVDTitle) {
        List <DVD> returnDVDbyTitle = new ArrayList<DVD>();
        for (int i=0;i<DVD_Data_Store.size();i++)
        {
            if (DVD_Data_Store.get(i).getTitle().equals(DVDTitle)) {
                returnDVDbyTitle.add(DVD_Data_Store.get(i).copyDVDData());
            }
        }
        return returnDVDbyTitle;
    }

    @Override
    public boolean writeToFile() {
        return false;
    }


}