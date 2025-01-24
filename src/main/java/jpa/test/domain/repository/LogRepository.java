package jpa.test.domain.repository;

import jpa.test.domain.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Test, Long> {

}
