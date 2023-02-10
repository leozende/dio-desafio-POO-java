package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Set;

public class Dev {
    private String name;
    private Set<Contents> subscribedContent = new LinkedHashSet<>();
    private Set<Contents> concludedContents = new LinkedHashSet<>();

    public void subscribeBootcamp (Bootcamp bootcamp){}

    public void progress() {}

    public void calculateTotalXp() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Contents> getSubscribedContent() {
        return subscribedContent;
    }

    public void setSubscribedContent(Set<Contents> subscribedContent) {
        this.subscribedContent = subscribedContent;
    }

    public Set<Contents> getConcludedContents() {
        return concludedContents;
    }

    public void setConcludedContents(Set<Contents> concludedContents) {
        this.concludedContents = concludedContents;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((subscribedContent == null) ? 0 : subscribedContent.hashCode());
        result = prime * result + ((concludedContents == null) ? 0 : concludedContents.hashCode());
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
        Dev other = (Dev) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (subscribedContent == null) {
            if (other.subscribedContent != null)
                return false;
        } else if (!subscribedContent.equals(other.subscribedContent))
            return false;
        if (concludedContents == null) {
            if (other.concludedContents != null)
                return false;
        } else if (!concludedContents.equals(other.concludedContents))
            return false;
        return true;
    }

    
}
