package br.com.dio.desafio.dominio;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Dev{
    private Map<Integer, Register> info = new TreeMap<>();
    private Map<Integer, Set<Contents>> subscribedContent = new LinkedHashMap<>();
    private Map<Integer, Set<Contents>> concludedContents = new LinkedHashMap<>();
    
    public Dev() {

    }

    public void registerNewDev(String name, Bootcamp bootcamp){
        int count = 0;
        for (Entry<Integer, Register> entry : info.entrySet()) {
            count++;
            if(entry.getValue().equals(null)) {
                this.info.put(count, new Register(name, bootcamp));
                this.subscribedContent.put(count, bootcamp.getContents());
            }
        }
    }

    public void progress(Integer code) {
        
        Optional<Contents> content = subscribedContent.get(code).stream().findFirst();

        if(content.isPresent()){
            this.concludedContents.get(code).add(content.get());
            this.subscribedContent.get(code).remove(content.get());
        } else {
            System.err.println("You are not subscribed to any content!");
        }
    }

    public double calculateTotalXp(Integer code) {
        return this.concludedContents.get(code)
        .stream()
            .mapToDouble(Contents::calculateXp)
            .sum();
        }
        
    public Map<Integer, Register> getInfo() {
        return info;
    }

    public void setInfo(Map<Integer, Register> info) {
        this.info = info;
    }
    
    public Map<Integer, Set<Contents>> getSubscribedContent() {
        return subscribedContent;
    }

    public void setSubscribedContent(Map<Integer, Set<Contents>> subscribedContent) {
        this.subscribedContent = subscribedContent;
    }

    public Map<Integer, Set<Contents>> getConcludedContents() {
        return concludedContents;
    }

    public void setConcludedContents(Map<Integer, Set<Contents>> concludedContents) {
        this.concludedContents = concludedContents;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((info == null) ? 0 : info.hashCode());
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
        if (info == null) {
            if (other.info != null)
                return false;
        } else if (!info.equals(other.info))
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
