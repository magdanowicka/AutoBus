package pl.mnowicka.autobus.search;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;



import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

/**
 * Created by magda on 2017-02-02.
 */
//@Component
public class BuildSearchIndex
//        implements ApplicationListener<ApplicationReadyEvent> {
{
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public void onApplicationEvent(final ApplicationReadyEvent event) {
//        try {
//            FullTextEntityManager fullTextEntityManager =
//                    Search.getFullTextEntityManager(entityManager);
//            fullTextEntityManager.createIndexer().startAndWait();
//        }
//        catch (InterruptedException e) {
//            System.out.println(
//                    "An error occurred trying to build the serach index: " +
//                            e.toString());
//        }
//        return;
//    }


}