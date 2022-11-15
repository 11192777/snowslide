package sql;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.text.CharSequenceUtil;
import org.junit.Test;
import pers.qingyu.snowslide.enumeration.DbType;
import pers.qingyu.snowslide.sql.SQLUtils;
import pers.qingyu.snowslide.sql.ast.SQLStatement;

import java.util.ArrayList;

/**
 * <H1></H1>
 *
 * @author Qingyu.Meng
 * @version 1.0
 * @date 2022/11/15 19:18
 */
public class SelectTests {


    @Test
    public void case0() {
        String sql = "select * from user where id in ('1', 2, '3')";
        SQLStatement sqlStatement = SQLUtils.parseSingleStatement(sql, DbType.mysql);
        System.out.println(sqlStatement);
    }

    @Test
    public void case1() {
        String sql = "select * from user where id in (1, 2, 3) and name in ('张三', '李四') limit 100, 10";
        System.out.println(SQLUtils.mysqlToOracle(sql));
    }

    @Test
    public void case2() {
        ArrayList<Integer> params = CollUtil.newArrayList();
        for (int i = 0; i <= 1000; i++) {
            params.add(i);
        }
        String sql = "select * from user where id in ({}) and name in ('张三', '李四') limit 100, 10";
        System.out.println(CharSequenceUtil.format(sql, CollectionUtil.join(params, ",")));
        System.out.println(SQLUtils.mysqlToOracle(CharSequenceUtil.format(sql, CollectionUtil.join(params, ","))));
    }

    @Test
    public void case3() {
        ArrayList<String> params = CollUtil.newArrayList();
        for (int i = 0; i <= 1000; i++) {
            params.add(CharSequenceUtil.format("'{}'", i));
        }
        String sql = "select * from user where id in ({}) and name in ('张三', '李四') limit 100, 10";
        System.out.println(CharSequenceUtil.format(sql, CollectionUtil.join(params, ",")));
        System.out.println(SQLUtils.mysqlToOracle(CharSequenceUtil.format(sql, CollectionUtil.join(params, ","))));
    }
}
