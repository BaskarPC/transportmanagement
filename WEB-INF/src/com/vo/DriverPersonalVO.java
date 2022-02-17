package com.vo;

import java.util.ArrayList;

import org.apache.log4j.Logger;

public class DriverPersonalVO {
	
	private static final Logger logger=(Logger)Logger.getLogger(DriverPersonalVO.class);
	private String seqid=null;
	private String driverId=null;
	private String drivercode=null;
	private String driverdesc=null;
	private String driverName=null;
	private String permanentAddress=null;
	private String temporaryAddress=null;
	private String district1=null;
	private String district2=null;
	private String state1=null;
	private String state1desc=null;
	private String state1code=null;
	private String state2=null;
	private String state2desc=null;
	private String state2code=null;
	private String district1code=null;
	private String district2code=null;
	private String district1desc=null;
	private String district2desc=null;
	private String mobileNo=null;
	private String residentialNo1=null;
	private String residentialNo2=null;
	private String community=null;
	private ArrayList communityList=null;
	private String communitycode=null;
    private String communitydesc=null;
	private String religion=null;
	private ArrayList religionList=null;
	private String religioncode=null;
	private String religiondesc=null;
	private String DOB=null;
	private String salary=null;
	private String caste=null;
	private String DOJ=null;
	private ArrayList driveridList=null;
	private ArrayList state1List=null;
	private ArrayList state2List=null;
	private ArrayList district2List=null;
	private ArrayList district1List=null;
	/**
	 * @return the caste
	 */
	public String getCaste() {
		return caste;
	}
	/**
	 * @param caste the caste to set
	 */
	public void setCaste(String caste) {
		this.caste = caste;
	}
	/**
	 * @return the community
	 */
	public String getCommunity() {
		return community;
	}
	/**
	 * @param community the community to set
	 */
	public void setCommunity(String community) {
		this.community = community;
	}
	/**
	 * @return the communitycode
	 */
	public String getCommunitycode() {
		return communitycode;
	}
	/**
	 * @param communitycode the communitycode to set
	 */
	public void setCommunitycode(String communitycode) {
		this.communitycode = communitycode;
	}
	/**
	 * @return the communitydesc
	 */
	public String getCommunitydesc() {
		return communitydesc;
	}
	/**
	 * @param communitydesc the communitydesc to set
	 */
	public void setCommunitydesc(String communitydesc) {
		this.communitydesc = communitydesc;
	}
	
	/**
	 * @return the district1
	 */
	public String getDistrict1() {
		return district1;
	}
	/**
	 * @param district1 the district1 to set
	 */
	public void setDistrict1(String district1) {
		this.district1 = district1;
	}
	/**
	 * @return the district1code
	 */
	public String getDistrict1code() {
		return district1code;
	}
	/**
	 * @param district1code the district1code to set
	 */
	public void setDistrict1code(String district1code) {
		this.district1code = district1code;
	}
	
	/**
	 * @return the district2
	 */
	public String getDistrict2() {
		return district2;
	}
	/**
	 * @param district2 the district2 to set
	 */
	public void setDistrict2(String district2) {
		this.district2 = district2;
	}
	/**
	 * @return the district2code
	 */
	public String getDistrict2code() {
		return district2code;
	}
	/**
	 * @param district2code the district2code to set
	 */
	public void setDistrict2code(String district2code) {
		this.district2code = district2code;
	}

	/**
	 * @return the dOB
	 */
	public String getDOB() {
		return DOB;
	}
	/**
	 * @param dob the dOB to set
	 */
	public void setDOB(String dob) {
		DOB = dob;
	}
	/**
	 * @return the dOJ
	 */
	public String getDOJ() {
		return DOJ;
	}
	/**
	 * @param doj the dOJ to set
	 */
	public void setDOJ(String doj) {
		DOJ = doj;
	}
	/**
	 * @return the driverId
	 */
	public String getDriverId() {
		return driverId;
	}
	/**
	 * @param driverId the driverId to set
	 */
	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	/**
	 * @return the driverName
	 */
	public String getDriverName() {
		return driverName;
	}
	/**
	 * @param driverName the driverName to set
	 */
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	/**
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}
	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	/**
	 * @return the permanentAddress
	 */
	public String getPermanentAddress() {
		return permanentAddress;
	}
	/**
	 * @param permanentAddress the permanentAddress to set
	 */
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	/**
	 * @return the religion
	 */
	public String getReligion() {
		return religion;
	}
	/**
	 * @param religion the religion to set
	 */
	public void setReligion(String religion) {
		this.religion = religion;
	}
	/**
	 * @return the religioncode
	 */
	public String getReligioncode() {
		return religioncode;
	}
	/**
	 * @param religioncode the religioncode to set
	 */
	public void setReligioncode(String religioncode) {
		this.religioncode = religioncode;
	}
	/**
	 * @return the religiondesc
	 */
	public String getReligiondesc() {
		return religiondesc;
	}
	/**
	 * @param religiondesc the religiondesc to set
	 */
	public void setReligiondesc(String religiondesc) {
		this.religiondesc = religiondesc;
	}
		/**
	 * @return the residentialNo1
	 */
	public String getResidentialNo1() {
		return residentialNo1;
	}
	/**
	 * @param residentialNo1 the residentialNo1 to set
	 */
	public void setResidentialNo1(String residentialNo1) {
		this.residentialNo1 = residentialNo1;
	}
	/**
	 * @return the residentialNo2
	 */
	public String getResidentialNo2() {
		return residentialNo2;
	}
	/**
	 * @param residentialNo2 the residentialNo2 to set
	 */
	public void setResidentialNo2(String residentialNo2) {
		this.residentialNo2 = residentialNo2;
	}
	/**
	 * @return the salary
	 */
	public String getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(String salary) {
		this.salary = salary;
	}
	/**
	 * @return the state1
	 */
	public String getState1() {
		return state1;
	}
	/**
	 * @param state1 the state1 to set
	 */
	public void setState1(String state1) {
		this.state1 = state1;
	}
	/**
	 * @return the state1code
	 */
	public String getState1code() {
		return state1code;
	}
	/**
	 * @param state1code the state1code to set
	 */
	public void setState1code(String state1code) {
		this.state1code = state1code;
	}
	/**
	 * @return the state1desc
	 */
	public String getState1desc() {
		return state1desc;
	}
	/**
	 * @param state1desc the state1desc to set
	 */
	public void setState1desc(String state1desc) {
		this.state1desc = state1desc;
	}
	
