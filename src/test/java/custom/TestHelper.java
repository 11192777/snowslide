package custom;

import cn.hutool.core.util.StrUtil;
import pers.qingyu.snowslide.sql.visitor.mysql2oracle.BooleanValueVisitor;
import pers.qingyu.snowslide.enums.DbType;
import pers.qingyu.snowslide.sql.SQLUtils;
import pers.qingyu.snowslide.sql.ast.SQLStatement;

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
        System.out.print(StrUtil.format(String.valueOf(o), params));
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
