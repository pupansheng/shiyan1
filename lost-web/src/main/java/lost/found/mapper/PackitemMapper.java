package lost.found.mapper;

import java.util.List;

import lost.found.pojo.Item;
import lost.found.pojo.Packitem;
import lost.found.pojo.PackitemExample;
import org.apache.ibatis.annotations.Param;

public interface PackitemMapper {
    int countByExample(PackitemExample example);

    int deleteByExample(PackitemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Packitem record);

    int insertSelective(Packitem record);
    
    int getSumCount();
    int getSumCountByUid(int uid);
    List<Packitem> getPackitemPage(@Param("now") int now,@Param("pagesize") int pagesize);
    List<Packitem> getPackitemPageFabu(@Param("now") int now,@Param("pagesize") int pagesize,@Param("uid") int uid);
    
    

    List<Packitem> selectByExampleWithBLOBs(PackitemExample example);

    List<Packitem> selectByExample(PackitemExample example);

    Packitem selectByPrimaryKey(Integer id);

    List<Packitem> selectIndex10();
    
    int updateByExampleSelective(@Param("record") Packitem record, @Param("example") PackitemExample example);

    int updateByExampleWithBLOBs(@Param("record") Packitem record, @Param("example") PackitemExample example);

    int updateByExample(@Param("record") Packitem record, @Param("example") PackitemExample example);

    int updateByPrimaryKeySelective(Packitem record);

    int updateByPrimaryKeyWithBLOBs(Packitem record);

    int updateByPrimaryKey(Packitem record);
}