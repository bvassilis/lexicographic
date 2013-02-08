package gr.vb.idocs.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.NoResultException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

public class ListWordRepository implements WordRepository {

    private static final Log log = LogFactory.getLog(ListWordRepository.class);

    private List<Word> words = Lists.newArrayList();
    
    @Override
    public void save(String name) {
        Word word = new Word(name);
        if(words.contains(word)){
           return; 
        }
        words.add(new Word(name));
    }
    
    @Override
    public void update(String name) {
        Word word = new Word(name);
        if (!words.contains(word)) {
            log.info("Could not be updated " + name);
            return;
        }
        word = findByName(name);
        word.setFileCounter(word.getFileCounter() + 1);
    }
    
    @Override
    public void delete(String name) {
        Word word = new Word(name);
        words.remove(word);
    }

    @Override
    public List<Word> listAll() {
        return words;
    }

    @Override
    public Word findByName(String name) {
        Word wordName = new Word(name);
        if(words.contains(wordName)){
            int index = words.indexOf(wordName);
            return words.get(index);
        }
        throw new NoResultException("Not Found " + name);
    }
    
    @Override
    public int count() {
        return words.size();
    }

    @Override
    public List<Word> getWordsInFilesOrderByName() {
        Collection<Word> wordInFiles = Collections2.filter(words, WordPredicates.WORD_IN_FILES);
        List<Word> wordInFilesList = new ArrayList(wordInFiles);
        Collections.sort(wordInFilesList);
        return wordInFilesList;
    }
    
    enum WordPredicates implements Predicate<Word> {
        WORD_IN_FILES {
            @Override
            public boolean apply(Word word) {
                return word.getFileCounter() > 1;
            }
        }
    }

}
