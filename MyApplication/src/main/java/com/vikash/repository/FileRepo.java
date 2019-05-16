package com.vikash.repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.data.repository.CrudRepository;

import com.vikash.modal.Fileupload;
import com.vikash.modal.User;

public interface FileRepo extends CrudRepository<Fileupload, Integer> {
	
	//public File FindByUsername(String hashvalue);
	
	//public List<Fileupload> FindByUsername(String Username);
	
	public Fileupload findById(int id);
	//public ArrayList<Fileupload> findByHashvalue(String hashvalue);
	public Fileupload findByHashvalue(String hashvalue);

	//public Fileupload findByUsername(String username);
	public ArrayList<Fileupload> findByUsername(String username);
	public ArrayList<Fileupload> findByFilename(String filename);
	//public ArrayList<Fileupload> editByHashvalue(String hashvalue);
}
