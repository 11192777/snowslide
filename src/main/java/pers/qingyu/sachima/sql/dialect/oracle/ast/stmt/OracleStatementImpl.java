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
package pers.qingyu.sachima.sql.dialect.oracle.ast.stmt;

import pers.qingyu.sachima.enums.DbType;
import pers.qingyu.sachima.util.SQLUtils;
import pers.qingyu.sachima.sql.ast.SQLStatementImpl;
import pers.qingyu.sachima.sql.dialect.oracle.visitor.OracleASTVisitor;
import pers.qingyu.sachima.sql.visitor.SQLASTVisitor;

public abstract class OracleStatementImpl extends SQLStatementImpl implements OracleStatement {
    
    public OracleStatementImpl() {
        super(DbType.oracle);
    }

    protected void accept0(SQLASTVisitor visitor) {
        accept0((OracleASTVisitor) visitor);
    }

    public abstract void accept0(OracleASTVisitor visitor);

    public String toString() {
        return SQLUtils.toOracleString(this);
    }
}