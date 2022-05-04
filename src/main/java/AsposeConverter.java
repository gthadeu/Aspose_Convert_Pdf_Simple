import com.aspose.words.Document;
import com.aspose.words.SaveFormat;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Base64;

public class AsposeConverter {

    public static void main(String[] args) throws Exception {
        convertBase64(mergePdf(convertPdf( )));
    }
    public static String[] convertPdf() throws Exception {
        String dataDir = "C:\\ferraz\\anotacoes\\aspose\\";
        ArrayList<Document> docs = new ArrayList<Document>();
        String[] types = {"file.csv", "file.doc", "file.docx", "file.html", "file.txt"};
        String[] newDocs = new String[types.length];
        for (int i = 1; i <= types.length; i++) {
            docs.add(new Document(dataDir + types[i - 1]));
            docs.get(i - 1).save(dataDir + "file0" + i + "Converted.pdf", SaveFormat.PDF);
            newDocs[i - 1] = dataDir + "file0" + i + "Converted.pdf";
        }
        return newDocs;
    }
    private static String mergePdf(String[] allFiles) throws IOException {
        PDFMergerUtility ut = new PDFMergerUtility();
        for (String allFile : allFiles) {
            ut.addSource(allFile);
        }
        ut.setDestinationFileName("C:\\ferraz\\anotacoes\\aspose\\merge.pdf");
        ut.mergeDocuments();
        return ut.getDestinationFileName();
    }
    public static String convertBase64(String fileMerger) throws IOException {
        File file = new File(fileMerger);
        byte[] qqb =  Files.readAllBytes(file.toPath());
        String b64 = Base64.getEncoder().encodeToString(qqb);
        System.out.println("b64 = " + b64);
        return b64;
    }
    public static void uploadBD(String b64){

    }
}