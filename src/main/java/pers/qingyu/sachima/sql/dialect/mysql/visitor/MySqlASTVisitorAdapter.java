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
package pers.qingyu.sachima.sql.dialect.mysql.visitor;

import pers.qingyu.sachima.sql.ast.expr.SQLIntervalExpr;
import pers.qingyu.sachima.sql.ast.statement.SQLAlterCharacter;
import pers.qingyu.sachima.sql.ast.statement.SQLShowColumnsStatement;
import pers.qingyu.sachima.sql.ast.statement.SQLShowCreateTableStatement;
import pers.qingyu.sachima.sql.dialect.mysql.ast.*;
import pers.qingyu.sachima.sql.dialect.mysql.ast.clause.*;
import pers.qingyu.sachima.sql.dialect.mysql.ast.clause.MySqlCaseStatement.MySqlWhenStatement;
import pers.qingyu.sachima.sql.dialect.mysql.ast.expr.*;
import pers.qingyu.sachima.sql.dialect.mysql.ast.statement.*;
import pers.qingyu.sachima.sql.dialect.mysql.ast.statement.MySqlCreateTableStatement.TableSpaceOption;
import pers.qingyu.sachima.sql.dialect.mysql.ast.statement.MySqlCreateUserStatement.UserSpecification;
import pers.qingyu.sachima.sql.visitor.SQLASTVisitorAdapter;

public class MySqlASTVisitorAdapter extends SQLASTVisitorAdapter implements MySqlASTVisitor {

}
