import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

/**
* AddController
* <p>
* This program is a simple message board.
*
* @author Bingxuan Li
* @version April 22, 2020
*/
public final class DeleteController {

   private TwitterModel twitterModel;
   private DeleteTweet deleteTweet;

   /**
    * Implement the DeleteController constructor per the instructions in the handout
    *
    * @param twitterModel TwitterModel object connecting the model and controller portions of the MVC paradigm.
    * @param deleteTweet  DeleteTweet object connecting the view and controller portions of the MVC paradigm.
    */

   public DeleteController(TwitterModel twitterModel, DeleteTweet deleteTweet) throws IllegalArgumentException {
       if (twitterModel == null || deleteTweet == null) {
           throw new IllegalArgumentException();
       }
       this.deleteTweet = deleteTweet;
       this.twitterModel = twitterModel;
       deleteTweet.getDeleteButton().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               getDeleteButtonSemantics();
           }
       });
       deleteTweet.getClearButton().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               getClearButtonSemantics();
           }
       });
   }

   /**
    * A method to control specific GUI component actions.
    */
   private void getDeleteButtonSemantics() {
       String id = deleteTweet.getidTextField().getText();
       Optional<Tweet> test = twitterModel.searchByID(id);
       if (test.isEmpty()) {
           JOptionPane.showMessageDialog(null,
                   "A message with the given ID dose not exist!",
                   "Delete Tweet", JOptionPane.WARNING_MESSAGE);
       } else {
           Tweet tweet = test.get();
           twitterModel.remove(tweet);
           JOptionPane.showMessageDialog(null,
                   "The tweet is deleted successfully!",
                   "Delete Tweet", JOptionPane.INFORMATION_MESSAGE);
           deleteTweet.getidTextField().setText("");
       }

   }

   /**
    * A method to control specific GUI component actions.
    */
   private void getClearButtonSemantics() {
       deleteTweet.getidTextField().setText("");
       deleteTweet.getidTextField().requestFocus();
   }
}
