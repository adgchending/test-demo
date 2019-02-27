package com.cd.shiro.pojo.domain;

import java.io.Serializable;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table sys_permission
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class SysPermission implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_permission.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_permission.parent_id
     *
     * @mbg.generated
     */
    private Long parentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_permission.res_name
     *
     * @mbg.generated
     */
    private String resName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_permission.res_type
     *
     * @mbg.generated
     */
    private String resType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_permission.permission
     *
     * @mbg.generated
     */
    private String permission;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_permission.url
     *
     * @mbg.generated
     */
    private String url;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_permission
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_permission.id
     *
     * @return the value of sys_permission.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_permission.id
     *
     * @param id the value for sys_permission.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_permission.parent_id
     *
     * @return the value of sys_permission.parent_id
     *
     * @mbg.generated
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_permission.parent_id
     *
     * @param parentId the value for sys_permission.parent_id
     *
     * @mbg.generated
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_permission.res_name
     *
     * @return the value of sys_permission.res_name
     *
     * @mbg.generated
     */
    public String getResName() {
        return resName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_permission.res_name
     *
     * @param resName the value for sys_permission.res_name
     *
     * @mbg.generated
     */
    public void setResName(String resName) {
        this.resName = resName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_permission.res_type
     *
     * @return the value of sys_permission.res_type
     *
     * @mbg.generated
     */
    public String getResType() {
        return resType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_permission.res_type
     *
     * @param resType the value for sys_permission.res_type
     *
     * @mbg.generated
     */
    public void setResType(String resType) {
        this.resType = resType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_permission.permission
     *
     * @return the value of sys_permission.permission
     *
     * @mbg.generated
     */
    public String getPermission() {
        return permission;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_permission.permission
     *
     * @param permission the value for sys_permission.permission
     *
     * @mbg.generated
     */
    public void setPermission(String permission) {
        this.permission = permission;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_permission.url
     *
     * @return the value of sys_permission.url
     *
     * @mbg.generated
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_permission.url
     *
     * @param url the value for sys_permission.url
     *
     * @mbg.generated
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
