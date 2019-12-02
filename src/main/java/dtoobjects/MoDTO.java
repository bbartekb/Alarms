package dtoobjects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MoDTO implements ObjectDTOInterface {
    private String identifier;
    private String resource;
    private String lifecycleState;
    private String description;
    private String xCreateDate;
    private String xCreateUser;

    public static final class Builder {
        private String identifier;
        private String resource;
        private String lifecycleState;
        private String description;
        private String xCreateDate;
        private String xCreateUser ;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");



        public Builder identifier(String identifier) {
            this.identifier = identifier;
            return this;
        }

        public Builder resource(String resource) {
            this.resource = resource;
            return this;
        }

        public Builder lifecycleState(String acknowledgeUserID) {
            this.lifecycleState = acknowledgeUserID;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder xCreateUser(String xCreateUser) {
            this.xCreateUser = xCreateUser;
            return this;
        }


        public Builder xCreateDate(String xCreateDate){
            try {
                Date additionalTime = formatter.parse(xCreateDate);
                this.xCreateDate = formatter.format(additionalTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return this;
        }




        public MoDTO build(){
            if(identifier.isEmpty()){
                throw new IllegalStateException("Identifier cannot be empty");
            }
            if(xCreateDate.isEmpty()){
                throw new IllegalStateException("XCreateDate cannot be empty");
            }
            MoDTO moDTO = new MoDTO();
            moDTO.identifier = this.identifier;
            moDTO.resource= this.resource;
            moDTO.lifecycleState = this.lifecycleState;
            moDTO.description = this.description;
            moDTO.xCreateUser = this.xCreateUser;
            moDTO.xCreateDate = this.xCreateDate;
            return moDTO;
        }





        public Builder from(MoDTO moDTO) {
            identifier(moDTO.getFirstAttribute());
            resource(moDTO.getSecondAttribute());
            lifecycleState(moDTO.getThirdAttribute());
            description(moDTO.getFourthAttribute());
            xCreateUser(moDTO.getFifthAttribute().toString());
            xCreateDate(moDTO.getSixthAttribute().toString());
            return this;
        }
    }







    @Override
    public String getFirstAttribute() {
        return this.identifier;
    }

    @Override
    public String getSecondAttribute() {
        return this.resource;
    }

    @Override
    public String getThirdAttribute() {
        return this.lifecycleState;
    }

    @Override
    public String getFourthAttribute() {
        return this.description;
    }

    @Override
    public String getFifthAttribute() {
        return this.xCreateUser;
    }

    @Override
    public String getSixthAttribute() {
        return this.xCreateDate;
    }
}
