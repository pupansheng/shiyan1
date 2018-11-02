package lost.found.mapper;

import java.util.List;
import lost.found.pojo.User;
import lost.found.pojo.UserExample;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);
    int getSumCount();
    
    List<User> selectByExample(UserExample example);
    
    List<User> getPageUser(@Param("now") int now,@Param("pagesize") int pagesize);
    
    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}