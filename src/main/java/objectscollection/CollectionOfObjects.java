package objectscollection;

import dtoobjects.ObjectDTOInterface;
import basic.Runner;
import dtoobjects.TypeOfObjects;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionOfObjects<T extends ObjectDTOInterface> {
    private CopyOnWriteArrayList<T> collection=new CopyOnWriteArrayList<>();

    public void setCollectionA(List<T> collection) {
        this.collection.addAll(collection);
        Runner.getWindow().setParametersA(this.collection);
        StreamOperations streamOperations=new StreamOperations();
        PairOfLists G = streamOperations.divideIntoTwoLists(this.collection);
        CollectionOfObjects A = streamOperations.mergeTwoLists((CollectionOfObjects)G.getA(),(CollectionOfObjects)G.getB());
        System.out.println("number of elements in list:" + streamOperations.numberOfElements((CollectionOfObjects)G.getB()));

        System.out.println("number of elements in second list:" + streamOperations.numberOfElements(streamOperations.everyThirdElementFromList(this.collection)));
        System.out.println("number of elements in third list:" + streamOperations.numberOfElements(streamOperations.removeEverySecondElementFromList((CollectionOfObjects) G.getB())));

        System.out.println("number of elements begins with \"E\": " + streamOperations.numberOfElements(streamOperations.selectItemBeginsWithLetter(A)));

        System.out.println("number of elements with not empty forth attribute (moTTInfo): " + streamOperations.numberOfElements(streamOperations.notEmptyOptionalValue(A)));

        if (Runner.getSelectedTypeOfData().equals(TypeOfObjects.ALARM)){
            System.out.println("Sum of alert count = " + streamOperations.sumOfAlertCount(A));
            Optional<ObjectDTOInterface> object = streamOperations.specificObjects(A);
            Optional<ObjectDTOInterface> object2 = streamOperations.anySpecificObjects(A);
            System.out.println("aaa");

            CollectionOfObjects sortedList=streamOperations.sortByAlertCount(A);
        }

        System.out.println("Pogrupowane po alert count elementy (mapa <String, ObjectDTOIntface), powinno zwrocić tyle el. ile jest różnych alert count>)"
                +streamOperations.groupByAlertCount(A).size());


        CollectionOfObjects duplicatedList = streamOperations.mergeTwoLists((CollectionOfObjects)G.getA(),(CollectionOfObjects)G.getA());
        System.out.println("number of alarms in duplicated list: " + streamOperations.numberOfElements(duplicatedList));
        System.out.println("number of unique elements: " + streamOperations.numberOfElements(streamOperations.distinctObjects(duplicatedList)));
        System.out.println("number of elements in set: " + (streamOperations.convertToSet(duplicatedList)).size());
        System.out.println("number of elements in array: " + streamOperations.convertToArray(duplicatedList).length);
     streamOperations.displayAlarmsAsString(A);
        //   System.out.println("Alarms in collection: \n" + streamOperations.displayAlarmsAsString(A));
    }

public void setCollection(List<T> collection) {
        this.collection.addAll(collection);
    }

    public synchronized void add(T alarm){
        this.collection.add(alarm);
        Runner.getWindow().setParametersA(this.collection);
    }

    public synchronized void remove(int i){
        this.collection.remove(i);
        Runner.getWindow().setParametersA(this.collection);
    }

    public synchronized void add (T alarm, int i){
        this.collection.add(i,alarm);
        Runner.getWindow().setParametersA(this.collection);

    }

    public List<T> getCollection(){
        return this.collection;
    }
    public T getObject(int i){
        return this.collection.get(i);
    }

}
