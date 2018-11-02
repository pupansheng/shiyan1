package lost.found.mapper;

import java.util.List;
import lost.found.pojo.Msg;
import lost.found.pojo.MsgExample;
import org.apache.ibatis.annotations.Param;

public interface MsgMapper {
    int countByExample(MsgExample example);

    int deleteByExample(MsgExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Msg record);

    int insertSelective(Msg record);
     int getSumCount(int uid);
    
    List<Msg> getPageMsg(@Param("now") int now,@Param("pagesize") int pagesize,@Param("uid") int uid);
    
    
    List<Msg> selectByExampleWithBLOBs(MsgExample example);

    List<Msg> selectByExample(MsgExample example);

    Msg selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Msg record, @Param("example") MsgExample example);

    int updateByExampleWithBLOBs(@Param("record") Msg record, @Param("example") MsgExample example);

    int updateByExample(@Param("record") Msg record, @Param("example") MsgExample example);

    int updateByPrimaryKeySelective(Msg record);

    int updateByPrimaryKeyWithBLOBs(Msg record);

    int updateByPrimaryKey(Msg record);
}