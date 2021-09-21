package Thanachai.BackupJson.models;

import Thanachai.BackupJson.Backup;

public class BackupRequest {

    private String jwt;
    private Backup data_backup;

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public Backup getData_backup() {
        return data_backup;
    }

    public void setData_backup(Backup data_backup) {
        this.data_backup = data_backup;
    }
}
