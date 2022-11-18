package pers.qingyu.sachima.sql.dialect.ads.visitor;

import pers.qingyu.sachima.sql.dialect.mysql.ast.MySqlPrimaryKey;
import pers.qingyu.sachima.sql.dialect.mysql.ast.statement.MySqlCreateTableStatement;
import pers.qingyu.sachima.sql.visitor.SQLASTVisitor;

public interface AdsVisitor extends SQLASTVisitor {
    boolean visit(MySqlPrimaryKey x);
    void endVisit(MySqlPrimaryKey x);

    boolean visit(MySqlCreateTableStatement x);
    void endVisit(MySqlCreateTableStatement x);
}
