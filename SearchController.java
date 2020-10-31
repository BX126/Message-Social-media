
public class SearchController {

    private TwitterModel twitterModel;
    private SearchTweet searchTweet;

    /** Implement the SearchController constructor per the instructions in the handout
     * @param twitterModel TwitterModel object connecting the model and controller portions of the MVC paradigm.
     * @param searchTweet SearchTweet object connecting the view and controller portions of the MVC paradigm.
     */
    public SearchController(TwitterModel twitterModel, SearchTweet searchTweet) throws IllegalArgumentException {
        if (twitterModel == null || searchTweet==null){
            throw new IllegalArgumentException();
        }
        this.twitterModel = twitterModel;
        this.searchTweet = searchTweet;
        searchTweet.getSearchButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                getSearchButtonSemantics();
            }
        });
    }

    /**
     * Gets the output {@code String} for the specified product list.
     * @param tweetList the product list to be converted to an output {@code String}
     * @return the output {@code String} for the specified product list
     */
    private String getOutputString(List<? extends Tweet> tweetList) {
        StringBuilder stringBuilder = new StringBuilder();
        String outString;

        for (Tweet aTweet : tweetList) {
            stringBuilder.append(aTweet).append("\n\n");
        }
        outString = stringBuilder.toString();

        if (outString.length() > 0) {
            outString = stringBuilder.substring(0, stringBuilder.length() - 2);
        }
        return outString;
    }

    /** Searches our TweetList for a given phrase, returning a List containing all Tweets that apply
     * @param body String of text being searched for
     * @return list of applicable Tweets.
     */
    private List searchForString(String body) {
        List<Tweet> list = this.twitterModel.searchByText(body);
        return list;
    }

    /** A method to control specific GUI component actions. */
    private void getSearchButtonSemantics() {
        String body = searchTweet.getSearchTermTextField().getText();
        String s = "";
        if (body.equals("")){
            JOptionPane.showMessageDialog(null,"Please enter a phrase to search!", "Warning",JOptionPane.WARNING_MESSAGE);
        }
        List list = searchForString(body);

        for (Object o : list) {
            Tweet t = (Tweet) o;
            s += t.getID() + "\n";
            searchTweet.getidTextArea().setText(s);
        }


    }



}
