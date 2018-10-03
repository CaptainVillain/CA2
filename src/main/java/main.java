
import java.util.HashMap;
import javax.persistence.Persistence;

public class main
{
    public static void main(String[] args)
    {
     
        Persistence.generateSchema("pu", null);
        //Persistence.generateSchema("Ca2PU", null);
    }
}
