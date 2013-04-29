package com.mikalai.dao.jdbc.dao;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlFunction;

public class SfFirstNameById extends SqlFunction<String> {
    private static final String SQL = "select getfirstnamebyid(?)";
    public SfFirstNameById(DataSource ds){
        super(ds, SQL);
        declareParameter(new SqlParameter(Types.INTEGER));
        compile();
        
    }
}
