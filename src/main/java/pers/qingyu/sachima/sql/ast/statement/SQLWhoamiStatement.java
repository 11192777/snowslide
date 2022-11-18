package pers.qingyu.sachima.sql.ast.statement;

import pers.qingyu.sachima.sql.ast.SQLStatement;
import pers.qingyu.sachima.sql.ast.SQLStatementImpl;
import pers.qingyu.sachima.sql.visitor.SQLASTVisitor;

public class SQLWhoamiStatement extends SQLStatementImpl {
    @Override
    protected void accept0(SQLASTVisitor v) {
        if (v.visit(this)) {

        }
        v.endVisit(this);
    }
}
