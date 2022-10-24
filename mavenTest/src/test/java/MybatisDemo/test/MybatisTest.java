package MybatisDemo.test;

import MybatisDemo.mapper.BrandMapper;
import MybatisDemo.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

import java.util.List;

public class MybatisTest {
    /**
     查询所有
     */
    public static void selectAll(BrandMapper mapper){
        List<Brand> brands = mapper.selectAll();
        System.out.println(brands);
    }

    /**
     * 根据id查询一个
     */
    public static void selectById(BrandMapper mapper, int id){
        Brand brand = mapper.selectById(id);
        System.out.println(brand);

    }

    /**
     *根据条件查询（模糊搜索）
     */
    public static void selectByCondition(BrandMapper mapper){
        Brand brand = new Brand();
        brand.setStatus(1);
        brand.setBrandName("%华为%");
        brand.setCompanyName("%华为%");

        List<Brand> brands = mapper.selectByCondition(brand);
        System.out.println(brands);
    }

    /**
     单个查询
     */
    public static void selectByConditionSingle(BrandMapper mapper){
        Brand brand = new Brand();
        brand.setStatus(1);
        brand.setBrandName("%华为%");
//        brand.setCompanyName();
        List<Brand> brands = mapper.selectByConditionSingle(brand);
        System.out.println(brands);
    }

    public static void add(BrandMapper mapper){
        Brand brand = new Brand();
        brand.setCompanyName("打王牌汽车中心");
        brand.setBrandName("紫焰哈雷");
        brand.setStatus(1);
        brand.setOrdered(100);
        brand.setDescription("超速汽车 超乎你想象");
        mapper.add(brand);
        Integer id = brand.getId();
        System.out.println(id);

    }

    public static void update(BrandMapper mapper){
        Brand brand = new Brand();
//        brand.setCompanyName("超牌汽车");
//        brand.setBrandName("紫焰哈雷王");
//        brand.setStatus(1);
        brand.setOrdered(666);
//        brand.setDescription("超牌汽车 超乎你想象");
        brand.setId(11);
        int update = mapper.update(brand);
        System.out.println("影响行数有" + update);
    }

    public static void deleteById(BrandMapper mapper){
        mapper.deleteById(11);
    }

    public static void deleteByIds(BrandMapper mapper){
        Integer[] ids = {16, 17};
        mapper.deleteByIds(ids);
    }

    public static void main(String[] args) throws Exception {
        //获取会话工厂
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        deleteByIds(mapper);
        sqlSession.close();
    }

}
