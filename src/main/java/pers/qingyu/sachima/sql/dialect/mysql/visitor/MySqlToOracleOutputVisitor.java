package pers.qingyu.sachima.sql.dialect.mysql.visitor;

import pers.qingyu.sachima.sql.ast.SQLExprImpl;
import pers.qingyu.sachima.sql.ast.expr.*;
import pers.qingyu.sachima.sql.dialect.mysql.visitor.impl.VisitorHandler;
import pers.qingyu.sachima.sql.dialect.oracle.visitor.OracleOutputVisitor;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * <H1></H1>
 *
 * @author Qingyu.Meng
 * @version 1.0
 * @date 2022/11/18 15:18
 */
public class MySqlToOracleOutputVisitor extends OracleOutputVisitor {

    private final Map<Class<?>, Consumer<?>> funMap;


    public MySqlToOracleOutputVisitor(Appendable appender, List<VisitorHandler.Handler<? extends SQLExprImpl>> handlers) {
        super(appender);
        funMap = handlers.stream().filter(Objects::nonNull).collect(Collectors.toMap(VisitorHandler.Handler::getKey, VisitorHandler.Handler::getValue, (e1, e2) -> e2));
    }

    public MySqlToOracleOutputVisitor(Appendable appender, boolean printPostSemi, List<VisitorHandler.Handler<? extends SQLExprImpl>> handlers) {
        super(appender, printPostSemi);
        funMap = handlers.stream().filter(Objects::nonNull).collect(Collectors.toMap(VisitorHandler.Handler::getKey, VisitorHandler.Handler::getValue, (e1, e2) -> e2));
    }

    public void funRun(SQLExprImpl s) {
        if (Objects.isNull(s)) {
            return;
        }

        Consumer consumer = funMap.get(s.getClass());
        if (Objects.nonNull(consumer)) {
            consumer.accept(s);
        }
    }

    @Override
    public boolean visit(SQLMethodInvokeExpr x) {
        funRun(x);
        return super.visit(x);
    }

    @Override
    public boolean visit(SQLInListExpr x) {
        funRun(x);
        return super.visit(x);
    }

    @Override
    public boolean visit(SQLBinaryOpExpr x) {
        funRun(x);
        return super.visit(x);
    }
}
