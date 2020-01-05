package objectscollection;
import dtoobjects.AlarmDTO;
import dtoobjects.ObjectDTOInterface;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperations {

    public <T> PairOfLists divideIntoTwoLists(CopyOnWriteArrayList<T> copyOnWriteArrayList){
         CopyOnWriteArrayList<T> B;
         int length = copyOnWriteArrayList.size();

         CopyOnWriteArrayList<T> A = copyOnWriteArrayList.stream()
            .skip(length/2)
            .collect(Collectors.toCollection(CopyOnWriteArrayList::new));

         B= copyOnWriteArrayList.stream()
            .limit(length/2)
            .collect(Collectors.toCollection(CopyOnWriteArrayList::new));

         CollectionOfObjects C= new CollectionOfObjects();
            C.setCollection(A);
         CollectionOfObjects D= new CollectionOfObjects();
            D.setCollection(B);
         PairOfLists pairOfLists = new PairOfLists(C,D);

         return pairOfLists;
    }

    public CollectionOfObjects mergeTwoLists(CollectionOfObjects A, CollectionOfObjects B){
        CollectionOfObjects C = new CollectionOfObjects();
        List<AlarmDTO> D;

        Stream<AlarmDTO> mergedStream = Stream.concat(A.getCollection().stream(), B.getCollection().stream());
        D = mergedStream
                .collect(Collectors.toList());
        C.setCollection(D);

        return C;
    }


    public long numberOfElements(CollectionOfObjects A){
       long numberOfElements = A.getCollection().stream()
            .count();
       return numberOfElements;
    }


    public <T> CollectionOfObjects everyThirdElementFromList(CopyOnWriteArrayList<T> copyOnWriteArrayList){
        CopyOnWriteArrayList<T> B = new CopyOnWriteArrayList<>();

        Stream.iterate(0, n->n+100)
                .limit(copyOnWriteArrayList.size()/100+1)
                .forEach(x -> B.add((T) copyOnWriteArrayList.get(x)));

        System.out.println("sko");
        CollectionOfObjects C = new CollectionOfObjects();
        C.setCollection(B);
        return C;
    }

    public CollectionOfObjects removeEverySecondElementFromList(CollectionOfObjects collection){
        List<ObjectDTOInterface> B=new ArrayList<>();

        Stream.iterate(0, n->n+2)
                .limit(collection.getCollection().size()/2)
                .forEach(x ->B.add((ObjectDTOInterface) collection.getCollection().get(x)));
        System.out.println("sko2");
        CollectionOfObjects finalCollection = new CollectionOfObjects();
        finalCollection.setCollection(B);
        return finalCollection;
    }

    public CollectionOfObjects selectItemBeginsWithLetter(CollectionOfObjects collection){
        List<ObjectDTOInterface> B;

        B= (List<ObjectDTOInterface>) collection.getCollection().stream()
                .filter(g -> ((ObjectDTOInterface) g).getFirstAttribute().startsWith("E"))
                .collect(Collectors.toList());
        CollectionOfObjects finalCollection = new CollectionOfObjects();
        finalCollection.setCollection(B);

        return finalCollection;
    }


    public CollectionOfObjects notEmptyOptionalValue(CollectionOfObjects collection){
        List<ObjectDTOInterface> B;

        B = (List<ObjectDTOInterface>) collection.getCollection().stream()
                .filter(g -> ((ObjectDTOInterface) g).getFourthAttribute().isPresent())
                .collect(Collectors.toList());

        CollectionOfObjects finalCollection = new CollectionOfObjects();
        finalCollection.setCollection(B);

        return finalCollection;
    }

/*//TODO change ValueIfPresent
    public CollectionOfObjects changeValueIfPresent(CollectionOfObjects collection){

    }*/


    public Integer sumOfAlertCount(CollectionOfObjects collection){
        List<AlarmDTO> B=collection.getCollection();
        int k=0;
        for (int i=0; i<collection.getCollection().size();i++){
        k=k+ Integer.valueOf(B.get(i).getFifthAttribute());
        }
        return k;
    }

    public CollectionOfObjects distinctObjects (CollectionOfObjects collection){

        List<ObjectDTOInterface> newList= (List<ObjectDTOInterface>) collection.getCollection().stream()
                .distinct()
                .collect(Collectors.toList());

        CollectionOfObjects finalCollection = new CollectionOfObjects();
        finalCollection.setCollection(newList);

        return finalCollection;
    }

    public Optional<ObjectDTOInterface> specificObjects (CollectionOfObjects collection){

        Optional<ObjectDTOInterface> object=  collection.getCollection().stream()
                .filter(g -> ((ObjectDTOInterface)g).getFirstAttribute().startsWith("E"))
                .filter(g->(Integer.valueOf(((ObjectDTOInterface) g).getFifthAttribute())<5))
                        .findFirst();

        return object;
    }

    public Optional<ObjectDTOInterface> anySpecificObjects (CollectionOfObjects collection){

        Optional<ObjectDTOInterface> object=  collection.getCollection().stream()
                .filter(g -> ((ObjectDTOInterface)g).getFirstAttribute().startsWith("E"))
                .filter(g->(Integer.valueOf(((ObjectDTOInterface) g).getFifthAttribute())<5))
                        .findAny();

        return object;
    }

    public CollectionOfObjects sortByAlertCount (CollectionOfObjects collection){
        List <ObjectDTOInterface> newList;

       newList = (List<ObjectDTOInterface>) collection.getCollection().stream()
                .sorted((p1,p2)-> (Integer.valueOf(((ObjectDTOInterface)p1).getFifthAttribute())).compareTo(Integer.valueOf((((ObjectDTOInterface)p2).getFifthAttribute()))))
                .collect(Collectors.toList());

        CollectionOfObjects finalCollection = new CollectionOfObjects();
        finalCollection.setCollection(newList);

        return finalCollection;
    }

    public Map<String,ObjectDTOInterface> groupByAlertCount (CollectionOfObjects collection){
        Map<String,ObjectDTOInterface> newList;

       newList = (Map<String, ObjectDTOInterface>) collection.getCollection().stream()
                    .collect(Collectors.groupingBy(alarm -> ((ObjectDTOInterface)alarm).getFifthAttribute()));

        return newList;
    }

    public Set<ObjectDTOInterface> convertToSet (CollectionOfObjects collection){
        Set<ObjectDTOInterface> newSet;

       newSet = (Set<ObjectDTOInterface>) collection.getCollection().stream()
                    .collect(Collectors.toSet());

        return newSet;
    }

    public ObjectDTOInterface[] convertToArray (CollectionOfObjects collection){
        ObjectDTOInterface[] newArray;

       newArray = (ObjectDTOInterface[]) collection.getCollection().stream()
                    .toArray(ObjectDTOInterface[]::new);

        return newArray;
    }

    public void displayAlarmsAsString (CollectionOfObjects collection){

        System.out.println("Lista alarmów z kolekcji:");
 collection.getCollection().stream()
                .map(alarm -> ((ObjectDTOInterface)alarm).getFirstAttribute() +", "+ ((ObjectDTOInterface) alarm).getSecondAttribute() +", "
                        + ((ObjectDTOInterface) alarm).getThirdAttribute() +", " + ((ObjectDTOInterface) alarm).getFourthAttribute().orElse("no data") +", "
                        + ((ObjectDTOInterface) alarm).getFifthAttribute() +", " + ((ObjectDTOInterface) alarm).getSixthAttribute())
                .forEach(System.out::println);
    }

}
