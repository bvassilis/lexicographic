package gr.vb.idocs;

import java.util.Iterator;
import java.util.List;

import gr.vb.idocs.core.Word;
import gr.vb.idocs.core.WordRepository;

import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public abstract class RepositoryTest {
    
    @Autowired
    protected WordRepository wordRepository;
    
    @After
    public void emptyDatabase() {
        List<Word> words = wordRepository.listAll();
        Iterator<Word> wordIterator = words.iterator();
        while (wordIterator.hasNext()) {
            Word word = wordIterator.next();
            wordIterator.remove();
        }
    }

}
