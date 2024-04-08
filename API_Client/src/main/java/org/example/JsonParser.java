package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static java.net.HttpURLConnection.HTTP_OK;

public class JsonParser {
    public JsonParser() {
    }

    //metoda pobiera plik json z podanego url i zwraca go jako string
    private static String getJSONFromURL(String strURL) throws IOException {
        String jsonText = "";

        try {
            URL url = new URL(strURL);
            InputStream is = url.openStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonText += line + "\n";
            }

            is.close();
            bufferedReader.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonText;
    }

    public static List<StudentDTO> getAllStudents() throws IOException {

        // przypisanie json z danego url do zmiennej
        String strJson = getJSONFromURL("http://localhost:8080/users");
        List<StudentDTO> studentDTOList = new ArrayList<>();

        try {
            JSONParser parser = new JSONParser();

            //przerobienie stringa z jsonem na obiekt z jsonem
            Object object = parser.parse(strJson);

            //przerobienie obiektu na tablice
            JSONArray jsonArray = (JSONArray) object;

            for (Object obj : jsonArray) {
                JSONObject student = (JSONObject) obj;

                long id = (long) student.get("id");
                String name = (String) student.get("name");
                String city = (String) student.get("city");
                long age = (long) student.get("age");

                studentDTOList.add(new StudentDTO(id, name, (int) age, city));
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return studentDTOList;
    }

    public static void addStudent(StudentDTO studentDTO) throws IOException {
        URL url = new URL("http://localhost:8080/users");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        //konwersja obiektu student na format JSON
        String jsonString = "{\"name\": \"" + studentDTO.getName() + "\", \"age\": \"" + studentDTO.getAge() + "\", \"city\": \"" + studentDTO.getCity() + "\"}";

        //wysylanie danych do serwera
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        //odczytanie odpowiedzi z serwera
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;

            while ((responseLine = bufferedReader.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println("Odpowiedz serwera: " + response);
        }
        connection.disconnect();
    }

    public static void deleteStudent(String id) throws IOException {
        if (!ifStudentExist(id)){
            System.out.println("Student o podanym id nie istnieje !");
            return;
        }
        try {
            URL url = new URL("http://localhost:8080/users/" + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");

            //TODO ogarnac wyjatek kiedy studenta o danym id nie ma zeby serwer zwracal error czy cos
            //sprawdzenie odpowiedzi z API
            int responseCode = connection.getResponseCode();
            if (responseCode == HTTP_OK) {
                System.out.println("Student został usunięty pomyślnie");
            } else {
                System.out.println("Nie udało się usunąć studenta");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean ifStudentExist(String id) throws IOException {
        try {
            URL url = new URL("http://localhost:8080/users/" + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Sprawdzenie odpowiedzi z API
            int responseCode = connection.getResponseCode();
            if (responseCode == HTTP_OK) {
                // Czytanie odpowiedzi z serwera
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                //sprawdzenie czy ta odpowiedz ma informacje o danym id
                if (response.toString().isEmpty()) {
                    return false;
                } else {
                    return true;
                }
            } else {
                System.out.println("Nie udalo sie sprawdzic danych o studencie" + responseCode);
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
