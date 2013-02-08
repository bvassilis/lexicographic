package gr.vb.idocs;

import gr.vb.idocs.core.WordRepository;
import gr.vb.idocs.file.FileWordsReader;
import gr.vb.idocs.file.FileWordsWriter;

import java.io.File;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainClass {

    private static final Log log = LogFactory.getLog(MainClass.class);

    public static void main(String[] args) throws IOException {

        if (args.length < 3) {
            System.out.println("You must call the program as follow:");
            System.out.println("java MainClass arg0 arg1 arg2");
            System.exit(-1);
        }
        
        File file0 = new File(args[0]);
        File file1 = new File(args[1]);
        File file2 = new File(args[2]);
        
        boolean inputFilesExists = file0.exists() && file1.exists();
        if (!inputFilesExists) {
            System.out.println("Files do not exist");
            System.exit(-1);
        }

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        log.info("Lexicographically Application Running");
        WordRepository repository = context.getBean(WordRepository.class);
        context.registerShutdownHook();

        FileWordsReader fileWordsReader = new FileWordsReader(file0, repository);
        fileWordsReader.save();
        
        fileWordsReader = new FileWordsReader(file1, repository);
        fileWordsReader.update();
        
        FileWordsWriter fileWordsWriter = new FileWordsWriter(file2, repository); 
        fileWordsWriter.lexicography();
    }

}
