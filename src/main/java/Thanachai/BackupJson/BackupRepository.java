package Thanachai.BackupJson;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BackupRepository extends JpaRepository<Backup, Long> {
    Optional<Backup> findBackupByCustomerID (String customerId);
}
