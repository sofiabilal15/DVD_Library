import Model.DVD;
import Service.DVDService;
import Service.DVDServiceImpl;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DVDService dvdService = new DVDServiceImpl();

        Scanner scan = new Scanner(System.in);
        char con = 'n';
        do {
            System.out.println("*****************************");
            System.out.println("1. Add a DVD");
            System.out.println("2. Remove a DVD");
            System.out.println("3. Update a DVD");
            System.out.println("4. List the DVDs in the collection");
            System.out.println("5. Display the information for a particular DVD by DVD Id");
            System.out.println("6. Search for a DVD by title");
            System.out.println("7. Write to a file");
            System.out.println("8. Exit");
            System.out.println("*****************************");
            System.out.println("Enter your option: ");

            int option = scan.nextInt();
            System.out.println("*****************************");

            switch (option) {
                case 1:
                    System.out.println("Please enter the details of the DVD");

                    System.out.println("Enter DVD Title....");
                    scan.nextLine();
                    String dvdTitle = scan.nextLine();

                    System.out.println("Enter Director's name....");
                    String dvdAuthor = scan.nextLine();

                    System.out.println("Enter Studio....");
                    String dvdstudio = scan.nextLine();

                    System.out.println("Enter Release date");
                    String dvdPublished = scan.nextLine();
                    LocalDate dvdPublishedDate = LocalDate.parse(dvdPublished);

                    System.out.println("Enter MPAA rating....");
                    String MPAA_rating = scan.nextLine();

                    System.out.println("Enter User rating or note ....");
                    String User_note = scan.nextLine();
                    int User_notInt = 0;
                    try {
                       User_notInt = Integer.parseInt(User_note);
                        System.out.println("User's integer rating: " + User_notInt);
                        DVD newDVD = new DVD(0,dvdTitle,dvdPublishedDate,dvdstudio,dvdAuthor,MPAA_rating,User_notInt);
                        DVD returningDVD = dvdService.addDVD(newDVD);
                        System.out.println("DVD added successfully");
                        System.out.println("New DVD ID is : " + returningDVD.getDVDId());

                    } catch (InputMismatchException e ) {
                        System.out.println("Invalid input. Please enter a valid integer.");
                    }


                    //DVD newDVD = new DVD(0,dvdTitle,dvdPublishedDate,dvdstudio,dvdAuthor,MPAA_rating,User_notInt);
                    //DVD returningDVD = dvdService.addDVD(newDVD);
                    //System.out.println("DVD added successfully");
                    //System.out.println("New DVD ID is : " + returningDVD.getDVDId());
                    break;
                case 2:
                    System.out.println("Enter the DVD ID to be Deleted...");
                    int removedvdId = scan.nextInt();
                    DVD removeFetchedDVD = dvdService.fetchById(removedvdId);
                    if (removeFetchedDVD == null) {
                        System.out.println("Sorry! DVD with this ID doesn't exist");
                        break;
                    }else {
                        System.out.println(removeFetchedDVD);
                        System.out.println("Are you sure you want to remove this dvd? (y/n)");
                        char ans = scan.next().charAt(0);
                        if (ans == 'y') {
                            dvdService.removeDVD(removedvdId);
                            System.out.println("The DVD has been deleted");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter the DVDId to be updated...");
                    int updateDVDId = scan.nextInt();
                    DVD updateFetchedDVD = dvdService.fetchById(updateDVDId);
                    if (updateFetchedDVD == null){
                        System.out.println("Sorry! DVD with this ID doesn't exist" );
                    } else {
                        //print the book info
                        System.out.println(updateFetchedDVD);
                        System.out.println("Please edit the Title");
                        String updateTitle = scan.nextLine();
                        updateFetchedDVD.setTitle(updateTitle);

                        System.out.println(updateFetchedDVD);
                        System.out.println("Please edit the Director name");
                        String updateAuthor = scan.nextLine();
                        updateFetchedDVD.setDirector_name(updateAuthor);

                        System.out.println(updateFetchedDVD);
                        System.out.println("Please edit the Studio name");
                        String updateStudio = scan.nextLine();
                        updateFetchedDVD.setStudio(updateStudio);

                        System.out.println(updateFetchedDVD);
                        System.out.println("Please edit the Release date");
                        String updatepublished = scan.nextLine();
                        LocalDate updatepublishedDate = LocalDate.parse(updatepublished);
                        updateFetchedDVD.setRelease_date(updatepublishedDate);

                        System.out.println(updateFetchedDVD);
                        System.out.println("Please edit the MPAA rating");
                        String updateMPAA = scan.nextLine();
                        updateFetchedDVD.setMPAA_rating(updateMPAA);

                        System.out.println(updateFetchedDVD);
                        System.out.println("Please edit the User rating");
                        int updateUser = scan.nextInt();
                        updateFetchedDVD.setUser_rating(updateUser);

                        dvdService.updateDVD(updateFetchedDVD);
                        System.out.println("DVD information edited successfully!");
                    }
                case 4:
                    List<DVD> allDVDs = dvdService.fetchAllDVDs();
                    for (DVD eachDVD : allDVDs) {
                        System.out.println(eachDVD.toString());
                    }
                    break;
                case 5:
                    System.out.println("Enter the DVD ID to fetch the dvd...");
                    int dvdId = scan.nextInt();
                    DVD fetchedDVD = dvdService.fetchById(dvdId);
                    if (fetchedDVD == null) {
                        System.out.println("Sorry! DVD with this ID doesn't exist");
                        break;
                    }else {
                        System.out.println(fetchedDVD);
                    }
                case 6:
                    System.out.println("Enter the DVD Title to find the DVD...");
                    scan.nextLine();
                    String inputDVDTitle = scan.nextLine();
                    List<DVD> allDVDTitle = dvdService.fetchByTitle(inputDVDTitle);
                    if (allDVDTitle.isEmpty()) {
                        System.out.println("Sorry! DVD with this Title doesn't exist");
                        break;
                    }else {
                        for (DVD eachDVD : allDVDTitle){
                            System.out.println(eachDVD);
                        }
                    }
                case 7:
                    System.out.println("Written to a file...");
                    dvdService.writeToFile();
                    break;
                case 8:
                    System.out.println("*****************************");
                    System.out.println("Thank you for using the system");
                    System.out.println("*****************************");
                    System.exit(0);
            }
            System.out.println("Do you want to continue? (y/n)");
            con = scan.next().charAt(0);
        } while (con == 'y');


    }
}