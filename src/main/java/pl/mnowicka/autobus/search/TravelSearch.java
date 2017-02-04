package pl.mnowicka.autobus.search;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;



import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;
import pl.mnowicka.autobus.entities.Route;


/**
 * Created by magda on 2017-02-02.
 */
//@Repository
//@Transactional
public class TravelSearch {

//    @PersistenceContext
//    private EntityManager entityManager;
//
//    public List<Route> search(String text) {
//
//        // get the full text entity manager
//        FullTextEntityManager fullTextEntityManager =
//                org.hibernate.search.jpa.Search.
//                        getFullTextEntityManager(entityManager);
//
//        // create the query using Hibernate Search query DSL
//        QueryBuilder queryBuilder =
//                fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Route.class).get();
//
//        // a very basic query by keywords
//        org.apache.lucene.search.Query query =
//                queryBuilder
//                        .keyword()
//                        .onFields("departure", "destination")
//                        .matching(text)
//                        .createQuery();
//
//        // wrap Lucene query in an Hibernate Query object
//        org.hibernate.search.jpa.FullTextQuery jpaQuery =
//                fullTextEntityManager.createFullTextQuery(query, Route.class);
//
//        // execute search and return results (sorted by relevance as default)
//        @SuppressWarnings("unchecked")
//        List<Route> results = jpaQuery.getResultList();
//
//        return results;
//    }
}
