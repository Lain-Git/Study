package cn.lain.mapper;

import cn.lain.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {

    /**
     * 查询所有
     */
    public List<Brand> selectAll();

    /**
     * 查看详情：根据id查询
     */
    Brand selectById(int id);

    /**
     * 条件查询
     * * 参数接收
     * 1. 散装参数：如果方法中有多个参数，需要使用@param("sql参数占位符名称")
     * 2. 对象参数：只需要保证sql中的参数名和实体类属性名对应上
     * 3. map集合参数：只需要保证sql中的参数名和map集合的键的名称对应上
     *
     * @param status
     * @param companyName
     * @param brandName
     * @return
     */
    List<Brand> selectByCondition(@Param("status") int status,
                                  @Param("companyName") String companyName,
                                  @Param("brandName") String brandName);

    //List<Brand> selectByCondition(Brand brand);
    //List<Brand> selectByCondition(Map map);

    /**
     * 单条件动态查询
     * @param brand
     * @return
     */
    List<Brand> selectByConditionSingle(Brand brand);

    /**
     * 添加
     */
    void add(Brand brand);

    /**
     * 修改
     */
    int update(Brand brand);

    /**
     * 删除
     */
    void deleteById(int id);

    /**
     * 批量删除
     */
    void deleteByIds(@Param("ids") int[] ids);

}
