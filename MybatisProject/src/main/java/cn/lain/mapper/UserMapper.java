package cn.lain.mapper;

import cn.lain.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();

    @Select("select * from tb_user where id = ${id}")
    User selectById(int id);

    /**
     * MyBatis参数封装：
     * 单个参数：
     *      1. POJO类型：直接使用，保证 POJO的属性名 和 对应sql语句的参数占位符名称 一致
     *                  MyBatis对于POJO类型的不会在封装为Map集合
     *      2. Map集合：直接使用，保证 Map集合的键名 和 参数占位符 一致
     *      3. Collection：封装为Map集合，可以使用@param注解，替换Map集合中默认的arg键名
     *                  map.put("arg0", collection集合)
     *                  map.put("collection", collection集合)
     *      4. List：，可以使用@param注解，替换Map集合中默认的arg键名
     *              map.put("arg0", list集合)
     *              map.put("collection", list集合)
     *              map.put("list", list集合)
     *      5. Array：封装为Map集合，可以使用@param注解，替换Map集合中默认的arg键名
     *              map.put("arg0", 数组)
     *              map.put("array", 数组)
     *      6. 其他类型：直接使用
     * 多个参数：封装为Map集合，可以使用@param注解，替换Map集合中默认的arg键名
     *      map.put("arg0", 参数值1)
     *      map.put("param1", 参数值1)
     *      map.put("arg1", 参数值2)
     *      map.put("param2", 参数值2)
     */

    /* MyBatis提供了ParamNameResolver类来进行参数封装 */

    // 【推荐】第一种方式：使用@param注解的方式进行简便开发
    User select(@Param("username") String username, @Param("password") String password);

    // 第二种方式：使用键值对的方式进行开发
    //User select(String username, String password);
}
