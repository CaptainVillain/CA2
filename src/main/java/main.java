
import java.util.HashMap;
import javax.persistence.Persistence;

public class main
{
    public static void main(String[] args)
    {
        HashMap<String, Object> puproperties = new HashMap<>();
        puproperties.put("javax.persistence.sql-load-script-source", "Scripts/ZIpCodes.sql");
        Persistence.generateSchema("Ca2PU", puproperties);
        //Persistence.generateSchema("Ca2PU", null);
    }
}
