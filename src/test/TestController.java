package test;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.JpaController;
import model.Book;
import model.Customer;
import model.Orders;
import model.Provider;
import model.Supply;

public class TestController {
	
	private static JpaController controller = null;
	
	
	@BeforeClass
	public static void init(){
		if(controller == null)
		 controller = new JpaController();
	}
	
	@AfterClass
	public static void desrt(){
		 controller = null;
	}
	
	@Test
	public void testAddBook() {
		Book book = new Book("Test", "Test", "Test", 1111);
		controller.add(book);
		Book find = (Book) controller.findByID(Book.class, book.getId());
		Assert.assertNotNull("ƒанна€ запись была добавлена ранее", find);
		Assert.assertEquals(book, find);
	}
	
	/*@Test
	public void testAddCustomer(){
		Customer cust = new Customer("Test","Test","Test");
		controller.add(cust);
		Customer find = (Customer) controller.findByID(Customer.class, cust.getId());
		Assert.assertNotNull("ƒанна€ запись была добавлена ранее",find);
		Assert.assertEquals(cust, find);
	}
	
	@Test
	public void testAddProvider(){
		Provider prov = new Provider("Test","Test","Test","Test");
		controller.add(prov);
		Provider find = (Provider) controller.findByID(Provider.class, prov.getId());
		Assert.assertNotNull("ƒанна€ запись была добавлена ранее",find);
		Assert.assertEquals(prov, find);
	}
	
	@Test
	public void testAddSupply(){
		List books = controller.getObjectList(Book.class);
		Assert.assertNotEquals("Ќевозможно добавить поскольку в таблице Book нет записей", 0, books.size());
		List providers = controller.getObjectList(Provider.class);
		Assert.assertNotEquals("Ќевозможно добавить поскольку в таблице Provider нет записей", 0, providers.size());
		Supply suppl = new Supply(100,(Book)books.get(0),(Provider)providers.get(0));
		controller.add(suppl);
		Supply find = (Supply) controller.findByID(Supply.class, suppl.getId());
		Assert.assertNotNull("ƒанна€ запись была добавлена ранее",find);
		Assert.assertEquals(suppl, find);
	}
	
	@Test
	public void testAddOrders(){
		List books = controller.getObjectList(Book.class);
		Assert.assertNotEquals("Ќевозможно добавить поскольку в таблице Book нет записей", 0, books.size());
		List customers = controller.getObjectList(Customer.class);
		Assert.assertNotEquals("Ќевозможно добавить поскольку в таблице Customer нет записей", 0, customers.size());
		Orders ord = new Orders(true,(Book)books.get(0),(Customer)customers.get(0));
		controller.add(ord);
		Orders find = (Orders) controller.findByID(Orders.class, ord.getId());
		Assert.assertNotNull("ƒанна€ запись была добавлена ранее",find);
		Assert.assertEquals(ord, find);
	}*/
	
	@Test
	public void testEditBook(){
		Book book = new Book("Edit","Edit","Edit",1111);
		List books = controller.getObjectList(Book.class);
		Assert.assertNotEquals("“аблица Book пуста", 0, books.size());
		Book bookU = (Book)books.get(0);
		Assert.assertNotEquals("Ќе удалось редактировать, поскольку така€ запись уже существует", book, bookU);
		controller.edit(bookU.getId(), book, "model.Book");
		Book find = (Book) controller.findByID(Book.class, bookU.getId());
		Assert.assertNotNull(find);
		Assert.assertEquals(book, find);
	}
	
//	@Test
//	public void testEditCustomer(){
//		Customer cust = new Customer("Edit","Edit","888888");
//		List customers = controller.getObjectList(Customer.class);
//		Assert.assertNotEquals("“аблица Customer пуста", 0, customers.size());
//		Customer c = (Customer)customers.get(0);
//		Assert.assertNotEquals("Ќе удалось обновить, поскольку така€ запись уже существует", cust, c);
//		controller.edit(c.getId(), cust, "model.Customer");
//		Customer find = (Customer) controller.findByID(Customer.class, c.getId());
//		Assert.assertNotNull(find);
//		Assert.assertEquals(cust, find);
//	}
	
	/*@Test
	public void testEditProvider(){
		Provider prov = new Provider("EditTestAddress","EditTestCity","EditTestName","9999999");
		controller.edit(1, prov, "model.Provider");
		List<Provider> providers = controller.getObjectList(Provider.class);
		Assert.assertNotNull(providers);
		Assert.assertTrue(providers.contains(prov));
	}
	
	@Test
	public void testEditSupply(){
		EntityManager em = controller.emf.createEntityManager();
		Supply suppl = new Supply(200,em.find(Book.class, 1),em.find(Provider.class, 1));
		controller.edit(1,suppl,"model.Supply");
		List<Supply> s = controller.getObjectList(Supply.class);
		Assert.assertNotNull(s);
		Assert.assertTrue(s.contains(suppl));
	}
	
	@Test
	public void testEditOrders(){
		EntityManager em = controller.emf.createEntityManager();
		Orders ord = new Orders(true,em.find(Book.class, 1),em.find(Customer.class, 1));
		controller.edit(2,ord,"model.Orders");
		List<Orders> s = controller.getObjectList(Orders.class);
		Assert.assertNotNull(s);
		Assert.assertTrue(s.contains(ord));
	}*/
	
	@Test
	public void testDeleteBook(){
		List books = controller.getObjectList(Book.class);
		Assert.assertNotEquals("“аблица Book пуста", 0, books.size());
		Book bookD = (Book)books.get(0);
		controller.delete(bookD.getId(), "Book");
		Book find = (Book) controller.findByID(Book.class, bookD.getId());
		Assert.assertNull(find);
	}
	
}
