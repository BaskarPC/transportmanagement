package com.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import oracle.jdbc.driver.OracleDriver;
import oracle.jdbc.driver.OracleResultSet;
import oracle.sql.BLOB;

import org.apache.log4j.Logger;
import org.apache.struts.upload.FormFile;

import com.dbcom.dbcom;
import com.vo.DieselRequisitionVO;

public class UploadDocDAO {
	private static final Logger logger=(Logger)Logger.getLogger(UploadDocDAO.class);
	dbcom db=new dbcom();
	ArrayList list=new ArrayList();
	public File retrieveFile(String strDocId, String strFilePath,String strFileName)
			{
		DieselRequisitionVO vo=new DieselRequisitionVO();
		logger.info("retrieveFile ------>>");
		OutputStream outstream = null;
		String docId = strDocId;
		String filePath = strFilePath;
		File fObj = null;
		BLOB blob = null;
		try {
			try{
				boolean isFilePath = ((filePath == null) || (filePath.length() == 0));

				logger.debug(" sERVICE ### docId " + docId);
				logger.debug(" sERVICE ### filePath " + filePath);
				logger.debug(" sERVICE ### strFileName " + strFileName);
				blob = fetchDocImage(docId);
				if (filePath.length() > 0) {
					if (!filePath.endsWith(File.separator)) {
						filePath += File.separator;
					}
					strFileName = filePath + strFileName;
				}
				logger.debug(" Service after IF ### strFileName "+ strFileName);
				fObj = new File(strFileName);
				outstream = new FileOutputStream(fObj);
				if (blob == null) {
					logger.debug("\n Whass Up!!!! blob is null");
				}
				byte[] buf = new byte[10240];
				long blobsize = blob.length();
				logger.debug("before for loop ::::::::" + blobsize);
				for (int jk = 1; jk < blobsize; jk = jk + 10240) {
					logger.debug("inside for");
					buf = blob.getBytes(jk, 10240);
					logger.debug("after get");
					outstream.write(buf);
					logger.debug("after write");

				}
				logger.debug("after for loop ::::::::");
				// outstream.close();
				if (!isFilePath) {
					outstream.flush();
					// outstream.close();
				}
			} finally {
				outstream.close();		
			}
			logger.info("retrieveFile <<------");
			
		} catch (Exception e) {
			logger.error("Error :", e);			
		}
		
	return fObj;
	}

	private BLOB fetchDocImage(String docId)
	{
logger.info("fetchDocImage ------>>");
BLOB blob = null;

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	try {
		
	DriverManager.registerDriver(new OracleDriver());
	conn = DriverManager.getConnection("jdbc:oracle:thin:@172.16.16.111:1521:ORCL02", "kectransport", "kectransport");
	logger.debug("AFTER CONNECTION");
	stmt = conn.createStatement();
	logger.debug("xx1");
	rs=stmt.executeQuery("select * from imagetable where id="+docId);
	logger.debug("rss" +rs);
	rs.next();
	logger.debug("rs test :"+rs);
	blob=((OracleResultSet)rs).getBLOB("image");
	logger.debug("bufffff sizeeeeeeee : "+blob.length());
	
} catch (Exception e) { logger.debug("exception "+e);}
logger.info("fetchDocImage <<--------");
return blob;
}
	
