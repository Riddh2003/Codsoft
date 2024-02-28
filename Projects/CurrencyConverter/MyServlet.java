package Program;

import java.net.*;
import java.util.Scanner;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MyServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double amount  = Double.parseDouble(request.getParameter("amount"));
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String key = "fca_live_8xKQJGTtV8RhZ61ltlmdQMj9UmhLPQF8xNuDFu1H";
		String apiUrl = "https://api.currencyapi.com/v3/latest?apikey=" + key;
		try {			
			URL url = new URL(apiUrl);
			//url connetion establish
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			//data read from connection
			InputStream inputStream = conn.getInputStream();
			InputStreamReader reader = new InputStreamReader(inputStream);
			
			//data store in string
			StringBuilder responseContent = new StringBuilder();
			
			//Input from the reader , will create scanner object
			Scanner sc = new Scanner(reader);
			while(sc.hasNext()) {
				responseContent.append(sc.nextLine());
			}
			sc.close();
			System.out.println(responseContent);
			//Typecasting into json
			Gson gson = new Gson();
			JsonObject jsonObject = gson.fromJson(responseContent.toString(),JsonObject.class);
			double torate = jsonObject.getAsJsonObject("data").get("value").getAsDouble();
			double fromrate = jsonObject.getAsJsonObject("data").get("value").getAsDouble();
			
			double converterRate = (amount/fromrate) * torate;
			
            conn.disconnect();
		}
		catch(Exception e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			PrintWriter writer = response.getWriter();
			writer.print("<html><body>"+e.getMessage()+"</body></html>");
			writer.flush();
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
