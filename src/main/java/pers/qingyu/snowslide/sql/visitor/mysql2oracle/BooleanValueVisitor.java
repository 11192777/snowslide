package pers.qingyu.snowslide.sql.visitor.mysql2oracle;

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
        x.setRight(new SQLNumberExpr(this.getBooleanNumber((SQLBooleanExpr) x.getRight())));
    }

    private Number getBooleanNumber(SQLBooleanExpr right) {
        //How do you think it's boolean field?
        //if params has boolean field map. need cache?
        return String.valueOf(right).equalsIgnoreCase(Boolean.TRUE.toString()) ? TRUE : FALSE;
    }
}
