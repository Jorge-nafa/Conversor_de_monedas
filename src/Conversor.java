import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Conversor {

   private Scanner teclado=new Scanner(System.in);
   private JsonObject tipoDeCambio;
   private List<Historial> HistorialConversiones;

    public Conversor() throws IOException {
        // Setting URL
        String url_str = "https://v6.exchangerate-api.com/v6/03d147bb79a7d1de1a5820ff/latest/USD";

// Making Request
        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

// Convert to JSON
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

// Accessing object
        String req_result = jsonobj.get("result").getAsString();

        this.tipoDeCambio= jsonobj.getAsJsonObject("conversion_rates");
        this.HistorialConversiones=new ArrayList<>();
    }


    public void VenderDolar(String moneda)  {
        try {
            System.out.println("Cantidad que desea cambiar:");
            double dinero=teclado.nextDouble();
            System.out.println("Tu cambio es: $"+ (tipoDeCambio.get(moneda.toUpperCase()).getAsDouble()*dinero)+" "+moneda);
            Historial CambioExitoso=new Historial("USD",moneda,dinero);
            this.HistorialConversiones.add(CambioExitoso);
        }catch (Exception e){
            System.out.println("Moneda o cantidad no valida");
            teclado.next();
        }

    }

    public void ComprarDolar(String moneda)  {
        try {
            System.out.println("Cantidad que desea cambiar:");
            double dinero=teclado.nextDouble();
            System.out.println("Tu cambio es: $"+ (dinero/tipoDeCambio.get(moneda.toUpperCase()).getAsDouble())+" USD");
            Historial CambioExitoso=new Historial(moneda,"USD",dinero);
            this.HistorialConversiones.add(CambioExitoso);
        }catch (Exception e){
            System.out.println("Moneda o cantidad no valida");
            teclado.next();
        }
    }

    public List<Historial> getHistorialConversiones() {
        return HistorialConversiones;
    }
}
