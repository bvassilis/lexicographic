package gr.vb.idocs.file;

import static org.junit.Assert.assertEquals;
import gr.vb.idocs.RepositoryTest;
import gr.vb.idocs.core.Word;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class FileWordsReaderTest extends RepositoryTest{

    private FileWordsReader fileWordsReader;
    
    @Before
    public void beforeFileRead(){
        File file = new File(this.getClass().getResource("file0.txt").getFile());
        fileWordsReader = new FileWordsReader(file, wordRepository);
    }
    
    @Test
    public void testSave() throws IOException{
        assertEquals(0, wordRepository.count());
        fileWordsReader.save();
        assertEquals(3, wordRepository.count());
    }
    
    @Test
    public void testUpdate() throws IOException{
        assertEquals(0, wordRepository.count());
        fileWordsReader.update();
        assertEquals(0, wordRepository.count());
        
        fileWordsReader.save();
        fileWordsReader.update();
        assertEquals(3, wordRepository.count());
        
        for(Word word : wordRepository.listAll()) {
            assertEquals(Integer.valueOf(2), word.getFileCounter());
        }
    }

}
