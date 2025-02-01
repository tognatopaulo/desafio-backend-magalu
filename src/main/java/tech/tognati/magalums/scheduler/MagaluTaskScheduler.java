package tech.tognati.magalums.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
public class MagaluTaskScheduler {

    Logger logger = LoggerFactory.getLogger(MagaluTaskScheduler.class);

    @Scheduled(fixedDelay = 3, timeUnit = TimeUnit.SECONDS)
    public void runTask() {
        var dateTime = LocalDateTime.now();
        logger.info("Running task at {}", dateTime);
    }
}
