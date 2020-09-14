package supplementary.jichujiaqiang.xml;

/*
一概念
1.可扩展标记语言Extensible Markup Language
 *可扩展：标签都是自定义的 <user> <student>
2.功能
 *存储数据
    1.配置文件
    2.在网络中传输
3.xml与html的区别
    1.xml标签都是自定义的，html标签是预定义的
    2.xml的语法严格，html语法松散
    3.xml是存储数据的，html是展示数据

w3c:万维网联盟
properties

二语法
 *基本语法
    1.xml文档的后缀名 .xml
    2.xml第一行必须定义为文档声明
    3.xml文档中有且仅有一个根标签(可以为任意自定义标签)
    4.属性值必须使用引号(单双都可)引起来
    5.标签必须正确关闭                自闭合标签<br/>
    6.xml标签名称区分大小写
 *快速入门
<?xml version="1.0" ?>      必须第一行
<root>
    <user id="1">
        <name>zhangsan</name>
        <age>23</age>
        <gender>male</gender>
    </user>
    <user id="2">
        <name>lisi</name>
        <age>24</age>
        <gender>demale</gender>
    </user>
</root>
 *组成部分
 1.文档声明
    1.格式： <?xml 属性列表 ?>
    2.属性列表
        version：版本号，必须的属性 1.0
        encoding：编码方式.告知解析引擎当前文档使用的字符集，默认值：ISO-8859-1
        standalone：是否独立
            取值：
                yes：不依赖其他文件
                no：以来其他文件

 2.指令(了解)：结合css的   <?xml-stylesheet type="text/css" href="a.css" ?>
 3.标签：标签名称自定义的
    规则：
        1.名称可以包含字母、数字以及其他的字符
        2.名称不能以数字或者标点符号开始
        3.名称不能以字母xml(或者XML、Xml等等)开始
        4.名称不能包含空格
 4.属性
    id属性值唯一
 5.文本
    CDATA区；在该区域中的数据会被原样展示
        格式：<![CDATA[数据]]>



 约束：规定xml文档的书写规则
    作为框架的使用者(开发者)：
        1.能够在xml中引入约束文档
        2.能够简单的读懂约束文档

    分类：
        1.DTD：一种简单的约束技术
        2.Schema：一种复杂的约束技术


    DTD:
        引入dtd文档到xml文件中
            内部的dtd：将约束规则定义在xml文档中<!DOCTYPE 根标签名 [dtd文件内容]>
            外部的dtd：将约束规则定义在外部的dtd文件中
                本地：<!DOCTYPE 根标签名 SYSTEM "dtd文件的位置">
                网络：<!DOCTYPE 根标签名 PUBLIC "dtd文件名字" "dtd文件的位置URL">
    Schema:
        引入约束文档：
        1.填写xml文档的元素
        2.引入xsi前缀, xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        3.引入xsd文件命名控件,xsi:schemaLocation="http://www.itcast.cn/xml student.xsd"
        4.为每一个xsd约束声明一个前缀，作为标识 xmls="http://www.itcast.cn/xml"



三解析：操作xml文档，将文档中的数据读取到内存中
    操作xml文档
        1.解析(读取)：将文档中的数据读取到内存中
        2.写入：将内存中的数据保存到xml文档中。持久化的存储

    解析方式：（解析思想）
        DOM：将标记语言文档一次性加载进内存，在内存中形成一颗dom树
            优点：操作方便，可以对文档进行CRUD的所有操作
            缺点：占内存
        SAX：逐行读取，基于事件驱动
            优点：不占内存
            缺点：只能读取，你能增删改

    xml常见的解析器：
        1.JAXP：sun公司提供的解析器，支持dom和sax两种思想
        2.DOM4J：一款非常优秀的解析器
        3.Jsoup：jsoup是一款Java的HTML解析器，可直接解析某个URL地址、HTML文本内容。它提供了一套非常省力的API，可通过DOM，CSS以及类似于jQuery的操作方法来取出和操作数据。
        4.PULL：Android操作系统内置的解析器，sax方式

    Jsoup
    快速入门
        步骤：
        1.导入jar包
        2.获取Document对象
        3.获取对应的标签Element对象
        4.获取数据

    代码：
    //获取Document对象，根据xml文档获取
    //2.1获取student.xml的path
    String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
    //2.2解析xml文档，加载文档进内存，获取dom树-->Domcument
    Document document = Jsoup.parse(new File(path), "GBK");//快捷键： Ctrl + Alt + v
    //3获取元素对象 Element对象
    Elements elements = document.getElementsByTag("name");

    System.out.println(elements.size());

    //3.1获取第一个name的Element对象
    Element element = elements.get(0);
    //3.2获取数据
    String name = element.text();
    System.out.println(name);

    对象的使用：
        1.Jsoup：工具类，可以解析html或xml文档，返回Document对象
            parse解析html或xml文档，返货Document
                static Document	parse (File in, String charsetName)	Parse the contents of a file as HTML.解析xml或html文件的
                static Document	parse (String html)	Parse HTML into a Document.解析xml或html字符串的
                static Document	parse (URL url, int timeoutMillis) Fetch a URL, and parse it as HTML.通过网络路径获取指定的html或xml的文档对象
        2.Document：文档对象。代表内存中的dom树
            获取Element对象
                getElementById (String id)根据id属性值获取唯一的element对象
            	getElementsByTag (String tagName)根据标签名称获取元素对象集合
            	getElementsByAttribute (String key)根据属性名称获取元素对象集合
            	getElementsByAttributeValue (String key, String value)根据对应的属性名和属性值获取元素对象
        3.Elements：元素Element对象的集合，可以当作ArrayList<Element>来使用
        4.Element：元素对象
            1.获取子元素对象
                getElementById (String id)根据id属性值获取唯一的element对象
            	getElementsByTag (String tagName)根据标签名称获取元素对象集合
            	getElementsByAttribute (String key)根据属性名称获取元素对象集合
            	getElementsByAttributeValue (String key, String value)根据对应的属性名和属性值获取元素对象
            2.获取属性值
                String attr(String key)：根据属性名称获取属性值
            3.获取文本内容
                String text()：获取所有子标签的纯文本内容
                String html()：获取标签体的所有内容(包括子标签的字符串内容，包括标签和文本内容)
        5.Node：节点对象
            是Document和Element的父类

    快捷查询方式
        1.selector：选择器
            使用的方法：public Elements select (String cssQuery)
                语法：参考Selector类中定义的语法
        2.XPath：XPath即为XML路径语言，它是一种用来确定XML(标准标记语言的子集)文档中某部分位置的语言
            使用Jsoup的Xpath需要额外导入jar包
            查询w3cshool参考手册，使用xpath的语法完成查询

 */
public class XMLDemo {
}


/*
以下内容来自PHP教程，后续学习java版
概述：
XML数据格式的最主要功能就是：数据传输
用途：
程序之间的数据传输通讯
PHP语言 <- 快递100 <- Java语言
配置文件 config.xml
config.xml -> php语言、java语言、python语言
存储数据，充当小型数据库
data.xml
规范数据格式，使数据具有结构性，易读易处理


什么是XML
XML 可扩展性标记语言
XML被发明的目的是传输和存储数据，而不是展示数据(html)。
XML的标签必须自定义，但是在写标签名的时候一定要有含义
XML是W3C推举的数据传输格式

如何自己写一段XML
所有xml必须有根节点(根标签)<root></root>
与HTML区别：
                XML                     HTML
标签          只能自定义               不能自定义
语法要求    极其严格必须是成对标签         不严格
作用          传输和存储数据             展示数据



 */

