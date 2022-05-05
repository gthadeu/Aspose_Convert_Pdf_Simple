import com.aspose.words.Document;
import com.aspose.words.SaveFormat;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.List;

public class AsposeConverter {

    public static void main(String[] args) throws Exception {
        new AsposeConverter().getBase64FromFiles();
    }

    private Path getInputPath()
    {
        final String REEMBOLSO_FILES_PATH = "files";
        final String REEMBOLSO_SENAC_PATH = "senac";
        Path filesPath = Paths.get(String.valueOf(Path.of("").toAbsolutePath()),REEMBOLSO_FILES_PATH);
        return Paths.get(filesPath.toString(),REEMBOLSO_SENAC_PATH);
    }

    private Path getOutputPath()
    {
        final String APP_REEMBOLSO_OUTPUT_DIR = "outputApp";
        return Paths.get(String.valueOf(Path.of("").toAbsolutePath()),APP_REEMBOLSO_OUTPUT_DIR);
    }

    private Path getTempPath()
    {
        final String APP_REEMBOLSO_TEMP_DIR = "filesTemp";
        return Paths.get(String.valueOf(Path.of("").toAbsolutePath()),APP_REEMBOLSO_TEMP_DIR);
    }

    private File[] GetAllFiles(Path parentPath)
    {
        File folder = new File(parentPath.toString());
        return folder.listFiles();
    }
    private String getNewFilename(File file,String newExtension) //arquivo.png => arquivo.pdf
    {
        String extension = "";

        int i = file.getName().lastIndexOf('.');
        if (i > 0) {
            extension = file.getName().substring(i);
        }
        String timestamp = String.valueOf(Instant.now().getEpochSecond());
        return file.getName().replaceAll(extension,timestamp + "_Converted." + newExtension);
    }

    private String getMergedFileName(String name) //arquivo.png => arquivo.pdf
    {
        String timestamp = String.valueOf(Instant.now().getEpochSecond());
        return timestamp + "_merged.pdf";
    }

    public List<Path> getAllPdfFiles() throws Exception {
        Path uploadRootPath = getInputPath();
        List<Path> docs = new ArrayList<Path>();
        File[] uploadedFiles = GetAllFiles(uploadRootPath);
        for(File file: uploadedFiles)
        {
            Path docPath = Paths.get(uploadRootPath.toString(),file.getName());

            if(!Files.exists(docPath))
                continue;

            Document oldDoc = new Document(docPath.toString());
            Path tempOutputFilePath = Paths.get(getTempPath().toString(),getNewFilename(file,"pdf"));
            oldDoc.save(tempOutputFilePath.toString(), SaveFormat.PDF);
            docs.add(tempOutputFilePath);
        }
        return docs;
    }

    private String mergePdf(Path outputPath,List<Path> allPdfFiles) throws IOException {
        PDFMergerUtility ut = new PDFMergerUtility();
        for (Path file : allPdfFiles) {
            ut.addSource(file.toString());
        }
        ut.setDestinationFileName(Paths.get(outputPath.toString(),getMergedFileName("merged.pdf")).toString());
        ut.mergeDocuments();
        return ut.getDestinationFileName();
    }

    public  String getBase64FromFiles() {

        String b64 = "";
        String fileMerger = null;
        try {
            fileMerger = mergePdf(getOutputPath(),getAllPdfFiles());
            File file = new File(fileMerger);
            byte[] qqb =  Files.readAllBytes(file.toPath());
            b64 = Base64.getEncoder().encodeToString(qqb);
            System.out.println("b64 = " + b64);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return b64;
    }
}