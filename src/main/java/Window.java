import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Window extends JFrame implements ActionListener {

    JLabel lNotificationIdentifier;
    JLabel lAcknowledgeState;
    JLabel lAcknowledgeUserID;
    JLabel lAlertCount;
    JLabel lMoTtInfo;
    JLabel lEventTime;

    JLabel[] index=new JLabel[20];
    TextField[] MOTTInfo=new TextField[20];
    TextField[] nID=new TextField[20];
    TextField[] acknState=new TextField[20];
    TextField[] acknUserId=new TextField[20];
    TextField[] alertCount=new TextField[20];
    TextField[] eventTime=new TextField[20];


    public Window() {
        setSize(1120, 700);
        setTitle("List of twenty alarms");
        setLayout(null);


        for (int i=0;i<20;i++){

            index[i]=new JLabel(String.valueOf(i+1));
            index[i].setBounds(5, 20+(i+1)*30, 15,20);
            add(index[i]);

            nID[i]=new TextField("");
            nID[i].setBounds(30, 20+(i+1)*30, 150,20);
            add(nID[i]);

            acknState[i]=new TextField("");
            acknState[i].setBounds(200, 20+(i+1)*30, 150,20);
            add(acknState[i]);

            acknUserId[i]=new TextField("");
            acknUserId[i].setBounds(370, 20+(i+1)*30, 150,20);
            add(acknUserId[i]);


            alertCount[i]=new TextField("");
            alertCount[i].setBounds(540, 20+(i+1)*30, 150,20);
            add(alertCount[i]);

            MOTTInfo[i]=new TextField("");
            MOTTInfo[i].setBounds(710, 20+(i+1)*30, 150,20);
            add(MOTTInfo[i]);

            eventTime[i]=new TextField("");
            eventTime[i].setBounds(880, 20+(i+1)*30, 190,20);
            add(eventTime[i]);
        }

        lNotificationIdentifier = new JLabel("Notification Identifier");
        lNotificationIdentifier.setBounds(30, 10, 150, 40);
        add(lNotificationIdentifier);

        lAcknowledgeState = new JLabel("Acknowledge State");
        lAcknowledgeState.setBounds(200, 10, 150, 40);
        add(lAcknowledgeState);

        lAcknowledgeUserID = new JLabel("Acknowledge User ID");
        lAcknowledgeUserID.setBounds(370, 10, 150, 40);
        add(lAcknowledgeUserID);

        lAlertCount= new JLabel("Alert Count");
        lAlertCount.setBounds(540, 10, 150, 40);
        add(lAlertCount);

        lMoTtInfo = new JLabel("MO TT Info");
        lMoTtInfo.setBounds(710, 10, 150, 40);
        add(lMoTtInfo);

        lEventTime = new JLabel("Event Time");
        lEventTime.setBounds(880, 10, 150, 40);
        add(lEventTime);
    }

    public void setParameters(List<AlarmDTO> listOfAlarms){

        int numberOfAlarmsToDisplay;
        if(listOfAlarms.size()<20){
            numberOfAlarmsToDisplay=listOfAlarms.size();
        }
        else{
            numberOfAlarmsToDisplay=20;
        }

            for(int i=0; i<numberOfAlarmsToDisplay;i++){
                nID[i].setText(listOfAlarms.get(i).getNotificationIdentifier());
                acknState[i].setText(listOfAlarms.get(i).getAcknowledgeState());
                acknUserId[i].setText(listOfAlarms.get(i).getAcknowledgeUserID());
                alertCount[i].setText(String.valueOf(listOfAlarms.get(i).getAlertCount()));
                MOTTInfo[i].setText(listOfAlarms.get(i).getMoTTInfo());
                eventTime[i].setText(String.valueOf(listOfAlarms.get(i).getEventTime()));
             }
        }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
