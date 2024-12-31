package test.com.itmagazine;

import org.junit.jupiter.api.Test;

import com.itmagazine.AccountsDepartment;
import com.itmagazine.Advertisement;
import com.itmagazine.Advertiser;
import com.itmagazine.Journalist;
import com.itmagazine.Photograph;
import com.itmagazine.Photographer;
import com.itmagazine.Story;

// import com.itmagazine.AccountsDepartment;
// import com.itmagazine.Advertisement;
// import com.itmagazine.Advertiser;
// import com.itmagazine.Journalist;
// import com.itmagazine.Photograph;
// import com.itmagazine.Photographer;
// import com.itmagazine.Story;

import static org.junit.jupiter.api.Assertions.*;

public class ITMagazineTest {

    @Test
    public void testAdvertiserCanPlaceMultipleAdvertisements() {
        Advertiser advertiser = new Advertiser("TechCorp");
        Advertisement ad1 = new Advertisement("Ad Content 1", "Full Page", "Front Page", advertiser);
        Advertisement ad2 = new Advertisement("Ad Content 2", "Half Page", "Back Page", advertiser);

        advertiser.addAdvertisement(ad1);
        advertiser.addAdvertisement(ad2);

        assertEquals(2, advertiser.getAdvertisements().size());
    }

    @Test
    public void testJournalistCanSubmitMultipleStories() {
        Journalist journalist = new Journalist("Alice Johnson");
        Story story1 = new Story("Story 1", "Content 1", journalist);
        Story story2 = new Story("Story 2", "Content 2", journalist);

        journalist.submitStory(story1);
        journalist.submitStory(story2);

        assertEquals(2, journalist.getStories().size());
    }

    @Test
    public void testPhotographerCanSubmitMultiplePhotographs() {
        Photographer photographer = new Photographer("Bob Smith");
        Photograph photo1 = new Photograph("Photo 1", photographer);
        Photograph photo2 = new Photograph("Photo 2", photographer);

        photographer.submitPhotograph(photo1);
        photographer.submitPhotograph(photo2);

        assertEquals(2, photographer.getPhotographs().size());
    }

    @Test
    public void testAdvertisementMustSpecifySizeAndPosition() {
        Advertiser advertiser = new Advertiser("TechCorp");
        Advertisement ad = new Advertisement("Ad Content", "Full Page", "Front Page", advertiser);

        assertNotNull(ad.getSize());
        assertNotNull(ad.getPosition());
    }

    @Test
    public void testSendPayment() {
        AccountsDepartment accounts = new AccountsDepartment();
        accounts.sendPayment("Alice Johnson", 500.0);

        assertTrue(accounts.getPayments().containsKey("Alice Johnson"));
        assertEquals(500.0, accounts.getPayments().get("Alice Johnson"));
    }
}