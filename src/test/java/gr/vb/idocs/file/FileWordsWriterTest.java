package gr.vb.idocs.file;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import gr.vb.idocs.RepositoryTest;
import gr.vb.idocs.core.Word;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class FileWordsWriterTest extends RepositoryTest {

    private FileWordsWriter fileWordsWriter;
    private File fileWrite = new File(this.getClass().getResource("").getFile() + "file2.txt");

    @Before
    public void beforeFileRead() {
        fileWordsWriter = new FileWordsWriter(fileWrite, wordRepository);
    }

    @Test
    public void testEmptyLexicography() throws IOException {
        fileWordsWriter.lexicography();
        //check writed file
        FileWordsReader fileWordsReader = new FileWordsReader(fileWrite, wordRepository);
        fileWordsReader.save();
        assertEquals(0, wordRepository.count());
    }

    @Test
    public void testLexicography() throws IOException {
        File file = new File(this.getClass().getResource("file0.txt").getFile());
        FileWordsReader fileWordsReader = new FileWordsReader(file, wordRepository);
        fileWordsReader.save();
        fileWordsReader.update();
        fileWordsWriter.lexicography();
        assertEquals(3, wordRepository.count());
        
        emptyDatabase();
        
        //check writed file
        fileWordsReader = new FileWordsReader(fileWrite, wordRepository);
        fileWordsReader.save();
        assertEquals(3, wordRepository.count());
        List<Word> words = wordRepository.listAll();
        assertTrue(words.get(0).getName().compareTo(words.get(1).getName()) < 0);
        assertTrue(words.get(1).getName().compareTo(words.get(2).getName()) < 0);

    }

}
