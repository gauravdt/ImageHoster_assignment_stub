package ImageHoster.repository;

import ImageHoster.model.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

//The annotation is a special type of @Component annotation which describes that the class defines a data repository
@Repository
public class CommentRepository {

    //Get an instance of EntityManagerFactory from persistence unit with name as 'imageHoster'
    @PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;


    //The method receives the Comment object to be persisted in the database
    //Creates an instance of EntityManager
    //Starts a transaction
    //The transaction is committed if it is successful
    //The transaction is rolled back in case of unsuccessful transaction
    public Comment createComment(Comment newComment) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(newComment);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return newComment;
    }

    //The method creates an instance of EntityManager
    //Executes JPQL query to fetch all the comments from the database
    //Returns the list of all the comments fetched from the database
    public List<Comment> getAllComments() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Comment> query = em.createQuery("SELECT i from Comment i", Comment.class);
        List<Comment> resultList = query.getResultList();

        return resultList;
    }



    //The method creates an instance of EntityManager
    //Executes JPQL query to fetch the comment from the database with corresponding id
    //Returns the comment fetched from the database
    public Comment getComment(Integer commentId) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Comment> typedQuery = em.createQuery("SELECT i from Comment i where i.id =:commentId", Comment.class).setParameter("commentId", commentId);
        Comment comment = typedQuery.getSingleResult();
        return comment;
    }

    //The method receives the Comment object to be updated in the database
    //Creates an instance of EntityManager
    //Starts a transaction
    //The transaction is committed if it is successful
    //The transaction is rolled back in case of unsuccessful transaction
    public void updateComment(Comment updatedComment) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.merge(updatedComment);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    //The method receives the Comment id of the comment to be deleted in the database
    //Creates an instance of EntityManager
    //Starts a transaction
    //Get the comment with corresponding comment id from the database
    //This changes the state of the comment model from detached state to persistent state, which is very essential to use the remove() method
    //If you use remove() method on the object which is not in persistent state, an exception is thrown
    //The transaction is committed if it is successful
    //The transaction is rolled back in case of unsuccessful transaction
    public void deleteComment(Integer commentId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Comment comment = em.find(Comment.class, commentId);
            em.remove(comment);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

}
