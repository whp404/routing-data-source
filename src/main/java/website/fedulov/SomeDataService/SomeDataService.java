package website.fedulov.SomeDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import website.fedulov.aspect.ReadOnlyConnection;
import website.fedulov.aspect.WriteConnection;
import website.fedulov.dao.SomeDataMapper;
import website.fedulov.testmodel.SomeData;

import java.util.List;

@Service
public class SomeDataService {

    private static int i = 0;
    @Autowired
    private SomeDataMapper someDataMapper;

    @ReadOnlyConnection
    @Transactional
    public List<SomeData> findAll() {

        return someDataMapper.findAll();
    }


    @WriteConnection
    @Transactional
    public List<SomeData> findAllMaster() {
        return someDataMapper.findAll();
    }

    @ReadOnlyConnection
    @Transactional
    public void save(SomeData someData) {
        someDataMapper.save(someData);
    }
}
