package com.xst.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @ClassName: User
 * @类描述： User  用户实体类
 * @Author: xiaoshitou
 * @Email: 15324399524@163.com
 * @CreateDate： 2018/8/23 9:03
 */

@Table(name = "edu_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //姓名
    private String fullname;

    //证件类型
    private int idtype;

    //身份证号
    private String idnumber;

    //登录密码
    private String password;

    //盐值
    private String salt;

    //生日
    private Date birthday;

    //邮箱
    private String email;

    //性别
    private char sex;

    //名族 id
    private int nation;

    //手机号
    private String tel;

    //单位id
    private int unitid;

    //籍贯省 id
    private int province;

    //籍贯市 id
    private int city;

    //籍贯区 id
    private int county;

    //籍贯
    private String birthplace;

    //头像地址
    private String imagefile;

    //角色 id
    private int roleid;

    //地址
    private String address;

    //政治面貌 id
    private int political;

    //最终毕业院校
    private String suniversity;

    //最终学历
    private String seducation;

    //最终专业
    private String smajor;

    //插入时间
    private String insertdatetime;

    //修改时间
    private String operatordatetime;

    //最后登录时间
    private String loginTime;

    //最后登录IP
    private String loginIp;

    //是否停用标识   0 停用 1启用（默认） 2 锁定
    private int state;

    //是否删除 0 删除  1 正常
    private int flag;

    //角色实体类
    private Roles role;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getIdtype() {
        return idtype;
    }

    public void setIdtype(int idtype) {
        this.idtype = idtype;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getNation() {
        return nation;
    }

    public void setNation(int nation) {
        this.nation = nation;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getUnitid() {
        return unitid;
    }

    public void setUnitid(int unitid) {
        this.unitid = unitid;
    }

    public int getProvince() {
        return province;
    }

    public void setProvince(int province) {
        this.province = province;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public int getCounty() {
        return county;
    }

    public void setCounty(int county) {
        this.county = county;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getImagefile() {
        return imagefile;
    }

    public void setImagefile(String imagefile) {
        this.imagefile = imagefile;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPolitical() {
        return political;
    }

    public void setPolitical(int political) {
        this.political = political;
    }

    public String getSuniversity() {
        return suniversity;
    }

    public void setSuniversity(String suniversity) {
        this.suniversity = suniversity;
    }

    public String getSeducation() {
        return seducation;
    }

    public void setSeducation(String seducation) {
        this.seducation = seducation;
    }

    public String getSmajor() {
        return smajor;
    }

    public void setSmajor(String smajor) {
        this.smajor = smajor;
    }

    public String getInsertdatetime() {
        return insertdatetime;
    }

    public void setInsertdatetime(String insertdatetime) {
        this.insertdatetime = insertdatetime;
    }

    public String getOperatordatetime() {
        return operatordatetime;
    }

    public void setOperatordatetime(String operatordatetime) {
        this.operatordatetime = operatordatetime;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }
}
