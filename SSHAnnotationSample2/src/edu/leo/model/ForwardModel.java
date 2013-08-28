package edu.leo.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import edu.leo.common.framework.CommonModel;

@Scope("request")
@Controller
public class ForwardModel extends CommonModel {

    private static final long serialVersionUID = 1481870782066955753L;

}
