
package com.ly.zmn48644.mybatis.type;

import java.sql.*;
import java.time.LocalDate;


// //@UsesJava8
public class LocalDateTypeHandler extends BaseTypeHandler<LocalDate> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, LocalDate parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setDate(i, Date.valueOf(parameter));
    }

    @Override
    public LocalDate getNullableResult(ResultSet rs, String columnName) throws SQLException {
        Date date = rs.getDate(columnName);
        return getLocalDate(date);
    }

    @Override
    public LocalDate getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        Date date = rs.getDate(columnIndex);
        return getLocalDate(date);
    }

    @Override
    public LocalDate getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        Date date = cs.getDate(columnIndex);
        return getLocalDate(date);
    }

    private static LocalDate getLocalDate(Date date) {
        if (date != null) {
            return date.toLocalDate();
        }
        return null;
    }
}
