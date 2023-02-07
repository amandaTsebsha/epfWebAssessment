package epfWebAssessment.Controller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public class ExcelFileController {
//    Where to save the file
    private static String fileStorage = "/home/MaTsebesha/epfWebAssessment";
    private String fileLoc;



    @GetMapping("/")
    public String index(Model model){
        List<String> financialList = new ArrayList<String>();
        File file = new File(fileStorage);
        String[] fileList = ((File) file).list();

        for (String name : fileList){
            financialList.add(name);
        }

        model.addAttribute("list", financialList);
        return "upload";
    }

    @PostMapping("/upload")
    public String singleFileUpload (@RequestParam("file") MultipartFile file, Model model) throws IOException {

        InputStream inputStream = file.getInputStream();
        File currentDirectory = new File(".");
        String filePath = currentDirectory.getAbsolutePath();
        fileLoc = filePath.substring(0, filePath.length() - 1) + file.getOriginalFilename();
        FileOutputStream fileOutputStream = new FileOutputStream(fileLoc);

        int ch = 0;

        while((ch = inputStream.read()) != -1) {
            fileOutputStream.write(ch);
        }

        fileOutputStream.flush();
        fileOutputStream.close();
        model.addAttribute("message", "File: " + file.getOriginalFilename() + " has been uploaded successfully!")
                return "excel file";
    }
}
