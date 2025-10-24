package co.th.mcrop.mucore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("co.th.mcrop")
@EntityScan("co.th.mcrop")
public class MuCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MuCoreApplication.class, args);
	}

}
