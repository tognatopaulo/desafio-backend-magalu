package tech.tognati.magalums.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.tognati.magalums.entity.Channel;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
}
