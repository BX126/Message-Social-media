import javax.swing.*;

public class EditTweet {

    private JPanel mainPanel;

    private JTextField bodyTextField;
    private JButton clearButton;
    private JButton editButton;
    private JTextField idTextField;

    /** Empty constructor for EditTweet.java. */
    public EditTweet() {
    }

    /** Public accessor methods for the private variables in EditTweet.java */

    public JTextField getidTextField() { return this.idTextField; }

    public JTextField getBodyTextField() {
        return bodyTextField;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public JPanel getMainPanel() {
        return this.mainPanel;
    }

    public JButton getClearButton() { return this.clearButton; }
}
