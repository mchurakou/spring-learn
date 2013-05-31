package com.mikalai.spring.mybatis.persistence;

import java.util.List;

import com.mikalai.spring.mybatis.domain.ContactTelDetail;

public interface ContactTelDetailMapper {
	public List<ContactTelDetail> selectTelDetailForContact(Long contactId);
	
	public void insertContactTelDetail(ContactTelDetail contactTelDetail);
	
	public void updateContactTelDetail(ContactTelDetail contactTelDetail);
	
	public void deleteOrphanContactTelDetail(List<Long> ids);
	
	public void deleteTelDetailForContact(Long contactId);


}
