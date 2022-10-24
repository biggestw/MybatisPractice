package MybatisDemo.mapper;

import MybatisDemo.pojo.Brand;
import org.apache.ibatis.annotations.Param;


import java.util.List;


public interface BrandMapper {
    List<Brand> selectAll();

    Brand selectById(int id);

//    List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);
    List<Brand> selectByCondition(Brand brand);

    List<Brand> selectByConditionSingle(Brand brand);

    void add(Brand brand);
    int update(Brand brand);

    int deleteById(int id);

//    首先明确这个注解是为SQL语句中参数赋值而服务的。
//    @Param的作用就是给参数命名，比如在mapper里面某方法A（int id），
//    当添加注解后A（@Param("userId") int id），也就是说外部想要取出传入的id值，只需要取它的参数名userId就可以了。
//    将参数值传如SQL语句中，通过#{userId}进行取值给SQL的参数赋值。
    //建议： 将来都是用@Param注解来修改Map集合中默认的键名，并使用修改后的名称来获取值，这样可读性更高
    void deleteByIds(@Param("ids") Integer []ids);
}
