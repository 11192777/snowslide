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
package pers.qingyu.snowslide.sql.ast.statement;

import pers.qingyu.snowslide.sql.ast.SQLExpr;
import pers.qingyu.snowslide.sql.ast.SQLName;
import pers.qingyu.snowslide.sql.ast.SQLObjectImpl;
import pers.qingyu.snowslide.sql.visitor.SQLASTVisitor;

public class SQLErrorLoggingClause extends SQLObjectImpl {

    private SQLName into;
    private SQLExpr simpleExpression;
    private SQLExpr limit;

    @Override
    public void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            acceptChild(visitor, into);
            acceptChild(visitor, simpleExpression);
            acceptChild(visitor, limit);
        }
        visitor.endVisit(this);
    }

    public SQLName getInto() {
        return into;
    }

    public void setInto(SQLName into) {
        this.into = into;
    }

    public SQLExpr getSimpleExpression() {
        return simpleExpression;
    }

    public void setSimpleExpression(SQLExpr simpleExpression) {
        this.simpleExpression = simpleExpression;
    }

    public SQLExpr getLimit() {
        return limit;
    }

    public void setLimit(SQLExpr limit) {
        this.limit = limit;
    }

    public SQLErrorLoggingClause clone() {
        SQLErrorLoggingClause x = new SQLErrorLoggingClause();
        if (into != null) {
            x.setInto(into.clone());
        }
        if (simpleExpression != null) {
            x.setSimpleExpression(simpleExpression.clone());
        }
        if (limit != null) {
            x.setLimit(limit.clone());
        }
        return x;
    }

}
