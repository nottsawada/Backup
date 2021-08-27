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
                    9 ,
                    11,
                    1998,
                    3,
                    100,
                    522039279,
                    522039179,
                    "notqawsed@hotmail.com",
                    1629796857,
                    "10000",
                    "51856910345174",
                    "10001075113760",
                    "1",
                    "",
                    "1998/11/9|15:33:25"
            );
            Backup eye = new Backup(
                    2L,
                    28,
                    8,
                    2020,
                    2,
                    150,
                    527039279,
                    592039179,
                    "ntqawsed@hotmail.com",
                    1829796857,
                    "20000",
                    "51896910345174",
                    "10801075113760",
                    "5",
                    "",
                    "2020/12/10|15:33:25"
            );

            repository.saveAll(
                    List.of(not, eye)
            );
        };
    }
}

