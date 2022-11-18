package pers.qingyu.sachima.sql.ast.statement;

import pers.qingyu.sachima.sql.ast.SQLName;
import pers.qingyu.sachima.sql.ast.SQLStatementImpl;
import pers.qingyu.sachima.sql.visitor.SQLASTVisitor;

public class SQLExportDatabaseStatement extends SQLStatementImpl {
    private SQLName db;
    private boolean realtime = false;

    public SQLName getDb() {
        return db;
    }

    public void setDb(SQLName db) {
        this.db = db;
    }

    public boolean isRealtime() {
        return realtime;
    }

    public void setRealtime(boolean realtime) {
        this.realtime = realtime;
    }

    protected void accept0(SQLASTVisitor v) {
        if (v.visit(this)) {
            acceptChild(v, db);
        }
        v.endVisit(this);
    }
}
