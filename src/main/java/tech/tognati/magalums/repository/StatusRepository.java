package tech.tognati.magalums.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.tognati.magalums.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
