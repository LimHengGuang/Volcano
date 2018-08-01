package com.example.postgresdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.example.postgresdemo.model.User;
import com.example.postgresdemo.repository.UserRepository;
import javax.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Entity
@Table(name = "chat")
public class Chat extends AuditModel {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long chatId; //primary id

    @Column(columnDefinition="TEXT")
    private String message;
    @Column()
    private Long creatorId;
    @Column()
    private Long teamId; //only got setters, as teamId should not be changed once set
    @Column()
    private String creatorNameSnapshot; // Let's just dump the username here for perf
    @Column()
    private String privateMessageID; // The Id of the user that sent the message (userId1+userid2)
    @Column()
    private Long receiverID; // The ID of the user that will get the messages (userid2)

    //getter
    public Long getCreatorId() {
        return this.creatorId;
    }

    public Long getChatId() {
      return this.chatId;
    }

    public String getMessage() {
        return this.message;
    }

    public String getCreatorNameSnapshot() {
        return this.creatorNameSnapshot;
    }

    public Long getTeamId() {
      return teamId;
    }

    public Long getRecieverID(){
        return receiverID;
    }

    public String getTimeSent() {
       // Calendar calendar = Calendar.getInstance();

       // java.util.Date now = calendar.getTime();

        //java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        return timeStamp;
    }

    //setters
    public void setCreatorNameSnapshot(String name) {
        this.creatorNameSnapshot = name;
    }

    public void setCreatorId(Long userId) {
        this.creatorId = creatorId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public void setPrivateMessageID(String privateMessageID){
        this.privateMessageID = privateMessageID;
    }

    public void setRecieverID(Long recieverID){
        this.receiverID = recieverID;
    }
}
