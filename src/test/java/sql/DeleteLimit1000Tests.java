package sql;

import custom.TestHelper;
import org.junit.Test;

/**
 * <H1></H1>
 *
 * @author Qingyu.Meng
 * @version 1.0
 * @date 2022/11/16 20:07
 */
public class DeleteLimit1000Tests extends TestHelper {

    @Test   // delete in limit 1000
    public void case0() {
        String sql = "delete from user as u where u.id in (1, 2, 3, 4, 5) and name in ('zhangsan', 'wangwu')";
        println(mysqlToOracle(sql));
    }


    @Test
    public void case1() {
        String sql = "delete from user as u where u.id in (1, 2) and name in ('zhangsan', 'wangwu')";
        println(mysqlToOracle(sql));
    }

}
