package com.nchu.ruanko.iwork.domain.entity;

import java.util.Date;

public class User {
    private String userUid;
    private String realName;
    private String password;
    private String nickName;
    private String gender;
    private Date birthday;
    private String wedLock;
    private Nation nation;
    private String nativePlace;
    private PoliticsStatus politicsStatus;
    private Department oweDepartment;
    private JobLevel jobLevel;
    private Position position;
    private String engageForm;
    private String specialty;
    private String tiptopDegree;
    private String school;
    private Date beginDate;
    private String workId;
    private Float contractTerm;
    private Date  beginContract;
    private Date  endContract;
    private Date  conversionTime;
    private Date notWorkDate;
    private Integer workAge;
    private String phone;
    private String mail;
    private String idCard;
    private String address;
    private EmployeeState employeeState;
    private String userFace;
    private String remark;

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getWedLock() {
        return wedLock;
    }

    public void setWedLock(String wedLock) {
        this.wedLock = wedLock;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public PoliticsStatus getPoliticsStatus() {
        return politicsStatus;
    }

    public void setPoliticsStatus(PoliticsStatus politicsStatus) {
        this.politicsStatus = politicsStatus;
    }

    public Department getOweDepartment() {
        return oweDepartment;
    }

    public void setOweDepartment(Department oweDepartment) {
        this.oweDepartment = oweDepartment;
    }

    public JobLevel getJobLevel() {
        return jobLevel;
    }

    public void setJobLevel(JobLevel jobLevel) {
        this.jobLevel = jobLevel;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getEngageForm() {
        return engageForm;
    }

    public void setEngageForm(String engageForm) {
        this.engageForm = engageForm;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getTiptopDegree() {
        return tiptopDegree;
    }

    public void setTiptopDegree(String tiptopDegree) {
        this.tiptopDegree = tiptopDegree;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public Float getContractTerm() {
        return contractTerm;
    }

    public void setContractTerm(Float contractTerm) {
        this.contractTerm = contractTerm;
    }

    public Date getBeginContract() {
        return beginContract;
    }

    public void setBeginContract(Date beginContract) {
        this.beginContract = beginContract;
    }

    public Date getEndContract() {
        return endContract;
    }

    public void setEndContract(Date endContract) {
        this.endContract = endContract;
    }

    public Date getConversionTime() {
        return conversionTime;
    }

    public void setConversionTime(Date conversionTime) {
        this.conversionTime = conversionTime;
    }

    public Date getNotWorkDate() {
        return notWorkDate;
    }

    public void setNotWorkDate(Date notWorkDate) {
        this.notWorkDate = notWorkDate;
    }

    public Integer getWorkAge() {
        return workAge;
    }

    public void setWorkAge(Integer workAge) {
        this.workAge = workAge;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EmployeeState getEmployeeState() {
        return employeeState;
    }

    public void setEmployeeState(EmployeeState employeeState) {
        this.employeeState = employeeState;
    }

    public String getUserFace() {
        return userFace;
    }

    public void setUserFace(String userFace) {
        this.userFace = userFace;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "User{" +
                "userUid='" + userUid + '\'' +
                ", realName='" + realName + '\'' +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", wedLock='" + wedLock + '\'' +
                ", nation=" + nation +
                ", nativePlace='" + nativePlace + '\'' +
                ", politicsStatus=" + politicsStatus +
                ", oweDepartment=" + oweDepartment +
                ", jobLevel=" + jobLevel +
                ", position=" + position +
                ", engageForm='" + engageForm + '\'' +
                ", specialty='" + specialty + '\'' +
                ", tiptopDegree='" + tiptopDegree + '\'' +
                ", school='" + school + '\'' +
                ", beginDate=" + beginDate +
                ", workId='" + workId + '\'' +
                ", contractTerm=" + contractTerm +
                ", beginContract=" + beginContract +
                ", endContract=" + endContract +
                ", conversionTime=" + conversionTime +
                ", notWorkDate=" + notWorkDate +
                ", workAge=" + workAge +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", idCard='" + idCard + '\'' +
                ", address='" + address + '\'' +
                ", employeeState=" + employeeState +
                ", userFace='" + userFace + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
