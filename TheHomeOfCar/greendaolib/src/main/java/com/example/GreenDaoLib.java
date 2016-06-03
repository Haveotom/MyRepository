package com.example;
//java代码
//步骤:
/*
File文件里选择new--new Module---java版本
greendao下的app 添加jar包
////////////////////////////
注意:Schema的引包:import de.greenrobot.daogenerator.Schema
最后运行:log日志下自动生成四个java文件
app下引包
 */

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class GreenDaoLib {
    public static void main(String[] args) {
        //版本名,包名
        //两个参数: 参数1 数据库的版本号(随意)
        //参数2 自动生成的代码的包名
        Schema schema = new Schema(1, "com.jingjiang.thehomeofcar");
        //最后调用方法(添加静态方法)
        addNote(schema);

        //自动生成代码
        //两个参数:
        //参数1 图标对象
        //参数2 自动生成的代码路径
        /*******************************/
        try {
            new DaoGenerator().generateAll(schema, "./app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 此方法是为我们的数据库里添加所需要的内容
     *
     * @param schema(形参)
     */
    private static void addNote(Schema schema) {
        //添加表名
        Entity entity = schema.addEntity("Person");
        //加入id
        //并且id自增
        entity.addIdProperty().autoincrement().primaryKey();
        //添加类属性,根据属性生成相应的字段
        entity.addStringProperty("name");
        entity.addIntProperty("age");
        entity.addStringProperty("sex");

    }

}
