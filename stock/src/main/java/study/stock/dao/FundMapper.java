package study.stock.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import study.stock.model.Fund;

public interface FundMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Fund record);

    int insertSelective(Fund record);

    Fund selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Fund record);

    int updateByPrimaryKey(Fund record);
    /**获取所有用户信息
     * @return List<User>
     */
    List<Fund> getAllFunds();  
    List<Fund> getPageFunds(@Param("pageNo")int pageNo,@Param("pageSize") int pageSize);  
    long getCountsFunds();
}