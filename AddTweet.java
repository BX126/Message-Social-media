import javax.swing.*;

public final class AddTweet {

    private JPanel mainPanel;
    private JTextField idTextField;
    private JButton clearButton;
    private JButton tweetButton;
    private JTextField bodyTextField;

    public AddTweet() {
    }

    public JTextField getidTextField() {
        return this.idTextField;
    }

    public JButton getClearButton() {
        return this.clearButton;
    }

    public JButton getTweetButton() {
        return this.tweetButton;
    }

    public JTextField getBodyTextField() {
        return this.bodyTextField;
    }

    public JPanel getMainPanel() {
        return this.mainPanel;
    }


}
