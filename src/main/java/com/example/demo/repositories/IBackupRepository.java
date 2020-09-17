package com.example.demo.repositories;

import com.example.demo.model.Backup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface IBackupRepository extends JpaRepository<Backup, Long> {

    Optional<Backup> getByName(String name);

}
