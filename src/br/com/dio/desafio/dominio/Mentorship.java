package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Mentorship {
    private String title;
    private String description;
    private LocalDate data;

    public Mentorship() {

    }
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Mentorship [ title = " + title + ", description = " + description + ", data = " + data + " ]";
    } 
    
}
