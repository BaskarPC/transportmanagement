package com.formbean;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;
public class TyreRequisitionForm extends ValidatorForm{
	private String code=null;
	private String ctype=null;
	private String des=null;
	private String date=null;
	private String from=null;
	private ArrayList tyreTypeList;
	private ArrayList tyreSizeList;
	private ArrayList tyrePlyList;
	private ArrayList tyrePartsList;
	private ArrayList approveStatusList;
	private String vehicleNo=null;
	private String tyreType1=null;
	private String tyreType2=null;
	private String tyreType3=null;
	private String tyreType4=null;
	private String tyreType5=null;
	private String tyreSize1=null;
	private String tyreSize2=null;
	private String tyreSize3=null;
	private String tyreSize4=null;
	private String tyreSize5=null;
	private String tyrePly1=null;
	private String tyrePly2=null;
	private String tyrePly3=null;
	private String tyrePly4=null;
	private String tyrePly5=null;
	private String[] tyreParts1=null;
	private String[] tyreParts2=null;
	private String[] tyreParts3=null;
	private String[] tyreParts4=null;
	private String[] tyreParts5=null;
	private String qtyAvailable1=null;
	private String qtyAvailable2=null;
	private String qtyAvailable3=null;
	private String qtyAvailable4=null;
	private String qtyAvailable5=null;
	private String needQty1=null;
	private String needQty2=null;
	private String needQty3=null;
	private String needQty4=null;
	private String needQty5=null;
	private String approveStatus1;
	private String approveStatus2;
	private String approveStatus3;
	private String approveStatus4;
	private String approveStatus5;
	private String newTyreType1;
	private String newTyreSize1;
	private String newTyrePly1;
	private String newTyreParts1;
	private String newNeededQty1;
	private String newApproveStatus1;
	private String newTyreType2;
	private String newTyreSize2;
	private String newTyrePly2;
	private String newTyreParts2;
	private String newNeededQty2;
	private String newApproveStatus2;
	private String newTyreType3;
	private String newTyreSize3;
	private String newTyrePly3;
	private String newTyreParts3;
	private String newNeededQty3;
	private String newApproveStatus3;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getNeedQty1() {
		return needQty1;
	}
	public void setNeedQty1(String needQty1) {
		this.needQty1 = needQty1;
	}
	public String getNeedQty2() {
		return needQty2;
	}
	public void setNeedQty2(String needQty2) {
		this.needQty2 = needQty2;
	}
	public String getNeedQty3() {
		return needQty3;
	}
	public void setNeedQty3(String needQty3) {
		this.needQty3 = needQty3;
	}
	public String getNeedQty4() {
		return needQty4;
	}
	public void setNeedQty4(String needQty4) {
		this.needQty4 = needQty4;
	}
	public String getNeedQty5() {
		return needQty5;
	}
	public void setNeedQty5(String needQty5) {
		this.needQty5 = needQty5;
	}
	public String getQtyAvailable1() {
		return qtyAvailable1;
	}
	public void setQtyAvailable1(String qtyAvailable1) {
		this.qtyAvailable1 = qtyAvailable1;
	}
	public String getQtyAvailable2() {
		return qtyAvailable2;
	}
	public void setQtyAvailable2(String qtyAvailable2) {
		this.qtyAvailable2 = qtyAvailable2;
	}
	public String getQtyAvailable3() {
		return qtyAvailable3;
	}
	public void setQtyAvailable3(String qtyAvailable3) {
		this.qtyAvailable3 = qtyAvailable3;
	}
	public String getQtyAvailable4() {
		return qtyAvailable4;
	}
	public void setQtyAvailable4(String qtyAvailable4) {
		this.qtyAvailable4 = qtyAvailable4;
	}
	public String getQtyAvailable5() {
		return qtyAvailable5;
	}
	public void setQtyAvailable5(String qtyAvailable5) {
		this.qtyAvailable5 = qtyAvailable5;
	}

