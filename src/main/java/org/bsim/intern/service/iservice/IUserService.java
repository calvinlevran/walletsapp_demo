package org.bsim.intern.service.iservice;

import org.bsim.intern.shared.dto.UserDTO;

import java.util.List;

public interface IUserService {
    // get all users
    List<UserDTO> getListUser();
    // get single user
    UserDTO getUserByUsername(String username);
    // add new user
    UserDTO addNewData(UserDTO user);
}
