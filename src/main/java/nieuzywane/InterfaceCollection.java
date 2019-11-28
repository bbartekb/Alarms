//to było jak mieliśmy do wyboru dwie kolekcje z alarmami, żeby łatwiej zarządzać

package nieuzywane;

import dto.AlarmDTO;

import java.util.List;

public interface InterfaceCollection {
    public void add(AlarmDTO alarm);

    public void remove(int i);

    public void add(AlarmDTO alarm, int i);

    public List<AlarmDTO> getCollection();

    public AlarmDTO getAlarm(int i);

    void setCollection(List<AlarmDTO> listOfAlarms);
    public boolean isEmpty();
}
