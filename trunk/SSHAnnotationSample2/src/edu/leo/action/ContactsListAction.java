package edu.leo.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

import edu.leo.common.CommonConst;
import edu.leo.common.annotation.EduLeoAnnotation;
import edu.leo.common.framework.CommonAction;
import edu.leo.common.system.SystemProperty;
import edu.leo.model.ContactsListModel;
import edu.leo.service.IContactsListService;
import edu.leo.value.ContactsListSearchParam;
import edu.leo.value.TContactsHeaderValue;

@Scope("prototype")
// @Namespace("/")
@ParentPackage("default")
@EduLeoAnnotation(name = "", loginCheck = true)
@Results({ @Result(name = Action.SUCCESS, location = "/WEB-INF/jsp/contactsList.jsp") })
public class ContactsListAction extends CommonAction implements ModelDriven<ContactsListModel> {

    private static final long serialVersionUID = -2358798343053189384L;

    @Resource
    private ContactsListModel model;

    @Autowired(required = true)
    public transient IContactsListService service;

    public ContactsListModel getModel() {
        return model;
    }

    public String execute() throws Exception {
        log.debug("execute start");

        this.init();

        this.search();

        log.debug("execute end");
        return Action.SUCCESS;
    }

    private void init() {
        // ページ初期化
        model.setPageNum(1);
        model.setContactsList(null);
        model.setShowResult(false);
    }

    private void search() throws Exception {

        // set seaarch parameter
        ContactsListSearchParam searchParam = new ContactsListSearchParam();
        searchParam.setSrchName(model.getSrchName());

        // 総件数を検索
        Long countLng = service.getAllContactsDataCount(searchParam);
        int count = countLng.intValue();
        model.setCount(count);

        if (count > 0) {
            // ページング変数を計算
            int pageNum = model.getPageNum();
            String strRowCntPerPage = SystemProperty.getProperty(CommonConst.CONTACTS_LIST_DISP_CNT, "20");
            int rowCntPerPage = Integer.parseInt(strRowCntPerPage);
            int pageCount = (int) Math.ceil((double) count / rowCntPerPage);
            model.setPageCount(pageCount);
            model.setShowResult(true);
            // hibernate用のページング変数を計算
            int maxResult = rowCntPerPage;
            // int firstResult = (rowCntPerPage * (pageNum - 1)) + 1;
            int firstResult = (rowCntPerPage * (pageNum - 1));
            model.setFirstResult(firstResult);

            searchParam.setFirstResult(firstResult);
            searchParam.setMaxResult(maxResult);

            // 全件の端末情報を取得する
            List<TContactsHeaderValue> contactList = service.getAllContactsData(searchParam);
            // モデルに設定
            model.setContactsList(contactList);
        } else {
            model.setPageCount(1);
            model.setFirstResult(0);
            model.setContactsList(null);
            // error.nodata=該当データがありません。
            addActionError(getText("error.nodata"));
            model.setShowResult(false);
        }
    }

    public String gotoFirst() throws Exception {
        log.debug("gotoFirst start");

        // ページ数設定
        model.setPageNum(1);
        // 検索を実行
        this.search();

        log.debug("gotoFirst end");
        return SUCCESS;
    }

    public String gotoPrev() throws Exception {
        log.debug("gotoPrev start");

        // ページ数設定
        int pageNum = model.getPageNum();
        pageNum--;
        if (pageNum < 1) {
            pageNum = 1;
        }
        model.setPageNum(pageNum);
        // 検索を実行
        this.search();

        log.debug("gotoPrev end");
        return SUCCESS;
    }

    public String gotoNext() throws Exception {
        log.debug("gotoNext start");

        // ページ数設定
        int pageNum = model.getPageNum();
        pageNum++;
        if (pageNum > model.getPageCount()) {
            pageNum = model.getPageCount();
        }
        model.setPageNum(pageNum);
        // 検索を実行
        this.search();

        log.debug("gotoNext end");
        return SUCCESS;
    }

    public String gotoLast() throws Exception {
        log.debug("gotoLast start");

        // ページ数設定
        model.setPageNum(model.getPageCount());
        // 検索を実行
        this.search();

        log.debug("gotoLast end");
        return SUCCESS;
    }
}
