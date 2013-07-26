package edu.leo.value;

import java.io.Serializable;

public class ResponseResultValue implements Serializable {

    private static final long serialVersionUID = -9133162658311868280L;

    public static final String SUCCESS = "success";
    public static final String FAILED = "failed";
    public static final String EXCLUDED = "excluded";

    private String resultCd;
    private String resultMsg;

    public String getResultCd() {
        return resultCd;
    }

    public void setResultCd(String resultCd) {
        this.resultCd = resultCd;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}
