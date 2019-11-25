package dto;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class AlarmDTO implements ObjectDTOInterface{
    private String notificationIdentifier;
    private String acknowledgeState;
    private String acknowledgeUserID;
    private Integer alertCount;
    private String moTTInfo;
    private String eventTime;

    public static final class Builder {
        private String notificationIdentifier;
        private String acknowledgeState;
        private String acknowledgeUserID;
        private Integer alertCount;
        private String moTTInfo;
        private String eventTime ;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");



        public Builder notificationIdentifier(String notificationIdentifier) {
            this.notificationIdentifier = notificationIdentifier;
            return this;
        }

        public Builder acknowledgeState(String acknowledgeState) {
            this.acknowledgeState = acknowledgeState;
            return this;
        }

        public Builder acknowledgeUserID(String acknowledgeUserID) {
            this.acknowledgeUserID = acknowledgeUserID;
            return this;
        }

        public Builder alertCount(String alertCount) {
            this.alertCount = Integer.valueOf(alertCount);
            return this;
        }

        public Builder moTTInfo(String moTTInfo) {
            this.moTTInfo = moTTInfo;
            return this;
        }


        public Builder eventTime(String eventTime){
            try {
                Date additionalTime = formatter.parse(eventTime);
                this.eventTime = formatter.format(additionalTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return this;
        }




        public AlarmDTO build(){
            if(notificationIdentifier.isEmpty()){
                throw new IllegalStateException("Notification Identifier cannot be empty");
            }
            if(acknowledgeState.isEmpty()){
                throw new IllegalStateException("Acknowledge State cannot be empty");
            }
            if(eventTime.isEmpty()){
                throw new IllegalStateException("Event Time cannot be empty");
            }

            AlarmDTO alarm = new AlarmDTO();
            alarm.notificationIdentifier = this.notificationIdentifier;
            alarm.acknowledgeState= this.acknowledgeState;
            alarm.acknowledgeUserID = this.acknowledgeUserID;
            alarm.alertCount = this.alertCount;
            alarm.moTTInfo = this.moTTInfo;
            alarm.eventTime = this.eventTime;
            return alarm;
        }





        public Builder from(AlarmDTO alarm) {
            notificationIdentifier(alarm.getNotificationIdentifier());
            acknowledgeState(alarm.getAcknowledgeState());
            acknowledgeUserID(alarm.getAcknowledgeUserID());
            moTTInfo(alarm.getMoTTInfo());
            alertCount(alarm.getAlertCount().toString());
            eventTime(alarm.getEventTime().toString());
            return this;
        }
    }

    public String getNotificationIdentifier(){
        return this.notificationIdentifier;
    }
    public String getAcknowledgeState(){
        return this.acknowledgeState;
    }
    public String getAcknowledgeUserID(){
        return this.acknowledgeUserID;
    }
    public String getMoTTInfo(){
        return this.moTTInfo;
    }
    public Integer getAlertCount(){
        return this.alertCount;
    }
    public String getEventTime(){
        return this.eventTime;
    }
}