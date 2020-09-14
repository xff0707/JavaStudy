package supplementary.jichujiaqiang.xml;

/*
һ����
1.����չ�������Extensible Markup Language
 *����չ����ǩ�����Զ���� <user> <student>
2.����
 *�洢����
    1.�����ļ�
    2.�������д���
3.xml��html������
    1.xml��ǩ�����Զ���ģ�html��ǩ��Ԥ�����
    2.xml���﷨�ϸ�html�﷨��ɢ
    3.xml�Ǵ洢���ݵģ�html��չʾ����

w3c:��ά������
properties

���﷨
 *�����﷨
    1.xml�ĵ��ĺ�׺�� .xml
    2.xml��һ�б��붨��Ϊ�ĵ�����
    3.xml�ĵ������ҽ���һ������ǩ(����Ϊ�����Զ����ǩ)
    4.����ֵ����ʹ������(��˫����)������
    5.��ǩ������ȷ�ر�                �Ապϱ�ǩ<br/>
    6.xml��ǩ�������ִ�Сд
 *��������
<?xml version="1.0" ?>      �����һ��
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
 *��ɲ���
 1.�ĵ�����
    1.��ʽ�� <?xml �����б� ?>
    2.�����б�
        version���汾�ţ���������� 1.0
        encoding�����뷽ʽ.��֪�������浱ǰ�ĵ�ʹ�õ��ַ�����Ĭ��ֵ��ISO-8859-1
        standalone���Ƿ����
            ȡֵ��
                yes�������������ļ�
                no�����������ļ�

 2.ָ��(�˽�)�����css��   <?xml-stylesheet type="text/css" href="a.css" ?>
 3.��ǩ����ǩ�����Զ����
    ����
        1.���ƿ��԰�����ĸ�������Լ��������ַ�
        2.���Ʋ��������ֻ��߱����ſ�ʼ
        3.���Ʋ�������ĸxml(����XML��Xml�ȵ�)��ʼ
        4.���Ʋ��ܰ����ո�
 4.����
    id����ֵΨһ
 5.�ı�
    CDATA�����ڸ������е����ݻᱻԭ��չʾ
        ��ʽ��<![CDATA[����]]>



 Լ�����涨xml�ĵ�����д����
    ��Ϊ��ܵ�ʹ����(������)��
        1.�ܹ���xml������Լ���ĵ�
        2.�ܹ��򵥵Ķ���Լ���ĵ�

    ���ࣺ
        1.DTD��һ�ּ򵥵�Լ������
        2.Schema��һ�ָ��ӵ�Լ������


    DTD:
        ����dtd�ĵ���xml�ļ���
            �ڲ���dtd����Լ����������xml�ĵ���<!DOCTYPE ����ǩ�� [dtd�ļ�����]>
            �ⲿ��dtd����Լ�����������ⲿ��dtd�ļ���
                ���أ�<!DOCTYPE ����ǩ�� SYSTEM "dtd�ļ���λ��">
                ���磺<!DOCTYPE ����ǩ�� PUBLIC "dtd�ļ�����" "dtd�ļ���λ��URL">
    Schema:
        ����Լ���ĵ���
        1.��дxml�ĵ���Ԫ��
        2.����xsiǰ׺, xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        3.����xsd�ļ������ؼ�,xsi:schemaLocation="http://www.itcast.cn/xml student.xsd"
        4.Ϊÿһ��xsdԼ������һ��ǰ׺����Ϊ��ʶ xmls="http://www.itcast.cn/xml"



������������xml�ĵ������ĵ��е����ݶ�ȡ���ڴ���
    ����xml�ĵ�
        1.����(��ȡ)�����ĵ��е����ݶ�ȡ���ڴ���
        2.д�룺���ڴ��е����ݱ��浽xml�ĵ��С��־û��Ĵ洢

    ������ʽ��������˼�룩
        DOM������������ĵ�һ���Լ��ؽ��ڴ棬���ڴ����γ�һ��dom��
            �ŵ㣺�������㣬���Զ��ĵ�����CRUD�����в���
            ȱ�㣺ռ�ڴ�
        SAX�����ж�ȡ�������¼�����
            �ŵ㣺��ռ�ڴ�
            ȱ�㣺ֻ�ܶ�ȡ��������ɾ��

    xml�����Ľ�������
        1.JAXP��sun��˾�ṩ�Ľ�������֧��dom��sax����˼��
        2.DOM4J��һ��ǳ�����Ľ�����
        3.Jsoup��jsoup��һ��Java��HTML����������ֱ�ӽ���ĳ��URL��ַ��HTML�ı����ݡ����ṩ��һ�׷ǳ�ʡ����API����ͨ��DOM��CSS�Լ�������jQuery�Ĳ���������ȡ���Ͳ������ݡ�
        4.PULL��Android����ϵͳ���õĽ�������sax��ʽ

    Jsoup
    ��������
        ���裺
        1.����jar��
        2.��ȡDocument����
        3.��ȡ��Ӧ�ı�ǩElement����
        4.��ȡ����

    ���룺
    //��ȡDocument���󣬸���xml�ĵ���ȡ
    //2.1��ȡstudent.xml��path
    String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
    //2.2����xml�ĵ��������ĵ����ڴ棬��ȡdom��-->Domcument
    Document document = Jsoup.parse(new File(path), "GBK");//��ݼ��� Ctrl + Alt + v
    //3��ȡԪ�ض��� Element����
    Elements elements = document.getElementsByTag("name");

    System.out.println(elements.size());

    //3.1��ȡ��һ��name��Element����
    Element element = elements.get(0);
    //3.2��ȡ����
    String name = element.text();
    System.out.println(name);

    �����ʹ�ã�
        1.Jsoup�������࣬���Խ���html��xml�ĵ�������Document����
            parse����html��xml�ĵ�������Document
                static Document	parse (File in, String charsetName)	Parse the contents of a file as HTML.����xml��html�ļ���
                static Document	parse (String html)	Parse HTML into a Document.����xml��html�ַ�����
                static Document	parse (URL url, int timeoutMillis) Fetch a URL, and parse it as HTML.ͨ������·����ȡָ����html��xml���ĵ�����
        2.Document���ĵ����󡣴����ڴ��е�dom��
            ��ȡElement����
                getElementById (String id)����id����ֵ��ȡΨһ��element����
            	getElementsByTag (String tagName)���ݱ�ǩ���ƻ�ȡԪ�ض��󼯺�
            	getElementsByAttribute (String key)�����������ƻ�ȡԪ�ض��󼯺�
            	getElementsByAttributeValue (String key, String value)���ݶ�Ӧ��������������ֵ��ȡԪ�ض���
        3.Elements��Ԫ��Element����ļ��ϣ����Ե���ArrayList<Element>��ʹ��
        4.Element��Ԫ�ض���
            1.��ȡ��Ԫ�ض���
                getElementById (String id)����id����ֵ��ȡΨһ��element����
            	getElementsByTag (String tagName)���ݱ�ǩ���ƻ�ȡԪ�ض��󼯺�
            	getElementsByAttribute (String key)�����������ƻ�ȡԪ�ض��󼯺�
            	getElementsByAttributeValue (String key, String value)���ݶ�Ӧ��������������ֵ��ȡԪ�ض���
            2.��ȡ����ֵ
                String attr(String key)�������������ƻ�ȡ����ֵ
            3.��ȡ�ı�����
                String text()����ȡ�����ӱ�ǩ�Ĵ��ı�����
                String html()����ȡ��ǩ�����������(�����ӱ�ǩ���ַ������ݣ�������ǩ���ı�����)
        5.Node���ڵ����
            ��Document��Element�ĸ���

    ��ݲ�ѯ��ʽ
        1.selector��ѡ����
            ʹ�õķ�����public Elements select (String cssQuery)
                �﷨���ο�Selector���ж�����﷨
        2.XPath��XPath��ΪXML·�����ԣ�����һ������ȷ��XML(��׼������Ե��Ӽ�)�ĵ���ĳ����λ�õ�����
            ʹ��Jsoup��Xpath��Ҫ���⵼��jar��
            ��ѯw3cshool�ο��ֲᣬʹ��xpath���﷨��ɲ�ѯ

 */
public class XMLDemo {
}


/*
������������PHP�̳̣�����ѧϰjava��
������
XML���ݸ�ʽ������Ҫ���ܾ��ǣ����ݴ���
��;��
����֮������ݴ���ͨѶ
PHP���� <- ���100 <- Java����
�����ļ� config.xml
config.xml -> php���ԡ�java���ԡ�python����
�洢���ݣ��䵱С�����ݿ�
data.xml
�淶���ݸ�ʽ��ʹ���ݾ��нṹ�ԣ��׶��״���


ʲô��XML
XML ����չ�Ա������
XML��������Ŀ���Ǵ���ʹ洢���ݣ�������չʾ����(html)��
XML�ı�ǩ�����Զ��壬������д��ǩ����ʱ��һ��Ҫ�к���
XML��W3C�ƾٵ����ݴ����ʽ

����Լ�дһ��XML
����xml�����и��ڵ�(����ǩ)<root></root>
��HTML����
                XML                     HTML
��ǩ          ֻ���Զ���               �����Զ���
�﷨Ҫ��    �����ϸ�����ǳɶԱ�ǩ         ���ϸ�
����          ����ʹ洢����             չʾ����



 */

