package com.example.demo.repositories;

import com.example.demo.model.Backup;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashSet;

@Slf4j
@Service
@RequiredArgsConstructor
public class DemoService {

    private final IBackupRepository repository;

    @PostConstruct
    public void doSomething() {
        final Backup one = Backup.builder()
                .id(1L)
                .name("one")
                .build();
        final Backup two = Backup.builder()
                .id(2L)
                .name("two")
                .build();
        final HashSet<Backup> backups = new HashSet<>();
        backups.add(one);
        backups.add(two);
        repository.saveAll(backups);

        final Backup oneFromDb = repository.getByName("one")
                .orElseThrow(() -> new RuntimeException("Could not find one!!!"));

        log.info("Got a new backup by name {}: {}", oneFromDb.getId(), oneFromDb.getName());
    }

}
