package Thanachai.BackupJson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;


@Service
    public class BackupService  {
//            @Override
//            public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//                return new User("admin","admin",new ArrayList<>());
//            }

        private final BackupRepository backupRepository;

        @Autowired
        public BackupService(BackupRepository backupRepository) {

            this.backupRepository = backupRepository;
        }
        public List<Backup> getBackups(){

            return backupRepository.findAll();
        }

        public ResponseDescription addNewBackup(Backup backup) {

            backupRepository.save(backup);
            return new ResponseDescription("1","เพิ่มรายการสำเร็จ  ! success");
        }


        public ResponseDescription deleteBill(Long primary_id) {
            backupRepository.findById(primary_id);
            boolean exists = backupRepository.existsById(primary_id);
            if (!exists){
                return new ResponseDescription ("0","backup with primaryid" + primary_id +" does not exists ");
            }
            backupRepository.deleteById(primary_id);
            return new ResponseDescription("1"," ลบรายการสำเร็จ  ! backup deleted ");
        }
        @Transactional
        public  ResponseDescription updateBackup(Backup putBackup) {
            Backup backup = backupRepository.findById(putBackup.getPrimary_id()).orElseThrow(() ->
                    new IllegalStateException(
                            "backup with primaryid" + putBackup.getPrimary_id() + "does not exist"));
            if (putBackup.getCustomerId() != null &&
                    putBackup.getCustomerId().length() > 0 &&
                    !Objects.equals(backup.getCustomerId(), putBackup.getCustomerId())) {
                backup.setCustomerId(putBackup.getCustomerId());
            }
            if (putBackup.getActDay() != null &&
                    putBackup.getActDay().intValue() > 0 ) {
                Optional<Backup> backupOptional = backupRepository.findBackupByCustomerID
                        (putBackup.getCustomerId());
                if (backupOptional.isPresent()) {
                    return new ResponseDescription("0","วันที่ไม่ถูกต้อง");
                }
                backup.setActDay(putBackup.getActDay());
            }
            if (putBackup.getActMonth() != null &&
                    putBackup.getActMonth().intValue() > 0 ) {
                Optional<Backup> backupOptional = backupRepository.findBackupByCustomerID(putBackup.getCustomerId());
                if (backupOptional.isPresent()) {
                    return new ResponseDescription("0","เดือนไม่ถูกต้อง");
                }
                backup.setActMonth(putBackup.getActMonth());
            }
            if (putBackup.getActYear() != null &&
                    putBackup.getActYear().intValue() > 0 ) {
                Optional<Backup> backupOptional = backupRepository.findBackupByCustomerID(putBackup.getCustomerId());
                if (backupOptional.isPresent()) {
                    return new ResponseDescription ("0","ปีไม่ถูกต้อง");
                }
                backup.setActYear(putBackup.getActYear());
            }
            if (putBackup.getAction() != null &&
                    putBackup.getAction().intValue() > 0 &&
                    !Objects.equals(backup.getAction(), putBackup.getAction())) {
                Optional<Backup> backupOptional = backupRepository.findBackupByCustomerID(putBackup.getCustomerId());
                if (backupOptional.isPresent()) {
                    return new ResponseDescription ("0","Action ไม่ถูกต้อง");
                }
                backup.setMoney_card(putBackup.getMoney_card());
            }
            if (putBackup.getActmoney() != null &&
                    putBackup.getActmoney().intValue() > 0 &&
                    !Objects.equals(backup.getActmoney(), putBackup.getActmoney())) {
                Optional<Backup> backupOptional = backupRepository.findBackupByCustomerID(putBackup.getCustomerId());
                if (backupOptional.isPresent()) {
                    return new ResponseDescription("0","จำนวนเงินไม่ถูกต้อง");
                }
                backup.setActmoney(putBackup.getActmoney());
            }
            if (putBackup.getAfmoney() != null &&
                    putBackup.getAfmoney().intValue() > 0 &&
                    !Objects.equals(backup.getAfmoney(), putBackup.getAfmoney())) {
                Optional<Backup> backupOptional = backupRepository.findBackupByCustomerID(putBackup.getCustomerId());
                if (backupOptional.isPresent()) {
                    return new ResponseDescription("0","afmoneyไม่ถูกต้อง");
                }
                backup.setAfmoney(putBackup.getAfmoney());
            }
            if (putBackup.getBefmoney() != null &&
                    putBackup.getBefmoney().intValue() > 0 &&
                    !Objects.equals(backup.getBefmoney(), putBackup.getBefmoney())) {
                Optional<Backup> backupOptional = backupRepository.findBackupByCustomerID(putBackup.getCustomerId());
                if (backupOptional.isPresent()) {
                    return new ResponseDescription("0","befmoneyไม่ถูกต้อง");
                }
                backup.setBefmoney(putBackup.getAfmoney());
            }
            if (putBackup.getItem_list() != null &&
                    putBackup.getItem_list().intValue() > 0 &&
                    !Objects.equals(backup.getItem_list(), putBackup.getItem_list())) {
                Optional<Backup> backupOptional = backupRepository.findBackupByCustomerID(putBackup.getCustomerId());
                if (backupOptional.isPresent()) {
                    return new ResponseDescription("0","ItemListไม่ถูกต้อง");
                }
                backup.setItem_list(putBackup.getItem_list());
            }
            if (putBackup.getMoney_card() != null &&
                    putBackup.getMoney_card().length() > 0 &&
                    !Objects.equals(backup.getMoney_card(), putBackup.getMoney_card())) {
                Optional<Backup> backupOptional = backupRepository.findBackupByCustomerID(putBackup.getCustomerId());
                if (backupOptional.isPresent()) {
                    return new ResponseDescription("0","money card ไม่ถูกต้อง");
                }
                backup.setMoney_card(putBackup.getMoney_card());
            }
            if (putBackup.getPincode() != null &&
                    putBackup.getPincode().length() > 0 &&
                    !Objects.equals(backup.getPincode(), putBackup.getPincode())) {
                Optional<Backup> backupOptional = backupRepository.findBackupByCustomerID(putBackup.getCustomerId());
                if (backupOptional.isPresent()) {
                    return new ResponseDescription("0","Pin Code ไม่ถูกต้อง");
                }
                backup.setPincode(putBackup.getPincode());
            }
            if (putBackup.getSerial_card() != null &&
                    putBackup.getSerial_card().length() > 0 &&
                    !Objects.equals(backup.getSerial_card(), putBackup.getSerial_card())) {
                Optional<Backup> backupOptional = backupRepository.findBackupByCustomerID(putBackup.getCustomerId());
                if (backupOptional.isPresent()) {
                    return new ResponseDescription("0","Serial card ไม่ถูกต้อง");
                }
                backup.setSerial_card(putBackup.getSerial_card());
            }
            if (putBackup.getService_card() != null &&
                    putBackup.getService_card().length() > 0 &&
                    !Objects.equals(backup.getService_card(), putBackup.getService_card())) {
                Optional<Backup> backupOptional = backupRepository.findBackupByCustomerID(putBackup.getCustomerId());
                if (backupOptional.isPresent()) {
                    return new ResponseDescription("0","Service card ไม่ถูกต้อง");
                }
                backup.setService_card(putBackup.getService_card());
            }
            if (putBackup.getStaff() != null &&
                    putBackup.getStaff().length() > 0 &&
                    !Objects.equals(backup.getStaff(), putBackup.getStaff())) {
                Optional<Backup> backupOptional = backupRepository.findBackupByCustomerID(putBackup.getCustomerId());
                if (backupOptional.isPresent()) {
                    return new ResponseDescription("0","Staff ไม่ถูกต้อง");
                }
                backup.setStaff(putBackup.getStaff());
            }
            if (putBackup.getTimestamp() != null &&
                    putBackup.getTimestamp().length() > 0 &&
                    !Objects.equals(backup.getTimestamp(), putBackup.getTimestamp())) {
                Optional<Backup> backupOptional = backupRepository.findBackupByCustomerID(putBackup.getCustomerId());
                if (backupOptional.isPresent()) {
                    return new ResponseDescription("0","Timestamp ไม่ถูกต้อง");
                }
                backup.setTimestamp(putBackup.getTimestamp());
            }


            return new ResponseDescription("1","แก้ไขสำเร็จ");
        }




    }


