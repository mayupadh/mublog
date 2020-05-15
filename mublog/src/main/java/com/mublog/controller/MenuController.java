package com.mublog.controller;


import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.UriComponentsBuilder;

import com.mublog.entity.Menu;
import com.mublog.exception.InstanceNotFoundException;
import com.mublog.service.MenuService;
import com.mublog.service.UserService;



  
@RestController
public class MenuController {
  
    @Autowired
    MenuService menuService;  //Service which will do all data retrieval/manipulation work
    
    @Autowired
    UserService userService;
    
    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
  
     
    //-------------------Retrieve All Menus--------------------------------------------------------
      
    @RequestMapping(value = "/menuDetails", method = RequestMethod.GET)
    public ResponseEntity<List<Menu>> listAllMenus() {
        List<Menu> menus = menuService.findAll();
        if(menus.isEmpty()){
            return new ResponseEntity<List<Menu>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Menu>>(menus, HttpStatus.OK);
    }
  
  
     
    //-------------------Retrieve Single Menu--------------------------------------------------------
      
    @RequestMapping(value = "/menuDetails/{id}", method = {RequestMethod.GET, RequestMethod.PUT}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Menu> getMenu(@PathVariable("id") long id) throws InstanceNotFoundException {
        System.out.println("Fetching Menu with id " + id);
        Menu menu = menuService.findById(id);
        if (menu == null) {
            System.out.println("Menu with id " + id + " not found");
            return new ResponseEntity<Menu>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Menu>(menu, HttpStatus.OK);
    }
  
      
      
    //-------------------Create a Menu--------------------------------------------------------
      
    @RequestMapping(value = "/menuDetails",method = RequestMethod.POST)
    public ResponseEntity<Menu> createMenu(@RequestBody Menu menu,UriComponentsBuilder ucBuilder) {
    	 logger.info("Creating Menu " + menu.getMenuName());
    	  
         if (menuService.isMenuExist(menu)) {
             logger.error("A menu with name " +menu.getMenuName()+ " already exist");
             return new ResponseEntity<Menu>(HttpStatus.CONFLICT);
         }
        
         menu.setCreatedBy("admin");
         menu.setCreatedBy("admin");
         menuService.save(menu);
   
         HttpHeaders headers = new HttpHeaders();
         headers.setLocation(ucBuilder.path("/menuDetails/{id}").buildAndExpand(menu.getId()).toUri());
         return new ResponseEntity<Menu>(menu, HttpStatus.CREATED);
    }
  
     
      
    //------------------- Update a Menu --------------------------------------------------------
      
    @RequestMapping(value = "/menuDetails/{id}", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<Menu> updateMenu(@PathVariable("id") long id, @RequestBody Menu menu) throws InstanceNotFoundException {
        System.out.println("Updating Menu " + id);
          
        Menu currentMenu = menuService.findById(id);
          
        if (currentMenu==null) {
            System.out.println("Menu with id " + id + " not found");
            return new ResponseEntity<Menu>(HttpStatus.NOT_FOUND);
        }
        currentMenu.setUpdatedBy("admin");
        currentMenu.setMenuName(menu.getMenuName());
        currentMenu.setMenuType(menu.getMenuType()); 
        currentMenu.setMenuDesc(menu.getMenuDesc());
        currentMenu.setParentId(menu.getParentId());
        menuService.update(currentMenu);
        return new ResponseEntity<Menu>(currentMenu, HttpStatus.OK);
    }
     
     
    //------------------- Delete a Menu --------------------------------------------------------
      
    @RequestMapping(value = "/menuDetails/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Menu> deleteMenu(@PathVariable("id") long id) throws InstanceNotFoundException {
        System.out.println("Fetching & Deleting Menu with id " + id);
  
        Menu menu = menuService.findById(id);
        if (menu == null) {
            System.out.println("Unable to delete. Menu with id " + id + " not found");
            return new ResponseEntity<Menu>(HttpStatus.NOT_FOUND);
        }
  
        menuService.deleteById(id);
        return new ResponseEntity<Menu>(HttpStatus.NO_CONTENT);
    }
  
      
     
    /*//------------------- Delete All Menus --------------------------------------------------------
      
    @RequestMapping(value = "/menuDetails", method = RequestMethod.DELETE)
    public ResponseEntity<Menu> deleteAllMenus() {
        System.out.println("Deleting All Menus");
  
        menuService.deleteAllMenus();
        return new ResponseEntity<Menu>(HttpStatus.NO_CONTENT);
    }*/
    
    //------------------- Upload Menu Icon --------------------------------------------------------
    @RequestMapping(value="/menuDetails/upload/{menuName}",headers = ("content-type=multipart/form-data"), method = RequestMethod.POST)
    public void uploadMenuLogo(@PathVariable String menuName,MultipartHttpServletRequest request, HttpServletResponse response){
    	System.out.println("Inside uploadMenuLogo method.");
    	Iterator<String> itr = request.getFileNames();
        MultipartFile file=null;
        while (itr.hasNext()) {
            file = request.getFile(itr.next());           
            if(file != null) {
        		Menu menu;
    			try {
    				menu = menuService.findByName(menuName);
    				menu.setMenuIcon(file.getBytes());
    				String fileName = file.getOriginalFilename();
    				menu.setIconName(fileName);
    				menuService.update(menu);
    			} catch (InstanceNotFoundException e) {
    				logger.error("Exception :"+e);
    				e.printStackTrace();
    			} catch (IOException e) {
    				logger.error("Exception :"+e);
    				e.printStackTrace();
    			}        		
        	}
            break;
        }
        
    }


  
}
