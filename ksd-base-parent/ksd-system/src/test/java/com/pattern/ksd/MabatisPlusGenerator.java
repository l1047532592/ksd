package com.pattern.ksd;


import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

public class MabatisPlusGenerator {

    //项目模块
//    private static String moduleName = "com-example-demo";
    //基本包名
    private static String basePackage = "com.pattern.ksdSystem";
    //作者
    private static String authorName = "lfl";
    //要生成的表名
    private static String[] tables = {"sx_xml_element"};
    //table前缀
    private static String prefix = "sx";
    //mapper 文件路径
    private static String mapperPreFile = "com/pattern/ksdSystem/mapper";
    //service类的名称，默认会带I,所以自定义
    private static String serviceName = "XmlElementService";

    //数据库配置四要素
    private static String driverName = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/authority_managerment?autoReconnect=true&useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
    private static String username = "root";
    private static String password = "960422";


    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
//        projectPath = projectPath + "/" + moduleName + "/";
        gc.setActiveRecord(true);
     // 自定义文件命名，注意 %s 会自动填充表实体属性！
//      setMapperName("%sMapper")
//      setXmlName("%sMapper")
//      setServiceName("%sService")
//      setServiceImplName("%sServiceImpl")
//      setControllerName("%sController")
        gc.setServiceName(serviceName);
        gc.setOutputDir(projectPath + "/src/main/java");
        // 是否覆盖文件
        gc.setFileOverride(true);
        gc.setAuthor(authorName);
        //生成后打开文件夹
        gc.setOpen(false);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(url);
        dsc.setDriverName(driverName);
        dsc.setUsername(username);
        dsc.setPassword(password);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
//         pc.setModuleName(moduleName);
        pc.setParent(basePackage);
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/" + mapperPreFile
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass("com.pattern.ksdSystem.entity.BasePlusEntity");
        strategy.setEntityLombokModel(true);
        //设置entity--TableField属性
        strategy.setEntityTableFieldAnnotationEnable(true);
        strategy.setRestControllerStyle(true);
        strategy.setInclude(tables);
        strategy.setSuperEntityColumns("id", "remarks", "sort_by", "update_date", "update_by", "create_date", "create_by", "del_flag");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(prefix);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}