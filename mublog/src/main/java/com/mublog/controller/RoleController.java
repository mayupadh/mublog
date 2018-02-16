package com.mublog.controller;


import java.util.List;

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
import org.springframework.web.util.UriComponentsBuilder;

import com.mublog.entity.Role;
import com.mublog.exception.InstanceNotFoundException;
import com.mublog.service.RoleService;
  
@RestController
public class RoleController {
  
    @Autowired
    RoleService roleService;  //Service which will do all data retrieval/manipulation work
  
     
    //-------------------Retrieve All Roles--------------------------------------------------------
      
    @RequestMapping(value = "/roleDetails", method = RequestMethod.GET)
    public ResponseEntity<List<Role>> listAllRoles() {
        List<Role> roles = roleService.findAll();
        if(roles.isEmpty()){
            return new ResponseEntity<List<Role>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Role>>(roles, HttpStatus.OK);
    }
  
  
     
    //-------------------Retrieve Single Role--------------------------------------------------------
      
    @RequestMapping(value = "/roleDetails/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Role> getRole(@PathVariable("id") long id) throws InstanceNotFoundException {
        System.out.println("Fetching Role with id " + id);
        Role role = roleService.findById(id);
        if (role == null) {
            System.out.println("Role with id " + id + " not found");
            return new ResponseEntity<Role>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Role>(role, HttpStatus.OK);
    }
  
      
      
    //-------------------Create a Role--------------------------------------------------------
      
    @RequestMapping(value = "/roleDetails", method = RequestMethod.POST)
    public ResponseEntity<Void> createRole(@RequestBody Role role,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Role " + role.getRoleName());
  
        if (roleService.isRoleExist(role)) {
            System.out.println("A Role with name " + role.getRoleName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
  
        roleService.save(role);
  
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/role/{id}").buildAndExpand(role.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
  
     
      
    //------------------- Update a Role --------------------------------------------------------
      
    @RequestMapping(value = "/roleDetails/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Role> updateRole(@PathVariable("id") long id, @RequestBody Role role) throws InstanceNotFoundException {
        System.out.println("Updating Role " + id);
          
        Role currentRole = roleService.findById(id);
          
        if (currentRole==null) {
            System.out.println("Role with id " + id + " not found");
            return new ResponseEntity<Role>(HttpStatus.NOT_FOUND);
        }
  
        currentRole.setRoleName(role.getRoleName());
     
        roleService.update(currentRole);
        return new ResponseEntity<Role>(currentRole, HttpStatus.OK);
    }
  
     
     
    //------------------- Delete a Role --------------------------------------------------------
      
    @RequestMapping(value = "/roleDetails/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Role> deleteRole(@PathVariable("id") long id) throws InstanceNotFoundException {
        System.out.println("Fetching & Deleting Role with id " + id);
  
        Role role = roleService.findById(id);
        if (role == null) {
            System.out.println("Unable to delete. Role with id " + id + " not found");
            return new ResponseEntity<Role>(HttpStatus.NOT_FOUND);
        }
  
        roleService.deleteById(id);
        return new ResponseEntity<Role>(HttpStatus.NO_CONTENT);
    }
  
      
     
    //------------------- Delete All Roles --------------------------------------------------------
      
   /* @RequestMapping(value = "/roleDetails", method = RequestMethod.DELETE)
    public ResponseEntity<Role> deleteAllRoles() {
        System.out.println("Deleting All Roles");
  
        roleService.deleteAllRoles();
        return new ResponseEntity<Role>(HttpStatus.NO_CONTENT);
    }*/
  
}
