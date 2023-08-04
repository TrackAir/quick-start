package fund.lucida.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface TestMapper extends BaseMapper<Test> {



    String getByName(String name);

}
