package com.example.demo.controller;

import com.example.demo.Responses;
import com.example.demo.UserView;
import com.example.demo.entity.User;
import com.example.demo.controller.base.BaseApiController;
import com.example.demo.repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * https://levelup.gitconnected.com/synchronize-backend-and-frontend-api-interfaces-the-swagger-way-at-the-push-of-a-button-e3b96dbf07cb
 * https://github.com/springfox/springfox/blob/master/springfox-petstore/src/main/java/springfox/petstore/controller/UserController.java
 *
 */
@javax.annotation.Generated(
  value = "io.swagger.codegen.languages.SpringCodegen",
  date = "2018-04-14T21:35:47.879+02:00"
)
@Controller
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
// don't do this in production ;)
@CrossOrigin(origins = "*")
@Api(value = "User", tags = { "User" })
public class UserApiController {//extends BaseApiController<User> {

  private UserRepository userRepository = new UserRepository();

  @RequestMapping(method = RequestMethod.POST)
  @ResponseBody
  @ApiOperation(value = "Create user", notes = "This can only be done by the logged in user.")
  public ResponseEntity<User> createUser(
          @RequestBody
          @ApiParam(value = "Created user object", required = true) User user) {

    userRepository.add(user);
    return Responses.ok();
  }

  @RequestMapping(value = "/{username}", method = RequestMethod.GET)
  @ApiOperation(value = "Get user by user name", response = User.class)
  @ApiResponses(value = {
          @ApiResponse(code = 400, message = "Invalid username supplied"),
          @ApiResponse(code = 404, message = "User not found") })
  public ResponseEntity<User> getUserByName(
          @ApiParam(value = "The name that needs to be fetched. Use user1 for testing. ", required = true)
          @PathVariable("username") String username) {
    User user = userRepository.get(username);
    if (null != user) {
      return Responses.ok(user);
      //return new ResponseEntity<>(user, HttpStatus.OK);
    } else {
      //throw new NotFoundException(404, "User not found");
      return Responses.notFound();
    }
  }

  @RequestMapping(value = "/{username}", method = RequestMethod.DELETE)
  @ApiOperation(value = "Delete user", notes = "This can only be done by the logged in user.")
  @ApiResponses(value = {
          @ApiResponse(code = 400, message = "Invalid username supplied"),
          @ApiResponse(code = 404, message = "User not found") })
  public ResponseEntity<String> deleteUser(
          @ApiParam(value = "The name that needs to be deleted", required = true) @PathVariable("username") String
                  username) {
    if (userRepository.exists(username)) {
      userRepository.delete(username);
      return Responses.ok();
    }
    return Responses.notFound();

  }


  @JsonView(UserView.Common.class)
  @ApiOperation(
    value = "Update user",
    nickname = "updateUser",
    notes = "This can only be done by the logged in user.",
    tags = { "User" },
    authorizations = { @Authorization(value = "apiKey") }
  )
  @ApiResponses(
    value = {
      @ApiResponse(code = 200, message = "OK"),
      @ApiResponse(code = 204, message = "No Content"),
      @ApiResponse(code = 400, message = "Invalid user supplied"),
      @ApiResponse(code = 401, message = "Unauthorized"),
      @ApiResponse(code = 403, message = "Forbidden"),
      @ApiResponse(code = 404, message = "User not found")
    }
  )
  @RequestMapping(
    value = "/{username}",
    method = RequestMethod.PUT
  )
  public ResponseEntity<User> update(
    @PathVariable("username") String username,
    @ApiParam(value = "User object") @Valid @RequestBody User object
  ) {
    // map DTO to Entity and save this into the DB.
    //return super.update(id, object, "resume");
    if (userRepository.get(username) != null) {
      userRepository.add(object);
      return Responses.ok();
    }
    return Responses.notFound();
  }
}