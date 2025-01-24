package jpa.test.domain.db;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DynamicTableNaming implements PhysicalNamingStrategy {

   /* private boolean logSet = false;

    public void setLogSet(boolean s) {
        this.logSet = s;
        System.out.println(logSet);
    }*/

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        String tableName = name.getText();

        boolean logSet = Boolean.parseBoolean(System.getProperty("server.month"));
        System.out.println("123123123 : " + logSet);

        if (logSet) {
            if ("log".equals(tableName)) {
                String yearMonth = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMM"));
                tableName = "log_" + yearMonth;
            }

            return Identifier.toIdentifier(tableName);
        }

        return Identifier.toIdentifier(tableName);
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
        // 컬럼 이름 변환 로직 (필요 시 구현, 여기서는 기본 이름 반환)
        return name;
    }

    @Override
    public Identifier toPhysicalSchemaName(Identifier name, JdbcEnvironment context) {
        return name; // 스키마 이름 기본 반환
    }

    @Override
    public Identifier toPhysicalSequenceName(Identifier name, JdbcEnvironment context) {
        return name; // 시퀀스 이름 기본 반환
    }

    @Override
    public Identifier toPhysicalCatalogName(Identifier name, JdbcEnvironment context) {
        return name; // 카탈로그 이름 기본 반환
    }
}
