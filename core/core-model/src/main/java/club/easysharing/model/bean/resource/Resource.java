package club.easysharing.model.bean.resource;

import club.easysharing.model.bean.BaseBean;

/**
 * @author huyuyang@lxfintech.com
 * @Title: Resource
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-06-30 15:05:13
 */
public class Resource extends BaseBean {
    /* 资源编码 */
    private String resourceCode;
    /* 资源所属类别 */
    private String categoryCode;
    /* 资源标题 */
    private String title;
    /* 资源概述 */
    private String note;
    /* 封面图片 */
    private String picture;
    /* 资源大小 */
    private String size;
    /* 所属语言 */
    private String language;
    /* 创建日期 */
    private String resourceDate;
    /* 分享途径 */
    private String shareWay;
    /* 资源类型 */
    private String type;
    /* 星级 */
    private int star;
    /* 环境 */
    private String environment;
    /* 资源内容 */
    private String content;
    /* 资源标签，用逗号分隔 */
    private String marks;
    /* 作者 */
    private String authorUserName;
    /* 页面模板 */
    private String pageTemplate;
    /* 资源状态10草稿20提交审核30审核失败40审核成功 */
    private String status;

    public String getResourceCode() {
        return resourceCode;
    }

    public Resource setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
        return this;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public Resource setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Resource setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getNote() {
        return note;
    }

    public Resource setNote(String note) {
        this.note = note;
        return this;
    }

    public String getPicture() {
        return picture;
    }

    public Resource setPicture(String picture) {
        this.picture = picture;
        return this;
    }

    public String getSize() {
        return size;
    }

    public Resource setSize(String size) {
        this.size = size;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public Resource setLanguage(String language) {
        this.language = language;
        return this;
    }

    public String getResourceDate() {
        return resourceDate;
    }

    public Resource setResourceDate(String resourceDate) {
        this.resourceDate = resourceDate;
        return this;
    }

    public String getShareWay() {
        return shareWay;
    }

    public Resource setShareWay(String shareWay) {
        this.shareWay = shareWay;
        return this;
    }

    public String getType() {
        return type;
    }

    public Resource setType(String type) {
        this.type = type;
        return this;
    }

    public int getStar() {
        return star;
    }

    public Resource setStar(int star) {
        this.star = star;
        return this;
    }

    public String getEnvironment() {
        return environment;
    }

    public Resource setEnvironment(String environment) {
        this.environment = environment;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Resource setContent(String content) {
        this.content = content;
        return this;
    }

    public String getMarks() {
        return marks;
    }

    public Resource setMarks(String marks) {
        this.marks = marks;
        return this;
    }

    public String getAuthorUserName() {
        return authorUserName;
    }

    public Resource setAuthorUserName(String authorUserName) {
        this.authorUserName = authorUserName;
        return this;
    }

    public String getPageTemplate() {
        return pageTemplate;
    }

    public Resource setPageTemplate(String pageTemplate) {
        this.pageTemplate = pageTemplate;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Resource setStatus(String status) {
        this.status = status;
        return this;
    }
}
