package com.vsapi.restapivs.Helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

    // private static String UPLOAD_PATH = "F:\\new spring
    // boot\\restapivs\\src\\main\\resources\\static\\File";
    private final String UPLOAD_PATH = new ClassPathResource("/static/File").getFile().getAbsolutePath();

    public FileUploadHelper() throws IOException {

    }

    public boolean uploadFile(MultipartFile file) {
        boolean f = false;
        try {
            Files.copy(file.getInputStream(), Path.of(UPLOAD_PATH + File.separator + file.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            f = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return f;
    }
}
