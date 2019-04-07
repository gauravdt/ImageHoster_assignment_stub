package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    //Call the getAllComments() method in the Repository and obtain a List of all the images in the database
    public List<Comment> getAllComments() {
        return commentRepository.getAllComments();
    }


    //The method calls the createComment() method in the Repository and passes the image to be persisted in the database
    public void createComment(Comment comment) {
        commentRepository.createComment(comment);
    }


    //The method calls the getComment() method in the Repository and passes the id of the image to be fetched
    public Comment getComment(Integer commentId) {
        return commentRepository.getComment(commentId);
    }

    //The method calls the updateComment() method in the Repository and passes the Comment to be updated in the database
    public void updateComment(Comment updatedComment) {
        commentRepository.updateComment(updatedComment);
    }

    //The method calls the deleteComment() method in the Repository and passes the Image id of the image to be deleted in the database
    public void deleteComment(Integer commentId) {
        commentRepository.deleteComment(commentId);
    }

}
