package jpa.test.domain.service;

import jpa.test.domain.entity.Test;
import jpa.test.domain.repository.LogRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class LogTestService {

    private final LogRepository logRepository;

    @Scheduled(fixedDelay = 10000)
    public void goTest() {
        Test test = new Test();
        test = Test.builder()
                .testKey(LocalDateTime.now().toString())
                .build();

        System.out.println(LocalDateTime.now());
        logRepository.save(test);
    }
}
