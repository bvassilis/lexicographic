package gr.vb.idocs;

import gr.vb.idocs.core.ListWordRepository;
import gr.vb.idocs.core.WordRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    
    @Bean
    public WordRepository wordRepository (){
        return new ListWordRepository();
    }

}
