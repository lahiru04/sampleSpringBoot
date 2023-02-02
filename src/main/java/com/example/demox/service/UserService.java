package com.example.demox.service;

import com.example.demox.dto.UserDTO;
import com.example.demox.entity.User;
import com.example.demox.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    public UserDTO saveUser(UserDTO userDTO) {
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepo.findAll();

        return modelMapper.map(users, new TypeToken<List<UserDTO>>() {
        }.getType());
    }

    public UserDTO updateUser(UserDTO userDTO) {
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public boolean deleteUser(UserDTO userDTO) {
        userRepo.delete(modelMapper.map(userDTO, User.class));
        return true;
    }

    public UserDTO getUserByUserId(int id) {
        User user = userRepo.getUserByUserId(id);
        return modelMapper.map(user, UserDTO.class);
    }

    public UserDTO getUserByUserIdAndAddress(int id,String address) {
        User user = userRepo.getUserByUserIdAndAddress(id,address);
        return modelMapper.map(user, UserDTO.class);
    }
}
