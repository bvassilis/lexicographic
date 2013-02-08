package gr.vb.idocs.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import gr.vb.idocs.RepositoryTest;

import java.util.List;

import javax.persistence.NoResultException;

import org.junit.Before;
import org.junit.Test;

public class WordRepositoryTest extends RepositoryTest {


    @Before
    public void populateDatabase() {
        wordRepository.save("a");
        wordRepository.save("b");
        wordRepository.save("c");
    }

    @Test
    public void testCount() {
        long size = wordRepository.count();
        assertTrue(size >= 3);
    }

    @Test(expected = NoResultException.class)
    public void testFindByNameExceptional() {
        wordRepository.findByName("name");
    }

    @Test
    public void testFindByName() {
        String expected = "a";
        Word word = wordRepository.findByName(expected);
        assertEquals(expected, word.getName());
    }

    @Test
    public void testSaveNewWord() {
        long sizeExpected = wordRepository.count() + 1;
        wordRepository.save("name");
        assertEquals(sizeExpected, wordRepository.count());

        // no new insert
        wordRepository.save("name");
        assertEquals(sizeExpected, wordRepository.count());
    }

    @Test
    public void testUpdateOldWord() {
        String name = "a";
        int wordCounterExpected = wordRepository.findByName(name).getFileCounter() + 1;
        wordRepository.update(name);
        int actual = wordRepository.findByName(name).getFileCounter();
        assertEquals(wordCounterExpected, actual);
    }

    @Test
    public void testGetWordsOrderByName() {
        int sizeExpected = 2;
        wordRepository.update("c");
        wordRepository.update("a");
        wordRepository.update("c");
        List<Word> words = wordRepository.getWordsInFilesOrderByName();
        assertEquals(sizeExpected, words.size());
        assertTrue(words.get(0).getName().compareTo(words.get(1).getName()) < 0);
    }

}
