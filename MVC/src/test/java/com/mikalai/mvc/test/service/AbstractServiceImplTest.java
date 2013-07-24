
package com.mikalai.mvc.test.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mikalai.mvc.test.config.ServiceTestConfig;
import com.mikalai.mvc.test.listener.ServiceTestExecutionListener;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServiceTestConfig.class})
@TestExecutionListeners({ServiceTestExecutionListener.class})
@ActiveProfiles("test")
public abstract class AbstractServiceImplTest extends AbstractTransactionalJUnit4SpringContextTests {

	@PersistenceContext
	protected EntityManager em;
	
}
