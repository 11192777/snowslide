package pers.qingyu.sachima.sql.ast;

import pers.qingyu.sachima.sql.ast.SQLName;
import pers.qingyu.sachima.sql.ast.SQLObject;
import pers.qingyu.sachima.sql.ast.statement.SQLSelectOrderByItem;

import java.util.List;

public interface SQLIndex extends SQLObject {
    List<SQLName> getCovering();
    List<SQLSelectOrderByItem> getColumns();
}
