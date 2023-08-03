package Model;

import java.time.LocalDate;

public class DVD {

    private int DVDId;
    private String Title;
    private LocalDate Release_date;
    private String MPAA_rating;
    private String Director_name;
    private String Studio;
    private int User_rating;


    public DVD(int DVDId, String title, LocalDate release_date, String MPAA_rating, String director_name, String studio, int user_rating) {
        this.DVDId = DVDId;
        this.Title = title;
        this.Release_date = release_date;
        this.MPAA_rating = MPAA_rating;
        this.Director_name = director_name;
        this.Studio = studio;
        this.User_rating = user_rating;
    }

    public int getDVDId() {
        return DVDId;
    }

    public String getTitle() {
        return Title;
    }

    public LocalDate getRelease_date() {
        return Release_date;
    }

    public String getMPAA_rating() {
        return MPAA_rating;
    }

    public String getDirector_name() {
        return Director_name;
    }

    public String getStudio() {
        return Studio;
    }

    public int getUser_rating() {
        return User_rating;
    }

    public void setDVDId(int DVDId) {
        this.DVDId = DVDId;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setRelease_date(LocalDate release_date) {
        Release_date = release_date;
    }

    public void setMPAA_rating(String MPAA_rating) {
        this.MPAA_rating = MPAA_rating;
    }

    public void setDirector_name(String director_name) {
        Director_name = director_name;
    }

    public void setStudio(String studio) {
        Studio = studio;
    }

    public void setUser_rating(int user_rating) {
        User_rating = user_rating;
    }
    public DVD copyDVDData () {
        DVD returningDVD = new DVD(this.DVDId,this.Title,this.Release_date,
                this.MPAA_rating,this.Director_name,this.Studio,this.User_rating);
        return returningDVD;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DVD ID: ").append(DVDId).append("\n");
        sb.append("Title: ").append(Title).append("\n");
        sb.append("Published Date: ").append(Release_date).append("\n");
        sb.append("MPAA Rating: ").append(MPAA_rating).append("\n");
        sb.append("Director: ").append(Director_name).append("\n");
        sb.append("Studio: ").append(Studio).append("\n");
        sb.append("User Rating: ").append(User_rating).append("\n");

        return sb.toString();
    }
}
