/*
package jpa.test.domain.db;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
public class ApplicationInitializer {

    private final DynamicCode dynamicCode;

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void init() {
        dynamicCode.addColumn();
    }
}
*/
