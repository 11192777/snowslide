package custom;

import pers.qingyu.snowslide.sql.dialect.oracle.visitor.BooleanValueVisitor;
import pers.qingyu.snowslide.enums.DbType;
import pers.qingyu.snowslide.util.SQLUtils;
import pers.qingyu.snowslide.sql.ast.SQLStatement;
import pers.qingyu.snowslide.util.StringUtils;

import java.util.List;

/**
 * <H1></H1>
 *
 * @author Qingyu.Meng
 * @version 1.0
 * @date 2022/11/16 18:04
 */
public class TestHelper {

    public static void println(Object o, Object... params) {
        print(String.valueOf(o).concat("\n"), params);
    }

    public static void print(Object o, Object... params) {
        System.out.print(StringUtils.format(String.valueOf(o), params));
    }

    public static String mysqlToOracle(String sql) {
        return SQLUtils.translateMysqlToOracle(sql, InLimit3Visitor.getInstance(), new BooleanValueVisitor());
    }

    public static SQLStatement getStatement(String sql) {
        return SQLUtils.parseSingleStatement(sql, DbType.mysql);
    }

    public static List<SQLStatement> listStatements(String sql) {
        return SQLUtils.parseStatements(sql, DbType.mysql);
    }

}
