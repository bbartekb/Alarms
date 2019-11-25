package kolekcjaAlarmow;

import dto.ObjectDTOInterface;

import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionOfObjects<T> {
    private CopyOnWriteArrayList<ObjectDTOInterface> collection;
}