	public ArrayList getImageList() {
		logger.debug("getImageList :DieselRequisitionDAO <<<<<<<<<<<<<<< ");
		String query = "select id as imageid,image_name as imagename from imagetable where del_id=0";
		list = db.selectQuery("com.vo.DieselRequisitionVO", query);
		logger.debug("getImageList dao :list size.." + list.size());
		DieselRequisitionVO vo = (DieselRequisitionVO) list.get(0);
		logger.debug("getImageList :DieselRequisitionDAO : Record Fetched");
		logger.debug("getImageList :DieselRequisitionDAO >>>>>>>>>>>>>>> ");
		return list;

	}
	public int getsid()
	{ int x,sid;
		logger.debug("getsid <<<<<<<<<");
		ArrayList sidlist=db.selectQuery("com.vo.DieselRequisitionVO", "select MAX(id)as sid from IMAGETABLE");
		logger.debug("id size :"+sidlist.size());
		 x=sidlist.size();
		
			DieselRequisitionVO vo=(DieselRequisitionVO)sidlist.get(0);
		logger.debug("vosid"+vo.getSid());
		String strsid=vo.getSid();
		sid=Integer.parseInt(strsid);
		sid=sid+1;
		
		logger.debug("getsid >>>>>>>>>>>>>");
		return sid;
	
	}
	public void UploadFile(FormFile f,int jobid,int taskid)
	{
		logger.debug("UploadFile :DieselRequisitionDAO <<<<<<<<<<<<<<<< ");
	
	 int id=getsid();
	 logger.debug("id"+ id);
	 logger.debug("file name "+ f.getFileName());
			final String emptyquery="insert into imagetable values("+null+","+null+","+id+",'"+f.getFileName()+"',empty_blob(),0)";
			logger.debug("emp query "+ emptyquery);
			upload(f,id,emptyquery);
			
			
		logger.debug("upload :DieselRequisitionDAO : Record Inserted");
		logger.debug("upload :DieselRequisitionDAO >>>>>>>>>>>>>>> ");		
	}
	public void editMethod(FormFile f,String id) {
		logger.debug("editMethod :DieselRequisitionDAO <<<<<<<<<<<<<<< ");
		int id1=Integer.parseInt(id);
		String query="empty";
		upload(f,id1,query);
		logger.debug("id +++++ :"+id);
		logger.debug("editMethod :DieselRequisitionDAO : Record updated");
		logger.debug("editMethod :DieselRequisitionDAO >>>>>>>>>>>>>>> ");
		
	}
	public void upload(FormFile f,int id,String emptyquery)
	{
		logger.debug("upload :DieselRequisitionDAO <<<<<<<<<<<<<<<< ");
		logger.debug("id +++++ :"+id);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		InputStream is=null;
		OutputStream oso=null;
		BLOB blob = null;		
		try {
		DriverManager.registerDriver(new OracleDriver());
		conn = DriverManager.getConnection("jdbc:oracle:thin:@172.16.16.111:1521:ORCL02", "kectransport", "kectransport");
		logger.debug("AFTER CONNECTION");
		conn.setAutoCommit(false);
		stmt = conn.createStatement();
		logger.debug("AFTER stmt");
		if(!emptyquery.equals("empty"))
		{
		int insertrecord=stmt.executeUpdate(emptyquery);
		logger.debug("inserted records :"+insertrecord);
		}
		else
		{
			String updatequery="update imagetable set image_name='"+f.getFileName()+"',image=EMPTY_BLOB() where id="+id;
			logger.debug("update query "+ updatequery);
			int n=stmt.executeUpdate(updatequery);
			logger.debug("after update "+n);
		}
		
		logger.debug("AFTER if condition");
		final String query = "select id,image from imagetable where id = " +id+" for update" ;		
		logger.debug("sel query "+ query);
		
		rs = stmt.executeQuery(query);
		logger.debug("RS :"+rs);
		if(rs.next()) {
			logger.debug("INSIDE IF");
			blob = ((OracleResultSet)rs).getBLOB("image");
			oso=blob.getBinaryOutputStream();
			logger.debug("oso size :"+blob.length());
			is=f.getInputStream();
			logger.debug("is:"+is.available());
			final byte[] buf = new byte[32528];
			int readBytes=0;
			while((readBytes = is.read(buf)) != -1){
				logger.debug("while");
				oso.write(buf,0,readBytes);
			}
			oso.flush();
			logger.debug("bufffff BERFORE size : "+blob.length());
			conn.setAutoCommit(true);
			}
					}
	catch(SQLException e) {			
		logger.debug(e.getMessage());
	}
	catch(FileNotFoundException e) {			
		logger.debug(e.getMessage());
	}
	catch(Exception e) {			
		logger.debug(e.getMessage());
	}
	finally {
		/*
		* Clean up.
		*/
		try {
			
			if(oso != null) { oso.close(); }
			
			if(stmt != null) {
				stmt.close();
			}
			if(rs != null) {
				rs.close();
			}
			if(conn != null) {
				conn.commit();
				conn.close();
			}
			is = null;
		
			stmt = null;
			rs = null;
			conn = null;
			blob = null;
		}
		catch(Exception e) {
			
			logger.debug(e.getMessage());
		}
	}
	}
	public String fetchFilename(String strIndexDocID)
	{
		logger.debug("getimagelist :DieselRequisitionService <<<<<<<<<<<<<<< ");
		String query = "select image_name as imagename from imagetable where id="+Integer.parseInt(strIndexDocID);
		list = db.selectQuery("com.vo.DieselRequisitionVO", query);
		DieselRequisitionVO vo = (DieselRequisitionVO) list.get(0);
		String imagename=vo.getImageName();
		logger.debug("imagename :"+imagename);
		logger.debug("getimagelist :DieselRequisitionService >>>>>>>>>>>>>>> ");
		return imagename;
	}
	public ArrayList deleteImage(String imageName) {
		logger.debug("deleteImage :DieselRequisitionDAO <<<<<<<<<<<<<<< ");
		logger.debug("image id :::"+imageName);
		String query = "update imagetable set del_id=1 where id="+ Integer.parseInt(imageName);
		db.otherQuery(query);
		logger.debug("updated");
		logger.debug("deleteImage :DieselRequisitionDAO >>>>>>>>>>>>>>> ");
		return list;

	}
}
