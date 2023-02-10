package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Mentorship extends Contents {

    private LocalDate data;
    
    @Override
    public double calculateXp() {
        return STANDARD_XP + 20d;
    } 

    public Mentorship() {

    }

    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Mentorship [ title = " + getTitle() + ", description = " + getDescription() + ", data = " + data + " ]";
    }
    
}
