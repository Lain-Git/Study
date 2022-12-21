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
     *      1. 散装参数：如果方法中有多个参数，需要使用@param("sql参数占位符名称")
     *      2. 对象参数：对象的属性名称要和参数占位符一致
     *      3. map集合参数
     *
     * @param status
     * @param companyName
     * @param brandName
     * @return
     */
    List<Brand> selectByCondition(@Param("status") int status,
                                  @Param("companyName") String companyName,
                                  @Param("brandName") String brandName);

//    List<Brand> selectByCondition(Brand brand);

//    List<Brand> selectByCondition(Map map);
}
