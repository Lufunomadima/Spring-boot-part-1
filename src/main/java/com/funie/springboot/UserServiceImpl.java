package com.funie.springboot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import static java.lang.String.format;

public class UserServiceImpl implements UserService{
    private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class.getName());
    // constructor dependency injection
    FakeRepoInterface fakeRepo;
    @Autowired
    public UserServiceImpl(FakeRepoInterface fakeRepo)
    {
        this.fakeRepo = fakeRepo;
    }

    @Override
    public String addUser(long id, String name, String surname) {
        fakeRepo.insertUser(1, name, surname);
        LOGGER.info(format("%s Entered", name));
        return name;
    }
    @Override
    public void remove(long id) {
        fakeRepo.deleteUser(id);
        LOGGER.info(format("%s removed", getUser(id) ));
    }
    @Override
    public long getUser(long id) {
        LOGGER.info("Hello " + fakeRepo.findById(id).getName());
        fakeRepo.findById(id);
        return id;
    }
}
