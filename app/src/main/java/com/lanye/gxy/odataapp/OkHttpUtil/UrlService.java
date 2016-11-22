package com.lanye.gxy.odataapp.OkHttpUtil;

/**
 * Created by Administrator on 2016/11/7.
 */
public class UrlService {
    //查询所有
    public String GetAllURL = "http://services.odata.org/TripPinRESTierService/(S(ttgxui24dxjyngne0nkqgyqi))/People";
    //条件查询
    public String GetOneByKey = "http://services.odata.org/TripPinRESTierService/(S(ttgxui24dxjyngne0nkqgyqi))/People?$filter=FirstName eq 'Lewis'";
    //查询某一个属性
    public String GetOneAtt = "http://services.odata.org/TripPinRESTierService/Airports('KSFO')/Name ";
    //添加
    public String ADDURL = "http://services.odata.org/TripPinRESTierService/(S(ttgxui24dxjyngne0nkqgyqi))/People";
    //删除
    public String DeleteURL = "http://services.odata.org/TripPinRESTierService/(S(ttgxui24dxjyngne0nkqgyqi))/People('aaa')";
    //更新
    public String PutURL = "http://services.odata.org/TripPinRESTierService/(S(ttgxui24dxjyngne0nkqgyqi))/People('aaa')";
}
