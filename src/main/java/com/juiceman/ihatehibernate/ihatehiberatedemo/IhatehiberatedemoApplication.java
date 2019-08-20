package com.juiceman.ihatehibernate.ihatehiberatedemo;

import com.juiceman.ihatehibernate.ihatehiberatedemo.config.SqlStringQuery;
import com.juiceman.ihatehibernate.ihatehiberatedemo.model.*;
import com.juiceman.ihatehibernate.ihatehiberatedemo.model.dto.ScoreAvgDTO;
import com.juiceman.ihatehibernate.ihatehiberatedemo.serevice.ScoreService;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.*;


@SpringBootApplication
@Transactional
public class IhatehiberatedemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(IhatehiberatedemoApplication.class, args);
    }




	/*
	@Autowired
	private SessionFactory sessionFactory;
*/


    @Override
    public void run(String... arg) throws Exception {

        executeQuery();






		/*
		Book book = new Book();
		book.setPrice(new BigDecimal("6.99"));// $5.99
		bookManger.persist(book); //Now, book has an assigned bookId;



		BookTitle bookTitle = new BookTitle();
		bookTitle.setId(new BookTitleId(book.getId(), "en"));
		bookTitle.setTitle("The Pursuit of Happyness");
		bookManger.persist(bookTitle);
        */

        //Book book = new Book();
        //book.setPrice(new BigDecimal("7.99"));// $5.99
        //book.addTitle("The Pursuit of Happyness", bookManger.find(Language.class, "cn"));

        //Only 1 persist this time around
        //bookManger.persist(book); //Now, book has an assigned bookId;


        //txn.commit();
        //bookManger.close();
        //sessionFactory.close();

		/*
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookStoreManager");
		EntityManager bookManger = emf.createEntityManager();
		EntityTransaction txn = bookManger.getTransaction();
		txn.begin();





		Book book = new Book();
		book.setPrice(new BigDecimal("5.99"));// $5.99
		bookManger.persist(book); //Now, book has an assigned bookId;

		BookTitle bookTitle = new BookTitle();
		bookTitle.setId(new BookTitleId(book.getId(), "en"));
		bookTitle.setTitle("The Pursuit of Happyness");
		bookManger.persist(bookTitle);


		txn.commit();
		bookManger.close();
		emf.close();
        */
    }


    @Autowired
    EntityManagerFactory entityManagerFactory;


    @Autowired
    private ScoreService scoreService;

    private void executeQuery() {


        testQueryAnnotation();

    }


    private void testQueryAnnotation(){

        List<ScoreAvgDTO> list = scoreService.getAllAvgScore();
        list.stream().forEach(dto->dto.showInfo());
    }

    private void testNameQUery() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Object[]> tuples = entityManager.createNamedQuery(
                "find_all_spaceships")
                .getResultList();

        for (Object[] tuple : tuples) {
            SpaceShip spaceShip = (SpaceShip) tuple[0];
            Number surface = (Number) tuple[1];
            Number volume = (Number) tuple[2];
        }
        entityManager.close();
    }




    private void transactionTest() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Identity identity = new Identity();
        identity.setFirstname("matt");
        identity.setLastname("matt_last");
        Captain captain = new Captain();
        captain.setId(identity);
        Dimensions dimensions = new Dimensions();
        dimensions.setLength(100);
        dimensions.setWidth(101);
        SpaceShip spaceShip = new SpaceShip();
        spaceShip.setModel("interstellar_model_01");
        spaceShip.setName("interstellar_01");
        spaceShip.setCaptain(captain);
        spaceShip.setSpeed(1001);
        spaceShip.setDimensions(dimensions);

        entityManager.persist(captain);
        entityManager.persist(spaceShip);

        transaction.commit();
        entityManager.close();
    }

}
