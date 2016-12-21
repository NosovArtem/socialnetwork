package com.sbertech.javaschool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_informations")
public class UserInformationData {

    @Id
    @Column(name = "user_id")
    private Long userid;
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
        return userid;
    }

    public void setUserId(Long userid) {
        this.userid = userid;
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

    public UserInformationData() {
    }
}
