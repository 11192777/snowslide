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
package pers.qingyu.snowslide.sql.visitor.functions;

import pers.qingyu.snowslide.sql.ast.SQLExpr;
import pers.qingyu.snowslide.sql.ast.expr.SQLMethodInvokeExpr;
import pers.qingyu.snowslide.sql.ast.expr.SQLValuableExpr;
import pers.qingyu.snowslide.sql.visitor.SQLEvalVisitor;

import java.util.List;

import static pers.qingyu.snowslide.sql.visitor.SQLEvalVisitor.EVAL_VALUE;


public class Ucase implements Function {
    public final static Ucase instance = new Ucase();
    
    public Object eval(SQLEvalVisitor visitor, SQLMethodInvokeExpr x) {
        if (x.getArguments().size() != 1) {
            return SQLEvalVisitor.EVAL_ERROR;
        }

        SQLExpr param0 = x.getArguments().get(0);
        param0.accept(visitor);

        Object param0Value = param0.getAttributes().get(EVAL_VALUE);
        if (param0Value == null) {
            return SQLEvalVisitor.EVAL_ERROR;
        }

        String strValue = param0Value.toString();

        String result = strValue.toUpperCase();
        return result;
    }

    public Object eval(SQLMethodInvokeExpr x) {
        List<SQLExpr> parameters = x.getArguments();
        if (parameters.size() == 1) {
            Object p0 = ((SQLValuableExpr) parameters.get(0)).getValue();

            if (p0 instanceof String) {
                String str = (String) p0;
                return str.toUpperCase();
            }
        }

        return SQLEvalVisitor.EVAL_ERROR;
    }
}
