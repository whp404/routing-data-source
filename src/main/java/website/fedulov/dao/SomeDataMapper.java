package website.fedulov.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import website.fedulov.testmodel.SomeData;

import java.util.List;

@Repository
public interface SomeDataMapper {

    public List<SomeData> findAll();

    public void save(@Param("someData") SomeData someData);
}
