package fund.lucida.app.service.impl;

import fund.lucida.app.dao.TestMapper;
import fund.lucida.app.service.TestService;
//import fund.lucida.dataSource.DataSourceAnnotation;
//import fund.lucida.dataSource.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

//    @DataSourceAnnotation(DataSourceType.onChain)
    @Override
    public String getByName(String name) {
        return testMapper.getByName(name);
    }
}
