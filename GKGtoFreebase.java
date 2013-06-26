import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;

import org.apache.commons.codec.binary.Base64;

/**
 * This class is a reference implementation of the "Google Knowledge Graph to
 * Freebase" link.
 * 
 * More details can be found at:
 * @see http://lists.w3.org/Archives/Public/semantic-web/2012Jun/0028.html
 *
 * @author Andreas Thalhammer
 */
public class GKGtoFreebase {
	
	/**
	 * Simple Java implementation
	 * 
	 * @param args: this method takes one argument: the stick parameter, e.g.
	 * 	H4sIAAAAAAAAAONgVuLQz9U3MKs0LgIAXXSnTQwAAAA
	 * @throws IOException
	 */
	public static void main(String [] args) throws IOException {
		Base64 decode = new Base64(true);
		byte [] bytes = decode.decode(args[0]);

		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);

		GZIPInputStream stream = new GZIPInputStream(bais);
		InputStreamReader reader = new InputStreamReader(stream);
		BufferedReader in = new BufferedReader(reader);

		String readed;
		String out = "";
		while ((readed = in.readLine()) != null) {
		    out += readed;
		}
		String id = out.split("\"")[1].trim().split("\\*")[0];
		System.out.println("http://freebase.com" + id);
	}
}