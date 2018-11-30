package com.mhc.orianna.test.base;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.springframework.util.StringUtils;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class MybatisGenerator {

    /**
     * ORM代码生成器
     * @param args
     */
    public static void main(String[] args) {

        AutoGenerator mpg = new AutoGenerator();
        //通用的全局配置
        mpg.setGlobalConfig(globalConfig());
        //数据源配置
        mpg.setDataSource(datasource());
        //类自动生成策略
        mpg.setStrategy(autoClassStrategy());
        //生成的包配置
        mpg.setPackageInfo(packageConfig());
        //需要生产的模板
        mpg.setTemplate(tc());
        //自定义配置，这儿写了mapper的目录
        mpg.setCfg(ic());
        mpg.execute();
    }


    private static String[] tablePrefix;

    private static String[] tableName;

    private static String author;

    static{
        Properties props = new Properties();
        try {
            props.load(new FileReader(MybatisGenerator.class.getResource("/generator/config.properties").getPath()));
            tablePrefix = props.getProperty("tablePrefix").split(",");
            tableName = props.getProperty("table").split(",");
            author = props.getProperty("author");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //全局的配置
    private static GlobalConfig globalConfig(){
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setActiveRecord(false);
        gc.setOutputDir("orianna-dal/src/main/java");
        gc.setFileOverride(true);
        // XML 二级缓存
        gc.setEnableCache(false);
        // XML ResultMap
        gc.setBaseResultMap(true);
        // XML columList
        gc.setBaseColumnList(true);
        // .setKotlin(true) 是否生成 kotlin 代码
        gc.setAuthor(author);
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sDao");
        gc.setServiceName("%sManager");
        gc.setServiceImplName("%sManagerImpl");
        return gc;
    }

    //数据源配置
    private static DataSourceConfig datasource(){
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL)
            .setTypeConvert(new MySqlTypeConvert(){
                @Override
                public DbColumnType processTypeConvert(String fieldType) {
                    // 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
                    return super.processTypeConvert(fieldType);
                }
            })
            .setDriverName("com.mysql.jdbc.Driver")
            .setUsername("assets_shixi")
                .setPassword("MDk3MjZiNDcwY2Jh")
            .setUrl("jdbc:mysql://daily-mhc-o.mysql.rds.aliyuncs.com:3306/db_assets_shixi?useUnicode=true&characterEncoding=utf-8");
        return dsc;
    }

    // 生成类名的策略配置
    private static StrategyConfig autoClassStrategy(){
        StrategyConfig strategy = new StrategyConfig();
        // 此处可以修改为您的表前缀
        if(StringUtils.isEmpty(tableName)){
            throw new RuntimeException("表名不能为空");
        }
        strategy.setTablePrefix(tablePrefix)
                .setInclude(tableName)
                .setNaming(NamingStrategy.underline_to_camel)
                .setSuperServiceClass("com.mhc.framework.common.base.dal.BaseManager")
                .setSuperServiceImplClass("com.mhc.framework.common.base.dal.BaseManagerImpl")
                .setSuperMapperClass("com.mhc.framework.common.base.dal.BaseDao")
                .setSuperEntityClass("com.mhc.framework.common.base.dal.BaseModel");
        return strategy;
    }

    //dal的包名位置配置
    private static PackageConfig packageConfig(){
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.mhc.orianna")
            .setEntity("domain")
            .setMapper("dao")
            .setService("manager")
            .setServiceImpl("manager.impl")
            .setModuleName("dal");
        return pc;
    }

    /**
     * 自定义配置
     * @return
     */
    private static InjectionConfig ic(){
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return "orianna-dal/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });
        cfg.setFileOutConfigList(focList);
        return cfg;
    }

    //自定义需要生成的模板
    private static TemplateConfig tc(){
        TemplateConfig tc = new TemplateConfig();
        tc.setController(null);
        tc.setXml(null);
        return tc;
    }
}
