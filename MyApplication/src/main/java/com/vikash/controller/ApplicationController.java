package com.vikash.controller;

import java.awt.image.BufferedImage;
import org.apache.commons.codec.binary.Base64;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Stream;
import java.lang.Object;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.google.common.primitives.Bytes;
import com.google.common.util.concurrent.RateLimiter;
import com.mysql.jdbc.Blob;
//import com.example.demo.user;
import com.vikash.modal.Fileupload;
//import com.example.demo.user;
import com.vikash.modal.User;
import com.vikash.repository.FileRepo;
import com.vikash.repository.UserRepository;
import com.vikash.services.FileService;
import com.vikash.services.UserService;

import antlr.collections.List;

@Controller
public class ApplicationController {

	@Autowired
	UserService userService;
	
	@Autowired
	FileService fileservice;
	
	@Autowired
	FileRepo filerepo;
	
	@ModelAttribute("user")
	public User setUpUserForm() {
	   return new User();
	}
	
	
String name="";
	
	@Autowired 
	UserRepository ur1;
	@RequestMapping("/welcome")
	public String Welcome(HttpServletRequest request,@ModelAttribute("user") User user) {
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}

	@RequestMapping("/register")
	public String registration(HttpServletRequest request,@ModelAttribute("user") User user) {
		
		{
		request.setAttribute("mode", "MODE_REGISTER");
		
		return "welcomepage";
		}
		
	}
	
	@RequestMapping("/register-user")
	public String registrationuser(HttpServletRequest request,@ModelAttribute("user") User user) {
		if(user.getFirstname()!=null && user.getLastname()!=null&& user.getPassword()!=null & user.getUsername()!=null)
		{
		request.setAttribute("mode", "MODE_REGISTER");
		
		return "welcomepage";
		}
		else
		{
			request.setAttribute("error", "Please fill all the details");
			request.setAttribute("mode", "MODE_REGISTER");
			return "welcomepage";
		}
	}
	
