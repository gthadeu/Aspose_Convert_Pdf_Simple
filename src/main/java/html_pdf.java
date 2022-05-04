import com.aspose.words.Document;
import com.aspose.words.SaveFormat;

public class html_pdf {
    public static void main(String[] args) throws Exception {
//        String dataDir = "C:\\Users\\Guilherme\\Downloads\\pdf\\config.doc";
        Document doc = new Document("c:\\Users\\Guilherme\\Downloads\\pdf\\config.html");
        doc.save("C:\\Users\\Guilherme\\Downloads\\pdf\\HTMLZAO.pdf", SaveFormat.PDF);
        System.out.println("CONVERTEU ESSA CARALHA");
    }
}
