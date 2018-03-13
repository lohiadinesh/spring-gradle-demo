/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.cap.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.annotations.ReturnInsert;

@Entity
@Cacheable(false)
@Table(name = "IFMS_USERMANAGEMENT.VW_UM_USERS_ADD")
@XmlRootElement
public class Users implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID")
	@ReturnInsert(returnOnly = true)
	private Long id;
	@Column(name = "GUID")
	private String guid;
	@Basic(optional = false)
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "MIDDLE_NAME")
	private String middleName;
	@Basic(optional = false)
	@Column(name = "LAST_NAME")
	private String lastName;
	@Basic(optional = false)
	@Column(name = "USER_NAME")
	private String userName;
	@Basic(optional = false)
	@Column(name = "DEFAULT_ROLE")
	private String defaultRole;
	@Basic(optional = false)
	@Column(name = "CONTACT_NO")
	private Long contactNo;
	@Column(name = "CONTACT_ADDRESS")
	private String contactAddress;
	@Basic(optional = false)
	@Column(name = "EMAIL_ID")
	private String emailId;
	@Column(name = "DESCRIPTION")
	private String description;
	@Basic(optional = false)
	@Column(name = "IS_FIRST_TIME_LOGIN")
	private Long isFirstTimeLogin;
	@Basic(optional = false)
	@Column(name = "IS_LOCKED")
	private Long isLocked;
	@Basic(optional = false)
	@Column(name = "LOGIN_ATTEMPTS")
	private Long loginAttempts;
	@Basic(optional = false)
	@Column(name = "CREATED_BY")
	private String createdBy;
	@Basic(optional = false)
	@Column(name = "CREATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@Basic(optional = false)
	@Column(name = "LAST_MODIFIED_BY")
	private String lastModifiedBy;
	@Basic(optional = false)
	@Column(name = "LAST_MODIFIED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;
	@Basic(optional = false)
	@Column(name = "IS_ACTIVE")
	private Long isActive;
	@Basic(optional = false)
	@Column(name = "IS_EDITABLE")
	private Long isEditable;
	@Basic(optional = false)
	@Column(name = "IS_VISIBLE")
	private Long isVisible;
	@Basic(optional = false)
	@Column(name = "IS_USED")
	private Long isUsed;
	@Basic(optional = false)
	@Column(name = "VERSION")
	private Long version;
	@Basic(optional = false)
	@Column(name = "IS_DELETED")
	private Long isDeleted;

	public Users() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDefaultRole() {
		return defaultRole;
	}

	public void setDefaultRole(String defaultRole) {
		this.defaultRole = defaultRole;
	}

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getIsFirstTimeLogin() {
		return isFirstTimeLogin;
	}

	public void setIsFirstTimeLogin(Long isFirstTimeLogin) {
		this.isFirstTimeLogin = isFirstTimeLogin;
	}

	public Long getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(Long isLocked) {
		this.isLocked = isLocked;
	}

	public Long getLoginAttempts() {
		return loginAttempts;
	}

	public void setLoginAttempts(Long loginAttempts) {
		this.loginAttempts = loginAttempts;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Long getIsActive() {
		return isActive;
	}

	public void setIsActive(Long isActive) {
		this.isActive = isActive;
	}

	public Long getIsEditable() {
		return isEditable;
	}

	public void setIsEditable(Long isEditable) {
		this.isEditable = isEditable;
	}

	public Long getIsVisible() {
		return isVisible;
	}

	public void setIsVisible(Long isVisible) {
		this.isVisible = isVisible;
	}

	public Long getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(Long isUsed) {
		this.isUsed = isUsed;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Long getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Long isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	@Override
	public String toString() {
		return "VwUmUsers [id=" + id + ", guid=" + guid + ", firstName="
				+ firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", userName=" + userName + ", defaultRole="
				+ defaultRole + ", contactNo=" + contactNo
				+ ", contactAddress=" + contactAddress + ", emailId=" + emailId
				+ ", description=" + description + ", isFirstTimeLogin="
				+ isFirstTimeLogin + ", isLocked=" + isLocked
				+ ", loginAttempts=" + loginAttempts + ", createdBy="
				+ createdBy + ", createdDate=" + createdDate
				+ ", lastModifiedBy=" + lastModifiedBy + ", lastModifiedDate="
				+ lastModifiedDate + ", isActive=" + isActive + ", isEditable="
				+ isEditable + ", isVisible=" + isVisible + ", isUsed="
				+ isUsed + ", version=" + version + ", isDeleted=" + isDeleted
				+ "]";
	}

}
