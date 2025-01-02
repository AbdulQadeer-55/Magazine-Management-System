package editing;

import java.util.List;

public class MagazineIssue {
    private final int issueNumber;
    private final List<Story> stories;
    private final List<Photograph> photographs;

    public MagazineIssue(int issueNumber, List<Story> stories, List<Photograph> photographs) {
        this.issueNumber = issueNumber;
        this.stories = stories;
        this.photographs = photographs;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public List<Story> getStories() {
        return stories;
    }

    public List<Photograph> getPhotographs() {
        return photographs;
    }

    @Override
    public String toString() {
        return "Issue #" + issueNumber + " containing " + stories.size() + " stories and " + photographs.size() + " photographs.";
    }
}
