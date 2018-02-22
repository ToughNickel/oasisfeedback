/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sources;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author RAJN
 */
public class Get_method {
    public static void main(String [] args){
        try{
                String url = "http://oasisfeedback.000webhostapp.com/feed.php";
                url += "?";
                String emailfeed = "rajn";
                String feedD = "NetBeans Testing 3";
                feedD = feedD.replace(" ", "+");
                url += "email=" + emailfeed + "%40vmware.com&description=" + feedD + "&submit=Submit+your+feedback";
                final String USER_AGENT = "Mozilla/5.0";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

                //response section
                System.out.println("OS Name : " + System.getProperty("os.name"));
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());
        }
        catch(Exception ex){}
    }
}
