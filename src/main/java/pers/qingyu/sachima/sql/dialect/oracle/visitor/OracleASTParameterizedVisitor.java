package pers.qingyu.sachima.sql.dialect.oracle.visitor;

import pers.qingyu.sachima.enums.DbType;
import pers.qingyu.sachima.sql.visitor.SQLASTParameterizedVisitor;

import java.util.List;

public class OracleASTParameterizedVisitor  extends SQLASTParameterizedVisitor implements OracleASTVisitor {
    public OracleASTParameterizedVisitor() {
        super(DbType.oracle);
    }

    public OracleASTParameterizedVisitor(List<Object> parameters) {
        super(DbType.oracle, parameters);
    }
}
