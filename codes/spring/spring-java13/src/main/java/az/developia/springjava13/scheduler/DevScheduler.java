package az.developia.springjava13.scheduler;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@Profile(value = {"development"})
public class DevScheduler {

	//@Scheduled(fixedRate = 1000)
			public void doIt() {
				System.out.println("Ixtar");
			}
}
