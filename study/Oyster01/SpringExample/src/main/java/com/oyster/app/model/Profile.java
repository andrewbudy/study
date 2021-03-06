package com.oyster.app.model;

import com.oyster.dao.annotation.Primary;
import com.oyster.dao.annotation.Stored;
import com.oyster.dao.annotation.utils.converter.LongConverter;

/**
 * @author bamboo
 * @since 4/15/14 10:32 PM
 */

@Stored(name = "PROFILE_TBL")
public class Profile {

    @Primary
    @Stored(name = "_id", converter = LongConverter.class)
    private long id;

    @Stored(name = "name")
    private String name;

    @Stored(name = "surname")
    private String surname;

    @Stored(name = "birthday", converter = LongConverter.class)
    private long birthday;


    public Profile(long id, String name, String surname, long birthday) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }
}
