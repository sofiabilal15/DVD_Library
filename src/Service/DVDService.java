package Service;

import Model.DVD;

import java.util.List;

public interface DVDService {
    DVD addDVD(DVD var1);

    DVD updateDVD(DVD updateBook);

    void removeDVD(int var1);

    List<DVD> fetchAllDVDs();

    DVD fetchById(int var1);

    List<DVD> fetchByTitle(String DVD_Title);

    boolean writeToFile();
}
