package org.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class JsonParser {

    public static String getJSONFromURL(String strURL) throws IOException {
        String jsonText = "";

        try {
            URL url = new URL(strURL);
            InputStream is = url.openStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

            String line;
            while ((line = bufferedReader.readLine()) != null){
                jsonText += line + "\n";
            }

            is.close();
            bufferedReader.close();


        }catch (Exception e){
            e.printStackTrace();
        }

        return jsonText;
    }

    public static void main(String[] args) throws IOException {
        String strJson = getJSONFromURL("http://localhost:8080/users");
        StudentDTO studentDTO = new StudentDTO();

//        System.out.println(strJson);

        try {
            JSONParser parser = new JSONParser();
            Object object = parser.parse(strJson);
            JSONObject mainJsonObject = (JSONObject) object;
            //id
            long id = (long) mainJsonObject.get("id");
            studentDTO.setId(id);

            //age
            long age = (long) mainJsonObject.get("age");
            studentDTO.setAge(age);

            //name
            String name = (String) mainJsonObject.get("name");
            studentDTO.setName(name);

            //city
            String city = (String) mainJsonObject.get("city");
            studentDTO.setCity(city);

            System.out.println(studentDTO.toString());

        }catch (Exception ex){
            ex.printStackTrace();
        }


    }

}
