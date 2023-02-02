package com.example.demox.controller;

import com.example.demox.dto.ResponseHandler;
import com.example.demox.dto.UserDTO;
import com.example.demox.service.UserService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(value = "api/v1/user")
@CrossOrigin
public class UserController  {

    private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    public List<UserDTO> getUser()
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",true);

        return userService.getAllUsers();
    }

    @PostMapping("/saveUser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO)
    {
        userService.saveUser(userDTO);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",true);

      //  return jsonObject.toString();

        return    userService.saveUser(userDTO);
    }

    @PatchMapping("/updateUser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO)
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",true);

     //   return jsonObject.toString();

        return    userService.updateUser(userDTO);
    }

     @DeleteMapping("/deleteUser")
     public  boolean deleteUser(@RequestBody UserDTO userDTO)
     {
         JSONObject jsonObject = new JSONObject();
         jsonObject.put("result",true);

       //  return jsonObject.toString();

         return  userService.deleteUser(userDTO);
     }

    @GetMapping("/getUsersByUserId")
    @ResponseBody
    public UserDTO getUserByUserId(@RequestParam int id)
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",true);

        return userService.getUserByUserId(id);
    }

    @GetMapping("/getUsersByUserIdAndAddress/{id}/{address}")
    public UserDTO getUserByUserIdAndAddress(@PathVariable int id,@PathVariable String address)
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",true);

        return userService.getUserByUserIdAndAddress(id,address);
    }



    @GetMapping("/test")
    public ResponseEntity<Object> getCusUser(@RequestParam int id) {
        LOGGER.info("Country list fetched");
        return ResponseHandler.generateResponse(HttpStatus.OK, true, "Success", userService.getUserByUserId(id));
    }
}
