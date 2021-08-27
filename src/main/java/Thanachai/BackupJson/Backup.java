package Thanachai.BackupJson;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table
public class Backup {

    @Id
    @SequenceGenerator(
            name = "backup_sequence",
            sequenceName = "backup_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "backup_sequence"
    )

//    @Id
//    @GenericGenerator(name = "backup_sequence", strategy = "Thanachai.BackupJson.generator.OrderIdGenerator")
//    @GeneratedValue(generator = "backup_sequence")


    @Column(name="primary_id")
    private Long primary_id;

    private Integer actDay;
    private Integer actMonth;
    private Integer actYear;
    private Integer action;
    private Integer actmoney;
    private Integer afmoney;
    private Integer befmoney;
    private String customerID;
    private Integer item_list;
    private String money_card;
    private String pincode;
    private String serial_card;
    private String service_card;
    private String staff;
    private String timestamp;




    public Backup() {
    }

    public Backup(Long primary_id, Integer actDay, Integer actMonth, Integer actYear,
                  Integer action, Integer actmoney, Integer afmoney, Integer befmoney,
                  String customerID, Integer item_list, String money_card, String pincode,
                  String serial_card, String service_card, String staff, String timestamp) {
        this.primary_id = primary_id;
        this.actDay = actDay;
        this.actMonth = actMonth;
        this.actYear = actYear;
        this.action = action;
        this.actmoney = actmoney;
        this.afmoney = afmoney;
        this.befmoney = befmoney;
        this.customerID = customerID;
        this.item_list = item_list;
        this.money_card = money_card;
        this.pincode = pincode;
        this.serial_card = serial_card;
        this.service_card = service_card;
        this.staff = staff;
        this.timestamp = timestamp;
    }
    public Backup(Integer actDay, Integer actMonth, Integer actYear,
                  Integer action, Integer actmoney, Integer afmoney, Integer befmoney,
                  String customerID, Integer item_list, String money_card, String pincode,
                  String serial_card, String service_card, String staff, String timestamp) {
        this.actDay = actDay;
        this.actMonth = actMonth;
        this.actYear = actYear;
        this.action = action;
        this.actmoney = actmoney;
        this.afmoney = afmoney;
        this.befmoney = befmoney;
        this.customerID = customerID;
        this.item_list = item_list;
        this.money_card = money_card;
        this.pincode = pincode;
        this.serial_card = serial_card;
        this.service_card = service_card;
        this.staff = staff;
        this.timestamp = timestamp;
    }

    public Long getPrimary_id() {
        return primary_id;
    }

    public void setPrimary_id(Long primary_id) {
        this.primary_id = primary_id;
    }

    public Integer getActDay() {return actDay;}

    public void setActDay(Integer actDay) {
        this.actDay = actDay;
    }

    public Integer getActMonth() {
        return actMonth;
    }

    public void setActMonth(Integer actMonth) {
        this.actMonth = actMonth;
    }

    public Integer getActYear() {
        return actYear;
    }

    public void setActYear(Integer actYear) {
        this.actYear = actYear;
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public Integer getActmoney() {
        return actmoney;
    }

    public void setActmoney(Integer actmoney) {
        this.actmoney = actmoney;
    }

    public Integer getAfmoney() {
        return afmoney;
    }

    public void setAfmoney(Integer afmoney) {
        this.afmoney = afmoney;
    }

    public Integer getBefmoney() {
        return befmoney;
    }

    public void setBefmoney(Integer befmoney) {
        this.befmoney = befmoney;
    }

    public String getCustomerId() {
        return customerID;
    }

    public void setCustomerId(String customerId) {
        this.customerID = customerId;
    }

    public Integer getItem_list() {
        return item_list;
    }

    public void setItem_list(Integer item_list) {
        this.item_list = item_list;
    }

    public String getMoney_card() {
        return money_card;
    }

    public void setMoney_card(String money_card) {
        this.money_card = money_card;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getSerial_card() {
        return serial_card;
    }

    public void setSerial_card(String serial_card) {
        this.serial_card = serial_card;
    }

    public String getService_card() {
        return service_card;
    }

    public void setService_card(String service_card) {
        this.service_card = service_card;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "backup{" +
                "primary_id=" + primary_id +
                ", actDay=" + actDay +
                ", actMonth=" + actMonth +
                ", actYear=" + actYear +
                ", action=" + action +
                ", actmoney=" + actmoney +
                ", afmoney=" + afmoney +
                ", befmoney=" + befmoney +
                ", customerID='" + customerID + '\'' +
                ", item_list=" + item_list +
                ", money_card='" + money_card + '\'' +
                ", pincode='" + pincode + '\'' +
                ", serial_card='" + serial_card + '\'' +
                ", service_card='" + service_card + '\'' +
                ", staff='" + staff + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
