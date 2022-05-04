import com.aspose.words.Document;
import com.aspose.words.SaveFormat;

public class create_html {
    public static void main(String[] args) throws Exception {
//        String dataDir = "C:\\Users\\Guilherme\\Downloads\\pdf\\config.doc";
        Document doc = new Document("c:\\Users\\Guilherme\\Downloads\\pdf\\config.csv");
        doc.save("C:\\Users\\Guilherme\\Downloads\\pdf\\config.html", SaveFormat.HTML);
        System.out.println("CONVERTEU ESSA CARALHA");
    }
}
