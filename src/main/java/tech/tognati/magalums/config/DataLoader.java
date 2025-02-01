package tech.tognati.magalums.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import tech.tognati.magalums.entity.Channel;
import tech.tognati.magalums.entity.Status;
import tech.tognati.magalums.repository.ChannelRepository;
import tech.tognati.magalums.repository.StatusRepository;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final StatusRepository statusRepository;
    private final ChannelRepository channelRepository;

    public DataLoader(StatusRepository statusRepository,
                      ChannelRepository channelRepository) {
        this.statusRepository = statusRepository;
        this.channelRepository = channelRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Arrays.stream(Channel.Values.values())
                .map(Channel.Values::toChannel)
                .forEach(channelRepository::save);

        Arrays.stream(Status.Values.values())
                .map(Status.Values::toStatus)
                .forEach(statusRepository::save);

    }
}
