package pers.qingyu.snowslide.adapter.mysql2oracle.visitor;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.text.CharSequenceUtil;
import pers.qingyu.snowslide.sql.ast.SQLExpr;
import pers.qingyu.snowslide.sql.ast.expr.SQLCharExpr;
import pers.qingyu.snowslide.sql.ast.expr.SQLIdentifierExpr;
import pers.qingyu.snowslide.sql.ast.expr.SQLInListExpr;
import pers.qingyu.snowslide.sql.ast.expr.SQLObjectExpr;
import pers.qingyu.snowslide.sql.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.Objects;


/**
 * <H1>java.sql.SQLException: ORA-01795: 列表中的最大表达式数为 1000</H1>
 *
 * @author Qingyu.Meng
 * @version 1.0
 * @date 2022/11/15 18:21
 */
public class InLimit1000Visitor implements SQLASTVisitor {

    public static InLimit1000Visitor INSTANCE = null;

    public static InLimit1000Visitor getInstance() {
        return INSTANCE == null ? new InLimit1000Visitor() : INSTANCE;
    }

    private static final int IN_ITEM_LIMIT = 1000;
    private static final String ITEM_FORMAT = "(1, {})";

    @Override
    public void endVisit(SQLInListExpr x) {
        if (Objects.isNull(x.getTargetList()) || CollectionUtil.size(x.getTargetList()) <= IN_ITEM_LIMIT) {
            return;
        }
        ArrayList<SQLExpr> formatTargetList = new ArrayList<>(x.getTargetList().size());
        for (SQLExpr sqlExpr : x.getTargetList()) {
            String formatItem = CharSequenceUtil.format(ITEM_FORMAT, sqlExpr.toString());
            formatTargetList.add(new SQLCharExpr(formatItem));
        }
        x.setTargetList(formatTargetList);

        if (x.getExpr() instanceof SQLIdentifierExpr) {
            SQLIdentifierExpr sqlIdentifierExpr = (SQLIdentifierExpr) x.getExpr();
            sqlIdentifierExpr.setName(CharSequenceUtil.format(ITEM_FORMAT, sqlIdentifierExpr.getName()));
        }
    }
}
