import java.net.*;
import java.io.*;

public class WebPageReader {
    public static void main(String[] args) {
        String symbol = "ABBV";
        String urlycharts = "https://www.streetinsider.com/dividend_history.php?q=" + symbol;
        String webPageString = "";
        HttpURLConnection connection = null;  // Declare connection outside try block

        try {
            URL website = URI.create(urlycharts).toURL();
            connection = (HttpURLConnection) website.openConnection();

            // Add more browser-like headers
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) Chrome/120.0.0.0 Safari/537.36");
            connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            connection.setRequestProperty("Connection", "keep-alive");
            connection.setRequestProperty("Upgrade-Insecure-Requests", "1");
            connection.setRequestMethod("GET");

            // Add a timeout
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            // Follow redirects
            connection.setInstanceFollowRedirects(true);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            
            webPageString = response.toString();
            System.out.println("webPageString=" + webPageString);
            
        } catch (Exception e) {
            try {
                if (connection != null) {
                    System.out.println("Error code: " + connection.getResponseCode());
                }
            } catch (IOException ioe) {
                System.out.println("Could not get response code");
            }
            e.printStackTrace();
        }
    }
}