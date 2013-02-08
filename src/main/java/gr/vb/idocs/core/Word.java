package gr.vb.idocs.core;

import org.springframework.util.Assert;

public class Word implements Comparable<Word> {

    private String name;
    private Integer fileCounter;

    public Word(String name) {
        Assert.hasText(name);
        this.name = name;
        this.fileCounter = 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFileCounter() {
        return fileCounter;
    }

    public void setFileCounter(Integer fileCounter) {
        this.fileCounter = fileCounter;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        Word other = (Word) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public int compareTo(Word o) {
        return this.getName().compareTo(o.getName());
    }

}
