package com.mikalai.dao.jdbc.dao;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.BatchSqlUpdate;

public class InsertContactTelDetail extends BatchSqlUpdate {
    private static final String SQL = 
            "INSERT INTO CONTACT_TEL_DETAIL (contact_id, tel_type, TEL_NUMBER) " +
            "VALUES(:contact_id, :tel_type, :tel_number)";
    private static final int BATCH_SIZE = 10;
    
    public InsertContactTelDetail(DataSource ds){
        super(ds, SQL);
        super.declareParameter(new SqlParameter("contact_id", Types.INTEGER));
        super.declareParameter(new SqlParameter("tel_type", Types.VARCHAR));
        super.declareParameter(new SqlParameter("tel_number", Types.VARCHAR));
        setBatchSize(BATCH_SIZE);
    }
}
