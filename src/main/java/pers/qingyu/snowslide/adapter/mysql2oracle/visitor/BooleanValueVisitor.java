package pers.qingyu.snowslide.adapter.mysql2oracle.visitor;

import pers.qingyu.snowslide.sql.ast.SQLExpr;
import pers.qingyu.snowslide.sql.ast.expr.SQLBinaryOpExpr;
import pers.qingyu.snowslide.sql.ast.expr.SQLBooleanExpr;
import pers.qingyu.snowslide.sql.ast.expr.SQLNumberExpr;
import pers.qingyu.snowslide.sql.visitor.SQLASTVisitor;

import java.util.Objects;

/**
 * <H1></H1>
 *
 * @author Qingyu.Meng
 * @version 1.0
 * @date 2022/11/16 19:56
 */
public class BooleanValueVisitor implements SQLASTVisitor {

    private static final Number TRUE = 1;
    private static final Number FALSE = 0;

    @Override
    public void endVisit(SQLBinaryOpExpr x) {
        if (Objects.isNull(x.getRight()) || !(x.getRight() instanceof SQLBooleanExpr)) {
            return;
        }
        x.setRight(new SQLNumberExpr(this.getBooleanNumber(x.getRight())));
    }

    private Number getBooleanNumber(SQLExpr right) {
        return String.valueOf(right).equalsIgnoreCase(Boolean.TRUE.toString()) ? TRUE : FALSE;
    }
}
