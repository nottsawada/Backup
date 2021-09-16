package Thanachai.BackupJson;

import Thanachai.BackupJson.Security.AuthenRequest;
import Thanachai.BackupJson.Security.AuthenResponse;
import Thanachai.BackupJson.Security.JwtUtil;
import Thanachai.BackupJson.Security.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "/api/backup")
public class BackupController {

    private final BackupService backupService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    public BackupController(BackupService backupService) {
        this.backupService = backupService;
    }

    @Autowired
    private MyUserDetailsService userDetailsService;

    @GetMapping
    public List<Backup> getBackups() {

        return backupService.getBackups();
    }


    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenRequest authenRequest) throws  Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenRequest.getUsername(), authenRequest.getPassword())
            );
        }catch (BadCredentialsException e){
            throw  new Exception("Incorrect username or password", e);
            }
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenRequest.getUsername());


        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenResponse(jwt));
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

