package pers.qingyu.snowslide.sql.ast.statement;

import pers.qingyu.snowslide.sql.ast.SQLObjectImpl;
import pers.qingyu.snowslide.sql.dialect.mysql.ast.MySqlObject;
import pers.qingyu.snowslide.sql.dialect.mysql.ast.statement.MySqlExtPartition;
import pers.qingyu.snowslide.sql.dialect.mysql.visitor.MySqlASTVisitor;
import pers.qingyu.snowslide.sql.visitor.SQLASTVisitor;

/**
 * @author shicai.xsc 2018/9/17 上午10:35
 * @since 5.0.0.0
 */
public class SQLAlterTableDropExtPartition  extends SQLObjectImpl implements SQLAlterTableItem, MySqlObject {
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