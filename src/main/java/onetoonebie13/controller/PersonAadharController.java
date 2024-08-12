package onetoonebie13.controller;

import onetoonebie13.dao.AadharCardDao;
import onetoonebie13.dao.PersonDao;
import onetoonebie13.dto.AadharCard;
import onetoonebie13.dto.Person;

public class PersonAadharController {
public static void main(String[] args) {
//	Person person=new Person();
//	person.setId(1);
//	person.setName("Abhishek");
//	person.setAddress("Bang");
//	PersonDao dao=new PersonDao();
//	dao.savePerson(person);
	
	AadharCard aadharCard=new AadharCard();
	aadharCard.setId(101);
	aadharCard.setName("Abhi");
	aadharCard.setAge(19);
	
	
	AadharCardDao aadharCardDao=new AadharCardDao();
//	aadharCardDao.saveAadharCard(1, aadharCard);
	aadharCardDao.findAadharCard(101);
	PersonDao dao=new PersonDao();
	dao.findPerson(1);
}
}
