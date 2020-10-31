import javax.swing.*;

public class SearchTweet {
    private JTextField searchTermTextField;
    private JButton searchButton;
    private JPanel mainPanel;
    private JTextArea idTextArea;

    /** Empty constructor for SearchTweet.java. */
    public SearchTweet() {
    }

    /** Public accessor methods for the private variables in SearchTweet.java */

    public JTextArea getidTextArea() { return this.idTextArea; }

    public JTextField getSearchTermTextField() {
        return searchTermTextField;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public JPanel getMainPanel() { return this.mainPanel; }
}
