
package com.huawei.mybatisInterceptor;

import java.util.Locale;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.keygen.SelectKeyGenerator;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.huawei.dao.DynamicDataSourceHolder;

@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
    @Signature(type = Executor.class, method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class TestInterceptor implements Interceptor {

    private final static Logger logger = LoggerFactory.getLogger(TestInterceptor.class);

    private static final String REGEX = ".*insert\\u0020.*|.*delete\\u0020.*|.*update\\u0020.*";

    @Override
    public Object intercept(Invocation invocation)
        throws Throwable {
        logger.info("come in intercept");
        // 它首先查看当前是否存在事务管理上下文，并尝试从事务管理上下文获取连接，如果获取失败，直接从数据源中获取连接。
        // 在获取连接后，如果当前拥有事务上下文，则将连接绑定到事务上下文中。（此处直接继续下一过程）
        boolean synchronizationActive = TransactionSynchronizationManager.isSynchronizationActive();
        if (!synchronizationActive) {
            Object[] objects = invocation.getArgs();
            MappedStatement ms = (MappedStatement)objects[0];
            if (SqlCommandType.SELECT.equals(ms.getSqlCommandType())) {
                if (SelectKeyGenerator.SELECT_KEY_SUFFIX.equals(ms.getId())) {
                    DynamicDataSourceHolder.setDataSourceStr("master");
                } else {
                    BoundSql boundSql = ms.getSqlSource().getBoundSql(objects[1]);
                    String sql = boundSql.getSql().toLowerCase(Locale.CHINA).replaceAll("[\\t\\n\\r]", " ");
                    if (sql.matches(REGEX)) {
                        DynamicDataSourceHolder.setDataSourceStr("master");
                    } else {
                        DynamicDataSourceHolder.setDataSourceStr("slave");
                    }
                }
            }else {
                DynamicDataSourceHolder.setDataSourceStr("master");
            }
        } else {
        }
        logger.info("exit intercept DataSource:[{}]", DynamicDataSourceHolder.getDataSourceStr());
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof Executor) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {
        
        logger.info("inceptrro is name:"+properties.getProperty("name"));
    }

}
