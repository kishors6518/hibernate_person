package hibernate_person.controller;

import java.util.List;
import java.util.Scanner;

import hibernate_person.dao.Persondao;
import hibernate_person.dto.Person;

public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		Person person=new Person();
		Persondao dao=new Persondao();
		
		System.out.println("Press \n1.Singup \n2.Login \n3.Find by ID \n4.Find by Phone \n5.Find By Name \n6.Delete By Id \n7.Delete By Phone \n8. Delete By Email \n9.Find all Person \n10.Update Person");
		System.out.println("Enter your choice");
		try {
			switch (scanner.nextInt()) {
			case 1:{
				System.out.println("Enter Id");
				person.setId(scanner.nextInt());
				System.out.println("Enter your name");
				person.setName(scanner.next());
				System.out.println("Enter your phone number");
				person.setPhone(scanner.nextLong());
				System.out.println("Enter your email");
				person.setEmail(scanner.next());
				System.out.println("Enter password");
				person.setPassword(scanner.next());
				
				dao.savePerson(person);
			}
			break;
			case 2:{
				System.out.println("Enter email");
				String email=scanner.next();
				System.out.println("Enter password");
				String password=scanner.next();
				
				Person dbPerson=dao.getPerson(email);
				if (dbPerson!=null) {	
					if(password.equals(dbPerson.getPassword()))
					{
						System.out.println("Login Successful");
					}
					else
					{
						System.out.println("Login Failed");
					}		
				}
				else
				{
					System.out.println("Person not found");
				}
				
			}break;
			case 3:{
				System.out.println("Enter the Id");
				Person dbPerson=dao.findById(scanner.nextInt());
				if(dbPerson!=null)
				{
					System.out.println(dbPerson);
				}
			}
				break;
			case 4:{
				System.out.println("Enter the Phone");
				Person dbPerson=dao.findByPhone(scanner.nextLong());
				if(dbPerson!=null)
				{
					System.out.println(dbPerson);
				}else
				{
					System.out.println("Phone number not found");
				}
			}
				break;
			case 5:{
				System.out.println("Enter the name");
				List<Person> dbPerson=dao.findByName(scanner.next());
				if(dbPerson!=null)
				{
					System.out.println(dbPerson);
				}
				else
				{
					System.out.println("Name not found");
				}
			}
				break;
			case 6:{
				System.out.println("Enter Id for delete");
				dao.deleteById(scanner.nextInt());
			}
			break;
			case 7:{
				System.out.println("Enter Phone for delete");
				dao.deleteByPhone(scanner.nextLong());
			}
			break;
			case 8:{
				System.out.println("Enter Email for delete");
				dao.deleteByEmail(scanner.next());
			}
			break;
			case 9:{
				List<Person>list=dao.findAll();
				System.out.println(list);
			}break;
			case 10:{
				System.out.println("Enter Id for update");
				dao.updatePerson(scanner.nextInt());
				
			}
			}
		} catch (Exception e) {
			System.out.println("Please Enter valid Input");
			
		}
	}

}
