package com.mikalai.finals.test;



import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mikalai.finals.dao.ContactDAO;
import com.mikalai.finals.domain.Hobby;



@ContextConfiguration(locations={"classpath:/spring/app-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ContactDAOTest {

	@Autowired
	private ContactDAO contactDAO;



    @Test
	@Transactional
	public void testSaveOrderWithItems() throws Exception {
	    List<Hobby> hobbies = contactDAO.getAllHobbies();
		
		Assert.assertNotNull(hobbies);
		Assert.assertTrue(hobbies.size() > 0);
	}

	/*@Test
	@Transactional
	public void testSaveAndGet() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Order order = new Order();
		order.getItems().add(new Item());
		session.save(order);
		session.flush();
		// Otherwise the query returns the existing order (and we didn't set the
		// parent in the item)...
		session.clear();
		Order other = (Order) session.get(Order.class, order.getId());
		assertEquals(1, other.getItems().size());
		assertEquals(other, other.getItems().iterator().next().getOrder());
	}

	@Test
	@Transactional
	public void testSaveAndFind() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Order order = new Order();
		Item item = new Item();
		item.setProduct("foo");
		order.getItems().add(item);
		session.save(order);
		session.flush();
		// Otherwise the query returns the existing order (and we didn't set the
		// parent in the item)...
		session.clear();
		Order other = (Order) session
				.createQuery( "select o from Order o join o.items i where i.product=:product")
				.setString("product", "foo").uniqueResult();
		assertEquals(1, other.getItems().size());
		assertEquals(other, other.getItems().iterator().next().getOrder());
	}*/

    
    public ContactDAO getContactDAO() {
        return contactDAO;
    }

    public void setContactDAO(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }
}
