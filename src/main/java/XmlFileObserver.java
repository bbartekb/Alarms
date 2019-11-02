import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class XmlFileObserver {
    private Long date;

    private PropertyChangeSupport support;

    public XmlFileObserver() {
        support = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public void setDate(Long date) {
        support.firePropertyChange("date", this.date, date);
        this.date = date;
    }
}