import Thanachai.BackupJson.Backup;
import Thanachai.BackupJson.BackupRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BackupConfig {
        @Bean
    CommandLineRunner commandLineRunner(
            BackupRepository repository){
        return args -> {
            Backup  not = new Backup(
                    1L,
                    "" ,
                    11,
                    9,
                    1998,
                    3,
                    500,
                    50550,
                    125862,
                    "notqawsed@hotmail.com",
                    1253674418,
                    "51856910345174",
                    "10001075113760",
                    "1",
                    "4531424553" ,
                    "",
                    "1998/11/9|15:33:25"

            );
            Backup eye = new Backup(
                    2L,
                    "" ,
                    11,
                    9,
                    1998,
                    3,
                    500,
                    50550,
                    125862,
                    "ntqawsed@hotmail.com",
                    1253674418,
                    "51856910345174",
                    "10001075113760",
                    "1",
                    "4531424553" ,
                    "",
                    "1998/8/9|15:33:25"

            );

            repository.saveAll(
                    List.of(not, eye)
            );
        };
    }
}

