package br.com.dio.desafio.dominio;


public class Organizer extends User{
    
    private String bootcampName;

    @Override
    public double bootcampList() {
        return 0;
    }
    
    public void createBootcamp (Bootcamp bootcamp){

    }

    public void modifyBootcamp (Bootcamp bootcamp){
        
    }

    public String getBootcampName() {
        return bootcampName;
    }

    public void setBootcampName(String bootcampName) {
        this.bootcampName = bootcampName;
    }

}
