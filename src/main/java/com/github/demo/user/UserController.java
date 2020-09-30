package com.github.demo.user;

import com.github.demo.sms.SmsService;
import com.github.jsoncat.annotation.Autowired;
import com.github.jsoncat.annotation.GetMapping;
import com.github.jsoncat.annotation.PathVariable;
import com.github.jsoncat.annotation.PostMapping;
import com.github.jsoncat.annotation.RequestBody;
import com.github.jsoncat.annotation.RequestParam;
import com.github.jsoncat.annotation.RestController;

import java.util.List;

/**
 * @author shuang.kou
 * @createTime 2020年09月24日 14:52:00
 **/
@RestController("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public User get(@RequestParam("name") String name, @RequestParam("des") String des, @RequestParam("age") Integer age) {
        return new User(name, des, age);
    }

    @GetMapping("/{id}")
    public User get(@PathVariable("id") Integer id) {
        return userService.get(id);
    }

    @PostMapping
    public List<User> create(@RequestBody UserDto userDto) {
        return userService.create(userDto);
    }
}
