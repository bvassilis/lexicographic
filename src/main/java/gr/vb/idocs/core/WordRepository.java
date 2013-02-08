package gr.vb.idocs.core;

import java.util.List;

public interface WordRepository {

    public void save(String name);
    
    public void update(String name);

    public void delete(String name);
    
    public List<Word> listAll();
    
    public int count();
    
    public Word findByName(String name);

    public List<Word> getWordsInFilesOrderByName();

}
