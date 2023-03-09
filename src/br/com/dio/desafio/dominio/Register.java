package br.com.dio.desafio.dominio;

public class Register {
    private String name;
    private Bootcamp bootcamp;
    
    public Register(String name, Bootcamp bootcamp) {
        this.name = name;
        this.bootcamp = bootcamp;
    }

    public String getName() {
        return name;
    }

    public Bootcamp getBootcamp() {
        return bootcamp;
    }
    
}
