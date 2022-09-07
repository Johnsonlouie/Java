package org.json;

	import java.io.FileReader;
	import java.io.IOException;

	import org.json.simple.JSONObject;
	import org.json.simple.parser.JSONParser;
	import org.json.simple.parser.ParseException;
	public class Json {
		public static void main(String[] args) throws IOException, ParseException {
			FileReader fileReader = new FileReader("src\\test\\resources\\filename.json");
			JSONParser jsonParser = new JSONParser();
			Object obj = jsonParser.parse(fileReader);
			JSONObject jsonobject = (JSONObject) obj;

			// get data details

			Object objectdata = jsonobject.get("data");
			JSONObject data = (JSONObject) objectdata;
			//System.out.println(data);

			Object id = data.get("id");
			System.out.println(id);

			Object email = data.get("email");
			System.out.println(email);

			Object first_name = data.get("first_name");
			System.out.println(first_name);

			Object last_name = data.get("last_name");
			System.out.println(last_name);

			Object avatar = data.get("avatar");
			System.out.println(avatar);

			Object objectdata1 = jsonobject.get("support");
			JSONObject support = (JSONObject) objectdata1;

			Object url = support.get("url");
			System.out.println(url);

			Object text = support.get("text");
			System.out.println(text);
			// System.out.println(url+"\n"+text);
		}

	}



