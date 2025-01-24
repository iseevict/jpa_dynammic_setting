/*
package jpa.test.domain.db;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class DynamicTableNamingConfig implements BeanPostProcessor {

    @Value("${server.log}")
    private boolean logSet;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // DynamicTableNaming Bean에만 동작
        if (bean instanceof DynamicTableNaming) {
            DynamicTableNaming namingStrategy = (DynamicTableNaming) bean;
            namingStrategy.setLogSet(logSet); // 설정값 주입
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // After Initialization 로직이 필요하지 않다면 그대로 반환
        return bean;
    }
}
*/
