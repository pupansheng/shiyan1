package lost.found.mapper;

import java.util.List;
import lost.found.pojo.Item;
import lost.found.pojo.ItemExample;
import org.apache.ibatis.annotations.Param;

public interface ItemMapper {
	
	
    int countByExample(ItemExample example);

    int deleteByExample(ItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Item record);

    int insertSelective(Item record);
    
    int getSumCount();
    int getSumCountByUid(int id);
    List<Item> getItemPage(@Param("now") int now,@Param("pagesize") int pagesize);
    List<Item> getItemPageFabu(@Param("now") int now,@Param("pagesize") int pagesize,@Param("uid") int uid);
    

    List<Item> selectByExampleWithBLOBs(ItemExample example);

    List<Item> selectByExample(ItemExample example);
    
    
    List<Item> selectIndex10();//获取首页的10个发布丢失最早的10个记录

    Item selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Item record, @Param("example") ItemExample example);

    int updateByExampleWithBLOBs(@Param("record") Item record, @Param("example") ItemExample example);

    int updateByExample(@Param("record") Item record, @Param("example") ItemExample example);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKeyWithBLOBs(Item record);

    int updateByPrimaryKey(Item record);
}