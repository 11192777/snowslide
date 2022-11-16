/*
 * Copyright 1999-2017 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pers.qingyu.snowslide.sql.dialect.oracle.ast.stmt;

import pers.qingyu.snowslide.enums.DbType;
import pers.qingyu.snowslide.sql.SQLUtils;
import pers.qingyu.snowslide.sql.ast.SQLExpr;
import pers.qingyu.snowslide.sql.ast.SQLStatementImpl;
import pers.qingyu.snowslide.sql.dialect.oracle.visitor.OracleASTVisitor;
import pers.qingyu.snowslide.sql.visitor.SQLASTVisitor;

public class OracleRunStatement extends SQLStatementImpl implements OracleStatement {

    private SQLExpr     expr;

    public OracleRunStatement() {
        super (DbType.oracle);
    }
    public OracleRunStatement(SQLExpr expr) {
        super (DbType.oracle);
        this.setExpr(expr);
    }

    @Override
    public void accept0(OracleASTVisitor visitor) {
        if (visitor.visit(this)) {
            acceptChild(visitor, expr);
        }
        visitor.endVisit(this);
    }

    protected void accept0(SQLASTVisitor visitor) {
        accept0((OracleASTVisitor) visitor);
    }

    public String toString() {
        return SQLUtils.toOracleString(this);
    }

    public SQLExpr getExpr() {
        return expr;
    }

    public void setExpr(SQLExpr expr) {
        if (expr != null) {
            expr.setParent(this);
        }
        this.expr = expr;
    }
}
