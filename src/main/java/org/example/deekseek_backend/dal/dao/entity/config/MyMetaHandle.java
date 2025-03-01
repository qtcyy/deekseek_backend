package org.example.deekseek_backend.dal.dao.entity.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.example.deekseek_backend.common.BaseContext;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author chengyiyang
 */
@Slf4j
@Component
public class MyMetaHandle implements MetaObjectHandler {
    public static String getUserId() {
        String userId = BaseContext.getCurrentId();
        if (userId != null) {
            log.info("修改人员:{}", userId);
        } else {
            log.info("未登录");
        }
        return userId;
    }

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("开始插入信息...");
        String userId = getUserId();
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
        if (userId != null) {
            this.strictInsertFill(metaObject, "updateBy", String.class, userId);
            this.strictInsertFill(metaObject, "createBy", String.class, userId);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("开始更新信息...");
        String userId = getUserId();
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime::now, LocalDateTime.class);
        if (userId != null) {
            this.strictInsertFill(metaObject, "updateBy", String.class, userId);
        }
    }
}
