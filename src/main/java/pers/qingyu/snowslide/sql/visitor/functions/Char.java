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
import pers.qingyu.snowslide.sql.visitor.SQLEvalVisitor;

import java.math.BigDecimal;

import static pers.qingyu.snowslide.sql.visitor.SQLEvalVisitor.EVAL_VALUE;

public class Char implements Function {

    public final static Char instance = new Char();

    public Object eval(SQLEvalVisitor visitor, SQLMethodInvokeExpr x) {
        if (x.getArguments().size() == 0) {
            return SQLEvalVisitor.EVAL_ERROR;
        }

        StringBuffer buf = new StringBuffer(x.getArguments().size());
        for (SQLExpr param : x.getArguments()) {
            param.accept(visitor);

            Object paramValue = param.getAttributes().get(EVAL_VALUE);

            if (paramValue instanceof Number) {
                int charCode = ((Number) paramValue).intValue();
                buf.append((char) charCode);
            } else if (paramValue instanceof String) {
                try {
                    int charCode = new BigDecimal((String) paramValue).intValue();
                    buf.append((char) charCode);
                } catch (NumberFormatException e) {
                }
            } else {
                return SQLEvalVisitor.EVAL_ERROR;
            }
        }

        return buf.toString();
    }
}