package back.backend.repositories;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sql2o.Sql2o;

@Configuration
public class DatabaseContext {
    
    @Bean
        // Definir la URL de la BD, el usuario que la creó y la contraseña.
        // Ejemplo:jdbc:postgresql://127.0.0.1:5432/postgres, usuario, password
        public Sql2o sql2o(){
            return new Sql2o("jdbc:postgresql:///var/run/postgresql:5432/db_tingeso", "postgres", "postgres");
        }
}
