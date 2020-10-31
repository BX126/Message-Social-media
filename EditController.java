import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

public final class EditController {

   private TwitterModel twitterModel;
   private EditTweet editTweet;

   /**
    * Implement the AddController constructor per the instructions in the handout
    *
    * @param twitterModel TwitterModel object connecting the model and controller portions of the MVC paradigm.
    * @param editTweet    EditTweet object connecting the view and controller portions of the MVC paradigm.
    */

   public EditController(TwitterModel twitterModel, EditTweet editTweet) throws IllegalArgumentException {
       if (twitterModel == null || editTweet == null) {
           throw new IllegalArgumentException();
       }
       this.editTweet = editTweet;
       this.twitterModel = twitterModel;
       editTweet.getEditButton().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               getEditButtonSemantics();
           }
       });
       editTweet.getClearButton().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               getClearButtonSemantics();
           }
       });
   }

   /**
    * A method used to update a specific Tweet's body string.
    *
    * @param aTweet Tweet object containing an ID and body String
    * @param body   String
    */
   private void updateBody(Tweet aTweet, String body) {
       if (body.equals("")) {
           JOptionPane.showMessageDialog(
                   this.editTweet.getMainPanel(),
                   "This message body is empty. Maybe you should instead delete it?",
                   "Message Board",
                   JOptionPane.ERROR_MESSAGE);
           this.editTweet.getBodyTextField().requestFocus();
       } else {
           aTweet.setBody(body);
           JOptionPane.showMessageDialog(
                   this.editTweet.getMainPanel(),
                   "This message was properly updated!",
                   "Message Board",
                   JOptionPane.INFORMATION_MESSAGE);
       }
   }

   /**
    * A method to control specific GUI component actions.
    */
   private void getEditButtonSemantics() {
       String id = editTweet.getidTextField().getText();
       String body = editTweet.getBodyTextField().getText();
       Optional<Tweet> test = twitterModel.searchByID(id);
       if (test.isEmpty()) {
           JOptionPane.showMessageDialog(null,
                   "A message with the given ID dose not exist!",
                   "Warning", JOptionPane.WARNING_MESSAGE);
       } else {
           Tweet tweet = test.get();
           updateBody(tweet, body);
       }
   }

   /**
    * A method to control specific GUI component actions.
    */
   private void getClearButtonSemantics() {
       editTweet.getidTextField().setText("");
       editTweet.getBodyTextField().setText("");
       editTweet.getidTextField().requestFocus();
   }

}
