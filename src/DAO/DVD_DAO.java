package DAO;

import Model.DVD;

import java.util.List;

public interface DVD_DAO {
    DVD addDVD(DVD var1);

    DVD updateDVD(DVD var1);

    void removeDVD(int var1);

    List<DVD> fetchAllDVDs();

    DVD fetchById(int var1);

    List<DVD> fetchByTitle(String DVD_Title);

    boolean writeToFile();

}
