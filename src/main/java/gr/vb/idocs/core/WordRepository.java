package gr.vb.idocs.core;

import java.util.List;

public interface WordRepository {

    void save(String name);
    
    void update(String name);

    void delete(String name);
    
    List<Word> listAll();
    
    int count();
    
    Word findByName(String name);

    List<Word> getWordsInFilesOrderByName();

}
