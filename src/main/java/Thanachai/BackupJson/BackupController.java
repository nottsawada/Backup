package Thanachai.BackupJson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "/api/backup")
public class BackupController {

    private final BackupService backupService;

    @Autowired
    public BackupController(BackupService backupService) {
        this.backupService = backupService;
    }

    @GetMapping
    public List<Backup> getBackups() {
        return backupService.getBackups();
    }


    @RequestMapping(value = "/addbackup", method = RequestMethod.POST)
    public ResponseEntity<?> registerNewBackup(@RequestBody Backup backup){

        return  ResponseEntity.ok( backupService.addNewBackup(backup)) ;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity<?> deleteBill(@RequestParam String primaryID){

        return  ResponseEntity.ok( backupService.deleteBill(Long.valueOf(primaryID))) ;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ResponseEntity<?> updateBackup(@RequestBody Backup backup){

        return ResponseEntity.ok( backupService.updateBackup(backup) );
    }

}

