package gr.vb.idocs;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import gr.vb.idocs.core.WordRepository;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class ApplicationConfigTest {

	@Test
	public void bootstrapAppFromJavaConfig() {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		assertThat(context, is(notNullValue()));
		assertThat(context.getBean(WordRepository.class), is(notNullValue()));
	}

}
