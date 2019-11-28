package dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TicketDTO implements ObjectDTOInterface {
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




        public TicketDTO build(){
            if(notificationIdentifier.isEmpty()){
                throw new IllegalStateException("Notification Identifier cannot be empty");
            }
            if(acknowledgeState.isEmpty()){
                throw new IllegalStateException("Acknowledge State cannot be empty");
            }
            if(eventTime.isEmpty()){
                throw new IllegalStateException("Event Time cannot be empty");
            }

            TicketDTO alarm = new TicketDTO();
            alarm.notificationIdentifier = this.notificationIdentifier;
            alarm.acknowledgeState= this.acknowledgeState;
            alarm.acknowledgeUserID = this.acknowledgeUserID;
            alarm.alertCount = this.alertCount;
            alarm.moTTInfo = this.moTTInfo;
            alarm.eventTime = this.eventTime;
            return alarm;
        }





        public Builder from(AlarmDTO alarm) {
            notificationIdentifier(alarm.getFirstAttribute());
            acknowledgeState(alarm.getSecondAttribute());
            acknowledgeUserID(alarm.getThirdAttribute());
            moTTInfo(alarm.getFourthAttribute());
            alertCount(alarm.getFifthAttribute().toString());
            eventTime(alarm.getSixthAttribute().toString());
            return this;
        }
    }







    @Override
    public String getFirstAttribute() {
        return null;
    }

    @Override
    public String getSecondAttribute() {
        return null;
    }

    @Override
    public String getThirdAttribute() {
        return null;
    }

    @Override
    public String getFourthAttribute() {
        return null;
    }

    @Override
    public Integer getFifthAttribute() {
        return null;
    }

    @Override
    public String getSixthAttribute() {
        return null;
    }
}
