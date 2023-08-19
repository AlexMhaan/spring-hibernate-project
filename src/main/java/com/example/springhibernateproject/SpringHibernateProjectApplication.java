package com.example.springhibernateproject;

import com.example.springhibernateproject.entities.Task;
import com.example.springhibernateproject.entities.User;
import com.example.springhibernateproject.repositories.BillingRepository;
import com.example.springhibernateproject.repositories.TaskRepository;
import com.example.springhibernateproject.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class SpringHibernateProjectApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringHibernateProjectApplication.class, args);

		BillingRepository billingRepo = context.getBean(BillingRepository.class);
		UserRepository userRepo = context.getBean(UserRepository.class);
		TaskRepository taskRepo = context.getBean(TaskRepository.class);

		User user1 = new User(null, "testName1", "testLastName1", "337089991", LocalDate.now(), true);
		User user2 = new User(null, "testName2", "testLastName2", "337089992", LocalDate.now(), false);

		BillingInfo info1 = new BillingInfo(null,"De la Rosa1", "19141", "Bs.As", "Argen", "AR35BSIT20741",null);
		BillingInfo info2 = new BillingInfo(null,"De la Rosa2", "19142", "Bs.As", "Argen", "AR35BSIT20742",null);

		Task task1 = new Task(null,"Test task1", "test description from test object and fake info xD lalala", true, LocalDate.now(),user1);
		Task task2 = new Task(null,"Test task2", "test description from test object and fake info xD lalala", true, LocalDate.now(),user1);
		Task task3 = new Task(null,"Test task3", "test description from test object and fake info xD lalala", true, LocalDate.now(),user1);
		Task task4 = new Task(null,"Test task4", "test description from test object and fake info xD lalala", false, LocalDate.now(),user2);
		Task task5 = new Task(null,"Test task5", "test description from test object and fake info xD lalala", false, LocalDate.now(),user2);
		Task task6 = new Task(null,"Test task6", "test description from test object and fake info xD lalala", false, LocalDate.now(),user2);

		billingRepo.save(info1);
		billingRepo.save(info2);

		user1.setBillingInfo(info1);
		user2.setBillingInfo(info2);

		userRepo.save(user1);
		userRepo.save(user2);

		taskRepo.save(task1);
		taskRepo.save(task2);
		taskRepo.save(task3);
		taskRepo.save(task4);
		taskRepo.save(task5);
		taskRepo.save(task6);

	}

}
