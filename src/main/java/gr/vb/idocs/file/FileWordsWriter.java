package gr.vb.idocs.file;

import gr.vb.idocs.core.Word;
import gr.vb.idocs.core.WordRepository;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWordsWriter {

    private File file;
    private WordRepository repository;

    public FileWordsWriter(File file, WordRepository repository) {
        this.file = file;
        this.repository = repository;
    }

    public void lexicography() throws IOException {
        createFile();
        FileWriter fileWriter = new FileWriter(file, false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (Word word : repository.getWordsInFilesOrderByName()) {
            bufferedWriter.append(word.getName());
            bufferedWriter.append("\n");
        }
        bufferedWriter.close();
    }

    private void createFile() throws IOException {
        if (!file.exists()) {
            String parentPath = file.getParent();
            if (parentPath != null) {
                new File(file.getParent()).mkdirs();
            }
            file.createNewFile();
        }
    }

}
