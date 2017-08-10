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

    @SerializedName("cintas")
    List<Cinta> cintas;

    @SerializedName("skills")
    List<String> skills;

    @SerializedName("bio")
    String bio;

    @SerializedName("telefono")
    String telefono;

    @SerializedName("intereses")
    List<String> intereses;

    @SerializedName("hoobies")
    List<String> hoobbies;

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

    @SerializedName("languajes")
    List<String> languages;

    public Cv(String name, String email, String photo, List<Cinta> cintas, List<String> skills, String bio, String telefono, List<String> intereses, List<String> hoobbies, String website, String facebook, String twitter, String linkedin, String github, List<String> languages) {
        this.name = name;
        this.email = email;
        this.photo = photo;
        this.cintas = cintas;
        this.skills = skills;
        this.bio = bio;
        this.telefono = telefono;
        this.intereses = intereses;
        this.hoobbies = hoobbies;
        this.website = website;
        this.facebook = facebook;
        this.twitter = twitter;
        this.linkedin = linkedin;
        this.github = github;
        this.languages = languages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public List<Cinta> getCintas() {
        return cintas;
    }

    public void setCintas(List<Cinta> cintas) {
        this.cintas = cintas;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<String> getIntereses() {
        return intereses;
    }

    public void setIntereses(List<String> intereses) {
        this.intereses = intereses;
    }

    public List<String> getHoobbies() {
        return hoobbies;
    }

    public void setHoobbies(List<String> hoobbies) {
        this.hoobbies = hoobbies;
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
}
