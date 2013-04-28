package com.mikalai.dao.jdbc.dao;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class InsertContact extends SqlUpdate {
    private static final String SQL = 
            "INSERT INTO CONTACT (first_name, last_name, birth_date)" +
            " values(:first_name, :last_name, :birth_date)";
    public InsertContact(DataSource ds){
        super(ds, SQL);
        super.declareParameter(new SqlParameter("first_name", Types.VARCHAR));
        super.declareParameter(new SqlParameter("last_name", Types.VARCHAR));
        super.declareParameter(new SqlParameter("birth_date", Types.DATE));
        super.setGeneratedKeysColumnNames(new String[]{"id"});
        super.setReturnGeneratedKeys(true);
    }
}
