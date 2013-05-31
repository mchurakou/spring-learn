package com.mikalai.spring.mybatis.persistence;

import com.mikalai.spring.mybatis.domain.ContactHobbyDetail;

public interface ContactHobbyDetailMapper {
	public void insertContactHobbyDetail(ContactHobbyDetail contactHobbyDetail);
	public void deleteHobbyDetailForContact(Long contactId);
}