	@RequestMapping("/corenetwork")
	public String corenetwork(HttpServletRequest request,@ModelAttribute("user") User user) {
		request.setAttribute("mode", "CORE_NETWORK");
		return "homepage";
		
	}
	@RequestMapping("/advantage")
	public String advantage(HttpServletRequest request,@ModelAttribute("user") User user) {
		request.setAttribute("mode", "Advantage");
		return "advantage";
	}
	@RequestMapping("/edgenetwork")
	public String edgenetwork(HttpServletRequest request,@ModelAttribute("user") User user) {
		request.setAttribute("mode", "EDGE_NETWORK");
		return "homepage";
	}

	
	
	
	@PostMapping("/save-user")
	public String registerUser(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {
		userService.saveMyUser(user);
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}
	
	@RequestMapping("/downloadbargraph")
	public String downloadbargraph(Model model,@ModelAttribute("user") User user,HttpServletRequest request,@ModelAttribute("upload") Fileupload upload) {
		Map<Integer,Integer> map1=new HashMap<>();

		
		ArrayList<Fileupload> fp = new ArrayList<Fileupload>();
		for(Fileupload f : filerepo.findAll())
		{
			if(f.getUsername().equalsIgnoreCase(name) && f.getCachepath()!=null)
			{
			fp.add(f);
			break;
			}
//			map1.put((int)f.getDbtime(),(int) f.getAwstime());
			//System.out.println(f.getAwspath());
			}
		request.setAttribute("udata", fp);
//		map1.put(2,10000);
//		model.addAttribute("map1", map1);
//		System.out.println("inside bar");
		
		return"downloadbar";
		}
	
	@RequestMapping("/piechartgraph")
	public String bargraph(Model model,@ModelAttribute("user") User user,HttpServletRequest request,@ModelAttribute("upload") Fileupload upload) {
		Map<Integer,Integer> map1=new HashMap<>();

		
		ArrayList<Fileupload> fp = new ArrayList<Fileupload>();
		for(Fileupload f : filerepo.findAll())
		{
			
			if(f.getUsername().equalsIgnoreCase(name) && f.getCachepath()!=null )
			{
			fp.add(f);
			}
//			map1.put((int)f.getDbtime(),(int) f.getAwstime());
			//System.out.println(f.getAwspath());
			}
		request.setAttribute("udata", fp);
//		map1.put(2,10000);
//		model.addAttribute("map1", map1);
//		System.out.println("inside bar");
		
		return"piechartgraph";
		}
	@RequestMapping("/geochartgraph")
	public String awsbargraph(Model model,@ModelAttribute("user") User user,HttpServletRequest request,@ModelAttribute("upload") Fileupload upload) {
		Map<Integer,Integer> map1=new HashMap<>();

		
		ArrayList<Fileupload> fp = new ArrayList<Fileupload>();
		for(Fileupload f : filerepo.findAll())
		{
			
			if(f.getUsername().equalsIgnoreCase(name) && f.getCachepath()!=null )
			{
			fp.add(f);
			}
//			map1.put((int)f.getDbtime(),(int) f.getAwstime());
			//System.out.println(f.getAwspath());
			}
		request.setAttribute("udata", fp);
//		map1.put(2,10000);
//		model.addAttribute("map1", map1);
//		System.out.println("inside bar");
		
		return"geochartgraph";
		}
		
	@RequestMapping("/bargraph")
	public String bargraph1(Model model,@ModelAttribute("user") User user,HttpServletRequest request,@ModelAttribute("upload") Fileupload upload) {
		Map<Integer,Integer> map1=new HashMap<>();

		
		ArrayList<Fileupload> fp = new ArrayList<Fileupload>();
		for(Fileupload f : filerepo.findAll())
		{
			
			if(f.getUsername().equalsIgnoreCase(name) && f.getCachepath()!=null )
			{
			fp.add(f);
			}
//			map1.put((int)f.getDbtime(),(int) f.getAwstime());
			//System.out.println(f.getAwspath());
			}
		request.setAttribute("udata", fp);
//		map1.put(2,10000);
//		model.addAttribute("map1", map1);
//		System.out.println("inside bar");
		
		return"bargraph";
		}
	@RequestMapping("/linechartgraph")
	public String linechartgraph(Model model,@ModelAttribute("user") User user,HttpServletRequest request,@ModelAttribute("upload") Fileupload upload) {
		Map<Integer,Integer> map1=new HashMap<>();

		
		ArrayList<Fileupload> fp = new ArrayList<Fileupload>();
		for(Fileupload f : filerepo.findAll())
		{
			
			if(f.getUsername().equalsIgnoreCase(name) && f.getCachepath()!=null )
			{
			fp.add(f);
			}
//			map1.put((int)f.getDbtime(),(int) f.getAwstime());
			//System.out.println(f.getAwspath());
			}
		request.setAttribute("udata", fp);
//		map1.put(2,10000);
//		model.addAttribute("map1", map1);
//		System.out.println("inside bar");
		
		return"linechartgraph";
		}
	
	
	@RequestMapping("/dgraph")
	public String dgraph(Model model,@ModelAttribute("user") User user,HttpServletRequest request,@ModelAttribute("upload") Fileupload upload) {
		Map<Integer,Integer> map1=new HashMap<>();

		
		ArrayList<Fileupload> fp = new ArrayList<Fileupload>();
		for(Fileupload f : filerepo.findAll())
		{
			
			if(f.getUsername().equalsIgnoreCase(name) && f.getCachepath()!=null)
			{
			fp.add(f);
			}
//			map1.put((int)f.getDbtime(),(int) f.getAwstime());
			//System.out.println(f.getAwspath());
			}
		request.setAttribute("udata", fp);
//		map1.put(2,10000);
//		model.addAttribute("map1", map1);
//		System.out.println("inside bar");
		
		return"areagraph";
		}
	
	@RequestMapping("/Graph")
	public String Graph(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {
		userService.saveMyUser(user);
		request.setAttribute("mode", "MODE_HOME");
		return "Graph";
	}

	

	@GetMapping("/show-users")
	public String showAllUsers(HttpServletRequest request,@ModelAttribute("user") User user) {
		request.setAttribute("users", userService.showAllUsers());
		request.setAttribute("mode", "ALL_USERS");
		request.setAttribute("firstname", user.getFirstname());
		return "welcomepage";
	}
	
	
	@RequestMapping("/index")
	public String hello() {
		return "index1";
	}
	@RequestMapping("/dl")
	public String hello1() {
		return "download";
	}

	
	@RequestMapping("/delete-user")
	public String deleteUser(@RequestParam int id, HttpServletRequest request,@ModelAttribute("user") User user) {
		userService.deleteMyUser(id);
		request.setAttribute("users", userService.showAllUsers());
		request.setAttribute("mode", "ALL_USERS");
		request.setAttribute("firstname", user.getFirstname());
		return "welcomepage";
	}
	

	@RequestMapping("/delete-cache")
	public String deleteCache(@RequestParam int id, HttpServletRequest request,@ModelAttribute("user") User user) {
		//filerepo.delete(id);
		Fileupload f=filerepo.findById(id);
		
		f.setCachepath(null);
		filerepo.save(f);
	
		//request.setAttribute("users", userService.showAllUsers());
		//request.setAttribute("mode", "ALL_USERS");
		//request.setAttribute("firstname", user.getFirstname());
		return "upload";
	}
	
	@RequestMapping("/edit-user")
	public String editUser(@RequestParam int id,HttpServletRequest request,@ModelAttribute("user") User user) {
		request.setAttribute("user", userService.editUser(id));
		request.setAttribute("firstname", user.getFirstname());
		request.setAttribute("mode", "MODE_UPDATE");
		return "welcomepage";
	}
	
	@RequestMapping("/login")
	public String login(@ModelAttribute("user") User user, BindingResult bindingresult, HttpServletRequest request) {
		request.setAttribute("firstname", user.getFirstname());
		
		request.setAttribute("mode", "MODE_LOGIN");
		return "welcomepage";
	}
	
	@RequestMapping ("/login-user")
	public String loginUser(@ModelAttribute User user, HttpServletRequest request) {
		if(userService.findByUsernameAndPassword(user.getUsername(), user.getPassword())!=null) {
			request.setAttribute("firstname", ur1.findByUsername(user.getUsername()).getFirstname());
			user.setUsername(user.getUsername());
			name=user.getUsername();
			//System.out.println(user.getUsername());
			return "homepage";
		}
		else {
			request.setAttribute("error", "Invalid Username or Password");
			request.setAttribute("mode", "MODE_LOGIN");
			return "welcomepage";
			
		}
	}
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request)
	{
		return "welcomepage";
	}
	@GetMapping("/uploaddata")
	public String showAllUplodData(@ModelAttribute("user") User user,HttpServletRequest request,@ModelAttribute("upload") Fileupload upload) {
		//request.setAttribute("uploads", fileservice.showAllData());
		request.setAttribute("mode", "ALL_DATA");
		//request.setAttribute("username", "vamsi");
		
		System.out.println(user.getUsername());
		ArrayList<Fileupload> fp = new ArrayList<Fileupload>();
		for(Fileupload f : filerepo.findAll())
		{
			if(f.getUsername().equalsIgnoreCase(name) && f.getCachepath()!=null)
			{
			fp.add(f);
			//System.out.println(f.getAwspath());
			}
		}
		request.setAttribute("udata", fp);
		
		return "upload";
	}
	@RequestMapping(value="/allimages2")
    public String downloads3(@ModelAttribute("user") User user,HttpServletRequest request,@ModelAttribute("download") Fileupload download) throws IOException, NoSuchAlgorithmException
    {	
		request.setAttribute("mode", "DOWNLOAD_DATA");
		System.out.println(user.getUsername());
		ArrayList<Fileupload> fp = new ArrayList<Fileupload>();
		Blob b=null;
	    long millis = System.currentTimeMillis();
	    
	    String base64Encoded = null;
	    int flag=1;
		
		for(Fileupload f : filerepo.findAll())
		{    
			String dname=f.getDownloadname();
			System.out.println("print"+f.getUsername()+name);
			
			
			if( f.getDownloadname()!=null && f.getFilename().equals(dname) )
			{
				
				if(f.getCachepath()==null || f.getFile()==null)
				{
				f.setHitormiss("cache miss");
				f.setHitormiss("cache miss");
				long millis1 = System.currentTimeMillis();
				long y=millis1;
				f.setCachedownload(y);
				f.setCachepath(f.getAwspath());
				f.setDbdoownload(0);
				request.setAttribute("check", flag);
				}
				
				else
				{
					f.setHitormiss("cache hit");
					flag=0;
					Base64 base64=new Base64();
					 byte[] encodeBase64 = base64.encode(f.getFile());
					 base64Encoded = new String(encodeBase64, "UTF-8");
					 request.setAttribute("check", flag);
					 long millis2 = System.currentTimeMillis();
						long x=millis2-millis;
						f.setDbdoownload(x);
						f.setCachedownload(0);
					 
				}
				
				
				filerepo.save(f);
				
				
					fp.add(f);
					
					
					System.out.println(f.getAwspath());
					break;
					
			}
		}
		
		
		
		request.setAttribute("img123", base64Encoded);
		
		
		request.setAttribute("allimages1", fp);
		request.setAttribute("ddata", fp);
		
		
		return "allimages";
    }
	
	@RequestMapping(value="/downlaod")
	public String download(@ModelAttribute("user") User user,HttpServletRequest request,@RequestParam("filename") String fileupload)
	{
		System.out.println(user.getUsername());
		ArrayList<Fileupload> fp = new ArrayList<Fileupload>();
		System.out.println(fileupload);

		
		for(Fileupload f : filerepo.findAll())
		{    
			
			{
			f.setDownloadname(fileupload);
			filerepo.save(f);
			}
//			System.out.println("print"+f.getUsername()+name);
//			if(f.getUsername().equalsIgnoreCase(name) && f.getFilename()==fileupload)
//			{
//			fp.add(f);
//			System.out.println(f.getAwspath());
//			}
		}
		
		//request.setAttribute("allimages2", fp);

		return "homepage";
	}
    
	
	
	@PostMapping(value="/uploadrural")
    public ModelAndView uploadr3(@RequestParam("file") MultipartFile image,@ModelAttribute("user") User user,HttpServletRequest request, @RequestParam("region") String fileupload) throws IOException, NoSuchAlgorithmException
    {
		String reg="";
		String cache="";
		if(fileupload.equalsIgnoreCase("Virginia"))
		{
			
			reg="US_EAST_1";
			cache="cache1-usnv";
			
			
			
			LocalTime time = LocalTime.now();
		    long millis = System.currentTimeMillis();
			System.out.println(fileupload);
			Fileupload fileup = new Fileupload();
			ModelAndView indexPage= new ModelAndView();
			System.out.println("image path is "+ image.getOriginalFilename());
	       BasicAWSCredentials cred= new BasicAWSCredentials("AKIAJD34JQF3UMIB5LHQ","l8GoBuag+RrSKYhlzj1thgW0fj+EBPQ1ddf5mQks");
	       Fileupload f=new Fileupload();
	       f.setFile(image.getBytes());
	       f.setUsername(name );
	       f.setFilename(image.getOriginalFilename());
	       f.setRegion("United States");
	       InputStream in = new ByteArrayInputStream(image.getBytes()); 
	final MessageDigest messageDigest = MessageDigest.getInstance("SHA1");

	{
	final byte[] buffer = new byte[1024];
	for (int read = 0; (read = in.read(buffer)) != -1;) {
	  messageDigest.update(buffer, 0, read);
	}
	}

	// Convert the byte to hex format
	try (Formatter formatter = new Formatter()) {
	for (final byte b : messageDigest.digest()) {
	  formatter.format("%02x", b);
	}

	String hv=formatter.toString();
	System.out.println( hv);


		f.setHashvalue(hv);
		LocalTime time1 = LocalTime.now();
	    
	    System.out.println("321456");

	    RateLimiter rateLimiter = RateLimiter.create(500); 

	    
	    byte[] img1=image.getBytes(); 
	    
	    int j=0;
	    while (j<=image.getSize()) {
			    //byte[] line = img
			    System.out.println("bytes length" + img1.length);
			    //for (; i < img1.length; i+=500) {
			        byte[] bytes = image.getBytes();
			        rateLimiter.acquire(500);
			        j=j+500;
			        System.out.println(j+ " bytes reading" );
			        //f.setFile(line);
			    //}
			}
	    long millis1 = System.currentTimeMillis();
	    long diff=millis1-millis;
	    f.setDbtime(diff);
	    f.setType("rural");
	  
	    {
	 
	    {
	   
	    {
	        AmazonS3 client=AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(cred)).withRegion(Regions.valueOf(reg)).build();
	     


	        
	        PutObjectRequest put= new PutObjectRequest(cache,image.getOriginalFilename(),image.getInputStream(), new ObjectMetadata()).withCannedAcl(CannedAccessControlList.PublicRead);
			client.putObject(put);
	        String imgSrc1 = "http://"+cache+".s3.amazonaws.com/"+image.getOriginalFilename();
	        System.out.println(imgSrc1);
	        //filerepo.save(f);
	        indexPage.addObject("imgSrc",imgSrc1);
	        indexPage.setViewName("upload");
	        RateLimiter rateLimiter1 = RateLimiter.create(500); 
	       // byte[] img1=image.getBytes(); 
		    int i=0;
		    j=0;
		    while (j<=image.getSize()) {
				    //byte[] line = img
				    System.out.println("bytes length" + img1.length);
				    //for (; i < img1.length; i+=500) {
				        byte[] bytes = image.getBytes();
				        rateLimiter1.acquire(500);
				        j=j+500;
				        System.out.println(j+ " bytes reading" );
				        //f.setFile(line);
				    //}
				}
	        
	        long millis2 = System.currentTimeMillis();
	        long awstime=Math.abs(millis2-millis);
	        System.out.println("aws time 2-1"+ Math.abs(millis2-millis1));
	        System.out.println("aws time 2-0"+ Math.abs(millis2-millis1));

	        System.out.println("db time"+ diff);

	       // Fileupload fu=filerepo.findByHashvalue(hv);
	       f.setAwstime(awstime);
	       f.setAwspath(imgSrc1);
	       f.setCachepath(imgSrc1);
	       f.setType("rural");
	       filerepo.save(f); 
	        
	       return indexPage;
	    }
	    }
	    }
	}
		}
		
		else if(fileupload.equalsIgnoreCase("india"))
		{
			reg="AP_SOUTH_1";
			cache="cache2-usnv";
			
			
			LocalTime time = LocalTime.now();
		    long millis = System.currentTimeMillis();
			System.out.println(fileupload);
			Fileupload fileup = new Fileupload();
			ModelAndView indexPage= new ModelAndView();
			System.out.println("image path is "+ image.getOriginalFilename());
	       BasicAWSCredentials cred= new BasicAWSCredentials("AKIAJD34JQF3UMIB5LHQ","l8GoBuag+RrSKYhlzj1thgW0fj+EBPQ1ddf5mQks");
	       Fileupload f=new Fileupload();
	       f.setFile(image.getBytes());
	       f.setUsername(name );
	       f.setFilename(image.getOriginalFilename());
	       f.setRegion(fileupload);
	       InputStream in = new ByteArrayInputStream(image.getBytes()); 
	final MessageDigest messageDigest = MessageDigest.getInstance("SHA1");

	{
	final byte[] buffer = new byte[1024];
	for (int read = 0; (read = in.read(buffer)) != -1;) {
	  messageDigest.update(buffer, 0, read);
	}
	}

	// Convert the byte to hex format
	try (Formatter formatter = new Formatter()) {
	for (final byte b : messageDigest.digest()) {
	  formatter.format("%02x", b);
	}

	String hv=formatter.toString();
	System.out.println( hv);


		f.setHashvalue(hv);
		LocalTime time1 = LocalTime.now();
	    
	    System.out.println("321456");

	    RateLimiter rateLimiter = RateLimiter.create(240); 

	    
	    byte[] img1=image.getBytes(); 
	    byte[] img2 = null; 
	    int i=0;
	    int j=0;
	   
	    while (j<=image.getSize()) {
			    //byte[] line = img
			    System.out.println("bytes length" + img1.length);
			    //for (; i < img1.length; i+=500) {
			       byte[] bytes = image.getBytes();
			        rateLimiter.acquire(240);
			        img2[i]=bytes[i];
			        j=j+240;
			        System.out.println(j+"bytes" );
			        //f.setFile(line);
			    //}
			}
	    long millis1 = System.currentTimeMillis();
	    long diff=millis1-millis;
	    f.setDbtime(diff);
	    f.setType("rural");
	  
	    {
	 
	    {
	   
	    {
	        AmazonS3 client=AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(cred)).withRegion(Regions.valueOf(reg)).build();
	     


	        
	        PutObjectRequest put= new PutObjectRequest(cache,image.getOriginalFilename(),image.getInputStream(), new ObjectMetadata()).withCannedAcl(CannedAccessControlList.PublicRead);
			client.putObject(put);
	        String imgSrc1 = "http://"+cache+".s3.amazonaws.com/"+image.getOriginalFilename();
	        System.out.println(imgSrc1);
	        //filerepo.save(f);
	        indexPage.addObject("imgSrc",imgSrc1);
	        indexPage.setViewName("upload");
	        RateLimiter rateLimiter1 = RateLimiter.create(240); 

		    
		    //byte[] img1=image.getBytes(); 
		     i=0;
		     j=0;
		    while (j<=image.getSize()) {
				    //byte[] line = img
				    System.out.println("bytes length" + img1.length);
				    //for (; i < img1.length; i+=500) {
				        byte[] bytes = image.getBytes();
				        rateLimiter1.acquire(240);
				        j=j+240;
				        System.out.println(j+ " bytes reading" );
				        //f.setFile(line);
				    //}
				}
	        long millis2 = System.currentTimeMillis();
	        long awstime=Math.abs(millis2-millis);
	        System.out.println("aws time 2-1"+ Math.abs(millis2-millis1));
	        System.out.println("aws time 2-0"+ Math.abs(millis2-millis1));

	        System.out.println("db time"+ diff);

	       // Fileupload fu=filerepo.findByHashvalue(hv);
	       f.setAwstime(awstime);
	       f.setAwspath(imgSrc1);
	       f.setCachepath(imgSrc1);
	       f.setType("rural");
	       filerepo.save(f); 
	        
	       return indexPage;
	    }
	    }
	    }
	}
		}
		else if(fileupload.equalsIgnoreCase("Australia"))
		{
			reg="AP_SOUTHEAST_2";
			cache="cache4-usnv";
			
			LocalTime time = LocalTime.now();
		    long millis = System.currentTimeMillis();
			System.out.println(fileupload);
			Fileupload fileup = new Fileupload();
			ModelAndView indexPage= new ModelAndView();
			System.out.println("image path is "+ image.getOriginalFilename());
	       BasicAWSCredentials cred= new BasicAWSCredentials("AKIAJD34JQF3UMIB5LHQ","l8GoBuag+RrSKYhlzj1thgW0fj+EBPQ1ddf5mQks");
	       Fileupload f=new Fileupload();
	       f.setFile(image.getBytes());
	       f.setUsername(name );
	       f.setFilename(image.getOriginalFilename());
	       f.setRegion(fileupload);
	       InputStream in = new ByteArrayInputStream(image.getBytes()); 
	final MessageDigest messageDigest = MessageDigest.getInstance("SHA1");

	{
	final byte[] buffer = new byte[1024];
	for (int read = 0; (read = in.read(buffer)) != -1;) {
	  messageDigest.update(buffer, 0, read);
	}
	}

	// Convert the byte to hex format
	try (Formatter formatter = new Formatter()) {
	for (final byte b : messageDigest.digest()) {
	  formatter.format("%02x", b);
	}

	String hv=formatter.toString();
	System.out.println( hv);


		f.setHashvalue(hv);
		LocalTime time1 = LocalTime.now();
	    
	    System.out.println("321456");

	    RateLimiter rateLimiter = RateLimiter.create(300); 

	    
	    byte[] img1=image.getBytes(); 
	    int i=0;
	    int j=0;
	    while (j<=image.getSize()) {
			    //byte[] line = img
			    System.out.println("bytes length" + img1.length);
			    //for (; i < img1.length; i+=500) {
			        byte[] bytes = image.getBytes();
			        rateLimiter.acquire(300);
			        j=j+300;
			        System.out.println(j+ " bytes reading" );
			        //f.setFile(line);
			    //}
			}
	    long millis1 = System.currentTimeMillis();
	    long diff=millis1-millis;
	    f.setDbtime(diff);
	    f.setType("rural");
	  
	    {
	 
	    {
	   
	    {
	        AmazonS3 client=AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(cred)).withRegion(Regions.valueOf(reg)).build();
	     


	        
	        PutObjectRequest put= new PutObjectRequest(cache,image.getOriginalFilename(),image.getInputStream(), new ObjectMetadata()).withCannedAcl(CannedAccessControlList.PublicRead);
			client.putObject(put);
	        String imgSrc1 = "http://"+cache+".s3.amazonaws.com/"+image.getOriginalFilename();
	        System.out.println(imgSrc1);
	        //filerepo.save(f);
	        indexPage.addObject("imgSrc",imgSrc1);
	        indexPage.setViewName("upload");
	        RateLimiter rateLimiter1 = RateLimiter.create(300); 

		    
		   // byte[] img1=image.getBytes(); 
	        i=0;
		    j=0;
		    while (j<=image.getSize()) {
				    //byte[] line = img
				    System.out.println("bytes length" + img1.length);
				    //for (; i < img1.length; i+=500) {
				        byte[] bytes = image.getBytes();
				        rateLimiter1.acquire(300);
				        j=j+300;
				        System.out.println(j+ " bytes reading" );
				        //f.setFile(line);
				    //}
				}
	        long millis2 = System.currentTimeMillis();
	        long awstime=Math.abs(millis2-millis);
	        System.out.println("aws time 2-1"+ Math.abs(millis2-millis1));
	        System.out.println("aws time 2-0"+ Math.abs(millis2-millis1));

	        System.out.println("db time"+ diff);

	       // Fileupload fu=filerepo.findByHashvalue(hv);
	       f.setAwstime(awstime);
	       f.setAwspath(imgSrc1);
	       f.setCachepath(imgSrc1);
	       f.setType("rural");
	       filerepo.save(f); 
	        
	       return indexPage;
	    }
	    }
	    }
	}
	
		}
		else if(fileupload.equalsIgnoreCase("Franfurt"))
		{
			reg="EU_CENTRAL_1";
			cache="cache3-usnv";
			
			LocalTime time = LocalTime.now();
		    long millis = System.currentTimeMillis();
			System.out.println(fileupload);
			Fileupload fileup = new Fileupload();
			ModelAndView indexPage= new ModelAndView();
			System.out.println("image path is "+ image.getOriginalFilename());
	       BasicAWSCredentials cred= new BasicAWSCredentials("AKIAJD34JQF3UMIB5LHQ","l8GoBuag+RrSKYhlzj1thgW0fj+EBPQ1ddf5mQks");
	       Fileupload f=new Fileupload();
	       f.setFile(image.getBytes());
	       f.setUsername(name );
	       f.setFilename(image.getOriginalFilename());
	       f.setRegion("Germany");
	       InputStream in = new ByteArrayInputStream(image.getBytes()); 
	final MessageDigest messageDigest = MessageDigest.getInstance("SHA1");

	{
	final byte[] buffer = new byte[1024];
	for (int read = 0; (read = in.read(buffer)) != -1;) {
	  messageDigest.update(buffer, 0, read);
	}
	}

	// Convert the byte to hex format
	try (Formatter formatter = new Formatter()) {
	for (final byte b : messageDigest.digest()) {
	  formatter.format("%02x", b);
	}

	String hv=formatter.toString();
	System.out.println( hv);


		f.setHashvalue(hv);
		LocalTime time1 = LocalTime.now();
	    
	    System.out.println("321456");

	    RateLimiter rateLimiter = RateLimiter.create(150); 

	    
	    byte[] img1=image.getBytes(); 
	    int i=0;
	    int j=0;
	    while (j<=image.getSize()) {
			    //byte[] line = img
			    System.out.println("bytes length" + img1.length);
			    //for (; i < img1.length; i+=500) {
			        byte[] bytes = image.getBytes();
			        rateLimiter.acquire(150);
			        j=j+150;
			        System.out.println(j+ " bytes reading" );
			        //f.setFile(line);
			    //}
			}
	    long millis1 = System.currentTimeMillis();
	    long diff=millis1-millis;
	    f.setDbtime(diff);
	    f.setType("rural");
	  
	    {
	 
	    {
	   
	    {
	        AmazonS3 client=AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(cred)).withRegion(Regions.valueOf(reg)).build();
	     


	        
	        PutObjectRequest put= new PutObjectRequest(cache,image.getOriginalFilename(),image.getInputStream(), new ObjectMetadata()).withCannedAcl(CannedAccessControlList.PublicRead);
			client.putObject(put);
	        String imgSrc1 = "http://"+cache+".s3.amazonaws.com/"+image.getOriginalFilename();
	        System.out.println(imgSrc1);
	        //filerepo.save(f);
	        indexPage.addObject("imgSrc",imgSrc1);
	        indexPage.setViewName("upload");
	        RateLimiter rateLimiter1 = RateLimiter.create(150); 

		    
		   // byte[] img1=image.getBytes(); 
		    i=0;
		    j=0;
		    while (j<=image.getSize()) {
				    //byte[] line = img
				    System.out.println("bytes length" + img1.length);
				    //for (; i < img1.length; i+=500) {
				        byte[] bytes = image.getBytes();
				        rateLimiter1.acquire(150);
				        j=j+150;
				        System.out.println(j+ " bytes reading" );
				        //f.setFile(line);
				    //}
				}
	        long millis2 = System.currentTimeMillis();
	        long awstime=Math.abs(millis2-millis);
	        System.out.println("aws time 2-1"+ Math.abs(millis2-millis1));
	        System.out.println("aws time 2-0"+ Math.abs(millis2-millis1));

	        System.out.println("db time"+ diff);

	       // Fileupload fu=filerepo.findByHashvalue(hv);
	       f.setAwstime(awstime);
	       f.setAwspath(imgSrc1);
	       f.setCachepath(imgSrc1);
	       f.setType("rural");
	       filerepo.save(f); 
	        
	       return indexPage;
	    }
	    }
	    }
	}
		}
		else if(fileupload.equalsIgnoreCase("south america"))
		{
			reg="SA_EAST_1";
			cache="cache5-usnv";
			
			
			LocalTime time = LocalTime.now();
		    long millis = System.currentTimeMillis();
			System.out.println(fileupload);
			Fileupload fileup = new Fileupload();
			ModelAndView indexPage= new ModelAndView();
			System.out.println("image path is "+ image.getOriginalFilename());
	       BasicAWSCredentials cred= new BasicAWSCredentials("AKIAJD34JQF3UMIB5LHQ","l8GoBuag+RrSKYhlzj1thgW0fj+EBPQ1ddf5mQks");
	       Fileupload f=new Fileupload();
	       f.setFile(image.getBytes());
	       f.setUsername(name );
	       f.setFilename(image.getOriginalFilename());
	       f.setRegion("brazil");
	       InputStream in = new ByteArrayInputStream(image.getBytes()); 
	final MessageDigest messageDigest = MessageDigest.getInstance("SHA1");

	{
	final byte[] buffer = new byte[1024];
	for (int read = 0; (read = in.read(buffer)) != -1;) {
	  messageDigest.update(buffer, 0, read);
	}
	}

	// Convert the byte to hex format
	try (Formatter formatter = new Formatter()) {
	for (final byte b : messageDigest.digest()) {
	  formatter.format("%02x", b);
	}

	String hv=formatter.toString();
	System.out.println( hv);


		f.setHashvalue(hv);
		LocalTime time1 = LocalTime.now();
	    
	    System.out.println("321456");

	    RateLimiter rateLimiter = RateLimiter.create(165); 

	    
	    byte[] img1=image.getBytes(); 
	    int i=0;
	    int j=0;
	    while (j<=image.getSize()) {
			    //byte[] line = img
			    System.out.println("bytes length" + img1.length);
			    //for (; i < img1.length; i+=500) {
			        byte[] bytes = image.getBytes();
			        rateLimiter.acquire(165);
			        j=j+165;
			        System.out.println(j+ " bytes reading" );
			        //f.setFile(line);
			    //}
			}
	    long millis1 = System.currentTimeMillis();
	    long diff=millis1-millis;
	    f.setDbtime(diff);
	    f.setType("rural");
	  
	    {
	 
	    {
	   
	    {
	        AmazonS3 client=AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(cred)).withRegion(Regions.valueOf(reg)).build();
	     


	        
	        PutObjectRequest put= new PutObjectRequest(cache,image.getOriginalFilename(),image.getInputStream(), new ObjectMetadata()).withCannedAcl(CannedAccessControlList.PublicRead);
			client.putObject(put);
	        String imgSrc1 = "http://"+cache+".s3.amazonaws.com/"+image.getOriginalFilename();
	        System.out.println(imgSrc1);
	        //filerepo.save(f);
	        indexPage.addObject("imgSrc",imgSrc1);
	        indexPage.setViewName("upload");
	        RateLimiter rateLimiter1 = RateLimiter.create(165); 

		    
		  //  byte[] img1=image.getBytes(); 
		    i=0;
		    j=0;
		    while (j<=image.getSize()) {
				    //byte[] line = img
				    System.out.println("bytes length" + img1.length);
				    //for (; i < img1.length; i+=500) {
				        byte[] bytes = image.getBytes();
				        rateLimiter1.acquire(165);
				        j=j+165;
				        System.out.println(j+ " bytes reading" );
				        //f.setFile(line);
				    //}
				}
	        long millis2 = System.currentTimeMillis();
	        long awstime=Math.abs(millis2-millis);
	        System.out.println("aws time 2-1"+ Math.abs(millis2-millis1));
	        System.out.println("aws time 2-0"+ Math.abs(millis2-millis1));

	        System.out.println("db time"+ diff);

	       // Fileupload fu=filerepo.findByHashvalue(hv);
	       f.setAwstime(awstime);
	       f.setAwspath(imgSrc1);
	       f.setCachepath(imgSrc1);
	       f.setType("rural");
	       filerepo.save(f); 
	        
	       return indexPage;
	    }
	    }
	    }
	}
		}
		else
		{
			reg="US_EAST_1";
			cache="cache1-usnv";
			
			
			LocalTime time = LocalTime.now();
		    long millis = System.currentTimeMillis();
			System.out.println(fileupload);
			Fileupload fileup = new Fileupload();
			ModelAndView indexPage= new ModelAndView();
			System.out.println("image path is "+ image.getOriginalFilename());
	       BasicAWSCredentials cred= new BasicAWSCredentials("AKIAJD34JQF3UMIB5LHQ","l8GoBuag+RrSKYhlzj1thgW0fj+EBPQ1ddf5mQks");
	       Fileupload f=new Fileupload();
	       f.setFile(image.getBytes());
	       f.setUsername(name );
	       f.setFilename(image.getOriginalFilename());
	       f.setRegion("United States");
	       InputStream in = new ByteArrayInputStream(image.getBytes()); 
	final MessageDigest messageDigest = MessageDigest.getInstance("SHA1");

	{
	final byte[] buffer = new byte[1024];
	for (int read = 0; (read = in.read(buffer)) != -1;) {
	  messageDigest.update(buffer, 0, read);
	}
	}

	// Convert the byte to hex format
	try (Formatter formatter = new Formatter()) {
	for (final byte b : messageDigest.digest()) {
	  formatter.format("%02x", b);
	}

	String hv=formatter.toString();
	System.out.println( hv);


		f.setHashvalue(hv);
		LocalTime time1 = LocalTime.now();
	    
	    System.out.println("321456");

	    RateLimiter rateLimiter = RateLimiter.create(10000); 

	    
	    byte[] img1=image.getBytes(); 
	    int i=0;
	    int j=0;
	    while (j<=image.getSize()) {
			    //byte[] line = img
			    System.out.println("bytes length" + img1.length);
			    //for (; i < img1.length; i+=500) {
			        byte[] bytes = image.getBytes();
			        rateLimiter.acquire(1000);
			        j=j+1000;
			        System.out.println(j+ " bytes reading" );
			        //f.setFile(line);
			    //}
			}
	    long millis1 = System.currentTimeMillis();
	    long diff=millis1-millis;
	    f.setDbtime(diff);
	    f.setType("rural");
	  
	    {
	 
	    {
	   
	    {
	        AmazonS3 client=AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(cred)).withRegion(Regions.valueOf(reg)).build();
	     


	        
	        PutObjectRequest put= new PutObjectRequest(cache,image.getOriginalFilename(),image.getInputStream(), new ObjectMetadata()).withCannedAcl(CannedAccessControlList.PublicRead);
			client.putObject(put);
	        String imgSrc1 = "http://"+cache+".s3.amazonaws.com/"+image.getOriginalFilename();
	        System.out.println(imgSrc1);
	        //filerepo.save(f);
	        indexPage.addObject("imgSrc",imgSrc1);
	        indexPage.setViewName("upload");
	        
	        long millis2 = System.currentTimeMillis();
	        long awstime=Math.abs(millis2-millis1);
	        System.out.println("aws time 2-1"+ Math.abs(millis2-millis1));
	        System.out.println("aws time 2-0"+ Math.abs(millis2-millis1));

	        System.out.println("db time"+ diff);

	       // Fileupload fu=filerepo.findByHashvalue(hv);
	       f.setAwstime(awstime);
	       f.setAwspath(imgSrc1);
	       f.setCachepath(imgSrc1);
	       f.setType("rural");
	       filerepo.save(f); 
	        
	       return indexPage;
	    }
	    }
	    }
	}
		}
		
		
		
		
    }
    
	
	
	
	@PostMapping(value="/uploadurban")
    public ModelAndView uploads3(@RequestParam("file") MultipartFile image,@ModelAttribute("user") User user,HttpServletRequest request, @RequestParam("region") String fileupload ,@RequestParam("rurbytes") int rurbyt) throws IOException, NoSuchAlgorithmException
    {  
		
		String reg="";
		String cache="";
		if(fileupload.equalsIgnoreCase("Virginia"))
		{
			
			reg="US_EAST_1";
			cache="cache1-usnv";
			fileupload="United States";
		}
		else if(fileupload.equalsIgnoreCase("india"))
		{
			reg="AP_SOUTH_1";
			cache="cache2-usnv";
			fileupload="India";
		}
		else if(fileupload.equalsIgnoreCase("Australia"))
		{
			reg="AP_SOUTHEAST_2";
			cache="cache4-usnv";
			fileupload="Australia";
		}
		else if(fileupload.equalsIgnoreCase("Franfurt"))
		{
			reg="EU_CENTRAL_1";
			cache="cache3-usnv";
			fileupload="Germany";
		}
		else if(fileupload.equalsIgnoreCase("south america"))
		{
			reg="SA_EAST_1";
			cache="cache5-usnv";
			fileupload="Brazil";
		}
		else
		{
			reg="US_EAST_1";
			cache="cache1-usnv";
			fileupload="United States";
		}
		
		
		
		LocalTime time = LocalTime.now();
	    long millis = System.currentTimeMillis();
		System.out.println(fileupload);
		Fileupload fileup = new Fileupload();
		ModelAndView indexPage= new ModelAndView();
		System.out.println("image path is "+ image.getOriginalFilename());
       BasicAWSCredentials cred= new BasicAWSCredentials("AKIAJD34JQF3UMIB5LHQ","l8GoBuag+RrSKYhlzj1thgW0fj+EBPQ1ddf5mQks");
       Fileupload f=new Fileupload();
       f.setFile(image.getBytes());
       f.setUsername(name );
       f.setFilename(image.getOriginalFilename());
       f.setRegion(fileupload);
       f.setRurbytes(rurbyt);
       InputStream in = new ByteArrayInputStream(image.getBytes()); 
final MessageDigest messageDigest = MessageDigest.getInstance("SHA1");

{
final byte[] buffer = new byte[1024];
for (int read = 0; (read = in.read(buffer)) != -1;) {
  messageDigest.update(buffer, 0, read);
}
}

// Convert the byte to hex format
try (Formatter formatter = new Formatter()) {
for (final byte b : messageDigest.digest()) {
  formatter.format("%02x", b);
}

String hv=formatter.toString();
System.out.println( hv);

if(rurbyt!=0)
{
RateLimiter rateLimiter = RateLimiter.create(rurbyt); 


byte[] img1=image.getBytes(); 
int i=0;
int j=0;
while (j<=image.getSize()) {
	    //byte[] line = img
	    System.out.println("bytes length" + img1.length);
	    //for (; i < img1.length; i+=500) {
	        byte[] bytes = image.getBytes();
	        rateLimiter.acquire(rurbyt);
	        j=j+rurbyt;
	        System.out.println(j+ " bytes reading" );
	        //f.setFile(line);
	    //}
	}
}
	f.setHashvalue(hv);
	LocalTime time1 = LocalTime.now();
    long millis1 = System.currentTimeMillis();
    System.out.println("321456");

    long diff=millis1-millis;
    f.setDbtime(diff);
  //     filerepo.save(f);
    //Fileupload fu=filerepo.findByHashvalue(hv);
   // size= fu.size();
   // if(fu!=null)
    {
   // for(Fileupload f1 : fu )
    {
    //if(f1.getUsername().equalsIgnoreCase(name))
    {
        AmazonS3 client=AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(cred)).withRegion(Regions.valueOf(reg)).build();
     


        
        PutObjectRequest put= new PutObjectRequest(cache,image.getOriginalFilename(),image.getInputStream(), new ObjectMetadata()).withCannedAcl(CannedAccessControlList.PublicRead);
		client.putObject(put);
        String imgSrc1 = "http://"+cache+".s3.amazonaws.com/"+image.getOriginalFilename();
        System.out.println(imgSrc1);
        //filerepo.save(f);
        indexPage.addObject("imgSrc",imgSrc1);
        indexPage.setViewName("upload");
        if(rurbyt!=0)
        {
        RateLimiter rateLimiter = RateLimiter.create(rurbyt); 


        byte[] img1=image.getBytes(); 
        int i=0;
        int j=0;
        while (j<=image.getSize()) {
        	    //byte[] line = img
        	    System.out.println("bytes length" + img1.length);
        	    //for (; i < img1.length; i+=500) {
        	        byte[] bytes = image.getBytes();
        	        rateLimiter.acquire(rurbyt);
        	        j=j+rurbyt;
        	        System.out.println(j+ " bytes reading" );
        	        //f.setFile(line);
        	    //}
        	}
        }
        long millis2 = System.currentTimeMillis();
        long awstime=Math.abs(millis2-millis1);
        System.out.println("aws time 2-1"+ Math.abs(millis2-millis1));
        System.out.println("aws time 2-0"+ Math.abs(millis2-millis1));

        System.out.println("db time"+ diff);

       // Fileupload fu=filerepo.findByHashvalue(hv);
       f.setAwstime(awstime);
       f.setAwspath(imgSrc1);
       f.setCachepath(imgSrc1);
       f.setDbdoownload(0);
       f.setCachedownload(0);
       if(rurbyt==0)
       {
       f.setType("urban");
       }
       else
       {
    	   f.setType("rural");
       }
       filerepo.save(f); 
        
       return indexPage;
    }
    }
    }
   /*(fu==null )
    {
       
       AmazonS3 client=AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(cred)).withRegion(Regions.valueOf(reg)).build();
       RateLimiter rateLimiter1 = RateLimiter.create(100.0); 
          		 
    			
		PutObjectRequest put= new PutObjectRequest(cache,image.getOriginalFilename(),image.getInputStream(), new ObjectMetadata()).withCannedAcl(CannedAccessControlList.PublicRead);
		client.putObject(put);
        String imgSrc = "http://"+cache+".s3.amazonaws.com/"+image.getOriginalFilename();
        System.out.println(imgSrc);
        indexPage.addObject("imgSrc",imgSrc);
        indexPage.setViewName("index1");
        long millis2 = System.currentTimeMillis();
        long awstime=Math.abs(millis2-millis);
  
        
       f.setAwstime(awstime);
       f.setAwspath(imgSrc);
       f.setCachepath(imgSrc);
       filerepo.save(f); 
       

       return indexPage;
    }
      
    
    else
    {
    	indexPage.setViewName("homepage");
    	return indexPage;
    }
        
//       } catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
       
      //indexPage.setViewName("error");
      
    //  return indexPage;
       
   
      
    }
//return indexPage;

    }
	*/
	 

	
}
}
	}