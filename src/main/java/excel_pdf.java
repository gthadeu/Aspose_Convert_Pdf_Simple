import com.aspose.words.Document;
import com.aspose.words.SaveFormat;

public class excel_pdf {
    public static void main(String[] args) throws Exception {
//        String dataDir = "C:\\Users\\Guilherme\\Downloads\\pdf\\config.doc";
        Document doc = new Document("c:\\Users\\Guilherme\\Downloads\\pdf\\config.csv");
        doc.save("C:\\Users\\Guilherme\\Downloads\\pdf\\EXCEL.pdf", SaveFormat.PDF);
        System.out.println("CONVERTEU ESSA CARALHA");
        //Save the document in PDF format.
//        doc.save(dataDir + "html/Aspose_DocToHTML.html",SaveFormat.Html); //Save the document in HTML format.
//        doc.save(dataDir + "Aspose_DocToTxt.txt",SaveFormat.Excel); //Save the document in TXT format.
//        doc.save(dataDir + "Aspose_DocToJPG.jpg",SaveFormat.Svg); //Save the document in JPEG format.
    }
}
