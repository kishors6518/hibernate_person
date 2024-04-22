package hibernate_person.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate_person.dto.Person;




public class Persondao {
	
	public EntityManager getManager()
	{
		return Persistence.createEntityManagerFactory("kishor").createEntityManager();
	}
	
	public void savePerson(Person person)
	{
		EntityManager manager=getManager();
		EntityTransaction transaction=manager.getTransaction();
		
		transaction.begin();
		manager.persist(person);
		transaction.commit();
	}
	public Person getPerson(String email)
	{
		EntityManager manager=getManager();
		
		Query query=manager.createQuery("SELECT p FROM Person p WHERE p.email=?1");
		query.setParameter(1, email);
		try {
			Person person=(Person)query.getSingleResult();
			return person;
		} catch (Exception e) {
			return null;
		}	
	}
	public Person findById(int id)
	{
		EntityManager manager=getManager();
		
		Query query=manager.createQuery("SELECT p FROM Person p WHERE p.id=?1");
		query.setParameter(1, id);
		try {
			Person person=(Person)query.getSingleResult();
			return person;
		} catch (Exception e) {
			return null;
		}	
	}
	public Person findByPhone(Long phone)
	{
		EntityManager manager=getManager();
		
		Query query=manager.createQuery("SELECT p FROM Person p WHERE p.phone=?1");
		query.setParameter(1, phone);
		try {
			Person person=(Person)query.getSingleResult();
			return person;
		} catch (Exception e) {
			return null;
		}	
	}
    public List<Person> findByName(String name)
    {
    	EntityManager manager=getManager();
		Query query=manager.createQuery("SELECT p FROM Person p WHERE p.name=?1");
		query.setParameter(1, name);
		List<Person> list=query.getResultList();
		return list;
    }
    public void deleteById(int id)
    {
    	EntityManager manager=getManager();
		EntityTransaction transaction=manager.getTransaction();
		Person person=manager.find(Person.class, id);
		if(person!=null)
		{
			transaction.begin();
			manager.remove(person);
			transaction.commit();
		}
		else
		{
			System.out.println("ID not found");
		}
    }
    public void deleteByPhone(Long phone)
    {
    	EntityManager manager=getManager();
		EntityTransaction transaction=manager.getTransaction();
		Person person=manager.find(Person.class, phone);
		if(person!=null)
		{
			transaction.begin();
			manager.remove(person);
			transaction.commit();
		}
		else
		{
			System.out.println("Phone Number not found");
		}
    }
    public void deleteByEmail(String email)
    {
    	EntityManager manager=getManager();
		EntityTransaction transaction=manager.getTransaction();
		Person person=manager.find(Person.class, email);
		if(person!=null)
		{
			transaction.begin();
			manager.remove(person);
			transaction.commit();
		}
		else
		{
			System.out.println("Email not found");
		}
    }
    public List<Person> findAll()
    {
		EntityManager manager=getManager();
		
		Query query=manager.createQuery("SELECT s FROM Person s");
		List<Person> list=query.getResultList();
		return list;
		
    }
	public void updatePerson(int id)
	{
		EntityManager manager=getManager();
		EntityTransaction transaction=manager.getTransaction();
		
		
	}

}
