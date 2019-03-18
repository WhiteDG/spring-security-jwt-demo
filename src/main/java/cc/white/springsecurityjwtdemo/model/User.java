package cc.white.springsecurityjwtdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;

public class User {
    private Integer id;

    private String username;

    @JsonIgnore
    private String password;

    private Integer enable;

    @JsonIgnore
    private Date lastUpdatePwdTime;

    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Date getLastUpdatePwdTime() {
        return lastUpdatePwdTime;
    }

    public void setLastUpdatePwdTime(Date lastUpdatePwdTime) {
        this.lastUpdatePwdTime = lastUpdatePwdTime;
    }
}