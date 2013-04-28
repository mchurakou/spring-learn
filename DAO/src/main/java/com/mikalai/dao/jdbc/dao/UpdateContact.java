package com.mikalai.dao.jdbc.dao;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class UpdateContact extends SqlUpdate {
    private static final String SQL = 
            "UPDATE CONTACT set first_name=:first_name, last_name=:last_name," +
            " birth_date=:birth_date where id=:id";
    public UpdateContact(DataSource ds){
        super(ds, SQL);
        super.declareParameter(new SqlParameter("first_name", Types.VARCHAR));
        super.declareParameter(new SqlParameter("last_name", Types.VARCHAR));
        super.declareParameter(new SqlParameter("birth_date", Types.DATE));
        super.declareParameter(new SqlParameter("id", Types.INTEGER));
    }

 
}
