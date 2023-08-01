package DAO;
import Model.DVD;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DVD_DAO_File_collectionImpl implements DVD_DAO {

    List<DVD> dvdFileDataStore = new ArrayList <DVD>();

    public DVD_DAO_File_collectionImpl() {
        try {
            // 1.
            File myFile = new File("DVD_DB.txt");
            //myFile.createNewFile(); // Error fix 3: above line only create an object(instance) representation
            // 2.
            FileReader fr = new FileReader(myFile);
            // 3.
            BufferedReader br = new BufferedReader(fr);
            // 4.
            String line = null;
            while((line=br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, "=:"); // Error fix 1: did not pass line as the first parameter

                st.nextToken();
                String dId = st.nextToken();
                int dvdId = Integer.parseInt(dId);

                st.nextToken();
                String dvdTitle = st.nextToken();

                st.nextToken();
                String DPublished = st.nextToken();
                LocalDate dvdPublished = LocalDate.parse(DPublished);

                st.nextToken();
                String dMPAA = st.nextToken();

                st.nextToken();
                String dvdDirector = st.nextToken();

                st.nextToken();
                String dvdStudio = st.nextToken();

                st.nextToken();
                String dUser = st.nextToken();
                int dvdUser = Integer.parseInt(dUser);


                DVD dvd = new DVD(dvdId,dvdTitle,dvdPublished,dMPAA,dvdDirector,dvdStudio,dvdUser);
                dvdFileDataStore.add(dvd);

            }


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for (DVD dvd : dvdFileDataStore) {
            System.out.println(dvd);
        }
    }

    @Override
    public DVD addDVD(DVD newDVD) {
        int newDVDId = 0;
        if(dvdFileDataStore.size()==0) {
            newDVDId = 101;
        }else {
            newDVDId = dvdFileDataStore.get(dvdFileDataStore.size()-1).getDVDId() + 1;
        }
        newDVD.setDVDId(newDVDId);
        dvdFileDataStore.add(newDVD.copyDVDData());
        return newDVD;
    }

    @Override
    public DVD updateDVD(DVD updateDVD) {
        for(int i=0;i<dvdFileDataStore.size();i++) {
            if(dvdFileDataStore.get(i).getDVDId() == updateDVD.getDVDId()) {
                dvdFileDataStore.set(i, updateDVD.copyDVDData());
            }
        }
        return updateDVD;
    }

    @Override
    public void removeDVD(int dvdId) {
        for(int i=0;i<dvdFileDataStore.size();i++) {
            if(dvdFileDataStore.get(i).getDVDId() == dvdId) {
                dvdFileDataStore.remove(i);
            }
        }
    }

    @Override
    public List<DVD> fetchAllDVDs() {
        List<DVD> returnDVDDataStore = new ArrayList<DVD>(dvdFileDataStore);
        return returnDVDDataStore;
    }

    @Override
    public DVD fetchById(int dvdId) {
        DVD returnDVD = null;
        for(int i=0;i<dvdFileDataStore.size();i++) {
            if(dvdFileDataStore.get(i).getDVDId() == dvdId) {
                returnDVD = dvdFileDataStore.get(i).copyDVDData();
            }
        }
        return returnDVD;
    }

    @Override
    public List<DVD> fetchByTitle(String DVD_Title) {
        List<DVD> returnDVDByTitle = new ArrayList<DVD>();
        for(int i=0;i<dvdFileDataStore.size();i++) {
            if(dvdFileDataStore.get(i).getTitle().equals(DVD_Title)) {
                returnDVDByTitle.add(dvdFileDataStore.get(i).copyDVDData());
            }
        }
        return returnDVDByTitle;
    }

    @Override
    public boolean writeToFile() {
        try {
            // 1.
            File myFile = new File("DVD_DB.txt"); // if the file DVD_DB.txt does not exist, it will be created automatically
            // 2.
            FileWriter fw = new FileWriter(myFile);
            // 3.
            // traverse through the collection dvdFileDataStore
            // as we traverse write the string represtation of BookPojo objects to the file
            for(DVD eachDVD: dvdFileDataStore) {
                fw.write((eachDVD.toString()+"\n").toCharArray());
                fw.flush();// Error fix 2: did not call flush after writing to the FileWriter fw

            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return true;
    }
}
