package onetoonebie13.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetoonebie13.dto.AadharCard;
import onetoonebie13.dto.Person;

public class AadharCardDao {
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}
	
	
	public void saveAadharCard(int personId,AadharCard aadharCard) {
		EntityManager entityManager=getEntityManager();
		Person dbPerson=entityManager.find(Person.class, personId);
		if(dbPerson!=null) {
//			person is present so i can issue the AadharCard
			aadharCard.setPerson(dbPerson);
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			
			entityManager.persist(aadharCard);
//			Update the Person Details
			
			dbPerson.setAadharCard(aadharCard);
			
			entityTransaction.commit();
		}else {
			System.out.println("Sorry Person is not present");
		}
	}
	

	
	
	public void updateAadharCard(int id,AadharCard aadharCard) {
		EntityManager entityManager=getEntityManager();
		AadharCard dbAadharCard=entityManager.find(AadharCard.class, id);
		if(dbAadharCard!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			aadharCard.setId(id);
			aadharCard.setPerson(dbAadharCard.getPerson());
			entityManager.merge(aadharCard);
			entityTransaction.commit();
		}else {
			System.out.println("Sorry Aadharcard is not present");
		}
	}
	public void findAadharCard(int id) {
		EntityManager entityManager=getEntityManager();
		AadharCard dbAadharCard=entityManager.find(AadharCard.class, id);
		if(dbAadharCard!=null) {
			System.out.println(dbAadharCard);
		}else {
			System.out.println("Sorry Aadharcard is not present");
		}
	}
}
