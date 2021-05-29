import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 
public class store{

    @SuppressWarnings("unchecked")
    public void write(String uname, String pword){

        JSONParser parser = new JSONParser();
        JSONObject test = new JSONObject();

        try {
            Object obj = parser.parse(new FileReader("pwords.json"));
            JSONArray a = (JSONArray) obj;
            
            test.put(uname, pword);
            a.add(test);

            FileWriter file = new FileWriter("pwords.json");
            file.write(a.toJSONString());
            file.flush();
            file.close();

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public void retrieve(String uname){
        JSONParser parser = new JSONParser();

        try {
            FileReader reader = new FileReader("pwords.json");
            try {
                Object obj = parser.parse(reader);

                JSONArray a = (JSONArray) obj;

                for (int i = 0; i < a.size(); i++ ){
                    JSONObject o = (JSONObject) a.get(i);
                    if (o.get(uname) != null){
                        System.out.print(o.get(uname) + " ");
                    }           
                }

            } catch (IOException e) {e.printStackTrace();} 
            catch (ParseException e) {e.printStackTrace();}

        } catch (FileNotFoundException e) {e.printStackTrace();}
    }
}
