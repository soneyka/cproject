package com.manipal.iterator;

import com.manipal.model.PersonMkrtchanLS;

public interface PersonCollectionMkrtchanLS {
    void addPerson(PersonMkrtchanLS c);

    void removePerson(PersonMkrtchanLS c);

    PersonIteratorMkrtchanLS iterator();
}
