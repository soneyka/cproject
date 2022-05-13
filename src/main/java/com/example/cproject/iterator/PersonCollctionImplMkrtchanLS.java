package com.manipal.iterator;

import com.manipal.model.PersonMkrtchanLS;
import com.manipal.singleton.SingletonMkrtchanLS;

import java.util.ArrayList;
import java.util.List;

public class PersonCollctionImplMkrtchanLS implements PersonCollectionMkrtchanLS {

    private List<PersonMkrtchanLS> personlList;

    public PersonCollctionImplMkrtchanLS() {
        personlList = new ArrayList<>();
    }

    @Override
    public void addPerson(PersonMkrtchanLS c) {
        this.addPerson(c);
    }

    @Override
    public void removePerson(PersonMkrtchanLS c) {
        this.removePerson(c);
    }

    @Override
    public PersonIteratorMkrtchanLS iterator() {
        return null;
    }

    private class ChannelIteratorImpl implements PersonIteratorMkrtchanLS {
        private List<PersonMkrtchanLS> channels;
        private int position;

        public ChannelIteratorImpl(List<PersonMkrtchanLS> channelList) {
            this.channels = channelList;
        }

        @Override
        public boolean hasNext() {
            while (position < channels.size()) {
                PersonMkrtchanLS c = channels.get(position);
                SingletonMkrtchanLS obj = new SingletonMkrtchanLS();
                if (position < channels.size()) {
                    return true;
                } else {
                    position++;
                }
                return false;
            }
            return false;
        }

        @Override
        public PersonMkrtchanLS next() {
            PersonMkrtchanLS c = channels.get(position);
            position++;
            return c;
        }
    }
}