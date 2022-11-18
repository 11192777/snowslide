package pers.qingyu.sachima.sql.ast.statement;

import pers.qingyu.sachima.sql.ast.SQLObjectImpl;
import pers.qingyu.sachima.sql.dialect.mysql.ast.MySqlObject;
import pers.qingyu.sachima.sql.dialect.mysql.ast.statement.MySqlExtPartition;
import pers.qingyu.sachima.sql.dialect.mysql.visitor.MySqlASTVisitor;
import pers.qingyu.sachima.sql.visitor.SQLASTVisitor;

/**
 * @author shicai.xsc 2018-9-13
 * @since 5.0.0.0
 */
public class SQLAlterTableAddExtPartition extends SQLObjectImpl implements SQLAlterTableItem, MySqlObject {
    private MySqlExtPartition extPartition;

    @Override
    public void accept0(MySqlASTVisitor visitor) {
        visitor.visit(this);
        visitor.endVisit(this);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
        visitor.endVisit(this);
    }

    public void setExPartition(MySqlExtPartition x) {
        if (x != null) {
            x.setParent(this);
        }
        this.extPartition = x;
    }

    public MySqlExtPartition getExtPartition() {
        return extPartition;
    }
}