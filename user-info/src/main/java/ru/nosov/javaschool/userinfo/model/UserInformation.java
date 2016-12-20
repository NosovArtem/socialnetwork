package ru.nosov.javaschool.userinfo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "user_informations")
public class UserInformation {

   /* @Column(name = "birthday")
    Date birthday;
    @Column(name = "man")
    Boolean man;*/

    @Id
    private Long id;

    @NotNull
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "city")
    private String city;
    @Column(name = "mobile_phone")
    private String mobilePhone;
    @Column(name = "native_language")
    private String nativeLanguage;
    @Column(name = "religion")
    private String religion;
    @Column(name = "interests")
    private String interests;
    @Column(name = "favorite_music")
    private String favoriteMusic;
    @Column(name = "favorite_book")
    private String favoriteBook;
    @Column(name = "favorite_film")
    private String favoriteFilm;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getNativeLanguage() {
        return nativeLanguage;
    }

    public void setNativeLanguage(String nativeLanguage) {
        this.nativeLanguage = nativeLanguage;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getFavoriteMusic() {
        return favoriteMusic;
    }

    public void setFavoriteMusic(String favoriteMusic) {
        this.favoriteMusic = favoriteMusic;
    }

    public String getFavoriteBook() {
        return favoriteBook;
    }

    public void setFavoriteBook(String favoriteBook) {
        this.favoriteBook = favoriteBook;
    }

    public String getFavoriteFilm() {
        return favoriteFilm;
    }

    public void setFavoriteFilm(String favoriteFilm) {
        this.favoriteFilm = favoriteFilm;
    }

    public UserInformation() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserInformation)) return false;

        UserInformation that = (UserInformation) o;

        return getUserId() != null ? getUserId().equals(that.getUserId()) : that.getUserId() == null;

    }

    @Override
    public int hashCode() {
        return getUserId() != null ? getUserId().hashCode() : 0;
    }


    @Override
    public String toString() {
        return "UserInformation{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", nativeLanguage='" + nativeLanguage + '\'' +
                ", religion='" + religion + '\'' +
                ", interests='" + interests + '\'' +
                ", favoriteMusic='" + favoriteMusic + '\'' +
                ", favoriteBook='" + favoriteBook + '\'' +
                ", favoriteFilm='" + favoriteFilm + '\'' +
                '}';
    }
}
