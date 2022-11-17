/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
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
package pers.qingyu.snowslide.util;

import pers.qingyu.snowslide.enums.DbType;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author wenshao [szujobs@hotmail.com]
 */
public final class JdbcUtils {

    public static void close(Connection x) {
        if (x == null) {
            return;
        }

        try {
            if (x.isClosed()) {
                return;
            }

            x.close();
        } catch (Exception e) {
            //nothing
        }
    }

    public static void close(Statement x) {
        if (x == null) {
            return;
        }
        try {
            x.close();
        } catch (Exception e) {
            //nothing
        }
    }

    public static void close(ResultSet x) {
        if (x == null) {
            return;
        }
        try {
            x.close();
        } catch (Exception e) {
            //nothing
        }
    }

    public static void close(Closeable x) {
        if (x == null) {
            return;
        }

        try {
            x.close();
        } catch (Exception e) {
            //nothing
        }
    }

    public static DbType getDbTypeRaw(String rawUrl, String driverClassName) {
        if (rawUrl == null) {
            return null;
        }

        if (rawUrl.startsWith("jdbc:mysql:") || rawUrl.startsWith("jdbc:cobar:")
                || rawUrl.startsWith("jdbc:log4jdbc:mysql:")) {
            return DbType.mysql;
        } else if (rawUrl.startsWith("jdbc:oracle:") || rawUrl.startsWith("jdbc:log4jdbc:oracle:")) {
            return DbType.oracle;
        } else {
            return null;
        }
    }

    public static String getDbType(String rawUrl, String driverClassName) {
        DbType dbType = getDbTypeRaw(rawUrl, driverClassName);

        if (dbType == null) {
            return null;
        }

        return dbType.name();
    }


    public static boolean isOracleDbType(String dbTypeName) {
        return isOracleDbType(DbType.of(dbTypeName));
    }

    public static boolean isOracleDbType(DbType dbType) {
        return DbType.oracle == dbType || DbType.oceanbase == dbType || DbType.ali_oracle == dbType;
    }

    public static boolean isMysqlDbType(String dbTypeName) {
        return isMysqlDbType(DbType.of(dbTypeName));
    }

    public static boolean isMysqlDbType(DbType dbType) {
        return dbType == DbType.mysql;
    }

}
