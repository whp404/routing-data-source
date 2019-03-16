package website.fedulov;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import website.fedulov.SomeDataService.SomeDataService;
import website.fedulov.routing.DbContextHolder;
import website.fedulov.testmodel.SomeData;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring.xml"})
public class MainTest {

    private static final Logger log = LoggerFactory.getLogger(MainTest.class);

    @Autowired
    private SomeDataService someDataService;

    @Test
    public void testReplica() {
        log.info(">>> DbContextHolder.getDbType {}", DbContextHolder.getDbType());
        log.info(someDataService.findAll().toString());
    }

    @Test
    public void testMaster() {
        log.info(">>> DbContextHolder.getDbType {}", DbContextHolder.getDbType());
        log.info(">>> Master: {}", someDataService.findAllMaster());
    }

    @Test
    public void testMasterUpdate() {
        log.info(">>> DbContextHolder.getDbType {}", DbContextHolder.getDbType());
        log.info(">>> Master: {}", someDataService.findAll());

        SomeData someData = new SomeData();
        someData.setId(2);
        someData.setName("name");
        someData.setValue("newData");
        someDataService.save(someData);
        log.info(">>> Master updated:{}", someDataService.findAll());
        log.info(">>> Master updated:{}", someDataService.findAllMaster());
    }
}