	/**
	 * @return the state2
	 */
	public String getState2() {
		return state2;
	}
	/**
	 * @param state2 the state2 to set
	 */
	public void setState2(String state2) {
		this.state2 = state2;
	}
	/**
	 * @return the state2code
	 */
	public String getState2code() {
		return state2code;
	}
	/**
	 * @param state2code the state2code to set
	 */
	public void setState2code(String state2code) {
		this.state2code = state2code;
	}
	/**
	 * @return the state2desc
	 */
	public String getState2desc() {
		return state2desc;
	}
	/**
	 * @param state2desc the state2desc to set
	 */
	public void setState2desc(String state2desc) {
		this.state2desc = state2desc;
	}
	
	/**
	 * @return the communityList
	 */
	public ArrayList getCommunityList() {
		return communityList;
	}
	/**
	 * @param communityList the communityList to set
	 */
	public void setCommunityList(ArrayList communityList) {
		this.communityList = communityList;
	}
	/**
	 * @return the district1List
	 */
	public ArrayList getDistrict1List() {
		return district1List;
	}
	/**
	 * @param district1List the district1List to set
	 */
	public void setDistrict1List(ArrayList district1List) {
		this.district1List = district1List;
	}
	/**
	 * @return the district2List
	 */
	public ArrayList getDistrict2List() {
		return district2List;
	}
	/**
	 * @param district2List the district2List to set
	 */
	public void setDistrict2List(ArrayList district2List) {
		this.district2List = district2List;
	}
	/**
	 * @return the religionList
	 */
	public ArrayList getReligionList() {
		return religionList;
	}
	/**
	 * @param religionList the religionList to set
	 */
	public void setReligionList(ArrayList religionList) {
		this.religionList = religionList;
	}
	/**
	 * @return the state1List
	 */
	public ArrayList getState1List() {
		return state1List;
	}
	/**
	 * @param state1List the state1List to set
	 */
	public void setState1List(ArrayList state1List) {
		this.state1List = state1List;
	}
	/**
	 * @return the state2List
	 */
	public ArrayList getState2List() {
		return state2List;
	}
	/**
	 * @param state2List the state2List to set
	 */
	public void setState2List(ArrayList state2List) {
		this.state2List = state2List;
	}
	/**
	 * @return the temporaryAddress
	 */
	public String getTemporaryAddress() {
		return temporaryAddress;
	}
	/**
	 * @param temporaryAddress the temporaryAddress to set
	 */
	public void setTemporaryAddress(String temporaryAddress) {
		this.temporaryAddress = temporaryAddress;
	}
	/**
	 * @return the district1desc
	 */
	public String getDistrict1desc() {
		return district1desc;
	}
	/**
	 * @param district1desc the district1desc to set
	 */
	public void setDistrict1desc(String district1desc) {
		this.district1desc = district1desc;
	}
	/**
	 * @return the district2desc
	 */
	public String getDistrict2desc() {
		return district2desc;
	}
	/**
	 * @param district2desc the district2desc to set
	 */
	public void setDistrict2desc(String district2desc) {
		this.district2desc = district2desc;
	}
	/**
	 * @return the seqid
	 */
	public String getSeqid() {
		return seqid;
	}
	/**
	 * @param seqid the seqid to set
	 */
	public void setSeqid(String seqid) {
		this.seqid = seqid;
	}
	public String getDriverdesc() {
		return driverdesc;
	}
	public void setDriverdesc(String driverdesc) {
		this.driverdesc = driverdesc;
	}
	public String getDrivercode() {
		return drivercode;
	}
	public void setDrivercode(String drivercode) {
		this.drivercode = drivercode;
	}
	public ArrayList getDriveridList() {
		return driveridList;
	}
	public void setDriveridList(ArrayList driveridList) {
		this.driveridList = driveridList;
	}
	
	
	
	
}
