package jpa.test.domain.db;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class DynamicCode {

    @Value("${server.check}")
    private Boolean is_dynamic;
    @Value("${server.db.tbl_name}")
    private String tableName;
    @Value("${server.db.col_name}")
    private List<String> colList;
    @Value("${server.db.type}")
    private List<String> typeList;
    @PersistenceContext
    private EntityManager entityManager;

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void addColumn() {
        if (is_dynamic) {
            System.out.println("tbl : " + tableName);
            System.out.println("col : " + colList);
            System.out.println("type : " + typeList);
            int colCount = colList.size();
            int typeCount = typeList.size();
            if (colCount != typeCount) throw new IllegalArgumentException();
            else {
                StringBuilder sqlBuilder = new StringBuilder("ALTER TABLE " + tableName + " ");
                for (int i = 0; i < colCount; i++) {
                    sqlBuilder.append("ADD COLUMN ").append(colList.get(i)).append(" ").append(typeList.get(i));
                    if (i < colCount - 1) {
                        sqlBuilder.append(", ");
                    }
                }
                String sql = sqlBuilder.toString();
                System.out.println(sql);
                entityManager.createNativeQuery(sql).executeUpdate();
            }
        }
    }

}
