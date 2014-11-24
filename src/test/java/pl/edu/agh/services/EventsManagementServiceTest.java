package pl.edu.agh.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.edu.agh.config.ApplicationConfig;

import javax.sql.DataSource;

/**
 * Created by Krzysztof Kicinger on 2014-11-24.
 */
@ContextConfiguration(classes = ApplicationConfig.class)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
public class EventsManagementServiceTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void test() {
        System.out.println("HERE");
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
