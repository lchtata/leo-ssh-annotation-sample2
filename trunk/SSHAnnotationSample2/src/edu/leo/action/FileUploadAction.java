package edu.leo.action;

import java.io.File;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

import edu.leo.common.annotation.EduLeoAnnotation;
import edu.leo.common.framework.CommonAction;
import edu.leo.model.FileUploadModel;

@Scope("prototype")
// @Namespace("/")
@ParentPackage("default")
@EduLeoAnnotation(name = "", loginCheck = true)
@Results({ @Result(name = "welcome", location = "/WEB-INF/jsp/fileUpload.jsp"), @Result(name = Action.SUCCESS, location = "/WEB-INF/jsp/result.jsp") })
public class FileUploadAction extends CommonAction implements ModelDriven<FileUploadModel> {

    private static final long serialVersionUID = 7536296040256496392L;

    @Resource
    private FileUploadModel model;

    public FileUploadModel getModel() {
        return model;
    }

    public String execute() throws Exception {
        log.debug("execute start");

        log.debug("execute end");
        return "welcome";
    }

    public String exeUpload() throws Exception {
        log.debug("exeUpload start");

        File[] vUpdFiles = model.getUpdFile();
        for (File vEachFile : vUpdFiles) {
            log.debug("file : " + vEachFile);
        }
        String[] vFileNames = model.getUpdFileFileName();
        for (String vEachFName : vFileNames) {
            log.debug("file name : " + vEachFName);
        }
        String[] vContentTypes = model.getUpdFileContentType();
        for (String vEachContentType : vContentTypes) {
            log.debug("file type : " + vEachContentType);
        }

        super.addActionMessage(super.getText("message.upload.sucess"));
        model.setReturnUrl("file-upload.action");

        log.debug("exeUpload end");
        return Action.SUCCESS;
    }

}
