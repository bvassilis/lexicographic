package gr.vb.idocs.file;

import gr.vb.idocs.core.WordRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileWordsReader {
    
    private File file;
    private WordRepository repository;

    public FileWordsReader(File file, WordRepository repository) {
        this.file = file;
        this.repository = repository;
    }

    public void save() throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            repository.save(line);
        }
        fileReader.close();
    }

    public void update() throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            repository.update(line);
        }
        fileReader.close();
    }

}
