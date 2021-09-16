package Thanachai.BackupJson.Security;

public class AuthenResponse {

    private final String jwt;

    public AuthenResponse(String jwt){
        this.jwt = jwt;
    }

    public String getJwt(){
        return this.jwt;
    }


}
