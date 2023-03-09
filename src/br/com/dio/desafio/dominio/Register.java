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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((bootcamp == null) ? 0 : bootcamp.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Register other = (Register) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (bootcamp == null) {
            if (other.bootcamp != null)
                return false;
        } else if (!bootcamp.equals(other.bootcamp))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Register [ name= " + name + ", bootcamp= " + bootcamp + "]";
    }

    
}
