package br.com.dio.desafio.dominio;

import java.util.Map;
import java.util.TreeMap;

public abstract class  {

    private Map<Integer, Bootcamp> bootcampList = new TreeMap<>();

    public abstract double bootcampList();

    public Map<Integer, Bootcamp> getBootcampList() {
        return bootcampList;
    }
    public void setBootcampList(Map<Integer, Bootcamp> bootcampList) {
        this.bootcampList = bootcampList;
    }

}
