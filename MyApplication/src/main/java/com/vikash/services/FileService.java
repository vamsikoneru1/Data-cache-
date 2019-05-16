package com.vikash.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.vikash.modal.Fileupload;
import com.vikash.modal.User;
import com.vikash.repository.FileRepo;


@Service
@Transactional
public class FileService {

	private final FileRepo fr;

	public FileService(FileRepo fr) {
		super();
		this.fr = fr;
	}
	
	public List<Fileupload> showAllData(){
		List<Fileupload> fileuploads = new ArrayList<Fileupload>();
		for(Fileupload fr : fr.findAll()) {
			fileuploads.add(fr);
		}
		
		return fileuploads;
}
}
