package dojo.f.dev.com.appdojo.Data.Api.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Dagorik on 08/08/2017.
 */

public class Cv {

    @SerializedName("name")
    String name;

    @SerializedName("email")
    String email;

    @SerializedName("photo")
    String photo;

    @SerializedName("belts")
    List<Cinta> belts;

    @SerializedName("skills")
    List<String> skills;

    @SerializedName("biography")
    String biography;

    @SerializedName("phone")
    String phone;

    @SerializedName("interests")
    List<String> interests;

    @SerializedName("hobbies")
    List<String> hobbies;

    @SerializedName("website")
    String website;

    @SerializedName("facebook")
    String facebook;

    @SerializedName("twitter")
    String twitter;

    @SerializedName("linkedin")
    String linkedin;

    @SerializedName("github")
    String github;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<Cinta> getBelts() {
        return belts;
    }

    public void setBelts(List<Cinta> belts) {
        this.belts = belts;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    @SerializedName("languajes")
    List<String> languages;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
