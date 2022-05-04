import com.aspose.words.Document;
import com.aspose.words.SaveFormat;

public class txt_pdf {
    public static void main(String[] args) throws Exception {
//        String dataDir = "C:\\Users\\Guilherme\\Downloads\\pdf\\config.doc";
        Document doc = new Document("c:\\Users\\Guilherme\\Downloads\\pdf\\config.txt");
        doc.save("C:\\Users\\Guilherme\\Downloads\\pdf\\TXTZAO.pdf", SaveFormat.PDF);
        System.out.println("CONVERTEU ESSA CARALHA");
    }
}