	public String[] getTyreParts1() {
		return tyreParts1;
	}
	public void setTyreParts1(String[] tyreParts1) {
		this.tyreParts1 = tyreParts1;
	}
	public String[] getTyreParts2() {
		return tyreParts2;
	}
	public void setTyreParts2(String[] tyreParts2) {
		this.tyreParts2 = tyreParts2;
	}
	public String[] getTyreParts3() {
		return tyreParts3;
	}
	public void setTyreParts3(String[] tyreParts3) {
		this.tyreParts3 = tyreParts3;
	}
	public String[] getTyreParts4() {
		return tyreParts4;
	}
	public void setTyreParts4(String[] tyreParts4) {
		this.tyreParts4 = tyreParts4;
	}
	public String[] getTyreParts5() {
		return tyreParts5;
	}
	public void setTyreParts5(String[] tyreParts5) {
		this.tyreParts5 = tyreParts5;
	}
	public String getTyrePly1() {
		return tyrePly1;
	}
	public void setTyrePly1(String tyrePly1) {
		this.tyrePly1 = tyrePly1;
	}
	public String getTyrePly2() {
		return tyrePly2;
	}
	public void setTyrePly2(String tyrePly2) {
		this.tyrePly2 = tyrePly2;
	}
	public String getTyrePly3() {
		return tyrePly3;
	}
	public void setTyrePly3(String tyrePly3) {
		this.tyrePly3 = tyrePly3;
	}
	public String getTyrePly4() {
		return tyrePly4;
	}
	public void setTyrePly4(String tyrePly4) {
		this.tyrePly4 = tyrePly4;
	}
	public String getTyrePly5() {
		return tyrePly5;
	}
	public void setTyrePly5(String tyrePly5) {
		this.tyrePly5 = tyrePly5;
	}
	public String getTyreSize1() {
		return tyreSize1;
	}
	public void setTyreSize1(String tyreSize1) {
		this.tyreSize1 = tyreSize1;
	}
	public String getTyreSize2() {
		return tyreSize2;
	}
	public void setTyreSize2(String tyreSize2) {
		this.tyreSize2 = tyreSize2;
	}
	public String getTyreSize3() {
		return tyreSize3;
	}
	public void setTyreSize3(String tyreSize3) {
		this.tyreSize3 = tyreSize3;
	}
	public String getTyreSize4() {
		return tyreSize4;
	}
	public void setTyreSize4(String tyreSize4) {
		this.tyreSize4 = tyreSize4;
	}
	public String getTyreSize5() {
		return tyreSize5;
	}
	public void setTyreSize5(String tyreSize5) {
		this.tyreSize5 = tyreSize5;
	}
	public String getTyreType1() {
		return tyreType1;
	}
	public void setTyreType1(String tyreType1) {
		this.tyreType1 = tyreType1;
	}
	public String getTyreType2() {
		return tyreType2;
	}
	public void setTyreType2(String tyreType2) {
		this.tyreType2 = tyreType2;
	}
	public String getTyreType3() {
		return tyreType3;
	}
	public void setTyreType3(String tyreType3) {
		this.tyreType3 = tyreType3;
	}
	public String getTyreType4() {
		return tyreType4;
	}
	public void setTyreType4(String tyreType4) {
		this.tyreType4 = tyreType4;
	}
	public String getTyreType5() {
		return tyreType5;
	}
	public void setTyreType5(String tyreType5) {
		this.tyreType5 = tyreType5;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public ArrayList getTyrePartsList() {
		return tyrePartsList;
	}
	public void setTyrePartsList(ArrayList tyrePartsList) {
		this.tyrePartsList = tyrePartsList;
	}
	public ArrayList getTyrePlyList() {
		return tyrePlyList;
	}
	public void setTyrePlyList(ArrayList tyrePlyList) {
		this.tyrePlyList = tyrePlyList;
	}
	public ArrayList getTyreSizeList() {
		return tyreSizeList;
	}
	public void setTyreSizeList(ArrayList tyreSizeList) {
		this.tyreSizeList = tyreSizeList;
	}
	public ArrayList getTyreTypeList() {
		return tyreTypeList;
	}
	public void setTyreTypeList(ArrayList tyreTypeList) {
		this.tyreTypeList = tyreTypeList;
	}
	public String getApproveStatus1() {
		return approveStatus1;
	}
	public void setApproveStatus1(String approveStatus1) {
		this.approveStatus1 = approveStatus1;
	}
	public String getApproveStatus2() {
		return approveStatus2;
	}
	public void setApproveStatus2(String approveStatus2) {
		this.approveStatus2 = approveStatus2;
	}
	public String getApproveStatus3() {
		return approveStatus3;
	}
	public void setApproveStatus3(String approveStatus3) {
		this.approveStatus3 = approveStatus3;
	}
	public String getApproveStatus4() {
		return approveStatus4;
	}
	public void setApproveStatus4(String approveStatus4) {
		this.approveStatus4 = approveStatus4;
	}
	public String getApproveStatus5() {
		return approveStatus5;
	}
	public void setApproveStatus5(String approveStatus5) {
		this.approveStatus5 = approveStatus5;
	}
	public ArrayList getApproveStatusList() {
		return approveStatusList;
	}
	public void setApproveStatusList(ArrayList approveStatusList) {
		this.approveStatusList = approveStatusList;
	}
	public String getNewApproveStatus1() {
		return newApproveStatus1;
	}
	public void setNewApproveStatus1(String newApproveStatus1) {
		this.newApproveStatus1 = newApproveStatus1;
	}
	public String getNewApproveStatus2() {
		return newApproveStatus2;
	}
	public void setNewApproveStatus2(String newApproveStatus2) {
		this.newApproveStatus2 = newApproveStatus2;
	}
	public String getNewApproveStatus3() {
		return newApproveStatus3;
	}
	public void setNewApproveStatus3(String newApproveStatus3) {
		this.newApproveStatus3 = newApproveStatus3;
	}
	public String getNewNeededQty1() {
		return newNeededQty1;
	}
	public void setNewNeededQty1(String newNeededQty1) {
		this.newNeededQty1 = newNeededQty1;
	}
	public String getNewNeededQty2() {
		return newNeededQty2;
	}
	public void setNewNeededQty2(String newNeededQty2) {
		this.newNeededQty2 = newNeededQty2;
	}
	public String getNewNeededQty3() {
		return newNeededQty3;
	}
	public void setNewNeededQty3(String newNeededQty3) {
		this.newNeededQty3 = newNeededQty3;
	}
	public String getNewTyreParts1() {
		return newTyreParts1;
	}
	public void setNewTyreParts1(String newTyreParts1) {
		this.newTyreParts1 = newTyreParts1;
	}
	public String getNewTyreParts2() {
		return newTyreParts2;
	}
	public void setNewTyreParts2(String newTyreParts2) {
		this.newTyreParts2 = newTyreParts2;
	}
	public String getNewTyreParts3() {
		return newTyreParts3;
	}
	public void setNewTyreParts3(String newTyreParts3) {
		this.newTyreParts3 = newTyreParts3;
	}
	public String getNewTyrePly1() {
		return newTyrePly1;
	}
	public void setNewTyrePly1(String newTyrePly1) {
		this.newTyrePly1 = newTyrePly1;
	}
	public String getNewTyrePly2() {
		return newTyrePly2;
	}
	public void setNewTyrePly2(String newTyrePly2) {
		this.newTyrePly2 = newTyrePly2;
	}
	public String getNewTyrePly3() {
		return newTyrePly3;
	}
	public void setNewTyrePly3(String newTyrePly3) {
		this.newTyrePly3 = newTyrePly3;
	}
	public String getNewTyreSize1() {
		return newTyreSize1;
	}
	public void setNewTyreSize1(String newTyreSize1) {
		this.newTyreSize1 = newTyreSize1;
	}
	public String getNewTyreSize2() {
		return newTyreSize2;
	}
	public void setNewTyreSize2(String newTyreSize2) {
		this.newTyreSize2 = newTyreSize2;
	}
	public String getNewTyreSize3() {
		return newTyreSize3;
	}
	public void setNewTyreSize3(String newTyreSize3) {
		this.newTyreSize3 = newTyreSize3;
	}
	public String getNewTyreType1() {
		return newTyreType1;
	}
	public void setNewTyreType1(String newTyreType1) {
		this.newTyreType1 = newTyreType1;
	}
	public String getNewTyreType2() {
		return newTyreType2;
	}
	public void setNewTyreType2(String newTyreType2) {
		this.newTyreType2 = newTyreType2;
	}
	public String getNewTyreType3() {
		return newTyreType3;
	}
	public void setNewTyreType3(String newTyreType3) {
		this.newTyreType3 = newTyreType3;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}

}
