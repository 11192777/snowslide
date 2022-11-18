package pers.qingyu.sachima.sql.dialect.mysql.ast.statement;

import pers.qingyu.sachima.sql.ast.statement.SQLAlterTableItem;
import pers.qingyu.sachima.sql.dialect.mysql.ast.MySqlObjectImpl;
import pers.qingyu.sachima.sql.dialect.mysql.visitor.MySqlASTVisitor;

/**
 * version 1.0
 * Author zzy
 * Date 2019-06-03 16:22
 */
public class MySqlAlterTableValidation extends MySqlObjectImpl implements SQLAlterTableItem {

    private boolean withValidation;

    @Override
    public void accept0(MySqlASTVisitor visitor) {
        visitor.visit(this);
        visitor.endVisit(this);
    }

    public boolean isWithValidation() {
        return withValidation;
    }

    public void setWithValidation(boolean withValidation) {
        this.withValidation = withValidation;
    }
}
