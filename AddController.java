import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class AddController {

   private TwitterModel twitterModel;
   private AddTweet addTweet;

   /**
    * Implement the AddController constructor per the instructions in the handout
    *
    * @param twitterModel TwitterModel object connecting the model and controller portions of the MVC paradigm.
    * @param addTweet     AddTweet object connecting the view and controller portions of the MVC paradigm.
    */

   public AddController(TwitterModel twitterModel, AddTweet addTweet) {
       if (twitterModel == null || addTweet == null) {
           throw new IllegalArgumentException();
       }
       this.addTweet = addTweet;
       this.twitterModel = twitterModel;
       addTweet.getTweetButton().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               getAddButtonSemantics();
           }
       });
       addTweet.getClearButton().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               getClearButtonSemantics();
           }
       });
   }

   /**
    * A method used to verify if a given string is strictly containing numeric values.
    *
    * @param aString A string to verify
    * @return boolean
    */
   public static boolean isNumeric(String aString) {
       if (aString == null) {
           return false;
       } else if (aString.isEmpty()) {
           return false;
       } else if (aString.indexOf(".") != aString.lastIndexOf(".")) {
           return false;
       } else {
           int counter = 0;
           for (char c : aString.toCharArray()) {
               if (Character.isDigit(c)) {
                   counter++;
               }
           }

           return counter == aString.length();

       }
   }

   /**
    * A method to control specific GUI component actions.
    */
   private void getAddButtonSemantics() {
       String id = addTweet.getidTextField().getText();
       String body = addTweet.getBodyTextField().getText();
       if (isNumeric(id)) {
           Tweet newTweet = new Tweet(id, body);
           if (twitterModel.contains(newTweet)) {
               JOptionPane.showMessageDialog(null,
                       "The tweet's ID must be unique!",
                       "Add Tweet", JOptionPane.WARNING_MESSAGE);
               addTweet.getidTextField().requestFocus();
           } else {
               twitterModel.add(newTweet);
               JOptionPane.showMessageDialog(null,
                       "You added tweet successfully!",
                       "Add Tweet", JOptionPane.INFORMATION_MESSAGE);
           }
       } else {
           JOptionPane.showMessageDialog(null,
                   "The Specified ID is not a valid number!",
                   "Add Tweet", JOptionPane.ERROR_MESSAGE);
           addTweet.getidTextField().requestFocus();
       }

   }

   /**
    * A method to control specific GUI component actions.
    */
   public void getClearButtonSemantics() {
       addTweet.getidTextField().setText("");
       addTweet.getBodyTextField().setText("");
       addTweet.getidTextField().requestFocus();
   }
}