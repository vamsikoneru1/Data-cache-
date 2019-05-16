package com.vikash.modal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="file")
public class Fileupload {

	@Id
	private int id;
	private byte[] file;
	private String username;
	private String filename;
	private String awspath;
	private String cachepath;
	private long awstime;
	private long dbdoownload;
	private long cachedownload;
	private long rurbytes;
	private String region;
	private String type;
	private String downloadname;
	public String getAwspath() {
		return awspath;
	}
	public void setAwspath(String awspath) {
		this.awspath = awspath;
	}
	private String hashvalue;
	private String hitormiss;
	private long dbtime;
	
	
	
	
	public long getDbdoownload() {
		return dbdoownload;
	}
	public void setDbdoownload(long dbdoownload) {
		this.dbdoownload = dbdoownload;
	}
	public long getCachedownload() {
		return cachedownload;
	}
	public void setCachedownload(long cachedownload) {
		this.cachedownload = cachedownload;
	}
	public long getRurbytes() {
		return rurbytes;
	}
	public void setRurbytes(long rurbytes) {
		this.rurbytes = rurbytes;
	}
	public String getHitormiss() {
		return hitormiss;
	}
	public void setHitormiss(String hitormiss) {
		this.hitormiss = hitormiss;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDownloadname() {
		return downloadname;
	}
	public void setDownloadname(String downloadname) {
		this.downloadname = downloadname;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCachepath() {
		return cachepath;
	}
	public void setCachepath(String cachepath) {
		this.cachepath = cachepath;
	}
	public long getAwstime() {
		return awstime;
	}
	public void setAwstime(long awstime) {
		this.awstime = awstime;
	}
	public long getDbtime() {
		return dbtime;
	}
	public void setDbtime(long dbtime) {
		this.dbtime = dbtime;
	}
	public String getHashvalue() {
		return hashvalue;
	}
	public void setHashvalue(String hashvalue) {
		this.hashvalue = hashvalue;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
