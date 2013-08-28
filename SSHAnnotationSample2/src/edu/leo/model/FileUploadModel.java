package edu.leo.model;

import java.io.File;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import edu.leo.common.framework.CommonModel;

@Scope("request")
@Controller
public class FileUploadModel extends CommonModel {

    private static final long serialVersionUID = -485584870530587987L;

    private File[] updFile;
    private String[] updFileFileName;
    private String[] updFileContentType;

    public File[] getUpdFile() {
        return updFile;
    }

    public void setUpdFile(File[] updFile) {
        this.updFile = updFile;
    }

    public String[] getUpdFileFileName() {
        return updFileFileName;
    }

    public void setUpdFileFileName(String[] updFileFileName) {
        this.updFileFileName = updFileFileName;
    }

    public String[] getUpdFileContentType() {
        return updFileContentType;
    }

    public void setUpdFileContentType(String[] updFileContentType) {
        this.updFileContentType = updFileContentType;
    }
}
