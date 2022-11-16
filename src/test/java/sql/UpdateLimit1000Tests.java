package sql;

import custom.TestHelper;
import org.junit.Test;

/**
 * <H1></H1>
 *
 * @author Qingyu.Meng
 * @version 1.0
 * @date 2022/11/16 20:06
 */
public class UpdateLimit1000Tests extends TestHelper {


    @Test
    public void case0() {
        String sql = "update user as u set u.name = 'zhangsan' where u.id in (1, 2, 3, 4, 5) and name in ('zhangsan', 'wangwu'); ";
        println(mysqlToOracle(sql));
    }
}
